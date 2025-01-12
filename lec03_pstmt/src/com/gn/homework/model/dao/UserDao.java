package com.gn.homework.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.gn.homework.model.vo.User;

public class UserDao {

	public int userJoin(User u) {
		Connection conn = null;
		Statement  stmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/super_market";
			String id = "scott";
			String pw = "tiger";
			
			conn = DriverManager.getConnection(url,id,pw);
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			
			String sql = "SELECT COUNT(*) AS cnt "
					+ "FROM sm_user WHERE user_id = '"+u.getUserId()+"'";
			rs = stmt.executeQuery(sql);
			int cnt = 0;
			if(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			if(cnt == 0) {
				sql = "INSERT INTO sm_user (user_id,user_pw,user_name) "
						+ "VALUES ('"+u.getUserId()
						+"','"+u.getUserPw()+"','"+u.getUserName()+"')";
				result = stmt.executeUpdate(sql);	
			}else {
				System.out.println("중복되는 아이디가 있습니다.");
			}
			conn.commit();
		}catch(Exception e){
			try {
				conn.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null)stmt.close();
				if(conn != null)conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
