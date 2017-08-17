package com.alacriti.projecttracking.resteasy.resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.alacriti.projecttracking.biz.delegate.LoginDelegate;
import com.alacriti.projecttracking.model.Login;
import com.alacriti.projecttracking.util.SessionUtility;
@Path("/login")
public class LoginResource {
	
	@POST
	@Path("/verifyLoginDetails")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	
	
	public boolean verify(Login login , @Context HttpServletRequest request){
		LoginDelegate delegate = new LoginDelegate();
		
		if(delegate.verify(login))
		{
		HttpSession session= request.getSession();
		}
		 return delegate.verify(login);
}
	@GET
	@Path("/session")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean checkSessoin(@Context HttpServletRequest request)
	{
	SessionUtility sessionUtility=new SessionUtility();
	HttpSession session= request.getSession(false);
	System.out.println("session in checkSession :"+session);
	return sessionUtility.checkForSession(session);
	}

}