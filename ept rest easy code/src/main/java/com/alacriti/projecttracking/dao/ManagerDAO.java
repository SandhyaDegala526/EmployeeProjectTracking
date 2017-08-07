package com.alacriti.projecttracking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alacriti.projecttracking.model.Login;

public class ManagerDAO extends BaseDAO   {
	public ManagerDAO() {

	}

	public ManagerDAO(Connection conn) {
		super(conn);
	}

public boolean verify(Login login)throws DAOException{
	Connection conn=null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	boolean flag=false;
	
	try{
		
		String sqlCmd = "select empId,password from sandhyad_EmpProjectTracking_LoginDetails "+
	"where empId=? and password=?;";
		conn=getConnection();
		stmt=conn.prepareStatement(sqlCmd);
		stmt.setString(1, login.getEmpId());
		stmt.setString(2, login.getPassword());
		rs=stmt.executeQuery();
		if(rs.next())
		{
			flag=true;
		}
			
	}catch(SQLException e){
		System.out.println("Error  :" + e.getMessage());
		throw new DAOException("SQLException in ManagerDAO:", e);
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
	return flag;
}

	
}

