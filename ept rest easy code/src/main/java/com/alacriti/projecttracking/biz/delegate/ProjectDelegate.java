package com.alacriti.projecttracking.biz.delegate;

import java.sql.Connection;
import java.util.List;

import com.alacriti.projecttracking.bo.ProjectBO;
import com.alacriti.projecttracking.model.Project;

public class ProjectDelegate extends BaseDelegate {

	public List<Project>  getProjectList() {
		boolean rollBack = false;
		Connection connection = null;
		List<Project> projectList = null;
		ProjectBO sampleBO=null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			sampleBO  = new ProjectBO(connection);
			projectList= sampleBO.getProjectList();
		} catch (Exception e) {
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}

		return projectList;
	}
	public void  addProject(Project projects[]) {
		boolean rollBack = false;
		Connection connection = null;
		ProjectBO sampleBO =null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			sampleBO = new ProjectBO(connection);
			sampleBO.addProjects(projects);
		} catch (Exception e) {
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}

	}
	


}
