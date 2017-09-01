package com.alacriti.projecttracking.model.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoginVO {
	public String empId;
	public String password;

	public LoginVO(String empId, String password) {
		this.empId = empId;
		this.password = password;
	}

	public LoginVO() {

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
