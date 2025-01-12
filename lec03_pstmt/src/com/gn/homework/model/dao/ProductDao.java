package com.gn.homework.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gn.homework.model.vo.Product;
import com.gn.study.model.vo.ProjectVo;

public class ProductDao {
	
	public int insertProduct(Product p) {
		Connection conn = null;
		Statement  stmt = null;
		int result = 0;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/super_market";
			String id = "scott";
			String pw = "tiger";
			
			conn = DriverManager.getConnection(url,id,pw);
			stmt = conn.createStatement();
			
			String sql = "INSERT INTO sm_product (product_name,product_price,product_amount) "
					+ "VALUES ('"+p.getProductName()+"','"+p.getProductPrice()+"','"+p.getProductAmount()+"') ";
			result = stmt.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(stmt != null)stmt.close();
				if(conn != null)conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public List<Product> selectProductAll(){
		Connection conn = null;
		Statement  stmt = null;
		ResultSet rs = null;
		List<Product> list = new ArrayList<Product>();
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/super_market";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			stmt = conn.createStatement();
			String sql = "SELECT * "
						+ "FROM sm_product";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Product p = new Product();
				p.setProductNO(rs.getInt("product_no"));
				p.setProductName(rs.getString("product_name"));
				p.setProductPrice(rs.getInt("product_price"));
				p.setProductAmount(rs.getInt("product_amount"));
				list.add(p);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public int updateProductOne(Product p) {
		Connection conn = null;
		Statement stmt = null; stmt = null;
		int result = 0;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/super_market";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			stmt = conn.createStatement();
			String sql = "UPDATE sm_product SET product_amount = (product_amount + "+p.getProductAmount()+")"
					+ "WHERE product_no = "+p.getProductNO()+"";
			result = stmt.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
}
