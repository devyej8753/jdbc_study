package com.gn.homework.controller;

import com.gn.homework.model.dao.UserDao;
import com.gn.homework.model.vo.User;
import com.gn.homework.view.SuperMarketMenu;

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
	// 로그인
	public void loginMenu(String userId, String userPw) {
		User u = new User();
		u.setUserId(userId);
		u.setUserPw(userPw);
		String name = ud.loginMenu(u);
		if(name != null) {
			System.out.println(name+"님 환영합니다.");
			if("admin".equals(userId)) {
				new SuperMarketMenu().adminMenu();
			}else {
				new SuperMarketMenu().userMenu(userId);
			}
		}else {
			System.out.println("잘못된 아이디 또는 비밀번호 입니다.");
		}
	}
}
