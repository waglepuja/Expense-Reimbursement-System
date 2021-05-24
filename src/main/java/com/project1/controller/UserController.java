package com.project1.controller;

import javax.servlet.http.HttpServletRequest;

import com.project1.services.UserService;

public class UserController {
	
	static UserService userServ = new UserService();
	
	public static String login(HttpServletRequest req) {
		System.out.println("User="+req);
		System.out.println("Username is = " + req.getParameter("username"));
		System.out.println("Password is = " + req.getParameter("password"));
		System.out.println(userServ.verifyLoginCredentials(req.getParameter("username"), req.getParameter("password")));
		return userServ.verifyLoginCredentials(req.getParameter("username"), req.getParameter("password"));		
	}

}
