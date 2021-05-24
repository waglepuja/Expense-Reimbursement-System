package com.project1.model;

public class ReimbursementType {

	private int reimbimbursementTypeId;
	private String reimbursementType;
	
	
	public ReimbursementType() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ReimbursementType(int reimbimbursementTypeId, String reimbursementType) {
		super();
		this.reimbimbursementTypeId = reimbimbursementTypeId;
		this.reimbursementType = reimbursementType;
	}

	//Getter and Setters

	public int getReimbimbursementTypeId() {
		return reimbimbursementTypeId;
	}


	public void setReimbimbursementTypeId(int reimbimbursementTypeId) {
		this.reimbimbursementTypeId = reimbimbursementTypeId;
	}


	public String getReimbursementType() {
		return reimbursementType;
	}


	public void setReimbursementType(String reimbursementType) {
		this.reimbursementType = reimbursementType;
	}


	@Override
	public String toString() {
		return "ReimbursementType [reimbimbursementTypeId=" + reimbimbursementTypeId + ", reimbursementType="
				+ reimbursementType + "]";
	}
	
	
	
	
	
}
