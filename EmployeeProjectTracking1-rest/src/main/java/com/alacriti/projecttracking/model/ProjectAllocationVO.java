package com.alacriti.projecttracking.model;

import java.sql.Date;

public class ProjectAllocationVO {
	private String employeeId;
	private String projectName;
	private Date employeeStartDate;
	private Date employeeEndDate;
	private String employeeRole;
	public ProjectAllocationVO(String employeeId, String projectName,
			Date employeeStartDate, Date employeeEndDate, String employeeRole) {
		this.employeeId = employeeId;
		this.projectName = projectName;
		this.employeeStartDate = employeeStartDate;
		this.employeeEndDate = employeeEndDate;
		this.employeeRole = employeeRole;
	}
public ProjectAllocationVO() {
}
public String getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(String employeeId) {
	this.employeeId = employeeId;
}
public String getProjectName() {
	return projectName;
}
public void setProjectName(String projectName) {
	this.projectName = projectName;
}
public Date getEmployeeStartDate() {
	return employeeStartDate;
}
public void setEmployeeStartDate(Date employeeStartDate) {
	this.employeeStartDate = employeeStartDate;
}
public Date getEmployeeEndDate() {
	return employeeEndDate;
}
public void setEmployeeEndDate(Date employeeEndDate) {
	this.employeeEndDate = employeeEndDate;
}
public String getEmployeeRole() {
	return employeeRole;
}
public void setEmployeeRole(String employeeRole) {
	this.employeeRole = employeeRole;
}

}
