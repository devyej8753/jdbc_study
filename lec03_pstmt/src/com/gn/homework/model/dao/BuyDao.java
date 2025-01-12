package com.gn.homework.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gn.homework.model.vo.Buy;

public class BuyDao {
	
	public List<Buy> selectBuyListAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Buy> resultList = new ArrayList<Buy>();
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/super_market";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			stmt = conn.createStatement();
			
			String sql = "SELECT u.user_name ,p.product_name ,b.buy_amount "
					+ "FROM sm_buy b "
					+ "JOIN sm_user u ON b.user_no = u.user_no "
					+ "JOIN sm_product p ON b.product_no = p.product_no ";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Buy b = new Buy(rs.getString(1),rs.getString(2),rs.getInt(3));
				resultList.add(b);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)rs.close();
				if(stmt != null)stmt.close();
				if(conn != null)conn.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return resultList;
	}
}
