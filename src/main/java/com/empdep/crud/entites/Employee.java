package com.empdep.crud.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value = {"department"}, allowGetters = false, allowSetters = true) // to get only Employee
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empNo;
	private String empName;
	private String empAddress;
	private long empSalary;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Department> department = new ArrayList<>();
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int empNo, String empName, String empAddress, long empSalary, List<Department> department) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.empAddress = empAddress;
		this.empSalary = empSalary;
		this.department = department;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public long getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(long empSalary) {
		this.empSalary = empSalary;
	}

	public List<Department> getDepartment() {
		return department;
	}

	public void setDepartment(List<Department> department) {
		this.department = department;
	}
	
	public void addDepartment(Department dep) {
		department.add(dep);
	}
	
	public void removeDept(Department dep) {
		department.remove(dep);
	}

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", empAddress=" + empAddress + ", empSalary="
				+ empSalary + ", department=" + department + "]";
	}
	
	
	
}


