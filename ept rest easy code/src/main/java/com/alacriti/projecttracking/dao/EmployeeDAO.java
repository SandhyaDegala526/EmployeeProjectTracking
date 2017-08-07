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
		Connection conn=null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Employee> list = null;
		try {
			list = new ArrayList<Employee>();

			conn=getConnection();
			stmt = conn.prepareStatement("select employee_id,employee_name,employee_state from sandhyad_ept_employee;");
			rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(new Employee(rs.getString(1), rs
						.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {

			System.out.println("Error  :" + e.getMessage());
			throw new DAOException("Exception in getEmployee in Employee");

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
	public void addEmployee(Employee employees[]) throws DAOException{
		
		Connection conn=null;
		PreparedStatement stmt=null;
		
		try{
			
		     conn=getConnection();
		     stmt=conn.prepareStatement("insert into sandhyad_ept_employee(employee_id,employee_name,employee_status) values(?,?,?)");
		     for(int i=0;i<(employees.length);i++){
		    	 stmt.setString(1,employees[i].getEmployeeId());
		    	 stmt.setString(2, employees[i].getEmployeeName());
		    	 stmt.setString(3, employees[i].getEmployeeStatus());
		  
		    	 stmt.executeUpdate();
		    	 }
			}catch(SQLException e){
			System.out.println("Error  :" + e.getMessage());
			throw new DAOException("Exception in addEmployee in Employee");

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