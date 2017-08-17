package com.alacriti.projecttracking.model;

public class EmployeeRole {
private int id;
private String employeeRole;
public EmployeeRole(int id, String employeeRole) {
	super();
	this.id = id;
	this.employeeRole = employeeRole;
}
public EmployeeRole()
{
	
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEmployeeRole() {
	return employeeRole;
}
public void setEmployeeRole(String employeeRole) {
	this.employeeRole = employeeRole;
}

}
