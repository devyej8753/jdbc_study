package com.gn.homework.model.vo;

public class Buy {
	private String userId;
	private int productNo;
	private String userName;
	private String productName;
	private int buyAmount;
	
	public void Buy() {}

	public Buy(String userId, int productNo, String userName, String productName, int buyAmount) {
		super();
		this.userId = userId;
		this.productNo = productNo;
		this.userName = userName;
		this.productName = productName;
		this.buyAmount = buyAmount;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getBuyAmount() {
		return buyAmount;
	}

	public void setBuyAmount(int buyAmount) {
		this.buyAmount = buyAmount;
	}

	@Override
	public String toString() {
		return userName + " || " + productName + " || " + buyAmount;
	}
	
	
}
