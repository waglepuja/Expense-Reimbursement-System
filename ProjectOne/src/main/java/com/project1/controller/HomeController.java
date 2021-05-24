package com.project1.controller;

import javax.servlet.http.HttpServletRequest;

import com.project1.services.UserService;

public class HomeController {
	
	static UserService userServ = new UserService();
	
	public static String login(HttpServletRequest req) {
		if(!req.getMethod().equals("POST")){
			return "html/login.html";
		}
		
		UserVillain vill = userServ
		
	}

}
