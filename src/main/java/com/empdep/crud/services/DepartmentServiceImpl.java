package com.empdep.crud.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empdep.crud.daos.DepartmentDao;
import com.empdep.crud.entites.Department;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentServices {
	
	@Autowired
	DepartmentDao departmentDao;

	@Override
	public void addDepService(Department department) {
		departmentDao.saveDepartment(department);
	}

	@Override
	public Department getDepService(int id) {
		Department department = departmentDao.getDepartment(id);
		return department;
	}

	@Override
	public List<Department> getAllDepService() {
		return departmentDao.getAllDepartments();
	}

	@Override
	public Department updateDepService(Department department, int id) {
		Department updateDep =  departmentDao.updateDepartment(department, id);
		return updateDep;
	}

	@Override
	public String deleteDepService(int id) {
		return departmentDao.deleteDepartment(id);
	}

}
