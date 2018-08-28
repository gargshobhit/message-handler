package com.jpm.entity;

import java.math.BigDecimal;

public class AdjustmentRecord {
	private String productType;
	private BigDecimal totalPriceBeforeAdj;
	private BigDecimal totalPriceAfterAdj;
	private String adjOperation;
	private int adjQty;
	private BigDecimal adjPrice;
	
	public AdjustmentRecord(String _productType, BigDecimal _priceBeforeAdj, BigDecimal _priceAfterAdj, String _adjOperation, int _qty, BigDecimal _adjPrice){
		this.productType = _productType;
		this.totalPriceBeforeAdj = _priceBeforeAdj;
		this.totalPriceAfterAdj = _priceAfterAdj;
		this.adjOperation = _adjOperation;
		this.adjQty = _qty;
		this.adjPrice = _adjPrice;
	}
	
	public AdjustmentRecord(String _productType, BigDecimal _adjPrice, String _adjOperation, int _qty){
		this.productType = _productType;
		this.adjPrice = _adjPrice;
		this.adjOperation = _adjOperation;
		this.adjQty = _qty;
	}
	
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public BigDecimal getTotalProductPriceBeforeAdj() {
		return totalPriceBeforeAdj;
	}
	public void setTotalProductPriceBeforeAdj(BigDecimal totalProductPriceBeforeAdj) {
		this.totalPriceBeforeAdj = totalProductPriceBeforeAdj;
	}
	public BigDecimal getTotalProductPriceAfterAdj() {
		return totalPriceAfterAdj;
	}
	public void setTotalProductPriceAfterAdj(BigDecimal totalProductPriceAfterAdj) {
		this.totalPriceAfterAdj = totalProductPriceAfterAdj;
	}
	public String getAdjOperation() {
		return adjOperation;
	}
	public void setAdjOperation(String adjOperation) {
		this.adjOperation = adjOperation;
	}
	public int getAdjQty() {
		return adjQty;
	}
	public void setAdjQty(int adjQty) {
		this.adjQty = adjQty;
	}
	public BigDecimal getAdjPrice() {
		return adjPrice;
	}

	public void setAdjPrice(BigDecimal adjPrice) {
		this.adjPrice = adjPrice;
	}	
	
	public String toString(){
		return "\t" + productType + "\t\t" + totalPriceBeforeAdj + "\t\t" + totalPriceAfterAdj + "\t\t" + adjQty + "\t" + adjOperation + "\t\t"+adjPrice;
	}
}
