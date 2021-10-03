package com.empdep.crud.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandleController {
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<String> handleEMployyeNotFound(EmployeeNotFoundException employeeNotFoundException ){
		return new ResponseEntity<String>("Employee not found", HttpStatus.BAD_REQUEST ); 
	}
	
	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<String> handleDepartmentNotFound(DepartmentNotFoundException departmentNotFoundException ){
		return new ResponseEntity<String>("Department not found", HttpStatus.BAD_REQUEST ); 
	}
	
}
