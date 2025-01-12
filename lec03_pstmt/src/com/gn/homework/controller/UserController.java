package com.gn.homework.controller;

import com.gn.homework.model.dao.UserDao;
import com.gn.homework.model.vo.User;

public class UserController {
	private UserDao ud = new UserDao();
	// 회원가입
	public void userJoin(String userId, String userPw, String userName) {
		User u = new User();
		u.setUserId(userId);
		u.setUserPw(userPw);
		u.setUserName(userName);
		int result = ud.userJoin(u);
		if(result > 0){
			System.out.println("정상적으로 회원가입되었습니다.");
		}else {
			System.out.println("회원가입 진행중 문제가 발생하였습니다.");
		}
		
	}
}
