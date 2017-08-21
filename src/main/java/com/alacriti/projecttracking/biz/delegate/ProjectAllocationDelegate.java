package com.alacriti.projecttracking.biz.delegate;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.projecttracking.bo.ProjectAllocationBO;
import com.alacriti.projecttracking.model.vo.ProjectAllocationVO;

public class ProjectAllocationDelegate extends BaseDelegate {
	public static final Logger log = Logger.getLogger(LoginDelegate.class);

	public List<ProjectAllocationVO> getProjectAllocationList() {
		log.debug("in LoginDelegate.verify");
		boolean rollBack = false;
		Connection connection = null;
		ProjectAllocationBO projectAllocationBO = null;
		List<ProjectAllocationVO> projetAllotmentList = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			projectAllocationBO = new ProjectAllocationBO(connection);
			projetAllotmentList = projectAllocationBO
					.getProjectAllocationList();
		} catch (Exception e) {
			log.error("exception in LoginDelegate.verify" + e.getMessage());

			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}

		return projetAllotmentList;
	}

	public boolean projectAllotment(ProjectAllocationVO projectAllocationVO) {
		log.debug("in LoginDelegate.verify");

		boolean rollBack = false;
		Connection connection = null;
		ProjectAllocationBO projectAllocationBO = null;
		boolean flag = false;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			projectAllocationBO = new ProjectAllocationBO(connection);
			flag = projectAllocationBO.projectAllotment(projectAllocationVO);
		} catch (Exception e) {
			log.error("exception in LoginDelegate.verify" + e.getMessage());

			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
		return flag;

	}

}
