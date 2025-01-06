package com.gn.homework.controller;

import com.gn.homework.model.dao.UserDao;
import com.gn.homework.model.vo.User;

public class UserContorller {
	// 회원가입
	public int insertUser(String userId, String userPw, String userName) {
		User u = new User(userId,userPw,userName);
		
		int result = new UserDao().insertUser(u);
		return result;
	}
	// 로그인
//	public User login(String userId ,String userPw) {
//		return new UserDao().login();
	}
	
}
