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
		Connection conn=null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Project> list = null;
		try {
			list = new ArrayList<Project>();

			String sqlCmd = "select project_id,project_name from sandhyad_ept_project_details";
			conn=getConnection();
			stmt= conn.prepareStatement(sqlCmd);
			rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(new Project(rs.getInt(1), rs
						.getString(2)));
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
		Connection conn=null;
		PreparedStatement stmt = null;
		
		try{
			conn=getConnection();
		 stmt=conn.prepareStatement("insert into sandhyad_ept_project_details (project_id,project_name)values(?,?)");
		    
		    	 stmt.setInt(1, project.projectId);
		    	 stmt.setString(2, project.projectName);
		    	 stmt.executeUpdate();
				
		}catch(SQLException e){
			System.out.println("Error  :" + e.getMessage());
			throw new DAOException("Exception in ProjectDAO addProjects()");
		}
		finally {
			
			close(stmt);
		}
}
	}
	