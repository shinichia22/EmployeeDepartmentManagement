package com.empdep.crud.exceptions;

import org.springframework.stereotype.Component;

@Component
public class EmployeeNotFoundException extends RuntimeException {

		private String errorMessage;

		public EmployeeNotFoundException(String errorMessage) {
			super();
			this.errorMessage = errorMessage;
		}

		public EmployeeNotFoundException() {
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
