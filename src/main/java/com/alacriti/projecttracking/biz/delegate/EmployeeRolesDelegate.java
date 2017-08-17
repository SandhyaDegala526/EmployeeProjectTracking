package com.alacriti.projecttracking.biz.delegate;

import java.sql.Connection;
import java.util.List;

import com.alacriti.projecttracking.bo.EmployeeRoleBo;
import com.alacriti.projecttracking.model.EmployeeRole;

public class EmployeeRolesDelegate extends BaseDelegate {

	public List<EmployeeRole>  getEmployeeRoles() {
		boolean rollBack = false;
		EmployeeRoleBo employeeRoleBO=null;
		Connection connection = null;
		List<EmployeeRole> employeeList = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			 employeeRoleBO = new EmployeeRoleBo(connection);
			employeeList= employeeRoleBO.getEmployeeRoles();
		} catch (Exception e) {
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}

		return employeeList;
	}
}