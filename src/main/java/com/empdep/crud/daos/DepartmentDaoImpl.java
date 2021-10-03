package com.empdep.crud.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.empdep.crud.entites.Department;
import com.empdep.crud.entites.Employee;
import com.empdep.crud.exceptions.DepartmentNotFoundException;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public String saveDepartment(Department department) {
		Department dep = new Department();
		dep.setDepName(department.getDepName());
		dep.setDepDescription(department.getDepDescription());
		Employee emp = new Employee();
		dep.setEmployee(department.getEmployee());
		System.out.println("***dept value****  " + dep.toString());
		getSession().save(dep);
		return null;
	}

	@Override
	public Department getDepartment(int id) {
		Department department = getSession().get(Department.class, id);
		if(department == null) {
			throw new DepartmentNotFoundException("Department not fount Dao");
		}
		return department;
	}

	@Override
	public List<Department> getAllDepartments() {
		List<Department> allDepts = getSession().createCriteria(Department.class).list();
		return allDepts;
	}

	@Override
	public Department updateDepartment(Department department, int id) {
		Department dept = getDepartment(id);
		System.out.println("** current one **** " + dept);
		dept.setDepName(department.getDepName());
		dept.setDepDescription(department.getDepDescription());
		System.out.println("** updated one **** " + dept);
		return dept;
	}

	@Override
	public String deleteDepartment(int id) {
		Department dep = getDepartment(id);
		if(dep == null) {
			throw new DepartmentNotFoundException("Department not fount Dao");
		}
		getSession().remove(dep);
		return "Employee deleted Successfully";
	}
	
	private Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		if(session == null) {
			session = sessionFactory.openSession();
		}
			return session;
	}

}
