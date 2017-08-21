package com.alacriti.projecttracking.biz.delegate;

import java.sql.Connection;

import org.apache.log4j.Logger;

import com.alacriti.projecttracking.bo.LoginBO;
import com.alacriti.projecttracking.model.vo.LoginVO;

public class LoginDelegate extends BaseDelegate {
	public static final Logger log = Logger.getLogger(LoginDelegate.class);

	public boolean verify(LoginVO login) {
		boolean rollBack = false;
		Connection connection = null;
		boolean flag = false;
		LoginBO loginBO = null;
		try {
			log.debug("in LoginDelegate.verify");
			connection = startDBTransaction();
			setConnection(connection);
			loginBO = new LoginBO(connection);
			flag = loginBO.verify(login);
		} catch (Exception e) {
			log.error("exception in LoginDelegate.verify" + e.getMessage());
			e.printStackTrace();
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}

		return flag;
	}
}