package com.jpm.entity;

import java.math.BigDecimal;

public class SaleRecord {
	private String productType;
	private BigDecimal productPrice;
	private int quantity = 1;
	
	public SaleRecord(String _productType, BigDecimal _productPrice){
		this.productType = _productType;
		this.productPrice = _productPrice;
	}

	public SaleRecord(String _productType, BigDecimal _productPrice, int _quantity){
		this(_productType,_productPrice);
		this.quantity = _quantity;
	}

	public String toString(){
		return "ProductType:-> " + productType + " :: ProductPrice:-> "+ productPrice + " :: Quantity:-> " + quantity;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
