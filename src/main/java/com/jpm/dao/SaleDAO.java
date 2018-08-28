package com.jpm.dao;

import java.util.*;
import com.jpm.entity.SaleRecord;
import java.math.BigDecimal;  

public class SaleDAO {
	
	
	//private static List<SaleRecord> saleRecords = new ArrayList<SaleRecord>();
	private static Map<String, List<SaleRecord>> saleRecords = new HashMap<>();
	
	public static void insertSaleRecord(String productType, BigDecimal productPrice, int qty){
		List<SaleRecord> saleRecordsForProduct = saleRecords.get(productType);
		if(saleRecordsForProduct == null)
			saleRecordsForProduct = new ArrayList<SaleRecord>();
		
		saleRecordsForProduct.add(new SaleRecord(productType, productPrice, qty));
		saleRecords.put(productType, saleRecordsForProduct);
	}
	
	public static List<SaleRecord> getSaleRecords(String productType){
		return saleRecords.get(productType);
	}
	
	public static Set<String> getProductTypes(){
		return saleRecords.keySet();
	}
}
