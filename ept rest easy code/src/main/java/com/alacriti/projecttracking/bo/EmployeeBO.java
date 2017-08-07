package com.alacriti.projecttracking.bo;

import java.sql.Connection;
import java.util.List;

import com.alacriti.projecttracking.dao.DAOException;
import com.alacriti.projecttracking.dao.EmployeeDAO;
import com.alacriti.projecttracking.model.Employee;


public class EmployeeBO extends BaseBO {
	
	public EmployeeBO() {

	}

	public EmployeeBO(Connection conn) {
		super(conn);
	}
	public List<Employee> getEmployeeList() throws BOException {
		List<Employee>  list= null;
		EmployeeDAO accountDAO=null;
		try {
			System.out.println("employee Delegate");
			accountDAO = new EmployeeDAO(getConnection());
			list = accountDAO.getEmployeeList();
		} catch (DAOException e) {
			
			throw new BOException("DAOException Occured");
		} catch (Exception e) {
			
			throw new BOException();
		}
		return list;
	}
	public void addEmployee(Employee employees[]) throws BOException {
		EmployeeDAO accountDAO=null;
		try {
			accountDAO = new EmployeeDAO(getConnection());
			 accountDAO.addEmployee(employees);
		} catch (DAOException e) {
			
			throw new BOException("DAOException Occured");
		} catch (Exception e) {
			
			throw new BOException();
		}
	}
	
}
