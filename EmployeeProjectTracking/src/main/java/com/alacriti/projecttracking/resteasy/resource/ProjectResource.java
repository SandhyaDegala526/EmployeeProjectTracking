package com.alacriti.projecttracking.resteasy.resource;

import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.alacriti.projecttracking.biz.delegate.ProjectDelegate;
import com.alacriti.projecttracking.model.vo.ProjectEmployeeGroupVO;
import com.alacriti.projecttracking.model.vo.ProjectVO;

@Path("/project")
@Singleton
public class ProjectResource {
	public static final Logger log = Logger.getLogger(ProjectResource.class);
	ProjectDelegate projectDelegate = new ProjectDelegate();

	
	@GET
	@Path("/getProjectList")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProjectVO> getProjectList()
	{		
		log.debug(" ProjectResource.getProjectList start");
		return  projectDelegate.getProjectList();
	}
	@POST
	@Path("/addProject")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean addProject(ProjectVO project)
	{
		log.debug(" ProjectResource.addProject start");
		return projectDelegate.addProject(project);
		
	}
	@POST
	@Path("/getDateWiseProjects")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<ProjectEmployeeGroupVO> getDatewiseProjects(ProjectVO project)
	{
		log.debug(" ProjectResource.getDatewiseProjects start");
		return projectDelegate.getDatewiseProjects(project);
		
	}
	@GET
	@Path("/getProjectDurations")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProjectVO> getProjectDurations( )
	{
		log.debug(" ProjectResource.getProjectDurations start");
		return projectDelegate.getProjectDurations();
		
	}
	
}
