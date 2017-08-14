package com.alacriti.projecttracking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alacriti.projecttracking.model.Employee;


public class EmployeeDAO extends BaseDAO {

	public EmployeeDAO() {

	}

	public EmployeeDAO(Connection conn) {
		super(conn);
	}
	public List<Employee> getEmployeeList() throws DAOException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Employee> list = null;
		try {
			list = new ArrayList<Employee>();
			String sqlCmd = "select employee_id,employee_name,employee_state from sandhyad_ept_employee_details;";
			stmt =getPreparedStatement(getConnection(), sqlCmd);
			rs=executeQuery(stmt);
			while (rs.next()) {
				list.add(new Employee(rs.getString(1), rs
						.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {

			System.out.println("Error  :" + e.getMessage());
			throw new DAOException("Exception in getEmployee in Employee");

		} finally {

			close(stmt, rs);
		}
		return list;

	}
	public void addEmployee(Employee employee) throws DAOException{
		
		PreparedStatement stmt=null;
		
		try{
			String sqlCmd="insert into sandhyad_ept_employee_details(employee_id,employee_name,employee_state) values(?,?,?)";
			stmt =getPreparedStatement(getConnection(), sqlCmd);
		    	 stmt.setString(1,employee.getEmployeeId());
		    	 stmt.setString(2, employee.getEmployeeName());
		    	 stmt.setString(3, employee.getEmployeeState());
		    	 stmt.executeUpdate();
		  
			}catch(SQLException e){
				e.printStackTrace();
			System.out.println("Error  :" + e.getMessage());
			throw new DAOException("Exception in addEmployee in Employee");

		}
		finally {
			close(stmt);
		}
}
	public List<Employee> getNotAssignedEmployees()throws DAOException
	{
		PreparedStatement stmt = null;
		ResultSet rs=null;
		List<Employee> list=null;
		try {
			list=new ArrayList<Employee>();
		System.out.println("DAO 1");
			String sqlCmd="select employee_id,employee_name from sandhyad_ept_employee_details where employee_state='not-assigned'";
			stmt=getPreparedStatement(getConnection(), sqlCmd);
			System.out.println("DAO 2");
			rs=executeQuery(stmt);
			while(rs.next())
			{
				list.add(new Employee(rs.getString(1), rs
						.getString(2)));
			
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();

			System.out.println("Error  :" + e.getMessage());
			throw new DAOException("Exception in ProjectDAO getProjects()");
			

		} finally {

			close(stmt , rs);
		}
		return list;
		
	}
	

}