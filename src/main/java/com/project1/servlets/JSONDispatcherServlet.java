package com.project1.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project1.controller.HomeController;
import com.project1.controller.UserController;

public class JSONDispatcherServlet {

	public static void process(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		
		switch(req.getRequestURI()) {
		
		case "/ProjectOne/login.json":
			String login = UserController.login(req);
			res.getWriter().write(new ObjectMapper().writeValueAsString(login));
			break;
		case "/ProjectOne/viewPast.json":
			//call view reimbursement by author
			//res.getWriter()
			//.write(new ObjectMapper().writeValueAsString(__PASS_OBJECT_OR_ARRAY_TO_WRITE_HERE__));	
			break;
		case "/ProjectOne/addReimbursement.json":
			//call insert reimbursement
			UserController.login(req);
			break;
		case "/ProjectOne/updateReimbursement.json":
			// call update reimbursement
			break;
		case "/ProjectOne/viewAllReimbursement.json":
			// call view all reimbursement
			break;
		case "/ProjectOne/viewByStatus.json":
			//call view reimbursement by status
			break;
		case "/ProjectOne/getSessionReim.json":
			HomeController.getSessionReim(req, res);
			break;
			default:
				System.out.println("doing nothing");
		
	}
}
}
