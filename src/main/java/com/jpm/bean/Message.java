package com.jpm.bean;

import java.math.BigDecimal;

public class Message {
	
	String productType;
	BigDecimal productPrice;
	int quantity = 1;
	MessageType messageType = MessageType.SALE;
	

	public Message(String _productType, BigDecimal _productPrice){
		this.productType = _productType;
		this.productPrice = _productPrice;
	}

	public Message(String _productType, BigDecimal _productPrice, int _quantity){
		this(_productType, _productPrice);
		this.quantity = _quantity;
	}
	
	public Message(String _productType, BigDecimal _productPrice, MessageType _messageType ){
		this(_productType, _productPrice);
		this.messageType = _messageType;
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
	public MessageType getMessageType() {
		return messageType;
	}
	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
