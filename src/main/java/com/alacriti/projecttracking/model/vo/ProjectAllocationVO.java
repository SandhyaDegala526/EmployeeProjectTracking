package com.alacriti.projecttracking.model.vo;

import java.sql.Date;

public class ProjectAllocationVO {
	private String employeeId;
	private String employeeName;
	private String projectName;
	private Date employeeStartDate;
	private Date employeeEndDate;
	private String employeeRole;
	private int projectId;
	private int emproleId;

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getEmproleId() {
		return emproleId;
	}

	public void setEmproleId(int emproleId) {
		this.emproleId = emproleId;
	}

	public ProjectAllocationVO(String employeeId, int projectId,
			Date employeeStartDate, Date employeeEndDate, int emproleId) {
		this.employeeId = employeeId;
		this.projectId = projectId;
		this.employeeStartDate = employeeStartDate;
		this.employeeEndDate = employeeEndDate;
		this.emproleId = emproleId;
	}

	public ProjectAllocationVO(String employeeName, String projectName,
			Date employeeStartDate, Date employeeEndDate, String employeeRole) {
		this.employeeName = employeeName;
		this.projectName = projectName;
		this.employeeStartDate = employeeStartDate;
		this.employeeEndDate = employeeEndDate;
		this.employeeRole = employeeRole;
	}

	public ProjectAllocationVO(String projectName, String employeeName) {
		this.employeeName = employeeName;
		this.projectName = projectName;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
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
