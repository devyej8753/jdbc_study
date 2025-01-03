package com.gn.study.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gn.study.model.vo.Member;

public class MemberDao {
	
	public List<Member> memberIdSearch() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Member> list = new ArrayList<Member>();
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			stmt = conn.createStatement();
			
			String sql = ("SELECT * "
					+ "FROM member "
					+ "WHERE m_id =" );
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				Member m1 = new Member();
				m1.setMemberNo(rs.getInt(1));
				m1.setMemberId(rs.getString(2));
				m1.setMemberPw(rs.getString(3));
				m1.setMemberName(rs.getString(4));
				m1.setMemberEmail(rs.getNString(5));
				m1.setMemberPhone(rs.getString(6));
				m1.setMemberGender(rs.getString(7));
				m1.setRegDate(rs.getTimestamp(8).toLocalDateTime());
				m1.setModDate(rs.getTimestamp(9).toLocalDateTime());
				list.add(m1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public List<Member> selectMemberAll() {
		// 전체 member 정보 조회 -> List<Member>
		// DB에 SQL문 요청
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<Member> list = new ArrayList<Member>();
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM member");
			while(rs.next()){
				Member m = new Member();
				m.setMemberNo(rs.getInt(1));
				m.setMemberId(rs.getString(2));
				m.setMemberPw(rs.getString(3));
				m.setMemberName(rs.getString(4));
				m.setMemberEmail(rs.getNString(5));
				m.setMemberPhone(rs.getString(6));
				m.setMemberGender(rs.getString(7));
				m.setRegDate(rs.getTimestamp(8).toLocalDateTime());
				m.setModDate(rs.getTimestamp(9).toLocalDateTime());
				list.add(m);
			}
		}catch(Exception e){
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
		return list;
	}
	
	public int insertMember(Member m) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			stmt = conn.createStatement();
			String sql = "INSERT INTO member (m_id ,m_pw ,m_name ,m_email ,m_gender ,m_phone) "
					+ " VALUES ('"+m.getMemberId()+"','"+m.getMemberPw()+"','"
					+m.getMemberName()+"','"+m.getMemberEmail()+"','"
					+m.getMemberGender()+"','"+m.getMemberPhone()+"')";
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
	
}
