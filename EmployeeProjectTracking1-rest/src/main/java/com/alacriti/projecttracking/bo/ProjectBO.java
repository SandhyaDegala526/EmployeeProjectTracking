package com.alacriti.projecttracking.bo;

import java.sql.Connection;
import java.util.List;

import com.alacriti.projecttracking.dao.BaseDAO;
import com.alacriti.projecttracking.dao.DAOException;
import com.alacriti.projecttracking.dao.ProjectDAO;
import com.alacriti.projecttracking.model.Project;


public class ProjectBO extends BaseDAO {
	
	public ProjectBO() {

	}

	public ProjectBO(Connection conn) {
		super(conn);
	}
	public List<Project> getProjectList() throws BOException {
		List<Project>  list= null;
		ProjectDAO accountDAO=null;
		try {
			accountDAO = new ProjectDAO(getConnection());
			list = accountDAO.getProjectList();
		} catch (DAOException e) {
			
			throw new BOException("DAOException Occured");
		} catch (Exception e) {
			
			throw new BOException();
		}
		return list;
	}
	public void addProjects(Project project) throws BOException {
		ProjectDAO accountDAO=null;
		try {
			accountDAO = new ProjectDAO(getConnection());
			 accountDAO.addProject(project);
		} catch (DAOException e) {
			
			throw new BOException("DAOException Occured");
		} catch (Exception e) {
			
			throw new BOException();
		}
	}
	
}

