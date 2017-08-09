package com.alacriti.projecttracking.model;

public class Employee {
	private String employeeId;
	private String employeeName;
	private String employeeState;
	

	public Employee(String employeeId, String employeeName,String employeeState) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeState = employeeState;
		
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

	public String getEmployeeState() {
		return employeeState;
	}

	public void setEmployeeStatus(String employeeState) {
		this.employeeState = employeeState;
	}

	

}
