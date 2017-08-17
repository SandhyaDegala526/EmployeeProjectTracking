package com.alacriti.projecttracking.resteasy.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.alacriti.projecttracking.biz.delegate.ProjectDelegate;
import com.alacriti.projecttracking.model.Project;
import com.alacriti.projecttracking.model.ProjectEmployeeGroupVO;

@Path("/project")
public class ProjectResource {
	ProjectDelegate projectDelegate = new ProjectDelegate();
	@GET
	@Path("/getProjectList")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Project> getProjectList()
	{
		return  projectDelegate.getProjectList();
	}
	@POST
	@Path("/addProject")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void addProject(Project project)
	{
		System.out.println("project before resource");
		projectDelegate.addProject(project);
		System.out.println("project after resource");
	}
	@POST
	@Path("/getDateWiseProjects")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<ProjectEmployeeGroupVO> getDatewiseProjects(Project project)
	{
		return projectDelegate.getDatewiseProjects(project);
		
	}
	@GET
	@Path("/getProjectDurations")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Project> getProjectDurations( )
	{
		return projectDelegate.getProjectDurations();
		
	}
	
}
