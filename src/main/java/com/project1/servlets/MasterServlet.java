package com.project1.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MasterServlet extends HttpServlet { // with Servlet, the first thing is to write extends HttpServlet 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		req.getRequestDispatcher(RequestDispatcher.process(req)).forward(req,  res); // insdie of this i have to provide a path, and my requestDispatcher will provide that path for me
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		System.out.println("in master doPost");
		req.getRequestDispatcher(RequestDispatcher.process(req)).forward(req,  res); 
	}

}
