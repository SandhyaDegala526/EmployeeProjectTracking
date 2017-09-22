package com.alacriti.projecttracking.model;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Project {
	public int projectId;
	public String projectName;
	public Project(int projectId, String projectName) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
	}

	public Project() {

	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}
