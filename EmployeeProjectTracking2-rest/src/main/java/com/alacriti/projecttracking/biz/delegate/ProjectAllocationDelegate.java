package com.alacriti.projecttracking.biz.delegate;


import java.sql.Connection;
import java.util.List;

import com.alacriti.projecttracking.bo.ProjectAllocationBO;
import com.alacriti.projecttracking.model.ProjectAllocationVO;


public class ProjectAllocationDelegate extends BaseDelegate{

	public List<ProjectAllocationVO>  getProjectAllocationList() {
		boolean rollBack = false;
		Connection connection = null;
		ProjectAllocationBO projectAllocationBO =null;
		List<ProjectAllocationVO> projetAllotmentList = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
		    projectAllocationBO = new ProjectAllocationBO(connection);
			projetAllotmentList= projectAllocationBO.getProjectAllocationList();
		} catch (Exception e) {
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}

		return projetAllotmentList;
	}
	public void  projectAllotment(ProjectAllocationVO projectAllocationVO) {
		boolean rollBack = false;
		Connection connection = null;
		ProjectAllocationBO projectAllocationBO=null;
		try {
			System.out.println("delegate 1");
			connection = startDBTransaction();
			setConnection(connection);
			 projectAllocationBO = new ProjectAllocationBO(connection);
			System.out.println("delegate 2");
			projectAllocationBO.projectAllotment(projectAllocationVO);
		} catch (Exception e) {
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}

	}
	


}
