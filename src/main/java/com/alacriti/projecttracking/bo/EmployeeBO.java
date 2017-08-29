package com.alacriti.projecttracking.bo;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.projecttracking.dao.DAOException;
import com.alacriti.projecttracking.dao.EmployeeDAO;
import com.alacriti.projecttracking.model.vo.EmployeeVO;

public class EmployeeBO extends BaseBO {
	public static final Logger log = Logger.getLogger(EmployeeBO.class);

	public EmployeeBO() {

	}

	public EmployeeBO(Connection conn) {
		super(conn);
	}

	public List<EmployeeVO> getEmployeeList() throws BOException {
		log.debug("in EmployeeBO.getEmployeeList");

		List<EmployeeVO> list = null;
		EmployeeDAO employeeDAO = null;
		try {
			employeeDAO = new EmployeeDAO(getConnection());
			list = employeeDAO.getEmployeeList();
		} catch (DAOException e) {
			log.error("DAO exception in EmployeeBO.getEmployeeList"
					+ e.getMessage());
			throw new BOException("DAOException Occured");
		} catch (Exception e) {
			log.error("exception in EmployeeBO.getEmployeeList"
					+ e.getMessage());

			e.printStackTrace();
			throw new BOException();
		}
		return list;
	}

	public String addEmployee(EmployeeVO employee) throws BOException {
		log.debug("in EmployeeBO.addEmployee");

		EmployeeDAO employeeDAO = null;
		String status = "fail";
		List<EmployeeVO> employeeList = null;
		boolean flag = false;
		try {
			employeeDAO = new EmployeeDAO(getConnection());
			employeeList = employeeDAO.getEmployeeList();
			for (EmployeeVO employeeDetails : employeeList) {
				if (employee.getEmployeeId().equals(
						employeeDetails.getEmployeeId())) {
					flag = true;
					status = "isAlreadyExist";
				}
			}
			if (flag == false && employee.getEmployeeId() != null
					&& employee.getEmployeeName() != null
					&& employee.getEmployeeState() != (0 | 1)) {
				status = employeeDAO.addEmployee(employee);
			}
		} catch (DAOException e) {
			log.error(" DAO exception in EmployeeBO.addEmployee"
					+ e.getMessage());

			e.printStackTrace();
			throw new BOException("DAOException Occured");
		} catch (Exception e) {
			log.error("exception in EmployeeBO.addEmployee" + e.getMessage());

			e.printStackTrace();
			throw new BOException();
		}
		return status;
	}

	public List<EmployeeVO> getUnAssignedEmployees() throws BOException {
		log.debug(" EmployeeBO.getUnAssignedEmployees start");

		List<EmployeeVO> list = null;
		EmployeeDAO employeeDAO = null;

		try {
			System.out.println("employee Delegate");
			employeeDAO = new EmployeeDAO(getConnection());
			list = employeeDAO.getUnAssignedEmployees();
		} catch (DAOException e) {
			log.error("DAO exception in EmployeeBO.getUnAssignedEmployees"
					+ e.getMessage());

			e.printStackTrace();
			throw new BOException("DAOException Occured");
		} catch (Exception e) {
			log.error("exception in EmployeeBO.getUnAssignedEmployees"
					+ e.getMessage());

			e.printStackTrace();
			throw new BOException();
		}
		return list;
	}

}
