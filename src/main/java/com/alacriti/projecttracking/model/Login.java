package com.alacriti.projecttracking.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Login {
	public String empId;
	public String password;

	public Login(String empId, String password) {
		this.empId = empId;
		this.password = password;
	}

	public Login() {

	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
