package com.project1.services;


import java.util.ArrayList;
import java.util.List;

import com.project1.dao.ReimbursementDao;
import com.project1.model.Reimbursement;

public class ReimbursementService {

	public ReimbursementService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	/*
	 * public static Reimbursement updateReimbursement(int id) {
	 * 
	 * Reimbursement re =remD.g(id); remD.update(re);
	 * 
	 * return re; }
	 */

	
	public List<Reimbursement> retrieveReimbursements(Integer userid, String userrole){
		ReimbursementDao rDao = new ReimbursementDao();
		List<Reimbursement> result_list = new ArrayList<Reimbursement>();
		if(userrole == "Manager") { //we need to return all reimbursements
			result_list= rDao.getAllReimbursement();
			
		}else { // we need to return all the reimbursements for the specific userid
			result_list= rDao.getReimbursementByAuthorId(userid);
		}
		
		return result_list;
	}
	

}
