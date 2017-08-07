package com.alacriti.projecttracking.biz.delegate;

import java.sql.Connection;
import java.util.List;

import com.alacriti.projecttracking.bo.EmployeeBO;
import com.alacriti.projecttracking.model.Employee;

public class EmployeeDelegate extends BaseDelegate {

	public List<Employee>  getEmployeeList() {
		boolean rollBack = false;
		Connection connection = null;
		List<Employee> employeeList = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			EmployeeBO sampleBO = new EmployeeBO(connection);
			employeeList= sampleBO.getEmployeeList();
		} catch (Exception e) {
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}

		return employeeList;
	}
	public void  addEmployee(Employee employees[]) {
		boolean rollBack = false;
		Connection connection = null;
		System.out.println("add employee before try block");
		try {
			System.out.println("add employee try block");
			connection = startDBTransaction();
			setConnection(connection);
			EmployeeBO sampleBO = new EmployeeBO(connection);
			sampleBO.addEmployee(employees);
		} catch (Exception e) {
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}

	}
	


}
