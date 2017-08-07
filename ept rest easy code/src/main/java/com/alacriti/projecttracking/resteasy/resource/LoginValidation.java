package com.alacriti.projecttracking.resteasy.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.alacriti.projecttracking.biz.delegate.ManagerDelegate;
import com.alacriti.projecttracking.model.Login;
@Path("/")
public class LoginValidation {
	ManagerDelegate delegate = new ManagerDelegate();
	@POST
	@Path("verify")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	
	
	public boolean verify(Login login){
		 return delegate.verify(login);
}
}