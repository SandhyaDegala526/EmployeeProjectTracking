package com.alacriti.projecttracking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import static com.alacriti.projecttracking.constants.DataBaseConstants.EMPLOYEE_STATUS_ASSIGNED;
import com.alacriti.projecttracking.model.vo.ProjectAllocationVO;

public class ProjectAllocationDAO extends BaseDAO {
	public static final Logger log = Logger
			.getLogger(ProjectAllocationDAO.class);


	public ProjectAllocationDAO() {

	}

	public ProjectAllocationDAO(Connection conn) {
		super(conn);
	}

	public List<ProjectAllocationVO> getProjectAllocationList()
			throws DAOException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<ProjectAllocationVO> list = null;

		try {
			list = new ArrayList<ProjectAllocationVO>();

			String sqlCmd = " select e.employee_name,p.project_name,a.employee_start_date,a.employee_end_date,r.employee_role"
					+ " from sandhyad_ept_project_allocation a , sandhyad_ept_project_details p,sandhyad_ept_employee_details e,sandhyad_ept_employee_roles r"
					+ " where  a.project_id=p.project_id "
					+ " AND a.employee_id=e.employee_id "
					+ " and a.emprole_id=r.emprole_id"
					+ " order by p.project_name";
			stmt = getPreparedStatement(getConnection(), sqlCmd);
			rs = executeQuery(stmt);
			while (rs.next()) {
				ProjectAllocationVO projectAllocationVO = new ProjectAllocationVO();
				projectAllocationVO.setEmployeeName(rs
						.getString("employee_name"));
				projectAllocationVO
						.setProjectName(rs.getString("project_name"));
				projectAllocationVO.setEmployeeStartDate(rs
						.getDate("employee_start_date"));
				projectAllocationVO.setEmployeeEndDate(rs
						.getDate("employee_end_date"));
				projectAllocationVO.setEmployeeRole(rs
						.getString("employee_role"));
				list.add(projectAllocationVO);
			}
		} catch (SQLException e) {

			e.printStackTrace();
			throw new DAOException("Exception in ProjectDAO getProjects()");

		} finally {

			close(stmt, rs);
		}
		return list;

	}

	public boolean projectAllotment(ProjectAllocationVO projectAllocation)
			throws DAOException {

		PreparedStatement stmt = null;
		int rowCount = 0;
		boolean flag = false;
		try {
			String sqlCmd = "insert into sandhyad_ept_project_allocation "
					+ " (employee_id,project_id,employee_start_date,employee_end_date,emprole_id)"
					+ "values(?,?,?,?,?)";
			stmt = getPreparedStatement(getConnection(), sqlCmd);
			stmt.setString(1, projectAllocation.getEmployeeId());
			stmt.setInt(2, projectAllocation.getProjectId());
			stmt.setDate(3, projectAllocation.getEmployeeStartDate());
			stmt.setDate(4, projectAllocation.getEmployeeEndDate());
			stmt.setInt(5, projectAllocation.getEmproleId());
			rowCount = stmt.executeUpdate();
			if (rowCount > 0) {
				flag = true;
			}
			sqlCmd = " update sandhyad_ept_employee_details set empstatus_id=? where employee_id=? ";
			stmt = getPreparedStatement(getConnection(), sqlCmd);
			stmt.setInt(1,EMPLOYEE_STATUS_ASSIGNED);
			stmt.setString(2, projectAllocation.getEmployeeId());
			stmt.executeUpdate();
			System.out.println("DAO");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Exception in ProjectDAO addProjects()");
		} finally {

			close(stmt);
		}
		return flag;
	}

}
