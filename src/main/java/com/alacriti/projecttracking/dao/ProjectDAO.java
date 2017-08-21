package com.alacriti.projecttracking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.projecttracking.model.vo.ProjectVO;
import com.alacriti.projecttracking.model.vo.ProjectEmployeeGroupVO;

public class ProjectDAO extends BaseDAO {
	public static final Logger log = Logger.getLogger(ProjectDAO.class);

	public ProjectDAO() {

	}

	public ProjectDAO(Connection conn) {
		super(conn);
	}

	public List<ProjectVO> getProjectList() throws DAOException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<ProjectVO> list = null;
		try {
			list = new ArrayList<ProjectVO>();

			String sqlCmd = "select project_id,project_name from sandhyad_ept_project_details";
			stmt = getPreparedStatement(getConnection(), sqlCmd);
			rs = executeQuery(stmt);
			while (rs.next()) {
				list.add(new ProjectVO(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e) {

			System.out.println("Error  :" + e.getMessage());
			throw new DAOException("Exception in ProjectDAO getProjects()");

		} finally {

			close(stmt, rs);
		}
		return list;

	}

	public boolean addProject(ProjectVO project) throws DAOException {
		PreparedStatement stmt = null;
		boolean flag = false;
		int rowCount;
		try {
			if (project.getProjectEndDate() != null) {
				String sqlCmd = "insert into sandhyad_ept_project_details "
						+ "(project_name,project_start_date,project_end_date) values (?,?,?)";
				stmt = getPreparedStatement(getConnection(), sqlCmd);
				stmt.setString(1, project.getProjectName());
				stmt.setDate(2, project.getProjectStartDate());
				stmt.setDate(3, project.getProjectEndDate());
				rowCount = stmt.executeUpdate();
				if (rowCount > 0) {
					flag = true;
				}
			} else {
				String sqlCmd = "insert into sandhyad_ept_project_details "
						+ "(project_name,project_start_date) values (?,?)";
				stmt = getPreparedStatement(getConnection(), sqlCmd);
				stmt.setString(1, project.getProjectName());
				stmt.setDate(2, project.getProjectStartDate());
				rowCount = stmt.executeUpdate();
				if (rowCount > 0) {
					flag = true;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Exception in ProjectDAO addProjects()");
		} finally {

			close(stmt);
		}
		return flag;
	}

	public List<ProjectEmployeeGroupVO> getDatewiseProjects(ProjectVO project)
			throws DAOException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<ProjectEmployeeGroupVO> projectList = null;
		try {
			projectList = new ArrayList<ProjectEmployeeGroupVO>();
			if (project.getProjectName().equals("all")) {
				String sqlCmd = "select p.project_name,group_concat(e.employee_name),p.project_start_date,p.project_end_date "
						+ " from sandhyad_ept_project_allocation a ,sandhyad_ept_project_details p,sandhyad_ept_employee_details e"
						+ " where  a.project_id=p.project_id "
						+ " AND a.employee_id=e.employee_id "
						+ " and  project_start_date>=?"
						+ " AND project_end_date<=?"
						+ " group by p.project_name";

				stmt = getPreparedStatement(getConnection(), sqlCmd);
				stmt.setDate(1, project.getProjectStartDate());
				stmt.setDate(2, project.getProjectEndDate());
				rs = executeQuery(stmt);
			} else {
				String sqlCmd = "select p.project_name,group_concat(e.employee_name),p.project_start_date,p.project_end_date "
						+ " from sandhyad_ept_project_allocation a ,sandhyad_ept_project_details p,sandhyad_ept_employee_details e"
						+ " where  a.project_id=p.project_id "
						+ " AND a.employee_id=e.employee_id "
						+ " and  project_start_date>=?"
						+ " AND project_end_date<=?"
						+ " AND p.project_name=?"
						+ " group by p.project_name";

				stmt = getPreparedStatement(getConnection(), sqlCmd);
				stmt.setDate(1, project.getProjectStartDate());
				stmt.setDate(2, project.getProjectEndDate());
				stmt.setString(3, project.getProjectName());
				rs = executeQuery(stmt);
			}
			while (rs.next()) {

				ProjectEmployeeGroupVO employeeGroupVO = new ProjectEmployeeGroupVO();

				ProjectVO projectvo = new ProjectVO(rs.getString(1),rs.getDate(3),rs.getDate(4));
				employeeGroupVO.setProject(projectvo);
				employeeGroupVO.setEmpList(rs.getString(2));

				projectList.add(employeeGroupVO);
				System.out.println("DAO 3");
			}
		} catch (SQLException e) {
			e.printStackTrace();

			throw new DAOException("Exception in ProjectDAO getProjects()");

		} finally {

			close(stmt, rs);
		}
		return projectList;

	}

	public List<ProjectVO> getProjectDurations() throws DAOException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<ProjectVO> projectList = null;
		try {
			projectList = new ArrayList<ProjectVO>();

			String sqlCmd = "select project_name,project_start_date,project_end_date from "
					+ "sandhyad_ept_project_details order by project_name";

			stmt = getPreparedStatement(getConnection(), sqlCmd);
			rs = executeQuery(stmt);
			while (rs.next()) {
				ProjectVO project = new ProjectVO(rs.getString("project_name")
						,rs.getDate("project_start_date"),rs.getDate("project_end_date"));
			/*	project.setProjectName(rs.getString("project_name"));
				project.setProjectStartDate(rs.getDate("project_start_date"));
				project.setProjectEndDate(rs.getDate("project_end_date"));*/
				projectList.add(project);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Exception in ProjectDAO getProjects()");

		} finally {

			close(stmt, rs);
		}
		return projectList;

	}
}
