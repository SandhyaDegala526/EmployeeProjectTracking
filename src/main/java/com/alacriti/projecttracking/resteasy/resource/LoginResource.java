package com.alacriti.projecttracking.resteasy.resource;

import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.alacriti.projecttracking.biz.delegate.LoginDelegate;
import com.alacriti.projecttracking.model.vo.LoginVO;
import com.alacriti.projecttracking.util.SessionUtility;

@Path("/login")
@Singleton
public class LoginResource {
	public static final Logger log = Logger.getLogger(LoginResource.class);
	LoginDelegate delegate = new LoginDelegate();

	@POST
	@Path("/verifyLoginDetails")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean verify(LoginVO login, @Context HttpServletRequest request) {
		log.debug(" LoginDelegate.LoginResource start");
		if (delegate.verify(login)) {
			HttpSession session = request.getSession();
		}
		return delegate.verify(login);
	}

	@GET
	@Path("/session")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean checkSessoin(@Context HttpServletRequest request) {
		SessionUtility sessionUtility = new SessionUtility();
		return sessionUtility.checkForSession(request);
	}

	@GET
	@Path("/sessionDestroy")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean sessoinDestroy(@Context HttpServletRequest request) {
		log.debug("SessionResource sessoinDestroy");
		boolean result = false;
		SessionUtility sessionUtility = null;
		try {
			sessionUtility = new SessionUtility();
			HttpSession session = request.getSession(false);
			session.invalidate();
			result = sessionUtility.checkForSession(request);
		} catch (Exception e) {
			log.error(e.getMessage());
			System.out.println("Exception occured in destroying session");
		}
		return result;

	}

}
