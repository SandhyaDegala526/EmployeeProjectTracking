/*package com.alacriti.projecttracking.resteasy.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.alacriti.projecttracking.biz.delegate.DepartmentDelegate;
import com.alacriti.projecttracking.model.Department;

@Path("/")
public class DepartmentResource {
	DepartmentDelegate delegate = new DepartmentDelegate();
	@GET
	@Path("departmentList")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Department> getDepertmentList()
	{
		return  delegate.getDepartmentList();
	}
	@POST
	@Path("addDepartment")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Department> add(Department departments[])
	{
		delegate.addDepartment(departments);
		return delegate.getDepartmentList();
	}
}

*/