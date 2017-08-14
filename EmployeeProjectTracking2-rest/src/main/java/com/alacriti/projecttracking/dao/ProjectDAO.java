package com.alacriti.projecttracking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alacriti.projecttracking.model.Project;
import com.alacriti.projecttracking.model.ProjectEmployeeGroupVO;

;
public class ProjectDAO extends BaseDAO {

	public ProjectDAO() {

	}

	public ProjectDAO(Connection conn) {
		super(conn);
	}

	public List<Project> getProjectList() throws DAOException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Project> list = null;
		try {
			list = new ArrayList<Project>();

			String sqlCmd = "select project_id,project_name,project_start_date,project_end_date from sandhyad_ept_project_details";
			stmt = getPreparedStatement(getConnection(), sqlCmd);
			rs = executeQuery(stmt);
			while (rs.next()) {
				list.add(new Project(rs.getInt(1), rs.getString(2), rs
						.getDate(3), rs.getDate(4)));
			}
		} catch (SQLException e) {

			System.out.println("Error  :" + e.getMessage());
			throw new DAOException("Exception in ProjectDAO getProjects()");

		} finally {

			close(stmt, rs);
		}
		return list;

	}

	public void addProject(Project project) throws DAOException {
		PreparedStatement stmt = null;

		try {

			String sqlCmd = "insert into sandhyad_ept_project_details (project_id,project_name,project_start_date,project_end_date) ";
			stmt = getPreparedStatement(getConnection(), sqlCmd);
			stmt.setInt(1, project.getProjectId());
			stmt.setString(2, project.getProjectName());
			stmt.setDate(3, project.getProjectStartDate());
			stmt.setDate(4, project.getProjectEndDate());
			stmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error  :" + e.getMessage());
			throw new DAOException("Exception in ProjectDAO addProjects()");
		} finally {

			close(stmt);
		}
	}

	public List<ProjectEmployeeGroupVO> getDatewiseProjects(Project project)
			throws DAOException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<ProjectEmployeeGroupVO> projectList = null;
		try {
			System.out.println("DAO");
			projectList = new ArrayList<ProjectEmployeeGroupVO>();
			if (project.getProjectName().equals("all")) {
				String sqlCmd = "select proj.project_name,group_concat(emp_proj.employee_name),"
						+ "proj.project_start_date,proj.project_end_date "
						+ "from sandhyad_ept_project_details proj inner join sandhyad_ept_project_allocation emp_proj "
						+ "on  proj.project_name=emp_proj.project_name "
						+ "where project_start_date>=? AND project_end_date<=? "
						+ " group by proj.project_name";

				stmt = getPreparedStatement(getConnection(), sqlCmd);
				System.out.println("DAO 3");
				stmt.setDate(1, project.getProjectStartDate());
				stmt.setDate(2, project.getProjectEndDate());
				rs = executeQuery(stmt);
				System.out.println("DAO 4");

			} else {
				String sqlCmd = "select proj.project_name,group_concat(emp_proj.employee_name),"
						+ "proj.project_start_date,proj.project_end_date "
						+ "from sandhyad_ept_project_details proj inner join sandhyad_ept_project_allocation emp_proj "
						+ "on  proj.project_name=emp_proj.project_name "
						+ "where project_start_date>=? AND project_end_date<=?  AND proj.project_name=?"
						+ " group by proj.project_name";
				stmt = getPreparedStatement(getConnection(), sqlCmd);
				System.out.println("DAO 1");
				stmt.setDate(1, project.getProjectStartDate());
				stmt.setDate(2, project.getProjectEndDate());
				stmt.setString(3, project.getProjectName());
				rs = executeQuery(stmt);
				System.out.println("DAO 2");

			}
			while (rs.next()) {

				ProjectEmployeeGroupVO employeeGroupVO = new ProjectEmployeeGroupVO();

				Project projectDAO = new Project();
				projectDAO.setProjectName(rs.getString(1));
				projectDAO.setProjectStartDate(rs.getDate(3));
				projectDAO.setProjectEndDate(rs.getDate(4));
				employeeGroupVO.setProject(projectDAO);
				employeeGroupVO.setEmpList(rs.getString(2));
				System.out.println(employeeGroupVO.getEmpList());

				projectList.add(employeeGroupVO);
				System.out.println("DAO 3");
			}
		} catch (SQLException e) {
			e.printStackTrace();

			System.out.println("Error  :" + e.getMessage());
			throw new DAOException("Exception in ProjectDAO getProjects()");

		} finally {

			close(stmt, rs);
		}
		return projectList;

	}

	public List<Project> getProjectDurations() throws DAOException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Project> projectList = null;
		try {
			System.out.println("DAO");
			projectList = new ArrayList<Project>();

			String sqlCmd = "select project_name,project_start_date,project_end_date from sandhyad_ept_project_details";

			stmt = getPreparedStatement(getConnection(), sqlCmd);
			System.out.println("DAO 1");
			rs = executeQuery(stmt);
			System.out.println("DAO 2");
			while (rs.next()) {
				Project project=new Project();
				project.setProjectName(rs.getString("project_name"));
				project.setProjectStartDate(rs.getDate("project_start_date"));
				project.setProjectEndDate(rs.getDate("project_end_date"));
				projectList.add(project);
			}
		} catch (SQLException e) {
			e.printStackTrace();

			System.out.println("Error  :" + e.getMessage());
			throw new DAOException("Exception in ProjectDAO getProjects()");

		} finally {

			close(stmt, rs);
		}
		return projectList;

	}
}
