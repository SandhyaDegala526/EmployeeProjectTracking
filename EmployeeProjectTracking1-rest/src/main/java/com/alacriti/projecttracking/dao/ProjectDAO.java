package com.alacriti.projecttracking.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alacriti.projecttracking.model.Project;
public class ProjectDAO extends BaseDAO
{

	public ProjectDAO() {

	}

	public ProjectDAO(Connection conn) {
		super(conn);
	}
	
	public List<Project> getProjectList()throws DAOException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Project> list = null;
		try {
			list = new ArrayList<Project>();

			String sqlCmd = "select project_id,project_name,project_start_date,project_end_date from sandhyad_ept_project_details";
			stmt =getPreparedStatement(getConnection(), sqlCmd);
			rs=executeQuery(stmt);
			while (rs.next()) {
				list.add(new Project(rs.getInt(1), rs
						.getString(2),rs.getDate(3),rs.getDate(4)));
			}
		} catch (SQLException e) {

			System.out.println("Error  :" + e.getMessage());
			throw new DAOException("Exception in ProjectDAO getProjects()");
			

		} finally {

			close(stmt , rs);
		}
		return list;

	}
	public void addProject(Project project)throws DAOException {
		//Connection conn=null;
		PreparedStatement stmt = null;
		
		try{

			String sqlCmd ="insert into sandhyad_ept_project_details (project_id,project_name,project_start_date,project_end_date) "
			 		+ "values(?,?,?,?)";
		 /*stmt=conn.prepareStatement("insert into sandhyad_ept_project_details (project_id,project_name,project_start_date,project_end_date) "
		 		+ "values(?,?,?,?)");*/
			stmt =getPreparedStatement(getConnection(), sqlCmd);
		    stmt.setInt(1, project.getProjectId());
		    	 stmt.setString(2, project.getProjectName());
		    	 stmt.setDate(3,project.getProjectStartDate());
		    	 stmt.setDate(4,project.getProjectEndDate());
	    	 stmt.executeUpdate();
//		    	 executeUpdate(stmt);
				
		}catch(SQLException e){
			System.out.println("Error  :" + e.getMessage());
			throw new DAOException("Exception in ProjectDAO addProjects()");
		}
		finally {
			
			close(stmt);
		}
}
	}
	