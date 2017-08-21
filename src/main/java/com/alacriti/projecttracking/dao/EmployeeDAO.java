package com.alacriti.projecttracking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.projecttracking.model.vo.EmployeeVO;
import static com.alacriti.projecttracking.constants.DataBaseConstants.EMPLOYEE_STATUS_NOT_ASSIGNED;

public class EmployeeDAO extends BaseDAO {
	public static final Logger log = Logger.getLogger(EmployeeDAO.class);

	

	public EmployeeDAO() {

	}

	public EmployeeDAO(Connection conn) {
		super(conn);
	}

	public List<EmployeeVO> getEmployeeList() throws DAOException {
		log.debug("in EmployeeDAO.getEmployeeList");

		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<EmployeeVO> list = null;
		try {
			list = new ArrayList<EmployeeVO>();
			String sqlCmd = "select employee_id,employee_name,empstatus_id from sandhyad_ept_employee_details;";
			stmt = getPreparedStatement(getConnection(), sqlCmd);
			rs = executeQuery(stmt);
			while (rs.next()) {
				list.add(new EmployeeVO(rs.getString(1), rs.getString(2), rs
						.getInt(3)));
			}
		} catch (SQLException e) {

			log.error("SQLException in EmployeeDAO.getEmployeeList"
					+ e.getMessage());
			throw new DAOException("Exception in getEmployee in Employee");

		} finally {

			close(stmt, rs);
		}
		return list;

	}

	public String addEmployee(EmployeeVO employee) throws DAOException {
		log.debug("in EmployeeDAO.addEmployee");

		PreparedStatement stmt = null;
		int rowNumber;
		String status = "fail";
		try {

			String sqlCmdinsert = "insert into sandhyad_ept_employee_details(employee_id,employee_name,empstatus_id) values(?,?,?)";
			stmt = getPreparedStatement(getConnection(), sqlCmdinsert);
			stmt.setString(1, employee.getEmployeeId());
			stmt.setString(2, employee.getEmployeeName());
			stmt.setInt(3, employee.getEmployeeState());
			rowNumber = stmt.executeUpdate();
			if (rowNumber >= 1) {
				status = "success";
			}

		} catch (SQLException e) {
			log.error("exception in EmployeeDAO.addEmployee" + e.getMessage());
			throw new DAOException("Exception in addEmployee in Employee");

		} finally {
			close(stmt);
		}
		return status;
	}

	public List<EmployeeVO> getNotAssignedEmployees() throws DAOException {
		log.debug("in EmployeeDAO.getNotAssignedEmployees");

		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<EmployeeVO> list = null;
		try {
			list = new ArrayList<EmployeeVO>();
			String sqlCmd = "select employee_id,employee_name from sandhyad_ept_employee_details"
					+ " where empstatus_id=?";
			stmt = getPreparedStatement(getConnection(), sqlCmd);
			stmt.setInt(1,EMPLOYEE_STATUS_NOT_ASSIGNED );
			rs = executeQuery(stmt);
			while (rs.next()) {
				list.add(new EmployeeVO(rs.getString(1), rs.getString(2)));

			}

		} catch (SQLException e) {
			log.error("exception in EmployeeDAO.getNotAssignedEmployees"
					+ e.getMessage());
			throw new DAOException("Exception in ProjectDAO getProjects()");

		} finally {

			close(stmt, rs);
		}
		return list;

	}

}