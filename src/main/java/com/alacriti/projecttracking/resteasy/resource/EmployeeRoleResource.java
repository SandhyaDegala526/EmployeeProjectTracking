package com.alacriti.projecttracking.resteasy.resource;

import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.alacriti.projecttracking.biz.delegate.EmployeeRolesDelegate;
import com.alacriti.projecttracking.model.vo.EmployeeRoleVO;

@Path("/employeeRoles")
@Singleton
public class EmployeeRoleResource {
	public static final Logger log = Logger
			.getLogger(EmployeeRoleResource.class);
	EmployeeRolesDelegate delegate = new EmployeeRolesDelegate();


	@GET
	@Path("/getEmployeeRoles")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EmployeeRoleVO> getEmployeeRoles() {
		log.debug(" EmployeeRoleResource.getEmployeeRoles start");
		return delegate.getEmployeeRoles();
	}
}