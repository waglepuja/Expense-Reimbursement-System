package com.project1.services;


import java.util.List;
import com.project1.dao.UserDao;
import com.project1.model.User;

public class UserService {
	
	//static User u = UserDao.getByUsername(username);
	
	public UserService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public boolean verifyLoginCredentials(String uname, String pass) {
		UserDao uDao = new UserDao();
		//System.out.println("inside second else");
		String result = uDao.logIn(uname, pass);
		
		if(result != null) {
			return true;
		}else {
			return false;
		}
	}
	
		

}

