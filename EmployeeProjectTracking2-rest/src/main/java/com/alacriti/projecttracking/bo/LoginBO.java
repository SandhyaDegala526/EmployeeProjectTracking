package com.alacriti.projecttracking.bo;

import java.sql.Connection;


import com.alacriti.projecttracking.dao.DAOException;
import com.alacriti.projecttracking.dao.LoginDAO;
import com.alacriti.projecttracking.model.Login;


public class LoginBO extends BaseBO {
	
	public LoginBO() {

	}

	public LoginBO(Connection conn) {
		super(conn);
	}
	public boolean verify(Login login) throws BOException {
		boolean flag=false;
		LoginDAO loginDAO=null;
		try {
			loginDAO = new LoginDAO(getConnection());
			flag=loginDAO.verify(login);
		} catch (DAOException e) {
			
			throw new BOException("DAOException Occured");
		} catch (Exception e) {
			
			throw new BOException();
		}
		return flag;
	}
}