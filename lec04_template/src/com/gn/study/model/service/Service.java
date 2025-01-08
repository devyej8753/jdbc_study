package com.gn.study.model.service;

import static com.gn.study.common.JDBCTemplate.close;
import static com.gn.study.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.gn.study.model.dao.Dao;
import com.gn.study.model.vo.Car;

// DB에 접속 -> Connection 객체 생성
public class Service {
	private Dao dao = new Dao();
	
	public int updateCarOne(int carNo,String carName ,int carPrice ,String carDate) {
		Connection conn = getConnection();
		int result = dao.updateCarOne(carNo,carName,carPrice,carDate,conn);
		close(conn);
		return result;
	}
	
	public int deleteCarOne(int carNo) {
		Connection conn = getConnection();
		int result = dao.deleteCarOne(carNo,conn);
		close(conn);
		return result;
	}
	
	public List<Car> selectCarDate(String carDate){
		Connection conn = getConnection();
		List<Car> list = dao.selectCarDate(carDate,conn);
		close(conn);
		return list;
	}
	
	public List<Car> selectCarPrice(int carPrice){
		Connection conn = getConnection();
		List<Car> list = dao.selectCarPrice(carPrice,conn);
		close(conn);
		return list;
	}
	
	public List<Car> selectCarNo(int carNo){
		Connection conn = getConnection();
		List<Car> list = dao.selectCarNo(carNo,conn);
		close(conn);
		return list;
	}
	
	public List<Car> selectCarModel(String carName){
		Connection conn = getConnection();
		List<Car> list = dao.selectCarModel(carName,conn);
		close(conn);
		return list;
	}
	public List<Car> selectCarAll(){
		Connection conn = getConnection();
		List<Car> list = dao.selectCarAll(conn);
		close(conn);
		return list;
	}
	
	
	public int insertCarOne(Car car) {
		Connection conn = getConnection();
		int result = dao.insertCarOne(car, conn);
		close(conn);
		return result;
		
//		Connection conn = null;
//		int result = 0;
//		try {
//			Class.forName("org.mariadb.jdbc.Driver");
//			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
//			String user = "scott";
//			String pw = "tiger";
//			conn = DriverManager.getConnection(url,user,pw);
//			result = dao.insertCarOne(car,conn);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(conn != null) conn.close();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return result;
	}
	
}
