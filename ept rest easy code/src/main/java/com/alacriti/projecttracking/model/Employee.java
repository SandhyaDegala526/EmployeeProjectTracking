package com.alacriti.projecttracking.model;

public class Employee {
	private String employeeId;
	private String employeeName;
	private String employeeStatus;
	

	public Employee(String employeeId, String employeeName,String employeeStatus) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeStatus = employeeStatus;
		
	}

	public Employee() {

	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	

}
