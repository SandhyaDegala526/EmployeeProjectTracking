package com.alacriti.projecttracking.bo;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.projecttracking.dao.DAOException;
import com.alacriti.projecttracking.dao.ProjectDAO;
import com.alacriti.projecttracking.model.vo.ProjectEmployeeGroupVO;
import com.alacriti.projecttracking.model.vo.ProjectVO;

public class ProjectBO extends BaseBO {
	public static final Logger log = Logger.getLogger(ProjectBO.class);

	public ProjectBO() {

	}

	public ProjectBO(Connection conn) {
		super(conn);
	}

	public List<ProjectVO> getProjectList() throws BOException {
		log.debug("in ProjectBO.getProjectList");

		List<ProjectVO> list = null;
		ProjectDAO projectDAO = null;
		try {
			projectDAO = new ProjectDAO(getConnection());
			list = projectDAO.getProjectList();
		} catch (DAOException e) {
			log.error("DAO exception in ProjectBO.getProjectList"
					+ e.getMessage());
			throw new BOException("DAOException Occured");
		} catch (Exception e) {
			log.error("exception in ProjectBO.getProjectList" + e.getMessage());
			throw new BOException();
		}
		return list;
	}

	public boolean addProjects(ProjectVO project) throws BOException {
		log.debug("in ProjectBO.addProjects");

		ProjectDAO projectDAO = null;
		boolean flag = false;
		try {
			projectDAO = new ProjectDAO(getConnection());
			flag = projectDAO.addProject(project);
		} catch (DAOException e) {
			log.error("DAO exception in ProjectBO.addProjects" + e.getMessage());
			throw new BOException("DAOException Occured");
		} catch (Exception e) {
			log.error("exception in ProjectBO.addProjects" + e.getMessage());
			throw new BOException();
		}
		return flag;
	}

	public List<ProjectEmployeeGroupVO> getDatewiseProjects(ProjectVO project)
			throws BOException {
		log.debug("in ProjectBO.getDatewiseProjects");

		ProjectDAO projectDAO = null;
		List<ProjectEmployeeGroupVO> projectList = null;
		try {
			projectDAO = new ProjectDAO(getConnection());
			projectList = projectDAO.getDatewiseProjects(project);
		} catch (DAOException e) {
			log.error("DAO exception in ProjectBO.getDatewiseProjects"
					+ e.getMessage());
			throw new BOException("DAOException Occured");
		} catch (Exception e) {
			log.error("exception in ProjectBO.getDatewiseProjects"
					+ e.getMessage());
			throw new BOException();
		}
		return projectList;
	}

	public List<ProjectVO> getProjectDurations() throws BOException {
		log.debug("in ProjectBO.getProjectDurations");

		ProjectDAO projectDAO = null;
		List<ProjectVO> projectList = null;
		try {
			projectDAO = new ProjectDAO(getConnection());
			projectList = projectDAO.getProjectDurations();
		} catch (DAOException e) {
			log.error("DAO exception in ProjectBO.getProjectDurations"
					+ e.getMessage());
			throw new BOException("DAOException Occured");
		} catch (Exception e) {
			log.error("exception in ProjectBO.getProjectDurations"
					+ e.getMessage());
			throw new BOException();
		}
		return projectList;
	}

}
