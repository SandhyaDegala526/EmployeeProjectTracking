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

			String sqlCmd = "select  project_name,employee_name,employee_start_date,employee_end_date,employee_role "+
			"from sandhyad_ept_project_allocation ORDER BY project_name";
			stmt =getPreparedStatement(getConnection(), sqlCmd);
			rs=executeQuery(stmt);
			while (rs.next()) {
				ProjectAllocationVO projectAllocationVO=new ProjectAllocationVO();
				projectAllocationVO.setProjectName(rs.getString("project_name"));
				projectAllocationVO.setEmployeeName(rs.getString("employee_name"));
				projectAllocationVO.setEmployeeStartDate(rs.getDate("employee_start_date"));
				projectAllocationVO.setEmployeeEndDate(rs.getDate("employee_end_date"));
				projectAllocationVO.setEmployeeRole(rs.getString("employee_role"));
				list.add(projectAllocationVO);
			}
		} catch (SQLException e) {

			e.printStackTrace();			
			throw new DAOException("Exception in ProjectDAO getProjects()");
			

		} finally {

			close(stmt , rs);
		}
		return list;

	}
	public void projectAllotment(ProjectAllocationVO projectAllocation)throws DAOException {

		PreparedStatement stmt = null;
		
		try{

	String sqlCmd ="insert into sandhyad_ept_project_allocation"
		+ "(employee_id,employee_name,project_name,employee_start_date,employee_end_date,employee_role) "
			 + "values(?,?,?,?,?,?)";
			System.out.println("DAO  1");
			stmt =getPreparedStatement(getConnection(), sqlCmd);
		    stmt.setString(1, projectAllocation.getEmployeeId());
		    stmt.setString(2, projectAllocation.getEmployeeName());
		    stmt.setString(3, projectAllocation.getProjectName());
		    stmt.setDate(4,projectAllocation.getEmployeeStartDate());
		    stmt.setDate(5,projectAllocation.getEmployeeEndDate());
		    stmt.setString(6,projectAllocation.getEmployeeRole());
	    	 stmt.executeUpdate();
	    	sqlCmd="update sandhyad_ept_employee_details set employee_state='assigned' where employee_id=?";
	    	stmt =getPreparedStatement(getConnection(), sqlCmd);
		    stmt.setString(1, projectAllocation.getEmployeeId());
		    stmt.executeUpdate();
			System.out.println("DAO");	
		}catch(SQLException e){
			e.printStackTrace();
			throw new DAOException("Exception in ProjectDAO addProjects()");
		}
		finally {
			
			close(stmt);
		}
}
	
	
	}
	
