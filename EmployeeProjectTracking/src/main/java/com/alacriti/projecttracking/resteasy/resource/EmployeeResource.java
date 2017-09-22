package com.alacriti.projecttracking.resteasy.resource;

import static com.alacriti.projecttracking.constants.ResponseStatusConstants.EPT_APP_HEADER_REASON_CODE;
import static com.alacriti.projecttracking.constants.ResponseStatusConstants.EPT_APP_HEADER_RESPONSE_CODE;
import static com.alacriti.projecttracking.constants.ResponseStatusConstants.EPT_APP_REASON_CODE_EMPLOYEE_ADDED;
import static com.alacriti.projecttracking.constants.ResponseStatusConstants.EPT_APP_REASON_CODE_EMPLOYEE_EXISTS;
import static com.alacriti.projecttracking.constants.ResponseStatusConstants.EPT_APP_REASON_CODE_INTERNAL_ERROR;
import static com.alacriti.projecttracking.constants.ResponseStatusConstants.EPT_STATUS_CODE_FAILURE;
import static com.alacriti.projecttracking.constants.ResponseStatusConstants.EPT_STATUS_CODE_SUCCESS;

import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.alacriti.projecttracking.biz.delegate.EmployeeDelegate;
import com.alacriti.projecttracking.model.vo.EmployeeVO;

@Path("/employee")
@Singleton
public class EmployeeResource {
	public static final Logger log = Logger.getLogger(EmployeeResource.class);

	EmployeeDelegate delegate = new EmployeeDelegate();

	@GET
	@Path("/employeeList")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EmployeeVO> getEmployeeList() {
		log.debug(" EmployeeRoleResource.getEmployeeList start");
		return delegate.getEmployeeList();
	}

	@POST
	@Path("/addEmployee")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addEmployee(EmployeeVO employee) {
		log.debug(" EmployeeRoleResource.addEmployee start");

		String result = delegate.addEmployee(employee);

		if (result.equals("success")) {
			return Response
					.status(200)
					.entity("{\"" + EPT_APP_HEADER_RESPONSE_CODE + "\":"
							+ EPT_STATUS_CODE_SUCCESS + "," + "\""
							+ EPT_APP_HEADER_REASON_CODE + "\":"
							+ EPT_APP_REASON_CODE_EMPLOYEE_ADDED + "}").build();

		} else if (result.equals("isAlreadyExist")) {
			return Response
					.status(200)
					.entity("{\"" + EPT_APP_HEADER_RESPONSE_CODE + "\":"
							+ EPT_STATUS_CODE_FAILURE + "," + "\""
							+ EPT_APP_HEADER_REASON_CODE + "\":"
							+ EPT_APP_REASON_CODE_EMPLOYEE_EXISTS + "}")
					.build();
		} else {
			return Response
					.status(200)
					.entity("{\"" + EPT_APP_HEADER_RESPONSE_CODE + "\":"
							+ EPT_STATUS_CODE_FAILURE + "," + "\""
							+ EPT_APP_HEADER_REASON_CODE + "\":"
							+ EPT_APP_REASON_CODE_INTERNAL_ERROR + "}").build();
		}

	}

	@GET
	@Path("/getNotAssignedEmployees")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EmployeeVO> getUnAssignedEmployees() {
		log.debug(" EmployeeRoleResource.getUnAssignedEmployees start");

		return delegate.getUnAssignedEmployees();
	}
	@POST
	@Path("/checkEmpId")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public boolean checkEmpId(String employeeId){
		System.out.println("EmployeeResource.checkEmpId start");
		log.debug("EmployeeResource.checkEmpId start");
		return delegate.checkEmpId(employeeId);
	}
@POST
@Path("/deleteEmployee")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public boolean deleteEmployee(String employeeId){
	System.out.println("EmployeeResource.deleteEmployee start");
	return delegate.deleteEmployee(employeeId);

}

}