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

@Path("/")
public class ProjectResource {
	ProjectDelegate delegate = new ProjectDelegate();
	@GET
	@Path("projectList")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Project> getProjectList()
	{
		return  delegate.getProjectList();
	}
	@POST
	@Path("addProject")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void add(Project project)
	{
		delegate.addProject(project);
		//return delegate.getProjectList();
	}
}
