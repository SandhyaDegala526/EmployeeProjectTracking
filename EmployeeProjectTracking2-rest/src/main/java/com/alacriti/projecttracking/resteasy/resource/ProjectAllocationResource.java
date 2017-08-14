package com.alacriti.projecttracking.resteasy.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.alacriti.projecttracking.biz.delegate.ProjectAllocationDelegate;
import com.alacriti.projecttracking.model.ProjectAllocationVO;

@Path("/")
public class ProjectAllocationResource {
	ProjectAllocationDelegate projectAllocationDelegate=new ProjectAllocationDelegate();
	@GET
	@Path("projectAssignList")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProjectAllocationVO> getProjectAllocationList()
	{
		return  projectAllocationDelegate.getProjectAllocationList();
	}
	@POST
	@Path("assignProject")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void projectAllotment(ProjectAllocationVO projectAllocationVO)
	{
		System.out.println("resource");
	
		projectAllocationDelegate.projectAllotment(projectAllocationVO);
	}
}

