package com.empdep.crud.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empdep.crud.daos.EmployeeDao;
import com.empdep.crud.entites.Department;
import com.empdep.crud.entites.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDao employeeDao;

	@Override
	public void addEmpService(Employee employee) {
		employeeDao.saveEmployee(employee);
		
	}

	@Override
	public Employee getEmpService(int id) {
	Employee employee = employeeDao.getEmployee(id);
		
		return employee;
	}

	@Override
	public List<Employee> getAllEmpService() {
		return	employeeDao.getAllEmployees();
	}

	@Override
	public Employee updateEmpService(Employee employee, int id) {
		Employee updatedEMp =  employeeDao.updateEmployee(employee, id);
		return updatedEMp;
	}

	@Override
	public String deleteEmpService(int id) {
		return employeeDao.deleteEMployee(id);
	}

	@Override
	public Iterable<Department> getDeptFromEmpService(int dId) {
		return	employeeDao.getDepFromEmployee(dId);
	}

	
	
}
