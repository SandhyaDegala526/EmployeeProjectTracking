package com.alacriti.projecttracking.biz.delegate;

import java.sql.Connection;
import java.util.List;

import com.alacriti.projecttracking.bo.EmployeeBO;
import com.alacriti.projecttracking.model.Employee;

public class EmployeeDelegate extends BaseDelegate {

	public List<Employee>  getEmployeeList() {
		boolean rollBack = false;
		Connection connection = null;
		EmployeeBO employeeBO =null;
		List<Employee> employeeList = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			 employeeBO = new EmployeeBO(connection);
			employeeList= employeeBO.getEmployeeList();
		} catch (Exception e) {
			e.printStackTrace();
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}

		return employeeList;
	}
	public void  addEmployee(Employee employee) {
		boolean rollBack = false;
		Connection connection = null;
		System.out.println("add employee before try block");
		try {
			System.out.println("add employee try block");
			connection = startDBTransaction();
			setConnection(connection);
			EmployeeBO sampleBO = new EmployeeBO(connection);
			sampleBO.addEmployee(employee);
		} catch (Exception e) {
			e.printStackTrace();
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}

	}

	public List<Employee>  getNotAssignedEmployees() {
		boolean rollBack = false;
		Connection connection = null;
		List<Employee> list = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			EmployeeBO sampleBO = new EmployeeBO(connection);
			list= sampleBO.getNotAssignedEmployees();
		} catch (Exception e) {
			e.printStackTrace();
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}

		return list;
	}
	


}
