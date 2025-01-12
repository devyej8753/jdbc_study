package com.gn.homework.controller;

import java.util.List;

import com.gn.homework.model.dao.ProductDao;
import com.gn.homework.model.vo.Product;
import com.gn.study.model.vo.ProjectVo;

public class ProductController {
	private ProductDao pd = new ProductDao(); 
	
	public int insertProduct(String pdName,int pdPrice,int pdAmount) {
		Product p = new Product();;
		p.setProductName(pdName);
		p.setProductPrice(pdPrice);
		p.setProductAmount(pdAmount);
		int result = pd.insertProduct(p);
		if(result > 0){
			System.out.println(pdName+" 제품이 등록되었습니다.");
		}else {
			System.out.println("제품등록중 문제가 발생하였습니다.");
		}
		return result;
	}
	public List<Product> selectProductAll(){
		List<Product> list = pd.selectProductAll();
		return list;
	}
	public int updateProductOne(int pdNo, int pdAmount) {
		Product p = new Product();
		p.setProductNO(pdNo);
		p.setProductAmount(pdAmount);
		int result = pd.updateProductOne(p);
		if(result > 0) {
			System.out.println("제품이 정상 입고되었습니다.");
		}else {
			System.out.println("제품 입고 처리중 오류가 발생하였습니다.");
		}
		return result;
		
	}
}
