package com.gn.study.controller;

import java.sql.*;


public class D_Insert {

	public static void main(String[] args) {
		// 1. 작업용 객체 선언
		Connection conn = null;
		Statement stmt = null;
		
		// 2. try~catch~finally
		try {
			// 3. DriverManager 위치 찾기
			Class.forName("org.mariadb.jdbc.Driver");
			// 4. 터널(Connection) 만들기
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			// 5. 자동차(Statement) 만들기
			stmt = conn.createStatement();
			// 6. 자동차에 쿼리문 실어보내기(문자 -> '')
			//String sql = "INSERT INTO test(t_name) VALUES('테스트4')";
			String sql = "INSERT INTO test "
					+"VALUES(5,'테스트5',NOW())";
			int result = stmt.executeUpdate(sql);
			// 7. 결과 확인
			if(result > 0) {
				System.out.println("성공이닷!!");
			}else {
				System.out.println("실패ㅠ");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
	}
}
