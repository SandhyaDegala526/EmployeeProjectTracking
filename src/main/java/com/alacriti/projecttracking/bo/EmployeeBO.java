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
		List<Employee> list = null;
		EmployeeDAO employeeDAO = null;
		try {
			System.out.println("employee Delegate");
			employeeDAO = new EmployeeDAO(getConnection());
			list = employeeDAO.getEmployeeList();
		} catch (DAOException e) {
			e.printStackTrace();
			throw new BOException("DAOException Occured");
		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException();
		}
		return list;
	}

	public void addEmployee(Employee employee) throws BOException {
		EmployeeDAO employeeDAO = null;
		try {
			employeeDAO = new EmployeeDAO(getConnection());
			employeeDAO.addEmployee(employee);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new BOException("DAOException Occured");
		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException();
		}
	}

	public List<Employee> getNotAssignedEmployees() throws BOException {
		List<Employee> list = null;
		EmployeeDAO employeeDAO = null;

		try {
			System.out.println("employee Delegate");
			employeeDAO = new EmployeeDAO(getConnection());
			list = employeeDAO.getNotAssignedEmployees();
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
