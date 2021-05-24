package com.project1.model;

import java.sql.Timestamp;

public class Reimbursement {
	
	private int reimbursmentID;
	private double amount;
	private int authorID;
	private String author;
	private int reimbursementTypeId;
	private int reimbursementStatusId;
	private String reimbursementDescription;
	private Timestamp reimbusermentSubmitted;
	private Timestamp reimbursementResolved;	
	private int resolverId;
	private String resolver;
	private byte receipt;
	
	public Reimbursement() {
		super();
	}
	public Reimbursement(int authorID) {
		this.authorID = authorID;
	}
	
	
	
	public Reimbursement(int reimbursmentID, double amount, int authorID, String author, int reimbursementTypeId,
			int reimbursementStatusId, String reimbursementDescription, Timestamp reimbusermentSubmitted,
			Timestamp reimbursementResolved, int resolverId, String resolver, byte receipt) {
		super();
		this.reimbursmentID = reimbursmentID;
		this.amount = amount;
		this.authorID = authorID;
		this.author = author;
		this.reimbursementTypeId = reimbursementTypeId;
		this.reimbursementStatusId = reimbursementStatusId;
		this.reimbursementDescription = reimbursementDescription;
		this.reimbusermentSubmitted = reimbusermentSubmitted;
		this.reimbursementResolved = reimbursementResolved;
		this.resolverId = resolverId;
		this.resolver = resolver;
		this.receipt = receipt;
	}



	public int getReimbursmentID() {
		return reimbursmentID;
	}



	public void setReimbursmentID(int reimbursmentID) {
		this.reimbursmentID = reimbursmentID;
	}



	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}



	public int getAuthorID() {
		return authorID;
	}



	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}


	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public int getReimbursementTypeId() {
		return reimbursementTypeId;
	}



	public void setReimbursementTypeId(int reimbursementTypeId) {
		this.reimbursementTypeId = reimbursementTypeId;
	}



	public int getReimbursementStatusId() {
		return reimbursementStatusId;
	}



	public void setReimbursementStatusId(int reimbursementStatusId) {
		this.reimbursementStatusId = reimbursementStatusId;
	}



	public String getReimbursementDescription() {
		return reimbursementDescription;
	}



	public void setReimbursementDescription(String reimbursementDescription) {
		this.reimbursementDescription = reimbursementDescription;
	}



	public Timestamp getReimbusermentSubmitted() {
		return reimbusermentSubmitted;
	}



	public void setReimbusermentSubmitted(Timestamp reimbusermentSubmitted) {
		this.reimbusermentSubmitted = reimbusermentSubmitted;
	}



	public Timestamp getReimbursementResolved() {
		return reimbursementResolved;
	}



	public void setReimbursementResolved(Timestamp reimbursementResolved) {
		this.reimbursementResolved = reimbursementResolved;
	}



	public int getResolverId() {
		return resolverId;
	}



	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}


	public String getResolver() {
		return resolver;
	}



	public void setResolver(String resolver) {
		this.resolver = resolver;
	}



	public byte getReceipt() {
		return receipt;
	}



	public void setReceipt(byte receipt) {
		this.receipt = receipt;
	}
	@Override
	public String toString() {
		return "Reimbursement [reimbursmentID=" + reimbursmentID + ", amount=" + amount + ", authorID=" + authorID
				+ ", author=" + author + ", reimbursementTypeId=" + reimbursementTypeId + ", reimbursementStatusId="
				+ reimbursementStatusId + ", reimbursementDescription=" + reimbursementDescription
				+ ", reimbusermentSubmitted=" + reimbusermentSubmitted + ", reimbursementResolved="
				+ reimbursementResolved + ", resolverId=" + resolverId + ", resolver=" + resolver + ", receipt="
				+ receipt + "]";
	}



}
