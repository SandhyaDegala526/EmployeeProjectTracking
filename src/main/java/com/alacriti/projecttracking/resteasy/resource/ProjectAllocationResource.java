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

import com.alacriti.projecttracking.biz.delegate.ProjectAllocationDelegate;
import com.alacriti.projecttracking.model.ProjectAllocationVO;

@Path("/projectAllocation")
public class ProjectAllocationResource {
	ProjectAllocationDelegate projectAllocationDelegate=new ProjectAllocationDelegate();
	@GET
	@Path("/getProjectAssignList")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProjectAllocationVO> getProjectAllocationList( @Context HttpServletRequest request)
	{
		HttpSession session= request.getSession();
		return  projectAllocationDelegate.getProjectAllocationList();
	}
	@POST
	@Path("/assignProject")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void projectAllotment(ProjectAllocationVO projectAllocationVO)
	{
		System.out.println("resource");
	
		projectAllocationDelegate.projectAllotment(projectAllocationVO);
	}
}

