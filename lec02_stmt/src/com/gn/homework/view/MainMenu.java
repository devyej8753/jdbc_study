package com.gn.homework.view;

import java.util.Scanner;

import com.gn.homework.controller.MusicContorller;
import com.gn.homework.controller.UserContorller;

public class MainMenu {
	private Scanner sc = new Scanner(System.in);
	MusicContorller mc = new MusicContorller();
	UserContorller uc = new UserContorller();
	public void Initialmenu() {
		while(true) {
			System.out.println("=== 초기 메뉴 ===");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 로그아웃");
			
			System.out.print("메뉴 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
				case 1 : insertUser();break;
				case 2 : login();break;
				case 3 : System.out.println("로그아웃");return;
				default : System.out.println("잘못된 번호입니다.");
			}
		}
	}
	// 회원가입
	public void insertUser() {
		System.out.println("=== 회원가입 ===");
		System.out.print("아이디 : ");
		String userId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String userPw = sc.nextLine();
		System.out.print("이름 : ");
		String userName = sc.nextLine();
		
		int result = uc.insertUser(userId ,userPw ,userName);
		if(result > 0) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
	}
	public void login() {
		System.out.println("=== 로그인 ===");
		System.out.print("아이디 : ");
		String userId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String userPw = sc.nextLine();
		
	}
	
}
