package com.gn.homework.model.vo;

public class Product {
	private int productNO;
	private String productName;
	private int productPrice;
	private int productAmount;
	
	public Product() {}

	public Product(int productNO, String productName, int productPrice, int productAmount) {
		super();
		this.productNO = productNO;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productAmount = productAmount;
	}

	public int getProductNO() {
		return productNO;
	}

	public void setProductNO(int productNO) {
		this.productNO = productNO;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}

	@Override
	public String toString() {
		return "[제품번호 = " + productNO + ", 제품이름 = " + productName + ", 제품가격 = " + productPrice
				+ ", 제품총량 = " + productAmount + "]";
	}
	
	
}
