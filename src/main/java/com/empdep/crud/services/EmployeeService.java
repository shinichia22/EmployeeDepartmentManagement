package com.empdep.crud.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.empdep.crud.entites.Department;
import com.empdep.crud.entites.Employee;

public interface EmployeeService {
	
	public void addEmpService(Employee employee);
	public Employee getEmpService(int id);
	public List<Employee> getAllEmpService();
	public Employee updateEmpService(Employee employee, int id);
	public String deleteEmpService(int id);
	
	public Iterable<Department> getDeptFromEmpService(int dId);	
}
