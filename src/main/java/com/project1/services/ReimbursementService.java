package com.project1.services;


import java.sql.Timestamp;
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
	ReimbursementDao rDao = new ReimbursementDao();
	
	public List<Reimbursement> retrieveReimbursements(Integer userid, String userrole){
		
		List<Reimbursement> result_list = new ArrayList<Reimbursement>();
		if(userrole == "Manager") { //we need to return all reimbursements
			result_list= rDao.getAllReimbursement();
			
		}else { // we need to return all the reimbursements for the specific userid
			result_list= rDao.getReimbursementByAuthorId(userid);
		}
		
		return result_list;
	}
	
	public List<Reimbursement> getAuthorReimbursements(Integer authorId){ 
		return rDao.getReimbursementByAuthorId(authorId);
	}
	
	public void createReimbursement(double reimb_amount, 
			Timestamp reimb_submitted,
			String reimb_description, byte reimb_receipt,
			Integer reimb_author,
			Integer reimb_status_id, Integer reimb_type_id){
		rDao.createNewReimbursement(reimb_amount, reimb_submitted, reimb_description, reimb_receipt, reimb_author, reimb_status_id, reimb_type_id);
	}
	
	public List<Reimbursement> getAllReimbursement() {
		return rDao.getAllReimbursement();
	}
	
	public void updateReimbursement(Integer statusId, Integer resolverId, Integer reimbId) {
		rDao.updateReimbursement(statusId, resolverId, reimbId);
	}

}
