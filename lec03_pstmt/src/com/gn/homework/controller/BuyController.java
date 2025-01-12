package com.gn.homework.controller;

import java.util.ArrayList;
import java.util.List;

import com.gn.homework.model.dao.BuyDao;
import com.gn.homework.model.vo.Buy;

public class BuyController {
	
	public void selectBuyListAll() {
		List<Buy> resultList = new ArrayList();
		resultList = new BuyDao().selectBuyListAll();
		if(resultList.isEmpty()) {
			System.out.println("조회된 결과가 없습니다.");
		}else {
			for(Buy b : resultList) {
				System.out.println(b);
			}
		}
	}
}
