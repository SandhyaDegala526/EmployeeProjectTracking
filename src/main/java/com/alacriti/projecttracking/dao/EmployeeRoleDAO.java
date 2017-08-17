package com.alacriti.projecttracking.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alacriti.projecttracking.model.EmployeeRole;


public class EmployeeRoleDAO extends BaseDAO {

	public EmployeeRoleDAO() {

	}

	public EmployeeRoleDAO(Connection conn) {
		super(conn);
	}
	public List<EmployeeRole> getEmployeeRoles() throws DAOException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<EmployeeRole> list = null;
		try {
			list = new ArrayList<EmployeeRole>();
			String sqlCmd = "select employee_role from sandhyad_ept_employee_roles;";
			stmt =getPreparedStatement(getConnection(), sqlCmd);
			rs=executeQuery(stmt);
			
			while (rs.next()) {
				EmployeeRole employeeRole=new EmployeeRole();
				employeeRole.setEmployeeRole(rs.getString("employee_role"));
				list.add(employeeRole);
			}
		} catch (SQLException e) {

			e.printStackTrace();
			throw new DAOException("Exception in getEmployee in Employee");

		} finally {

			close(stmt, rs);
		}
		return list;


	}
	}