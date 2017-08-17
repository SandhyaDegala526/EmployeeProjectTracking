package com.alacriti.projecttracking.resteasy.resource;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.alacriti.projecttracking.biz.delegate.EmployeeRolesDelegate;
import com.alacriti.projecttracking.model.EmployeeRole;

@Path("/employeeRoles")
public class EmployeeRoleResource {
	EmployeeRolesDelegate delegate = new EmployeeRolesDelegate();
	@GET
	@Path("/getEmployeeRoles")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EmployeeRole> getEmployeeRoles(@Context HttpServletRequest request)
	{
		System.out.println("employee DAO");
		HttpSession session= request.getSession();
		return  delegate.getEmployeeRoles();
	}
}