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
			log.debug(" EmployeeDelegate.getEmployeeList start");
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
		log.debug(" EmployeeDelegate.addEmployee  start");
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
		log.debug("EmployeeDelegate.getUnAssignedEmployees() start");
		boolean rollBack = false;
		Connection connection = null;
		List<EmployeeVO> list = null;
		EmployeeBO employeeBO=null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			 employeeBO = new EmployeeBO(connection);
			list = employeeBO.getUnAssignedEmployees();
		} catch (Exception e) {
			log.error("exception in EmployeeDelegate.getUnAssignedEmployees"
					+ e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}

		return list;
	}
	public boolean deleteEmployee(String employeeId)
	{
		log.debug("EmployeeDelegate.deleteemployee() start");
		boolean flag=false;
		boolean rollBack=false;
		EmployeeBO employeeBO=null;
		Connection connection=null;
		try{
			connection=startDBTransaction();
			setConnection(connection);
			employeeBO=new EmployeeBO(connection);
			flag=employeeBO.deleteEmployee(employeeId);
		}catch(Exception e){
			log.error("exception in EmployeeDelegate.deleteEmployee"+e.getMessage());
			rollBack=true;
		}finally{
			endDBTransaction(connection, rollBack);
		}
		return flag;
	}
	public boolean checkEmpId(String employeeId){
		log.debug("EmployeeDelegate.checkEmpId() start");
		boolean flag=false;
		boolean rollBack=false;
		EmployeeBO employeeBO=null;
		Connection connection=null;
		try{
			connection=startDBTransaction();
			setConnection(connection);
			employeeBO=new EmployeeBO(connection);
			flag=employeeBO.checkEmpId(employeeId);
		}catch(Exception e){
			log.error("Exception in EmployeeDelegate.checkEmpId"+e.getMessage());
			rollBack=true;
		}finally{
			endDBTransaction(connection, rollBack);
		}
		return flag;
	}

}
