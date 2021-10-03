package com.empdep.crud.daos;

import java.util.List;

import com.empdep.crud.entites.Department;


public interface DepartmentDao {
	
	public String saveDepartment(Department department);
	public Department getDepartment(int id);
	public List<Department> getAllDepartments();
	public Department updateDepartment(Department employee, int id);
	public String deleteDepartment(int id);
	
}
