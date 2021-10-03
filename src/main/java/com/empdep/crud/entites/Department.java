package com.empdep.crud.entites;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int depId;
	private String depName;
	private String depDescription;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "emp_fk")
	@JsonIgnore // to preveny infinte Recurision in json o/p
	private Employee employee;

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	//for creating object
	public Department(String depName, String depDescription, Employee employee) {
		super();
		this.depName = depName;
		this.depDescription = depDescription;
		this.employee = employee;
	}

	public Department(int depId, String depName, String depDescription, Employee employee) {
		super();
		this.depId = depId;
		this.depName = depName;
		this.depDescription = depDescription;
		this.employee = employee;
	}



	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getDepDescription() {
		return depDescription;
	}

	public void setDepDescription(String depDescription) {
		this.depDescription = depDescription;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Department [depId=" + depId + ", depName=" + depName + ", depDescription=" + depDescription
				+ ", employee=" + employee + "]";
	}
	
	
	
	
}
