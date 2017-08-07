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

			String sqlCmd = "select * from sandhyad_ept_project";
			conn=getConnection();
			stmt= conn.prepareStatement(sqlCmd);
			rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(new Project(rs.getInt(1), rs
						.getString(2), rs.getDate(3), rs.getDate(4)));
			}
		} catch (SQLException e) {

			System.out.println("Error  :" + e.getMessage());
			throw new DAOException("Exception in ProjectDAO getProjects()");
			

		} finally {

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;

	}
	public void addProject(Project projects[])throws DAOException {
		Connection conn=null;
		PreparedStatement stmt = null;
		
		try{
			conn=getConnection();
		 stmt=conn.prepareStatement("insert into sandhyad_ept_project values(?,?,?,?)");
		     for(int i=0;i<(projects.length);i++){
		    	 stmt.setInt(1, projects[i].projectId);
		    	 stmt.setString(2, projects[i].projectName);
		    	 stmt.setDate(3, projects[i].startDate);
		    	 stmt.setDate(4, projects[i].endDate);
		    	 stmt.executeUpdate();
				}
				
		}catch(Exception e){
			System.out.println("Error  :" + e.getMessage());
			throw new DAOException("Exception in ProjectDAO addProjects()");
		}
		/*finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}*/
}
	}
	