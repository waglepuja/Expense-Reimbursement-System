package com.project1.model;

public class UserRole {

	private int userRoleId;
	private String uerRole;
	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserRole(int userRoleId, String uerRole) {
		super();
		this.userRoleId = userRoleId;
		this.uerRole = uerRole;
	}
	
	//Getters and Setters
	
	public int getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}
	public String getUerRole() {
		return uerRole;
	}
	public void setUerRole(String uerRole) {
		this.uerRole = uerRole;
	}
	
	@Override
	public String toString() {
		return "UserRole [userRoleId=" + userRoleId + ", uerRole=" + uerRole + "]";
	}
	
	
	
	
	
	
}
