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
import com.empdep.crud.entites.Employee;
import com.empdep.crud.services.EmployeeService;

@RestController
@RequestMapping("/api/v1/emp")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	
	@PostMapping("/saveEmployee")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee){
		employeeService.addEmpService(employee);
		return new ResponseEntity<String>("Employee created successfully",HttpStatus.CREATED);	
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable String id){
		Employee emp =  employeeService.getEmpService(Integer.parseInt(id));
		return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public Iterable<Employee>  gellAllEployees(){
		return employeeService.getAllEmpService();
	}
	
	@PutMapping("updateEmployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable int id){
		Employee updatedEmp =  employeeService.updateEmpService(employee, id);
			return new	ResponseEntity<Employee>(updatedEmp, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id){
		String status = employeeService.deleteEmpService(id);
		return new ResponseEntity<String>(status, HttpStatus.ACCEPTED); 
	}
	
	@GetMapping("/employee/{eid}/department")
	public Iterable<Department> getDeptfromEmployee(@PathVariable int eid){
		return employeeService.getDeptFromEmpService(eid);
	}
	
	
}
