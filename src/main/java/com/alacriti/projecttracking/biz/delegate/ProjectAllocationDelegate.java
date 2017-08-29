package com.alacriti.projecttracking.biz.delegate;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.projecttracking.bo.ProjectAllocationBO;
import com.alacriti.projecttracking.model.vo.ProjectAllocationVO;

public class ProjectAllocationDelegate extends BaseDelegate {
	public static final Logger log = Logger.getLogger(ProjectAllocationDelegate.class);

	public List<ProjectAllocationVO> getProjectAllocationList() {
		log.debug("ProjectAllocationDelegate.getProjectAllocationList start");
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
			log.error("exception in ProjectAllocationDelegate.getProjectAllocationList" + e.getMessage());

			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}

		return projetAllotmentList;
	}

	public String projectAllotment(ProjectAllocationVO projectAllocationVO) {
		log.debug(" ProjectAllocationDelegate.projectAllotment start");

		boolean rollBack = false;
		Connection connection = null;
		ProjectAllocationBO projectAllocationBO = null;
	String status="fail";
		try {
			connection = startDBTransaction();
			setConnection(connection);
			projectAllocationBO = new ProjectAllocationBO(connection);
			status = projectAllocationBO.projectAllotment(projectAllocationVO);
		} catch (Exception e) {
			log.error("exception in ProjectAllocationDelegate.projectAllotment" + e.getMessage());

			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
		return status;

	}

}
