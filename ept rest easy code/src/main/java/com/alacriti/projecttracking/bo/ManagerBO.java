package com.alacriti.projecttracking.bo;

import java.sql.Connection;


import com.alacriti.projecttracking.dao.DAOException;
import com.alacriti.projecttracking.dao.ManagerDAO;
import com.alacriti.projecttracking.model.Login;


public class ManagerBO extends BaseBO {
	
	public ManagerBO() {

	}

	public ManagerBO(Connection conn) {
		super(conn);
	}
	public boolean verify(Login login) throws BOException {
		boolean flag=false;
		ManagerDAO accountDAO=null;
		try {
			accountDAO = new ManagerDAO(getConnection());
			flag=accountDAO.verify(login);
		} catch (DAOException e) {
			
			throw new BOException("DAOException Occured");
		} catch (Exception e) {
			
			throw new BOException();
		}
		return flag;
	}
}