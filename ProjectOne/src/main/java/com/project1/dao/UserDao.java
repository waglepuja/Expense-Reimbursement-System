package com.project1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project1.model.User;

	public class UserDao  {
	DatabaseConnection dbconnection = new DatabaseConnection(); // object name dbconnection created for DatabaseConnection class
	
	//For testing purpose
	public static void main(String[] args) {
		List<User> userList = new ArrayList<User>();
		UserDao user = new UserDao();
		userList = user.getAll();
		System.out.println(userList); // test getAll method
		
		User selectedUser = new User();
		selectedUser = user.getOne(1);
		System.out.println(selectedUser); //test getOne method
		
		User selectedUser1 = new User();
		selectedUser1 = user.getByUsername("Puja");
		System.out.println(selectedUser1); //test getByUsername method
		
	
		System.out.println(user.logIn("Puja", "java")); //test logIn
		
	}
	
	
	public List<User> getAll() {
		
		List<User> userList = new ArrayList<User>(); // since we cannot access the method directly we created a variable name of the object
		try(Connection conn = dbconnection.getDbConnection()){
								
			
			String sql = "select * from ersdb.ers.\"ers_users\"";
			
			PreparedStatement ps = conn.prepareStatement(sql); //PreparedStatement is a default class
			ResultSet rs = ps.executeQuery(); // executing query of PreparedStatement 
			
			while(rs.next()) {
				User user = new User();  //creating object
				user.setUsername(rs.getString("ers_username")); // accessing the method setUsername by using user obj, 
												//then accessing the "username" column of the current row
				user.setPassword(rs.getString("ers_password"));
				user.setFirstName(rs.getString("user_first_name"));
				user.setLastName(rs.getString("user_last_name"));
				user.setEmail(rs.getString("user_email"));
				user.setRoleId(rs.getInt("user_role_id"));
				user.setUserId(rs.getInt("ers_users_id"));
				userList.add(user); // every row gets added to the userList
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return userList; // returning the variable of List of User (List<User>)
	}

	
	public User getOne(Integer id) {
		// TODO Auto-generated method stub
		User selectedUser = new User();
		try(Connection conn = dbconnection.getDbConnection()){
			String sql = "select * from ersdb.ers.\"ers_users\" where ers_users_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id); // setting the value of the "?" parameter from the query statement by declaring the position and the value"id" (position,value)passed
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				selectedUser.setUsername(rs.getString("ers_username"));
				selectedUser.setPassword(rs.getString("ers_password"));
				selectedUser.setFirstName(rs.getString("user_first_name"));
				selectedUser.setLastName(rs.getString("user_last_name"));
				selectedUser.setEmail(rs.getString("user_email"));
				selectedUser.setRoleId(rs.getInt("user_role_id"));
				selectedUser.setUserId(rs.getInt("ers_users_id"));				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return selectedUser;
	}

	
	public User getByUsername(String username) {
		// TODO Auto-generated method stub
		User selectedUser = new User();
		try(Connection conn = dbconnection.getDbConnection()){
			String sql = "select * from ersdb.ers.\"ers_users\" where ers_username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username); 
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				selectedUser.setUsername(rs.getString("ers_username"));
				selectedUser.setPassword(rs.getString("ers_password"));
				selectedUser.setFirstName(rs.getString("user_first_name"));
				selectedUser.setLastName(rs.getString("user_last_name"));
				selectedUser.setEmail(rs.getString("user_email"));
				selectedUser.setRoleId(rs.getInt("user_role_id"));
				selectedUser.setUserId(rs.getInt("ers_users_id"));					
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return selectedUser;
	}

	
	public List<Integer> getByUserId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public User createNew(User obj) {
		// TODO Auto-generated method stub
		return null;
	}


	public User update(User obj) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String logIn(String username, String password) {
		int role = 0;
		try(Connection conn = dbconnection.getDbConnection()){
			String sql = "select * from ersdb.ers.\"ers_users\" where ers_username = ? and ers_password = ?";			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2,  password);			
			ResultSet rs = ps.executeQuery(); // this will execute the query and return result
			
			if(rs.next()) {
				role = rs.getInt("user_role_id");
			}
			String sql1 = "select * from ersdb.ers.\"ers_user_roles\" where ers_user_role_id = ?";
			PreparedStatement ps1 = conn.prepareStatement(sql1);
			ps1.setInt(1, role);
					
			ResultSet rs1 = ps1.executeQuery(); // this will execute the query and return result
			
			if(rs1.next()) {
				return rs1.getString("user_role");
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}

