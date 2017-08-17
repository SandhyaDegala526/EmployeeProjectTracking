package com.alacriti.projecttracking.bo;

import java.sql.Connection;
import java.util.List;

import com.alacriti.projecttracking.dao.BaseDAO;
import com.alacriti.projecttracking.dao.DAOException;
import com.alacriti.projecttracking.dao.ProjectDAO;
import com.alacriti.projecttracking.model.Project;
import com.alacriti.projecttracking.model.ProjectEmployeeGroupVO;

public class ProjectBO extends BaseDAO {

	public ProjectBO() {

	}

	public ProjectBO(Connection conn) {
		super(conn);
	}

	public List<Project> getProjectList() throws BOException {
		List<Project> list = null;
		ProjectDAO projectDAO = null;
		try {
			projectDAO = new ProjectDAO(getConnection());
			list = projectDAO.getProjectList();
		} catch (DAOException e) {
			e.printStackTrace();
			throw new BOException("DAOException Occured");
		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException();
		}
		return list;
	}

	public void addProjects(Project project) throws BOException {
		ProjectDAO projectDAO = null;
		try {
			projectDAO = new ProjectDAO(getConnection());
			projectDAO.addProject(project);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new BOException("DAOException Occured");
		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException();
		}
	}

	public List<ProjectEmployeeGroupVO> getDatewiseProjects(Project project)
			throws BOException {
		ProjectDAO projectDAO = null;
		List<ProjectEmployeeGroupVO> projectList = null;
		try {
			projectDAO = new ProjectDAO(getConnection());
			projectList = projectDAO.getDatewiseProjects(project);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new BOException("DAOException Occured");
		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException();
		}
		return projectList;
	}

	public List<Project> getProjectDurations() throws BOException {
		ProjectDAO projectDAO = null;
		List<Project> projectList = null;
		try {
			projectDAO = new ProjectDAO(getConnection());
			projectList = projectDAO.getProjectDurations();
		} catch (DAOException e) {
			e.printStackTrace();
			throw new BOException("DAOException Occured");
		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException();
		}
		return projectList;
	}

}
