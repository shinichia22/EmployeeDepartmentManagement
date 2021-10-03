package com.empdep.crud.daos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.empdep.crud.entites.Department;
import com.empdep.crud.entites.Employee;
import com.empdep.crud.exceptions.EmployeeNotFoundException;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	EntityManager entityManager;
	
	@Override
	public String saveEmployee(Employee employee) {
		Employee emp = new Employee();
		emp.setEmpName(employee.getEmpName());
		emp.setEmpAddress(employee.getEmpAddress());
		emp.setEmpSalary(employee.getEmpSalary());
		for(Department dep:employee.getDepartment()) {
			emp.getDepartment().add( new Department(dep.getDepName(),dep.getDepDescription(), emp));
		}
//		emp.setDepartment(employee.getDepartment());				
		getSession().saveOrUpdate(emp);
		return null;
	}

	@Override
	public Employee getEmployee(int id) {
		
	Employee e=	getSession().get(Employee.class, id);
	if(e==null) {throw new EmployeeNotFoundException("Employee not found dao");}
		return e;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> allEmps = getSession().createCriteria(Employee.class).list();
		return allEmps;
	}

	@Override
	public Employee updateEmployee(Employee employee, int id) {
		
		Employee updEmp = getEmployee(id);
		
		updEmp.setEmpName(employee.getEmpName());
		updEmp.setEmpAddress(employee.getEmpAddress());
		updEmp.setEmpSalary(employee.getEmpSalary());
		
		return updEmp;
	}

	@Override
	public String deleteEMployee(int id) {
		Employee delEmp = getEmployee(id);
		if(delEmp == null) {throw new EmployeeNotFoundException("Employee not found dao"); }
		getSession().remove(delEmp);
		return "Deleted successfully";
	}
		
	@Override
	public Iterable<Department> getDepFromEmployee(int dId) {
		
		Employee emp = getEmployee(dId);
		return emp.getDepartment();

//		String sql = "SELECT Department d FROM Employee";
//		Query<Department> q = getSession().createQuery(sql);
//		List<Department> allDep = q.list();
				
	}

	private Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		if(session == null) {
			session = sessionFactory.openSession();
		}
			return session;
	}

}
