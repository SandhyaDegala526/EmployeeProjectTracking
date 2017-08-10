package com.alacriti.projecttracking.biz.delegate;

import java.sql.Connection;

import com.alacriti.projecttracking.bo.ManagerBO;
import com.alacriti.projecttracking.model.Login;


public class ManagerDelegate extends BaseDelegate {

	public boolean  verify(Login login) {
		boolean rollBack = false;
		Connection connection = null;
		boolean flag= false;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			ManagerBO sampleBO = new ManagerBO(connection);
			flag=sampleBO.verify(login);
		} catch (Exception e) {
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}

		return flag;
	}
}