package com.alacriti.projecttracking.dao;

import static com.alacriti.projecttracking.constants.DataBaseConstants.EMPLOYEE_STATUS_NOT_ASSIGNED;
import static com.alacriti.projecttracking.constants.DataBaseConstants.DELETE_STATUS_NOT_DELETED;
import static com.alacriti.projecttracking.constants.DataBaseConstants.DELETE_STATUS_DELETED;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.projecttracking.model.vo.EmployeeVO;

public class EmployeeDAO extends BaseDAO {
	public static final Logger log = Logger.getLogger(EmployeeDAO.class);

	public EmployeeDAO() {

	}

	public EmployeeDAO(Connection conn) {
		super(conn);
	}

	public List<EmployeeVO> getEmployeeList() throws DAOException {
		log.debug(" EmployeeDAO.getEmployeeList start");

		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<EmployeeVO> list = null;
		try {

			list = new ArrayList<EmployeeVO>();
			String sqlCmd = "select employee_id,employee_name,empstatus_id,delete_status from sandhyad_ept_employee_details "+
			" where delete_status=? order by employee_id;";
			stmt = getPreparedStatement(getConnection(), sqlCmd);
			stmt.setInt(1, DELETE_STATUS_NOT_DELETED);
			rs = executeQuery(stmt);
			while (rs.next()) {
				list.add(new EmployeeVO(rs.getString(1), rs.getString(2), rs
						.getInt(3)));
			}
		} catch (Exception e) {

			log.error("Exception in EmployeeDAO.getEmployeeList"
					+ e.getMessage());
			throw new DAOException();

		} finally {

			close(stmt, rs);
		}
		return list;

	}

	public String addEmployee(EmployeeVO employee) throws DAOException {
		log.debug(" EmployeeDAO.addEmployee start");

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

		} catch (Exception e) {
			log.error("exception in EmployeeDAO.addEmployee" + e.getMessage());
			throw new DAOException();

		} finally {
			close(stmt);
		}
		return status;
	}

	public List<EmployeeVO> getUnAssignedEmployees() throws DAOException {
		log.debug("EmployeeDAO.getUnAssignedEmployees start");

		PreparedStatement stmt = null;
		ResultSet rs = null;
		ResultSet projectResultset=null;
		ResultSet resultSet = null;
		List<EmployeeVO> list = null;
		PreparedStatement stmtUpdate = null;
		java.sql.Date date=null;
		try {
			String sqlCmd = "select  employee_id,employee_end_date  from sandhyad_ept_project_allocation"+
		" where employee_end_date<=?";
			stmt = getPreparedStatement(getConnection(), sqlCmd);
			long millis = System.currentTimeMillis();
			date = new java.sql.Date(millis);
			stmt.setDate(1, date);
			rs = executeQuery(stmt);
			while (rs.next()) {
					sqlCmd = " update sandhyad_ept_employee_details set empstatus_id=? where employee_id=? ";
					stmtUpdate = getPreparedStatement(getConnection(), sqlCmd);
					stmtUpdate.setInt(1, EMPLOYEE_STATUS_NOT_ASSIGNED);
					stmtUpdate.setString(2, rs.getString("employee_id"));
					stmtUpdate.executeUpdate();
				
			}
			 sqlCmd = "select a.employee_id,p.project_id,p.project_end_date from " +
					 " sandhyad_ept_project_details  p ,sandhyad_ept_project_allocation a " +
					 " where p.project_id=a.project_id and p.project_end_date<=? ";
			stmt = getPreparedStatement(getConnection(), sqlCmd);
			long millisec = System.currentTimeMillis();
			date = new java.sql.Date(millisec);
			stmt.setDate(1, date);
			projectResultset = executeQuery(stmt);
			while (projectResultset.next()) {
				sqlCmd = " update sandhyad_ept_employee_details set empstatus_id=? where employee_id=? ";
				stmtUpdate = getPreparedStatement(getConnection(), sqlCmd);
				stmtUpdate.setInt(1, EMPLOYEE_STATUS_NOT_ASSIGNED);
				stmtUpdate.setString(2, projectResultset.getString("employee_id"));
				stmtUpdate.executeUpdate();

			}
			list = new ArrayList<EmployeeVO>();
			sqlCmd = "select employee_id,employee_name from sandhyad_ept_employee_details"
					+ " where empstatus_id=? and delete_status=?";
			stmt = getPreparedStatement(getConnection(), sqlCmd);
			stmt.setInt(1, EMPLOYEE_STATUS_NOT_ASSIGNED);
			stmt.setInt(2, DELETE_STATUS_NOT_DELETED);
			resultSet = executeQuery(stmt);
			while (resultSet.next()) {
				list.add(new EmployeeVO(resultSet.getString(1), resultSet
						.getString(2)));

			}

		} catch (Exception e) {
			log.error("exception in EmployeeDAO.getUnAssignedEmployees"
					+ e.getMessage());
			throw new DAOException();

		} finally {

			close(stmt, rs);
			close(resultSet);
			close(projectResultset);
		}
		return list;

	}
	public boolean deleteEmployee(String employeeId) throws DAOException
	{
		log.debug("EmployeeDAO.deleteEmployee start");
		PreparedStatement stmt=null;
		int count=0;
		boolean flag=false;
		try{
			String sqlCmd="update sandhyad_ept_employee_details set delete_status=? where employee_id=?";
			stmt = getPreparedStatement(getConnection(), sqlCmd);
			stmt.setInt(1, DELETE_STATUS_DELETED);
			stmt.setString(2, employeeId);
			count=stmt.executeUpdate();
			if(count>0){
				flag=true;
			}
			
		}
		catch(Exception e){
			log.error("exception in EmployeeDAO.deleteEmployee"+e.getMessage());
			throw new DAOException();
		}
		finally{
		close(stmt);	
		}
		return flag;
	}
	public boolean checkEmpId(String employeeId)throws DAOException {
		PreparedStatement stmt=null;
		ResultSet rs=null;
		boolean flag=false;
		try{
			String sqlCmd = "select employee_id from sandhyad_ept_employee_details where employee_id=?;";
			stmt = getPreparedStatement(getConnection(), sqlCmd);
			stmt.setString(1, employeeId);
			rs = executeQuery(stmt);
			while (rs.next()) {
				flag=true;
			}
		}
		catch(Exception e){
			e.printStackTrace();
			log.error("exception in EmployeeDAO.checkEmpId"+e.getMessage());
			throw new DAOException();
		}
		finally{
		close(stmt,rs);	
		}
		return flag;
		
	}

}