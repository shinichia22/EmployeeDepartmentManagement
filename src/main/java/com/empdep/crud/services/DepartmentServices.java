package com.empdep.crud.services;

import java.util.List;

import com.empdep.crud.entites.Department;


public interface DepartmentServices {
	
	public void addDepService(Department department);
	public Department getDepService(int id);
	public List<Department> getAllDepService();
	public Department updateDepService(Department department, int id);
	public String deleteDepService(int id);
	
}	
