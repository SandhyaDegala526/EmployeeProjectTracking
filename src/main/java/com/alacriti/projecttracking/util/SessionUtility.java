package com.alacriti.projecttracking.util;

import javax.servlet.http.HttpSession;

public class SessionUtility {
	public boolean checkForSession(HttpSession session) {
		System.out.println("printing the status of session");
		System.out.println(session);
		if (session == null)
			return false;
		else
			return true;
	}

}