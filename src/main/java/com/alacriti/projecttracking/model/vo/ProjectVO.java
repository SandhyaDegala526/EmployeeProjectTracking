package com.alacriti.projecttracking.model.vo;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProjectVO {
	private int projectId;
	private String projectName;
	private Date projectStartDate;
	private Date projectEndDate;

	public ProjectVO() {

	}

	public ProjectVO(String projectName, Date projectStartDate,
			Date projectEndDate) {
		super();
		this.projectName = projectName;
		this.projectStartDate = projectStartDate;
		this.projectEndDate = projectEndDate;
	}

	public ProjectVO(int projectId, String projectName) {
		this.projectId = projectId;
		this.projectName = projectName;
	}

	public Date getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public Date getProjectEndDate() {
		return projectEndDate;
	}

	public void setProjectEndDate(Date projectEndDate) {
		this.projectEndDate = projectEndDate;
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
