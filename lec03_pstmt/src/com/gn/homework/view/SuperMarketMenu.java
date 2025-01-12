package com.gn.homework.view;

import java.util.List;
import java.util.Scanner;

import com.gn.homework.controller.BuyController;
import com.gn.homework.controller.ProductController;
import com.gn.homework.controller.UserController;
import com.gn.homework.model.vo.Product;

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
				case 2 : loginMenu();break;
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
		uc.userJoin(userId, userPw, userName);
	}
	public void loginMenu() {
		System.out.println("*** 로그인 ***");
		System.out.println("아이디,비밀번호를 입력하세요");
		System.out.print("아이디 : ");
		String userId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String userPw = sc.nextLine();
		uc.loginMenu(userId, userPw);
		
	}
	// 관리자 메뉴
	public void adminMenu() {
		System.out.println("*** 관리자 메뉴 ***");
		System.out.println("1. 제품등록");
		System.out.println("2. 제품입고");
		System.out.println("3. 판매현황");
		System.out.println("0. 로그아웃");
		System.out.print("메뉴 : ");
		int menu = sc.nextInt();
		sc.nextLine();
		switch(menu) {
			case 1 : insertProduct();break;
			case 2 : updateProductOne();break;
			case 3 : selectBuyListAll();break;
			case 0 : System.out.println("이용해주셔서 감사합니다!");return;
			default : System.out.println("뚜앗 그런 메뉴는 없당께!!");break;
			}
		
	}
	// 제품등록
	public void insertProduct() {
		System.out.println("*** 제품등록 ***");
		System.out.println("제품명,제품가격,입고개수 를 입력하세요.");
		System.out.print("제품명 : ");
		String productName = sc.nextLine();
		System.out.print("제품가격 : ");
		int productPrice = sc.nextInt();
		sc.nextLine();
		System.out.print("입고개수 : ");
		int productAmount = sc.nextInt();
		sc.nextLine();
		pc.insertProduct(productName, productPrice, productAmount);
	}
	// 제품입고
	public void updateProductOne() {
		System.out.println("*** 제품 입고 ***");
		List<Product> list = pc.selectProductAll();
		printListProduct(list);
		System.out.println("제품입고할 제품번호 와 입고개수를 입력하세요.");
		System.out.print("제품번호 : ");
		int ProductNO = sc.nextInt();
		sc.nextLine();
		System.out.print("입고개수 : ");
		int ProductAmount = sc.nextInt();
		sc.nextLine();
		pc.updateProductOne(ProductNO, ProductAmount);
	}
	// 전체조회
	public void printListProduct(List<Product> list) {
		if(list.isEmpty()) {
			System.out.println("조회된 제품 정보가 없습니다.");
		}else {
			for(Product pr : list) {
				System.out.println(pr);
			}
		}
	}
	// 판매 현황
	public void selectBuyListAll() {            
	bc.selectBuyListAll();
	}
	// 사용자 메뉴
	public void userMenu(String userId) {
		System.out.println("*** 사용자 메뉴 ***");
		System.out.println("1. 제품구매");
		System.out.println("2. 개인정보수정");
		System.out.println("3. 회원탈퇴");
		System.out.println("4. 로그아웃");
		System.out.print("메뉴 : ");
		int menu = sc.nextInt();
		sc.nextLine();
		switch(menu) {
			case 1 : ProductBuy();break;
			case 2 : updateUser();break;
			case 3 : deleteUser();break;
			case 4 : System.out.println("이용해주셔서 감사합니다.");return;
			default : System.out.println("엥 그런번호는 없는디^^");
		}
	}
	public void ProductBuy() {
		System.out.println("*** 제품구매 ***");
	}
	public void updateUser() {
		System.out.println("*** 개인정보수정 ***");
	}
	public void deleteUser() {
		System.out.println("*** 회원 탈퇴 ***");
	}
	
}
