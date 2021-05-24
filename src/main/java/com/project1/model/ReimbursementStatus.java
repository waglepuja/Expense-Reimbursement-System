package com.project1.model;

public class ReimbursementStatus {
	
	private int reimbursementId;
	private String reimbursementStatus;
	
	public ReimbursementStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReimbursementStatus(int reimbursementId, String reimbursementStatus) {
		super();
		this.reimbursementId = reimbursementId;
		this.reimbursementStatus = reimbursementStatus;
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public String getReimbursementStatus() {
		return reimbursementStatus;
	}

	public void setReimbursementStatus(String reimbursementStatus) {
		this.reimbursementStatus = reimbursementStatus;
	}

	@Override
	public String toString() {
		return "ReimbursementStatus [reimbursementId=" + reimbursementId + ", reimbursementStatus="
				+ reimbursementStatus + "]";
	}

	
	
	
	
	

}
