package com.alacriti.projecttracking.model;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class ProjectEmployeeGroupVO {
	private Project project = new Project();
	private ArrayList<Employee> empList;

	public ProjectEmployeeGroupVO(Project project, ArrayList<Employee> empList) {
		super();
		this.project = project;
		this.empList = empList;
	}

	public ProjectEmployeeGroupVO() {

	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public ArrayList<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(ArrayList<Employee> empList) {
		this.empList = empList;
	}
	
	
	public void setEmpList(String nameList)
	{
		
		System.out.println(nameList);
//		ArrayList<String> tempList=(ArrayList<String>) Arrays.asList(nameList.split(","));
		StringTokenizer stringTokenizer=new StringTokenizer(nameList,",");
		
		this.empList = new ArrayList<Employee>();
		
	    while (stringTokenizer.hasMoreTokens()) { 
	    	Employee emp = new Employee();
	    	emp.setEmployeeName(stringTokenizer.nextToken());
	    	this.empList.add(emp);  
	     } 
	    System.out.println(empList);
		
		
	}
	/*
	public static void main(String[] args) {	
		String list = "ram,shyam,ajeet";
		System.out.println("HI");
		ProjectEmployeeGroupVO grp = new ProjectEmployeeGroupVO();
		ArrayList<Employee> nameList = grp.setEmpList(list);
		
		
		System.out.println("dkajshdjkashkjd");
		for(Employee str : nameList) {
			System.out.println(str.getEmployeeName());
		}
		*/

}
