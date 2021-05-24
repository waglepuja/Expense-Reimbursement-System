package com.project1.servlets;

import javax.servlet.http.HttpServletRequest;

import com.project1.controller.HomeController;

public class RequestDispatcher {
public static String process(HttpServletRequest req) {
		
		switch(req.getRequestURI()) {
			case "/ProjectOne/login.change":
				System.out.println("in Login.change dispatcher");
				return HomeController.login(req);
				
			default:
					System.out.println("in default");
					return "html/unsuccessfullogin.html";
				
			
		
		}
		
	}

}
