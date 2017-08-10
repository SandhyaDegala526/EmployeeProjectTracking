package com.alacriti.projecttracking.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alacriti.projecttracking.model.ProjectAllocationVO;
public class ProjectAllocationDAO extends BaseDAO
{

	public ProjectAllocationDAO() {

	}

	public ProjectAllocationDAO(Connection conn) {
		super(conn);
	}
	
	public List<ProjectAllocationVO> getProjectAllocationList()throws DAOException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<ProjectAllocationVO> list = null;
		try {
			list = new ArrayList<ProjectAllocationVO>();

			String sqlCmd = "select  employee_id,project_name,employee_start_date,employee_end_date,employee_role "+
			"from sandhyad_ept_project_allocation ORDER BY project_name";
			stmt =getPreparedStatement(getConnection(), sqlCmd);
			rs=executeQuery(stmt);
			while (rs.next()) {
				list.add(new ProjectAllocationVO(rs.getString("employee_id"), rs
						.getString("project_name"),rs.getDate("employee_start_date"),rs.getDate("employee_end_date"),rs.getString("employee_role")));
			}
		} catch (SQLException e) {

			System.out.println("Error  :" + e.getMessage());
			throw new DAOException("Exception in ProjectDAO getProjects()");
			

		} finally {

			close(stmt , rs);
		}
		return list;

	}
	public void projectAllotment(ProjectAllocationVO projectAllocation)throws DAOException {
		//Connection conn=null;
		PreparedStatement stmt = null;
		
		try{

	String sqlCmd ="insert into sandhyad_ept_project_allocation"
		+ "(employee_id,project_name,employee_start_date,employee_end_date,employee_role) "
			 + "values(?,?,?,?,?)";
			System.out.println("DAO  1");
			stmt =getPreparedStatement(getConnection(), sqlCmd);
		    stmt.setString(1, projectAllocation.getEmployeeId());
		    	 stmt.setString(2, projectAllocation.getProjectName());
		    	 stmt.setDate(3,projectAllocation.getEmployeeStartDate());
		    	 stmt.setDate(4,projectAllocation.getEmployeeEndDate());
		    	 stmt.setString(5,projectAllocation.getEmployeeRole());
	    	 stmt.executeUpdate();
	    	 close(stmt);
	    	sqlCmd="update sandhyad_ept_employee_details set employee_state='assigned' where employee_id=?";
	    	stmt =getPreparedStatement(getConnection(), sqlCmd);
		    stmt.setString(1, projectAllocation.getEmployeeId());
		    stmt.executeUpdate();
			System.out.println("DAO");	
		}catch(SQLException e){
			System.out.println("Error  :" + e.getMessage());
			throw new DAOException("Exception in ProjectDAO addProjects()");
		}
		finally {
			
			close(stmt);
		}
}
	
	
	}
	
