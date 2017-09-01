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
import com.alacriti.projecttracking.biz.delegate.ProjectAllocationDelegate;
import com.alacriti.projecttracking.model.vo.ProjectAllocationVO;

@Path("/projectAllocation")
@Singleton
public class ProjectAllocationResource {
	public static final Logger log = Logger
			.getLogger(ProjectAllocationResource.class);
	ProjectAllocationDelegate projectAllocationDelegate = new ProjectAllocationDelegate();

	@GET
	@Path("/getProjectAssignList")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProjectAllocationVO> getProjectAllocationList() {
		log.debug(" ProjectAllocationResource.getProjectAllocationList start");
		return projectAllocationDelegate.getProjectAllocationList();
	}

	@POST
	@Path("/assignProject")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String projectAllotment(ProjectAllocationVO projectAllocationVO) {
		log.debug(" ProjectAllocationResource.projectAllotment start");
		return  projectAllocationDelegate.projectAllotment(projectAllocationVO);

	}
}
