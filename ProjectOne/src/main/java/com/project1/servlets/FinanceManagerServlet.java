package com.project1.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project1.dao.ReimbursementDao;
import com.project1.model.Reimbursement;

@WebServlet("/manager")
public class FinanceManagerServlet extends HttpServlet {
	
	//ReimbursementDao reimburseDao = new ReimbursementDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Reimbursement> ReimbursementList = new ArrayList<Reimbursement>();
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(ReimbursementList);     //???????????
		

		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");
		pw.write(json);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
