package com.gn.study.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.gn.study.controller.Controller;
import com.gn.study.model.vo.Car;

// 사용자가 보게될 화면
// - 사용자에게 정보 입력 받기
// - 결과 화면 출력
public class Menu {
	private Scanner sc = new Scanner(System.in);
	private Controller controller = new Controller();
	
	
	public void mainMenu() {
		while(true) {
			System.out.println("=== 자동차 정보 관리 ===");
			System.out.println("1. 추가");
			System.out.println("2. 목록 조회");
			System.out.println("3. 단일 조회");
			System.out.println("4. 수정");
			System.out.println("5. 삭제");
			
			System.out.print("메뉴 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
				case 1 : insertCarOne();break;
				case 2 : selectCarAll();break;
				case 3 : selectCarOne();break;
				case 4 : updateCarOne();break;
				case 5 : deleteCarOne();break;
			}	
		}
	}
	public void updateCarOne() {
		System.out.println("*** 수정 ***");
		List<Car> list = controller.selectCarAll();
		printList(list);
		
		System.out.println("어떤 모델의 정보를 수정하시겠습니까 ?");
		System.out.print("번호 : ");
		int carNo = sc.nextInt();
		sc.nextLine();
		
		System.out.println("모델명을 수정하시겠습니까? (Y/N)");
		String carModel = sc.nextLine();
		String model = null;
		if("Y".equals(carModel)) {
			System.out.print("모델명 : ");
			model = sc.nextLine();
			
		}
		System.out.println("가격을 수정하시겠습니까? (Y/N)");
		String carPrice = sc.nextLine();
		int price = 0;
		if("Y".equals(carPrice)) {
			System.out.print("가격 : ");
			price = sc.nextInt();
			sc.nextLine();
		}
		System.out.println("출시일을 수정하시겠습니까? (Y/N)");
		String carDate = sc.nextLine();
		String date = null;
		if("Y".equals(carDate)) {
			System.out.print("출시일 : ");
			date = sc.nextLine();
		}
		int result = controller.updateCarOne(carNo,model,price,date);
		dmlResultPrint(result,"수정");
	}
	
	
	public void deleteCarOne() {
		System.out.println("*** 삭제 ***");
		List<Car> list = controller.selectCarAll();
		printList(list);
		System.out.println("삭제하고자 하는 자동차 번호를 입력하세요.");
		System.out.print("번호 : ");
		int carNo = sc.nextInt();
		int result = controller.deleteCarOne(carNo);
		dmlResultPrint(result,"삭제");
		
		
	}
	
	
	
	
	public void selectCarOne() {
		System.out.println("*** 단일 조회 ***");
		System.out.println("검색 기준으로 삼고 싶은 항목을 선택하세요.");
		System.out.println("1. 번호 / 2. 모델명 / 3. 가격 / 4. 출시일 ");
		System.out.print("선택 : ");
		int menu = sc.nextInt();
		sc.nextLine();
		switch(menu) {
			case 1 : selectCarNo();break;
			case 2 : selectCarModel();break;
			case 3 : selectCarPrice();break;
			case 4 : selectCarDate();break;
			case 0 : System.out.println("취소합니다.");return;
		}
		
	}
	// 번호
	public void selectCarNo() {
		System.out.println("번호 기준으로 검색합니다.");
		System.out.print("번호 : ");
		int number = sc.nextInt();
		List<Car> list = controller.selectCarNo(number);
		printList(list);
	}
	// 단일조회 모델명
	public void selectCarModel() {
		System.out.println("모델명 기준으로 검색합니다.");
		System.out.print("모델명 : ");
		String carName = sc.nextLine();
		List<Car> list = controller.selectCarModel(carName);
		printList(list);
	}
	// 가격
	public void selectCarPrice() {
		System.out.println("가격 기준으로 검색합니다.");
		System.out.print("가격 : ");
		int price = sc.nextInt();
		List<Car> list = controller.selectCarPrice(price);
		printList(list);
	}
	// 출시일
	public void selectCarDate() {
		System.out.println("가격 기준으로 검색합니다.");
		System.out.print("가격 : ");
		String date = sc.nextLine();
		List<Car> list = controller.selectCarDate(date);
		printList(list);
	}
	
	public void selectCarAll() {
		System.out.println("*** 목록 조회 ***");
		List<Car> list = controller.selectCarAll();
		printList(list);
	}
	
	
	public void printList(List<Car> list) {
		if(list.isEmpty()) {
			System.out.println("조회된 결과가 없습니다.");
		}else {
			for(Car c : list) {
				System.out.println(c);
			}
		}
	}
	
	
	public void insertCarOne() {
		System.out.println("*** 추가 ***");
		System.out.println("모델명, 가격, 출시일을 입력하세요.");
		System.out.println("다만, 출시일은 반드시 OOOO-OO-OO 형식으로 입력해주세요.");
		System.out.print("모델명 : ");
		String modelName = sc.nextLine();
		System.out.print("가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		
		System.out.println("출시일 정보를 입력하시겠습니까?(Y/N)");
		String dateFlag = sc.nextLine();
		String date = null;
		if("Y".equals(dateFlag)) {
			System.out.print("출시일 : ");
			date = sc.nextLine();
		}
//		char dateFlag = sc.nextLine().charAt(0);
//		String date = null;
//		if(dateFlag == 'Y') {
//			System.out.print("출시일 : ");
//			date = sc.nextLine();
//		}
		int result = controller.insertCarOne(modelName,price,date);
		dmlResultPrint(result,"추가");
	}
	
	public void dmlResultPrint(int result, String menuName) {
		if(result > 0) System.out.println(menuName+"이(가) 정상 수행되었습니다.");
		else System.out.println(menuName+"중 오류가 발생하였습니다.");
	}
}
