package com.project1.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project1.model.Reimbursement;
import com.project1.model.User;
import com.project1.services.ReimbursementService;
import com.project1.services.UserService;

public class HomeController {
	
	static UserService userServ = new UserService();
	static ReimbursementService rs = new ReimbursementService();
	
	public static String login(HttpServletRequest req) {
		
		System.out.println("inside home controller login");
		/*
		 * if(!req.getMethod().equals("POST")) { return "/login.page"; }
		 */
		if(req.getParameter("username") == null) {
			return "/login.page";
		}
		String role = userServ.verifyLoginCredentials(req.getParameter("username"), req.getParameter("password"));
		
		User u = userServ.showUserInfo(req.getParameter("username"));
		int authorId = userServ.showUserInfo(req.getParameter("username")).getUserId();
		List<Reimbursement> reimbursementList = new ArrayList<Reimbursement>();
		
		if(role == null) {
			return "/unauthenticated.page";
		}
		else {
			req.getSession().setAttribute("currentUserId", authorId);
			if(role.contains("Finance_Manager")) {
				reimbursementList = rs.getAllReimbursement();
				for(int i=0; i<reimbursementList.size(); i++) {
					reimbursementList.get(i).setAuthor(userServ.getUser(reimbursementList.get(i).getAuthorID()).getFirstName() + " " + userServ.getUser(reimbursementList.get(i).getAuthorID()).getLastName());
					reimbursementList.get(i).setResolver(userServ.getUser(reimbursementList.get(i).getResolverId()).getFirstName() + " " + userServ.getUser(reimbursementList.get(i).getResolverId()).getLastName());
				}
				req.getSession().setAttribute("currentUserReimbursement", reimbursementList);
				return "/financemanager.page";
			}
			else {
				reimbursementList = rs.getAuthorReimbursements(authorId);
				for(int i=0; i<reimbursementList.size(); i++) {
					reimbursementList.get(i).setResolver(userServ.getUser(reimbursementList.get(i).getResolverId()).getFirstName() + " " + userServ.getUser(reimbursementList.get(i).getResolverId()).getLastName());
				}
				req.getSession().setAttribute("currentUserReimbursement", reimbursementList);
				return "/employee.page";
			}
		}
	}
	
	public static String logOut(HttpServletRequest req) {
		req.setAttribute("username", null);
		req.getSession().setAttribute("currentUserId", null);
		req.getSession().setAttribute("currentUserReimbursement", null);
		System.out.println("check = " + req.getParameter("currentUserId"));
		
		req.getSession().invalidate();
		return "/login.page";
	}
	
	public static void getSessionReim(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		HttpSession session = req.getSession(false);
		res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if(session!=null) {
			System.out.println("It's entering the getSessionReim");
		List<Reimbursement> reim = (List<Reimbursement>) req.getSession().getAttribute("currentUserReimbursement");
		
		res.getWriter().write(new ObjectMapper().writeValueAsString(reim));
		}
	}
	
	public static String addReimbursement(HttpServletRequest req) {
		System.out.println("inside add reimbursement login");
		if(!req.getMethod().equals("POST")) { 
			return "html/index.html";
		}
		int userId = (Integer)req.getSession().getAttribute("currentUserId");
		int statusId = 1;
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		
		rs.createReimbursement(Double.parseDouble(req.getParameter("amount")), currentTime, req.getParameter("description"), Byte.parseByte(req.getParameter("receipt")), userId, statusId, Integer.parseInt(req.getParameter("typeId")));
		List<Reimbursement> reimbursementList = new ArrayList<Reimbursement>();
		reimbursementList = rs.getAuthorReimbursements(userId);
		for(int i=0; i<reimbursementList.size(); i++) {
			reimbursementList.get(i).setAuthor(userServ.getUser(reimbursementList.get(i).getAuthorID()).getFirstName() + " " + userServ.getUser(reimbursementList.get(i).getAuthorID()).getLastName());
			reimbursementList.get(i).setResolver(userServ.getUser(reimbursementList.get(i).getResolverId()).getFirstName() + " " + userServ.getUser(reimbursementList.get(i).getResolverId()).getLastName());
		}
		req.getSession().setAttribute("currentUserReimbursement", reimbursementList);
		return "/employee.page";
		
	}
	 
	public static String approveReimbursement(HttpServletRequest req) {
		
		int userId = (Integer)req.getSession().getAttribute("currentUserId");
		rs.updateReimbursement(2, userId,  Integer.parseInt(req.getParameter("reimbId")));
		List<Reimbursement> reimbursementList = new ArrayList<Reimbursement>();
		reimbursementList = rs.getAllReimbursement();
		for(int i=0; i<reimbursementList.size(); i++) {
			reimbursementList.get(i).setAuthor(userServ.getUser(reimbursementList.get(i).getAuthorID()).getFirstName() + " " + userServ.getUser(reimbursementList.get(i).getAuthorID()).getLastName());
			reimbursementList.get(i).setResolver(userServ.getUser(reimbursementList.get(i).getResolverId()).getFirstName() + " " + userServ.getUser(reimbursementList.get(i).getResolverId()).getLastName());
		}
		req.getSession().setAttribute("currentUserReimbursement", reimbursementList);
		return "/financemanager.page";
	}
	
	public static String denyReimbursement(HttpServletRequest req) {

		int userId = (Integer)req.getSession().getAttribute("currentUserId");
		rs.updateReimbursement(3, userId,  Integer.parseInt(req.getParameter("reimbId")));
		List<Reimbursement> reimbursementList = new ArrayList<Reimbursement>();
		reimbursementList = rs.getAllReimbursement();
		for(int i=0; i<reimbursementList.size(); i++) {
			reimbursementList.get(i).setAuthor(userServ.getUser(reimbursementList.get(i).getAuthorID()).getFirstName() + " " + userServ.getUser(reimbursementList.get(i).getAuthorID()).getLastName());
			reimbursementList.get(i).setResolver(userServ.getUser(reimbursementList.get(i).getResolverId()).getFirstName() + " " + userServ.getUser(reimbursementList.get(i).getResolverId()).getLastName());
		}
		req.getSession().setAttribute("currentUserReimbursement", reimbursementList);
		return "/financemanager.page";
	}
	
	
	

}
