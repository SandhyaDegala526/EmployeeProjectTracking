package com.alacriti.projecttracking.bo;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.projecttracking.dao.DAOException;
import com.alacriti.projecttracking.dao.EmployeeRoleDAO;
import com.alacriti.projecttracking.model.vo.EmployeeRoleVO;

public class EmployeeRoleBO extends BaseBO {
	public static final Logger log = Logger.getLogger(EmployeeRoleBO.class);

	public EmployeeRoleBO() {

	}

	public EmployeeRoleBO(Connection conn) {
		super(conn);
	}

	public List<EmployeeRoleVO> getEmployeeRoles() throws BOException {
		log.debug("in EmployeeRoleBO.getEmployeeRoles");

		List<EmployeeRoleVO> list = null;
		EmployeeRoleDAO employeeRoleDAO = null;

		try {
			employeeRoleDAO = new EmployeeRoleDAO(getConnection());
			list = employeeRoleDAO.getEmployeeRoles();
		} catch (DAOException e) {
			log.error("DAO exception in EmployeeRoleBO.getEmployeeRoles"
					+ e.getMessage());

			throw new BOException("DAOException Occured");
		} catch (Exception e) {
			log.error("exception in EmployeeRoleBO.getEmployeeRoles"
					+ e.getMessage());

			throw new BOException();
		}
		return list;
	}
}