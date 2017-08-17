package com.alacriti.projecttracking.bo;

import java.sql.Connection;
import java.util.List;

import com.alacriti.projecttracking.dao.DAOException;
import com.alacriti.projecttracking.dao.EmployeeRoleDAO;
import com.alacriti.projecttracking.model.EmployeeRole;

public class EmployeeRoleBo extends BaseBO {

	public EmployeeRoleBo() {

	}

	public EmployeeRoleBo(Connection conn) {
		super(conn);
	}

	
	public List<EmployeeRole> getEmployeeRoles() throws BOException {
		List<EmployeeRole> list = null;
		EmployeeRoleDAO employeeRoleDAO = null;

		try {
			System.out.println("employee Delegate");
			employeeRoleDAO = new EmployeeRoleDAO(getConnection());
			list = employeeRoleDAO.getEmployeeRoles();
		} catch (DAOException e) {
			e.printStackTrace();
			throw new BOException("DAOException Occured");
		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException();
		}
		return list;
	}
}