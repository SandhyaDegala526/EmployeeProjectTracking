package com.alacriti.projecttracking.bo;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.projecttracking.dao.DAOException;
import com.alacriti.projecttracking.dao.ProjectAllocationDAO;
import com.alacriti.projecttracking.model.vo.ProjectAllocationVO;

public class ProjectAllocationBO extends BaseBO {
	public static final Logger log = Logger
			.getLogger(ProjectAllocationBO.class);

	public ProjectAllocationBO() {

	}

	public ProjectAllocationBO(Connection conn) {
		super(conn);
	}

	public List<ProjectAllocationVO> getProjectAllocationList()
			throws BOException {
		log.debug("in ProjectAllocationBO.getProjectAllocationList");

		List<ProjectAllocationVO> list = null;
		ProjectAllocationDAO projectAllocationDAO = null;
		try {
			projectAllocationDAO = new ProjectAllocationDAO(getConnection());
			list = projectAllocationDAO.getProjectAllocationList();
		} catch (DAOException e) {
			log.error("DAO exception in ProjectAllocationBO.getProjectAllocationList"
					+ e.getMessage());
			throw new BOException("DAOException Occured");
		} catch (Exception e) {
			log.error("exception in ProjectAllocationBO.getProjectAllocationList"
					+ e.getMessage());
			throw new BOException();
		}
		return list;
	}

	public boolean projectAllotment(ProjectAllocationVO projectAllocation)
			throws BOException {
		log.debug("in ProjectAllocationBO.projectAllotment");

		ProjectAllocationDAO projectAllotmentDAO = null;
		boolean flag = false;
		try {
			projectAllotmentDAO = new ProjectAllocationDAO(getConnection());
			flag = projectAllotmentDAO.projectAllotment(projectAllocation);
		} catch (DAOException e) {
			log.error("DAO exception in ProjectAllocationBO.projectAllotment"
					+ e.getMessage());
			throw new BOException("DAOException Occured");
		} catch (Exception e) {
			log.error("exception in ProjectAllocationBO.projectAllotment"
					+ e.getMessage());
			throw new BOException();
		}
		return flag;
	}

}
