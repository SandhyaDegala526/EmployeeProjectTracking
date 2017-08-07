/*package com.alacriti.projecttracking.bo;

import java.sql.Connection;
import java.util.List;


import com.alacriti.projecttracking.dao.DAOException;


import com.alacriti.projecttracking.dao.DepartmentDAO;
import com.alacriti.projecttracking.model.Department;


public class DepartmentBO extends BaseBO {
	
	public DepartmentBO() {

	}

	public DepartmentBO(Connection conn) {
		super(conn);
	}
	public List<Department> getDepartmentList() throws BOException {
		List<Department>  list= null;
		try {
		DepartmentDAO	accountDAO = new DepartmentDAO(getConnection());
			list = accountDAO.getDepartmentList();
		} catch (DAOException e) {
			
			throw new BOException("DAOException Occured");
		} catch (Exception e) {
			
			throw new BOException();
		}
		return list;
	}
	public void addDepartment(Department departments[]) throws BOException {
		
		try {
			DepartmentDAO	accountDAO = new DepartmentDAO(getConnection());
			 accountDAO.addDepartment(departments);
		} catch (DAOException e) {
			
			throw new BOException("DAOException Occured");
		} catch (Exception e) {
			
			throw new BOException();
		}
	}
	
}
*/