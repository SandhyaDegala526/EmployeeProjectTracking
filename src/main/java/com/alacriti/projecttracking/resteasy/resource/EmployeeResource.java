package com.alacriti.projecttracking.resteasy.resource;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.alacriti.projecttracking.model.Employee;
import com.alacriti.projecttracking.biz.delegate.EmployeeDelegate;

@Path("/employee")
public class EmployeeResource {
	EmployeeDelegate delegate = new EmployeeDelegate();
	@GET
	@Path("/employeeList")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployeeList(@Context HttpServletRequest request)
	{
		System.out.println("employee DAO");
		HttpSession session= request.getSession();
		return  delegate.getEmployeeList();
	}
	@POST
	@Path("/addEmployee")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Employee> add(Employee employee,@Context HttpServletRequest request)
	{
		delegate.addEmployee(employee);
		HttpSession session= request.getSession();
		return delegate.getEmployeeList();
	}
	@GET
	@Path("/getNotAssignedEmployees")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getNotAssignedEmployees(@Context HttpServletRequest request)
	{
		HttpSession session= request.getSession();
		return delegate.getNotAssignedEmployees();
	}
}