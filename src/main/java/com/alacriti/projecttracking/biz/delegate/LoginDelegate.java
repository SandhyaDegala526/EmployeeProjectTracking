package com.alacriti.projecttracking.biz.delegate;

import java.sql.Connection;

import com.alacriti.projecttracking.bo.LoginBO;
import com.alacriti.projecttracking.model.Login;


public class LoginDelegate extends BaseDelegate {

	public boolean  verify(Login login) {
		boolean rollBack = false;
		Connection connection = null;
		boolean flag= false;
		LoginBO loginBO =null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			 loginBO = new LoginBO(connection);
			flag=loginBO.verify(login);
		} catch (Exception e) {
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}

		return flag;
	}
}