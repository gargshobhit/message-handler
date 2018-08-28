package com.jpm.bean;

import java.math.BigDecimal;

public class ProductSaleDetails {
	int totalQtySold;
	BigDecimal totalProductSoldPrice;
	
	public ProductSaleDetails(BigDecimal _totalProductSoldPrice, int _totalQtySold){
		this.totalProductSoldPrice = _totalProductSoldPrice;
		this.totalQtySold = _totalQtySold;
	}
	public int getTotalQtySold() {
		return totalQtySold;
	}
	public void setTotalQtySold(int totalQtySold) {
		this.totalQtySold = totalQtySold;
	}
	public BigDecimal getTotalProductSoldPrice() {
		return totalProductSoldPrice;
	}
	public void setTotalProductSoldPrice(BigDecimal totalProductSoldPrice) {
		this.totalProductSoldPrice = totalProductSoldPrice;
	}
	
	public String toString(){
		return "\t\t\t"+totalProductSoldPrice + "\t\t\t" + totalQtySold;
	}
	
}
