package com.empdep.crud.exceptions;

import org.springframework.stereotype.Component;

@Component
public class DepartmentNotFoundException extends RuntimeException {
	
	private String errorMessage;

	public DepartmentNotFoundException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public DepartmentNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
	
	
	

}
