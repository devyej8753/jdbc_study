package com.gn.homework.view;

import java.util.Scanner;

import com.gn.homework.controller.BuyController;
import com.gn.homework.controller.ProductController;
import com.gn.homework.controller.UserController;

public class SuperMarketMenu {
	private Scanner sc = new Scanner(System.in);
	private BuyController bc = new BuyController();
	private ProductController pc = new ProductController();
	private UserController uc = new UserController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("=== 슈퍼마켓 ===");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("0.종료");
			
			System.out.print("메뉴 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
				case 1 : userJoin();break;
				case 2 : break;
				case 0 : System.out.println("이용해주셔서 감사합니다.");return;
				default : System.out.println("메뉴를 잘못 입력하셨습니다.");
				
			}
		}
	}
	public void userJoin() {
		System.out.println("*** 회원가입 ***");
		System.out.println("아이디,비밀번호,닉네임 을 입력하세요!");
		System.out.print("아이디 : ");
		String userId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String userPw = sc.nextLine();
		System.out.print("닉네임 : ");
		String userName = sc.nextLine();
		
		new UserController().userJoin(userId, userPw, userName);
	}
	
	
	
	
	
}
