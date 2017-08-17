package com.alacriti.projecttracking.bo;

import java.sql.Connection;
import java.util.List;

import com.alacriti.projecttracking.dao.BaseDAO;
import com.alacriti.projecttracking.dao.DAOException;
import com.alacriti.projecttracking.dao.ProjectAllocationDAO;
import com.alacriti.projecttracking.model.ProjectAllocationVO;


public class ProjectAllocationBO extends BaseDAO {
	
	public ProjectAllocationBO() {

	}

	public ProjectAllocationBO(Connection conn) {
		super(conn);
	}
public List<ProjectAllocationVO> getProjectAllocationList() throws BOException {
		List<ProjectAllocationVO>  list= null;
		ProjectAllocationDAO projectAllocationDAO=null;
		try {
			projectAllocationDAO = new ProjectAllocationDAO(getConnection());
			list = projectAllocationDAO.getProjectAllocationList();
		} catch (DAOException e) {
			e.printStackTrace();
			throw new BOException("DAOException Occured");
		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException();
		}
		return list;
	}
	public void projectAllotment(ProjectAllocationVO projectAllocation) throws BOException {
		ProjectAllocationDAO projectAllotmentDAO=null;
		try {
			System.out.println("BO 1");
			projectAllotmentDAO = new ProjectAllocationDAO(getConnection());
			System.out.println("BO 2");
			projectAllotmentDAO.projectAllotment(projectAllocation);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new BOException("DAOException Occured");
		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException();
		}
	}
	
}

