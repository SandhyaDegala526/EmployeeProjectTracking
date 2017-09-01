package com.alacriti.projecttracking.biz.delegate;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.projecttracking.bo.EmployeeRoleBO;
import com.alacriti.projecttracking.model.vo.EmployeeRoleVO;

public class EmployeeRolesDelegate extends BaseDelegate {
	public static final Logger log = Logger
			.getLogger(EmployeeRolesDelegate.class);

	public List<EmployeeRoleVO> getEmployeeRoles() {
		log.debug("in EmployeeRolesDelegate.getEmployeeRoles");
		boolean rollBack = false;
		EmployeeRoleBO employeeRoleBO = null;
		Connection connection = null;
		List<EmployeeRoleVO> employeeList = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			employeeRoleBO = new EmployeeRoleBO(connection);
			employeeList = employeeRoleBO.getEmployeeRoles();
		} catch (Exception e) {
			log.error("exception in EmployeeRolesDelegate.getEmployeeRoles"
					+ e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}

		return employeeList;
	}
}