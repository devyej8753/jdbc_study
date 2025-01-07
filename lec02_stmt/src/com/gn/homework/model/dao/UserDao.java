package com.gn.homework.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.gn.homework.model.vo.User;

public class UserDao {
	
	public int insertUser(User u) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/watermelon_music";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			stmt = conn.createStatement();
			String sql = "INSERT INTO wm_user (user_id ,user_pw , user_name)"
					+ "VALUES ('"+u.getUserId()+"','"+u.getUserPw()+"','"+u.getUserName()+"')";
			result = stmt.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	// 로그인
	public User login(String userId , String userPw) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		User u = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/watermelon_music";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * "
					+ "FROM wm_user "
					+ "WHERE user_id = '"+userId+"' "
					+ "AND user_pw = '"+userPw+"' ");
			if(rs.next()) {
				u = new User();
				u.setUserNo(rs.getInt("user_no"));
				u.setUserId(rs.getString("user_id"));
				u.setUserPw(rs.getString("user_pw"));
				u.setUserName(rs.getString("user_name"));
				u.setRegDate(rs.getTimestamp("reg_date").toLocalDateTime());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return u;
	}
	
	
}
