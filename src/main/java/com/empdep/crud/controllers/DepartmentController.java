package com.empdep.crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empdep.crud.entites.Department;
import com.empdep.crud.services.DepartmentServices;

@RestController
@RequestMapping("/api/v1/dep")
public class DepartmentController {
	
	@Autowired
	DepartmentServices departmentServices;
	
	@PostMapping("/saveDepartment")
	public ResponseEntity<String>saveDepartment(@RequestBody Department department){
		departmentServices.addDepService(department);
		return new ResponseEntity<String>("Department created Successfully",HttpStatus.CREATED);
	}
	
	@GetMapping("/departments")
	public Iterable<Department> getAllDepratments() {
		return departmentServices.getAllDepService();
		
	}
	
	@GetMapping("/department/{id}")
	public ResponseEntity<Department> getDepartment(@PathVariable int id){
		Department dep =  departmentServices.getDepService(id);
		return new ResponseEntity<Department>( dep,HttpStatus.OK);
	}
		
	@PutMapping("updateDepartment/{id}")
	public ResponseEntity<Department> updateDepartment(@RequestBody Department department, @PathVariable int id){
		Department updatedDep = departmentServices.updateDepService(department, id);
		return new ResponseEntity<Department>(updatedDep,HttpStatus.CREATED);
	}
	
	@DeleteMapping("deleteDepartment/{id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable int id){
		String status = departmentServices.deleteDepService(id);
		return new ResponseEntity<String>(status,HttpStatus.OK);
	}
	
}
