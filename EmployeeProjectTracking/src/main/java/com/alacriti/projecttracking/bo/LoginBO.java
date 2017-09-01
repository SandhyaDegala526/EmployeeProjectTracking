package com.alacriti.projecttracking.bo;

import java.sql.Connection;

import org.apache.log4j.Logger;

import com.alacriti.projecttracking.dao.DAOException;
import com.alacriti.projecttracking.dao.LoginDAO;
import com.alacriti.projecttracking.model.vo.LoginVO;

public class LoginBO extends BaseBO {
	public static final Logger log = Logger.getLogger(LoginBO.class);

	public LoginBO() {

	}

	public LoginBO(Connection conn) {
		super(conn);
	}

	public boolean verify(LoginVO login) throws BOException {
		log.debug("in LoginBO.verify");

		boolean flag = false;
		LoginDAO loginDAO = null;
		try {
			loginDAO = new LoginDAO(getConnection());
			flag = loginDAO.verify(login);
		} catch (DAOException e) {
			log.error("DAO exception in LoginBO.verify" + e.getMessage());
			throw new BOException("DAOException Occured");
		} catch (Exception e) {
			log.error("exception in LoginBO.verify" + e.getMessage());
			throw new BOException();
		}
		return flag;
	}
}