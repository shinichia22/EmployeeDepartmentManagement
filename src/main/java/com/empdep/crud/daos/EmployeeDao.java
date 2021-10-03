package com.empdep.crud.daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.empdep.crud.entites.Department;
import com.empdep.crud.entites.Employee;

public interface EmployeeDao {

	public String saveEmployee(Employee employee);
	public Employee getEmployee(int id);
	public List<Employee> getAllEmployees();
	public Employee updateEmployee(Employee employee, int id);
	public String deleteEMployee(int id);
	
	public Iterable<Department> getDepFromEmployee(int dId);
	
}
