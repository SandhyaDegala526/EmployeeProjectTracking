package com.alacriti.projecttracking.model.vo;

public class EmployeeVO {
	private String employeeId;
	private String employeeName;
	private int employeeState;
	

	public EmployeeVO(String employeeId, String employeeName,int employeeState) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeState = employeeState;
		
	}
	public EmployeeVO(String employeeId)
	{
		this.employeeId=employeeId;
	}
	public EmployeeVO(String employeeId,String employeeName)
	{
		this.employeeId=employeeId;
		this.employeeName=employeeName;
	}
	
	public EmployeeVO() {

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

	public int getEmployeeState() {
		return employeeState;
	}

	public void setEmployeeStatus(int employeeState) {
		this.employeeState = employeeState;
	}

	

}
