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
	
	UserDao uDao = new UserDao();
	public String verifyLoginCredentials(String uname, String pass) {
		//System.out.println("inside second else");
		String result = uDao.logIn(uname, pass);
		
		
		return result;
	}
	
	public List<User> showAllUsers() {
		return uDao.getAll();
	}
	
	public User showUserInfo(String username) {		
		return uDao.getByUsername(username);
	}
	
	public User getUser(Integer id) {
		return uDao.getOne(id);
	}

}

