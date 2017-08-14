package com.alacriti.projecttracking.resteasy.resource;



import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.alacriti.projecttracking.biz.delegate.EmployeeRolesDelegate;
import com.alacriti.projecttracking.model.EmployeeRole;

@Path("/")
public class EmployeeRoleResource {
	EmployeeRolesDelegate delegate = new EmployeeRolesDelegate();
	@GET
	@Path("employeeRoles")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EmployeeRole> getEmployeeRoles()
	{
		System.out.println("employee DAO");
		return  delegate.getEmployeeRoles();
	}
}