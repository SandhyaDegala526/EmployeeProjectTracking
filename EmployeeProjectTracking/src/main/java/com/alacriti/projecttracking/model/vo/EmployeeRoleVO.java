package com.alacriti.projecttracking.model.vo;

public class EmployeeRoleVO {
private int emproleId;
private String employeeRole;
public EmployeeRoleVO(int emproleId, String employeeRole) {
	super();
	this.emproleId = emproleId;
	this.employeeRole = employeeRole;
}
public EmployeeRoleVO()
{
	
}

public int getEmproleId() {
	return emproleId;
}
public void setEmproleId(int emproleId) {
	this.emproleId = emproleId;
}
public String getEmployeeRole() {
	return employeeRole;
}
public void setEmployeeRole(String employeeRole) {
	this.employeeRole = employeeRole;
}

}
