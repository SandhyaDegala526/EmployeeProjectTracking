package com.alacriti.projecttracking.biz.delegate;

import java.sql.Connection;
import java.util.List;

import com.alacriti.projecttracking.bo.ProjectBO;
import com.alacriti.projecttracking.model.Project;
import com.alacriti.projecttracking.model.ProjectEmployeeGroupVO;

public class ProjectDelegate extends BaseDelegate {

	public List<Project>  getProjectList() {
		boolean rollBack = false;
		Connection connection = null;
		List<Project> projectList = null;
		ProjectBO projectBO=null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			projectBO  = new ProjectBO(connection);
			projectList= projectBO.getProjectList();
		} catch (Exception e) {
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}

		return projectList;
	}
	public void  addProject(Project project) {
		boolean rollBack = false;
		Connection connection = null;
		ProjectBO projectBO =null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			projectBO = new ProjectBO(connection);
			projectBO.addProjects(project);
		} catch (Exception e) {
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}

	}
	public List<ProjectEmployeeGroupVO> getDatewiseProjects(Project project)
	{
		boolean rollBack=false;
		Connection connection=null;
		ProjectBO projectBO =null;
		List<ProjectEmployeeGroupVO> projectList = null;
		try {
			connection=startDBTransaction();
			setConnection(connection);
			projectBO = new ProjectBO(connection);
			projectList=projectBO.getDatewiseProjects(project);
		} catch (Exception e) {
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
		return projectList;

	}
	public List<Project> getProjectDurations()
	{
		boolean rollBack=false;
		Connection connection=null;
		ProjectBO projectBO =null;
		List<Project> projectList = null;
		try {
			connection=startDBTransaction();
			setConnection(connection);
			projectBO = new ProjectBO(connection);
			projectList=projectBO.getProjectDurations();
		} catch (Exception e) {
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
		return projectList;

	}
}
	
