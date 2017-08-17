package com.alacriti.projecttracking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alacriti.projecttracking.model.Login;

public class LoginDAO extends BaseDAO   {
	public LoginDAO() {

	}

	public LoginDAO(Connection conn) {
		super(conn);
	}

public boolean verify(Login login)throws DAOException{
	Connection conn=null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	boolean flag=false;
	
	try{
		
		String sqlCmd = "select emp_id,password from sandhyad_ept_login_details where emp_id=? and password=?";
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
		e.printStackTrace();
		throw new DAOException("SQLException in ManagerDAO:", e);
	}
	finally {
		close(stmt,rs);
	}
	return flag;
}
}

