package com.alacriti.projecttracking.model.vo;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class ProjectEmployeeGroupVO {
	private ProjectVO project = new ProjectVO();
	private ArrayList<EmployeeVO> empList;

	public ProjectEmployeeGroupVO(ProjectVO project,
			ArrayList<EmployeeVO> empList) {
		super();
		this.project = project;
		this.empList = empList;
	}

	public ProjectEmployeeGroupVO() {

	}

	public ProjectVO getProject() {
		return project;
	}

	public void setProject(ProjectVO project) {
		this.project = project;
	}

	public ArrayList<EmployeeVO> getEmpList() {
		return empList;
	}

	public void setEmpList(ArrayList<EmployeeVO> empList) {
		this.empList = empList;
	}

	public void setEmpList(String nameList) {

		System.out.println(nameList);
		StringTokenizer stringTokenizer = new StringTokenizer(nameList, ",");

		this.empList = new ArrayList<EmployeeVO>();

		while (stringTokenizer.hasMoreTokens()) {
			EmployeeVO emp = new EmployeeVO();
			emp.setEmployeeName(stringTokenizer.nextToken());
			this.empList.add(emp);
		}
		System.out.println(empList);

	}

}
