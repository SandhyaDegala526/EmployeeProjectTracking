/*package com.alacriti.projecttracking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.alacriti.projecttracking.model.Department;

public class DepartmentDAO extends BaseDAO{

	
	public DepartmentDAO() {

	}

	public DepartmentDAO(Connection conn) {
		super(conn);
	}
	
	public List<Department> getDepartmentList() {
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<Department> list = null;
		try {
			list = new ArrayList<Department>();

			dbSource = (DataSource) new InitialContext()
					.lookup("java:jboss/datasources/TRAINEE");

			connection = dbSource.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select departmentId,departmentName from sandhyad_EmpProjectTracking_DepartmentDetails;");
			while (resultSet.next()) {
				list.add(new Department(resultSet.getInt(1),resultSet.getString(2)));
			}
		} catch (Exception e) {

			System.out.println("Error  :" + e.getMessage());

		} finally {

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;

	}
	public void addDepartment(Department departments[]){
		DataSource dataSource=null;
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		try{
			
		     connection=dataSource.getConnection();
		     preparedStatement=connection.prepareStatement("insert into sandhyad_EmpProjectTracking_DepartmentDetails(departmentId,departmentName) values(?,?)");
		     for(int i=0;i<(departments.length);i++){
					preparedStatement.setInt(1,departments[i].getDepartmentId());
					preparedStatement.setString(2, departments[i].getDepartmentName());
					preparedStatement.executeUpdate();
				}
				
		}catch(SQLException e){
			e.printStackTrace();
		 
		}
		finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
}
}
*/