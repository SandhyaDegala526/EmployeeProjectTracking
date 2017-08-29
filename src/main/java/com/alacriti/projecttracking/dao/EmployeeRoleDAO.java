package com.alacriti.projecttracking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.projecttracking.model.vo.EmployeeRoleVO;

public class EmployeeRoleDAO extends BaseDAO {
	public static final Logger log = Logger.getLogger(EmployeeRoleDAO.class);

	public EmployeeRoleDAO() {

	}

	public EmployeeRoleDAO(Connection conn) {
		super(conn);
	}

	public List<EmployeeRoleVO> getEmployeeRoles() throws DAOException {
		log.debug(" EmployeeRoleDAO.getEmployeeRoles start");
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<EmployeeRoleVO> list = null;
		try {
			list = new ArrayList<EmployeeRoleVO>();
			String sqlCmd = "select emprole_id,employee_role from sandhyad_ept_employee_roles;";
			stmt = getPreparedStatement(getConnection(), sqlCmd);
			rs = executeQuery(stmt);

			while (rs.next()) {
				EmployeeRoleVO employeeRole = new EmployeeRoleVO();
				employeeRole.setEmproleId(rs.getInt("emprole_id"));
				employeeRole.setEmployeeRole(rs.getString("employee_role"));
				list.add(employeeRole);
			}
		} catch (SQLException e) {

			log.error("SQLException in EmployeeRoleDAO.getEmployeeRoles"
					+ e.getMessage());
			throw new DAOException("Exception in getEmployee in Employee");

		} finally {

			close(stmt, rs);
		}
		return list;

	}
}