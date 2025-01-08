package com.gn.homework.view;

import java.util.List;
import java.util.Scanner;

import com.gn.homework.controller.MusicContorller;
import com.gn.homework.controller.UserContorller;
import com.gn.homework.model.vo.Music;
import com.gn.homework.model.vo.User;

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
				case 3 : System.out.println("로그아웃 되었습니다.");return;
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
		
		User u = uc.login(userId, userPw);
		if(u != null) {
			System.out.println(userId+"님, 환영합니다");
			if(u.getUserNo() == 1) {
				managerMenu();
			}else {
				userMenu();
			}
		}else {
			System.out.println(userId+"는 존재하지 않는 정보입니다");
		}
		
	}
	public void managerMenu() {
		while(true) {
			System.out.println("*** 관리자 메뉴 ***");
			System.out.println("1.음악 추가");
			System.out.println("2.음악 인기 순위 조회");
			System.out.println("3. !!종료!! ");
			
			System.out.print("메뉴 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
				case 1 : insertMusicOne();break;
				case 2 : selectMusicTop10();break;
				case 3 : System.out.println("프로그램을 종료합니다!!");return;
				default : System.out.println("잘못된 번호입니다.");
			}
		}
	}
	public void insertMusicOne() {
		System.out.println("*** 음악 추가 ***");
		System.out.println("음악제목, 아티스트명을 입력하세요.");
		System.out.print("음악제목 : ");
		String musicName = sc.nextLine();
		System.out.print("아티스트명 : ");
		String artistName = sc.nextLine();
		int result = mc.insertMusicOne(musicName ,artistName);
		if(result > 0) {
			System.out.println("음악이 추가되었습니다");
		}else {
			System.out.println("음악 추가중 문제가 발생하였습니다.");
		}
	}
	public void selectMusicTop10() {
		System.out.println("*** 인기 순위 조회 ***");
		List<Music> list = mc.selectMusicTop10();
		if(list.isEmpty()) {
			System.out.println("조회된 정보가 없습니다.");
		}else {
			for(Music m : list) {
				System.out.println(m);
			}
		}
		
	}
	public void userMenu() {
		System.out.println("*** 사용자메뉴 ***");
	}
}
