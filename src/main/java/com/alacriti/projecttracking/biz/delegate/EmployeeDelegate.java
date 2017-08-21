package com.alacriti.projecttracking.biz.delegate;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.projecttracking.bo.EmployeeBO;
import com.alacriti.projecttracking.model.vo.EmployeeVO;

public class EmployeeDelegate extends BaseDelegate {
	public static final Logger log = Logger.getLogger(EmployeeDelegate.class);

	public List<EmployeeVO> getEmployeeList() {
		boolean rollBack = false;
		Connection connection = null;
		EmployeeBO employeeBO = null;
		List<EmployeeVO> employeeList = null;
		try {
			log.debug("in EmployeeDelegate.getEmployeeList");
			connection = startDBTransaction();
			setConnection(connection);
			employeeBO = new EmployeeBO(connection);
			employeeList = employeeBO.getEmployeeList();
		} catch (Exception e) {
			log.error("exception in EmployeeDelegate.getEmployeeList"
					+ e.getMessage());
			e.printStackTrace();
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}

		return employeeList;
	}

	public String addEmployee(EmployeeVO employee) {
		log.debug("in EmployeeDelegate.addEmployee");
		boolean rollBack = false;
		Connection connection = null;
		EmployeeBO employeeBO;
		String status = "fail";
		try {
			connection = startDBTransaction();
			setConnection(connection);
			employeeBO = new EmployeeBO(connection);
			status = employeeBO.addEmployee(employee);
		} catch (Exception e) {
			log.error("exception in EmployeeDelegate.addEmployee"
					+ e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
		return status;

	}

	public List<EmployeeVO> getUnAssignedEmployees() {
		log.debug("EmployeeDelegate.getUnAssignedEmployees start()");
		boolean rollBack = false;
		Connection connection = null;
		List<EmployeeVO> list = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			EmployeeBO sampleBO = new EmployeeBO(connection);
			list = sampleBO.getUnAssignedEmployees();
		} catch (Exception e) {
			log.error("exception in EmployeeDelegate.getNotAssignedEmployees"
					+ e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}

		return list;
	}

}
