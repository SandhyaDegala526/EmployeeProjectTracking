/*package com.alacriti.projecttracking.biz.delegate;


import java.sql.Connection;
import java.util.List;

import com.alacriti.projecttracking.bo.DepartmentBO;
import com.alacriti.projecttracking.model.Department;


public class DepartmentDelegate extends BaseDelegate{

	public List<Department>  getDepartmentList() {
		boolean rollBack = false;
		Connection connection = null;
		List<Department> departmentList = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			DepartmentBO sampleBO = new DepartmentBO();
			departmentList= sampleBO.getDepartmentList();
		} catch (Exception e) {
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}

		return departmentList;
	}
	public void  addDepartment(Department departments[]) {
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			DepartmentBO sampleBO = new DepartmentBO();
			sampleBO.addDepartment(departments);
		} catch (Exception e) {
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}

	}
	


}
*/