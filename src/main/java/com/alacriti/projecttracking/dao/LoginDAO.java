package com.alacriti.projecttracking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.alacriti.projecttracking.model.vo.LoginVO;

public class LoginDAO extends BaseDAO {
	public static final Logger log = Logger.getLogger(LoginDAO.class);

	public LoginDAO() {

	}

	public LoginDAO(Connection conn) {
		super(conn);
	}

	public boolean verify(LoginVO login) throws DAOException {
		log.debug(" LoginDAO.verify start");

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean flag = false;

		try {

			String sqlCmd = "select emp_id,password from sandhyad_ept_login_details where emp_id=? and password=?";
			conn = getConnection();
			stmt = conn.prepareStatement(sqlCmd);
			stmt.setString(1, login.getEmpId());
			stmt.setString(2, login.getPassword());
			rs = stmt.executeQuery();
			if (rs.next()) {
				flag = true;
			}

		} catch (SQLException e) {
			log.error("SQLException in LoginDAO.verify"
					+ e.getMessage());
			throw new DAOException("SQLException in LoginDAO:", e);
		} finally {
			close(stmt, rs);
		}
		return flag;
	}
}
