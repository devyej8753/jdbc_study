package com.gn.study.controller;

import java.util.List;

import com.gn.study.model.service.Service;
import com.gn.study.model.vo.Car;

// View로부터 전달받은 데이터 가공 -> Service 전달
public class Controller {
	private Service service = new Service();
	
	public int updateCarOne(int carNo ,String carName ,int carPrice ,String carDate) {
		return service.updateCarOne(carNo,carName,carPrice,carDate);
	}
	
	public int deleteCarOne(int carNo) {
		return service.deleteCarOne(carNo);
	}
	
	public List<Car> selectCarDate(String carDate){
		return service.selectCarDate(carDate);
	}
	
	public List<Car> selectCarPrice(int carPrice){
		return service.selectCarPrice(carPrice);
	}
	
	public List<Car> selectCarNo(int carNo){
		return service.selectCarNo(carNo);
	}
	
	public List<Car> selectCarModel(String carName){
		return service.selectCarModel(carName);
	}
	
	public List<Car> selectCarAll(){
		return service.selectCarAll();
	}
	
	
	public int insertCarOne(String modelName, int price ,String date) {
		Car car = new Car(modelName,price,date);
		int result = service.insertCarOne(car);
		return result;
	
	}
}
