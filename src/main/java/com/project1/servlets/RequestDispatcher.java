package com.project1.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project1.controller.HomeController;

public class RequestDispatcher {
public static String process(HttpServletRequest req) {
		
		switch(req.getRequestURI()) {
			case "/ProjectOne/login.page":
				return "html/login.html";
			case "/ProjectOne/login.change":
				System.out.println("test pass");
				return HomeController.login(req);
			case "/ProjectOne/employee.page":
				System.out.println("Entering employee");
				return "html/employee.html";
			case "/ProjectOne/addReimbursement.page":
				return "html/addReimbursement.html";
			case "/ProjectOne/addReimbursement.change":
				return HomeController.addReimbursement(req);
			case "/ProjectOne/financemanager.page":
				return "html/financemanager.html";
			case "/ProjectOne/approveReimbursement.change":
				return HomeController.approveReimbursement(req);
			case "/ProjectOne/denyReimbursement.change":
				return HomeController.denyReimbursement(req);
			case "/ProjectOne/logOut.change":
				return HomeController.logOut(req);
			case "/unauthenticated.page":
				return "html/errorlogin.html";
				
			default:
					System.out.println("in default");
					return "html/errorlogin.html";
					
		}
		
	}

}
