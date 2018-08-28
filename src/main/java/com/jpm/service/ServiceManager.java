package com.jpm.service;

import com.jpm.bean.Message;
import com.jpm.bean.MessageType;
import com.jpm.bean.ProductSaleDetails;
import com.jpm.dao.AdjustmentDAO;
import com.jpm.dao.SaleDAO;
import com.jpm.entity.AdjustmentRecord;
import com.jpm.entity.SaleRecord;

import java.math.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ServiceManager {
	
	public static void handleMessage(Message message){
		if(MessageType.SALE.equals(message.getMessageType()))
			processSaleMessage(message);
		else
			processAdjustmentMessage(message);

	}
	
	private static void processSaleMessage(Message message){
		SaleDAO.insertSaleRecord(message.getProductType(), message.getProductPrice(), message.getQuantity());
	}
	
	private static void processAdjustmentMessage(Message message){
		
		AdjustmentDAO.insertAdjustmentRecord(calculateAdjustmentForEachSale(message));
	}
	
	private static AdjustmentRecord calculateAdjustmentForEachSale(Message message){
		
		List<SaleRecord> saleRecords = SaleDAO.getSaleRecords(message.getProductType());
		BigDecimal totalPriceBeforeAdj = BigDecimal.ZERO;
		BigDecimal totalPriceAfterAdj = BigDecimal.ZERO;
		int totalQty = 0;
		
		for (SaleRecord rec:saleRecords){
			totalPriceBeforeAdj  = totalPriceBeforeAdj.add(rec.getProductPrice().multiply(BigDecimal.valueOf(rec.getQuantity())));
			BigDecimal priceAfterAdjustment = BigDecimal.ZERO;
			switch (message.getMessageType()) {
				case ADJUSTMENT_ADD: priceAfterAdjustment = (rec.getProductPrice().add(message.getProductPrice())).multiply(BigDecimal.valueOf(rec.getQuantity()));break;
				case ADJUSTMENT_SUB: priceAfterAdjustment = (rec.getProductPrice().subtract(message.getProductPrice())).multiply(BigDecimal.valueOf(rec.getQuantity()));break;
				case ADJUSTMENT_MUL: priceAfterAdjustment = (rec.getProductPrice().multiply(message.getProductPrice())).multiply(BigDecimal.valueOf(rec.getQuantity()));break;
				default: System.out.println(" Not a vaild Message "); 
			}
			totalQty = totalQty + rec.getQuantity();
			totalPriceAfterAdj= totalPriceAfterAdj.add(priceAfterAdjustment);
		}
		return new AdjustmentRecord(message.getProductType(), totalPriceBeforeAdj, totalPriceAfterAdj, message.getMessageType().name(),totalQty,message.getProductPrice());
	}
	
	public static List<AdjustmentRecord> getAllAdjustmentRecords(){
		return AdjustmentDAO.getAllAdjustmentRecords();
	}
	
	public static Map<String, ProductSaleDetails> calculateAllProductSales(){
		Map<String, ProductSaleDetails> allProductSales = new HashMap<String, ProductSaleDetails>();
		Set<String> productTypeList = SaleDAO.getProductTypes();
		for(String pType : productTypeList){
			allProductSales.put(pType, getProductSaleByProductType(pType));
		}
		
		return allProductSales;
	}
	
	public static ProductSaleDetails getProductSaleByProductType(String productType){
		List<SaleRecord> saleRecordList = SaleDAO.getSaleRecords(productType);
		BigDecimal totalProductPrice = BigDecimal.ZERO;
		int totalQty = 0;
		for(SaleRecord rec: saleRecordList){
			totalProductPrice = totalProductPrice.add(rec.getProductPrice().multiply(BigDecimal.valueOf(rec.getQuantity())));
			totalQty = totalQty + rec.getQuantity();
		}
		
		return new ProductSaleDetails(totalProductPrice, totalQty);
	}
	
}
