package com.alacriti.projecttracking.biz.delegate;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.projecttracking.bo.ProjectBO;
import com.alacriti.projecttracking.model.vo.ProjectVO;
import com.alacriti.projecttracking.model.vo.ProjectEmployeeGroupVO;

public class ProjectDelegate extends BaseDelegate {
	public static final Logger log = Logger.getLogger(ProjectDelegate.class);

	public List<ProjectVO> getProjectList() {
		boolean rollBack = false;
		Connection connection = null;
		List<ProjectVO> projectList = null;
		ProjectBO projectBO = null;
		try {
			log.debug("in ProjectDelegate.getProjectList");
			connection = startDBTransaction();
			setConnection(connection);
			projectBO = new ProjectBO(connection);
			projectList = projectBO.getProjectList();
		} catch (Exception e) {
			log.error("exception in ProjectDelegate.getProjectList"
					+ e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}

		return projectList;
	}

	public boolean addProject(ProjectVO project) {
		boolean rollBack = false;
		Connection connection = null;
		ProjectBO projectBO = null;
		boolean flag = false;
		try {
			log.debug("in ProjectDelegate.addProject");

			connection = startDBTransaction();
			setConnection(connection);
			projectBO = new ProjectBO(connection);
			flag = projectBO.addProjects(project);
		} catch (Exception e) {
			log.error("exception in ProjectDelegate.addProject"
					+ e.getMessage());

			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
		return flag;
	}

	public List<ProjectEmployeeGroupVO> getDatewiseProjects(ProjectVO project) {
		boolean rollBack = false;
		Connection connection = null;
		ProjectBO projectBO = null;
		List<ProjectEmployeeGroupVO> projectList = null;
		try {
			log.debug("in ProjectDelegate.getDatewiseProjects");

			connection = startDBTransaction();
			setConnection(connection);
			projectBO = new ProjectBO(connection);
			projectList = projectBO.getDatewiseProjects(project);
		} catch (Exception e) {
			log.error("exception in ProjectDelegate.getDatewiseProjects"
					+ e.getMessage());

			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
		return projectList;

	}

	public List<ProjectVO> getProjectDurations() {
		boolean rollBack = false;
		Connection connection = null;
		ProjectBO projectBO = null;
		List<ProjectVO> projectList = null;
		try {
			log.debug("in ProjectDelegate.getProjectDurations");

			connection = startDBTransaction();
			setConnection(connection);
			projectBO = new ProjectBO(connection);
			projectList = projectBO.getProjectDurations();
		} catch (Exception e) {
			log.error("exception in ProjectDelegate.getProjectDurations"
					+ e.getMessage());

			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
		return projectList;

	}
}
