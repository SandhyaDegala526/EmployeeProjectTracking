package com.alacriti.projecttracking.resteasy.resource;

import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.alacriti.projecttracking.model.vo.EmployeeVO;
import com.alacriti.projecttracking.biz.delegate.EmployeeDelegate;

@Path("/employee")
@Singleton
public class EmployeeResource {
	EmployeeDelegate delegate = new EmployeeDelegate();
	@GET
	@Path("/employeeList")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EmployeeVO> getEmployeeList()
	{
		System.out.println("employee DAO");
		return  delegate.getEmployeeList();
	}
	@POST
	@Path("/addEmployee")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String add(EmployeeVO employee)
	{
		return delegate.addEmployee(employee);
		
	}
	@GET
	@Path("/getNotAssignedEmployees")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EmployeeVO> getUnAssignedEmployees()
	{
		return delegate.getUnAssignedEmployees();
	}
}