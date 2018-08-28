package com.jpm.message.handler;

import java.util.*;
import java.math.BigDecimal;

import com.jpm.bean.Message;
import com.jpm.bean.MessageType;
import com.jpm.bean.ProductSaleDetails;
import com.jpm.entity.AdjustmentRecord;
import com.jpm.service.ServiceManager;


public class App 
{
	static List<Message> messagesToProcess = new ArrayList<Message>();
	
    public static void main( String[] args )
    {
        loadData();
        int count = 0;
        for (Message message:messagesToProcess ){
        	ServiceManager.handleMessage(message);
        	if (++count % 10 == 0)
        		printTotalSaleForEachProduct();
        	
        	if (count % 50 == 0)
        		printAdjustmentDetails();
        }
       
    }
    
    private static void printTotalSaleForEachProduct() {

    	Map<String, ProductSaleDetails> allProductSales = ServiceManager.calculateAllProductSales();
		System.out.println("ProductType		TotalValue		TotalQuantity");
		for (String productType: allProductSales.keySet()) {
			System.out.print(productType);
			System.out.println(allProductSales.get(productType));
		}
		System.out.println("\n");

    }
    
    private static void printAdjustmentDetails() {
    	
    	System.out.println("#########   ADJUSTMENT REPORT   ###########");
		System.out.println("ProductType\tPriceBeforeAdj\tPriceAftereAdj\tTotalQuantity\tAdjOperation\t\tAdjPrice");
		List<AdjustmentRecord> adjRecordList = ServiceManager.getAllAdjustmentRecords();
		
		for(AdjustmentRecord adj:adjRecordList){
			System.out.println(adj);
		}
		
		
		System.out.println("\n");
		System.out.println("\n");

    }
    
    private static void loadData(){
    	
    		messagesToProcess.add(new Message("Apple", BigDecimal.valueOf(10.00)));
    		messagesToProcess.add(new Message("Apple", BigDecimal.valueOf(11.00), 5));
    		messagesToProcess.add(new Message("Apple", BigDecimal.valueOf(2.00), MessageType.ADJUSTMENT_ADD));
    		
    		messagesToProcess.add(new Message("Grapes", BigDecimal.valueOf(12.00)));
    		messagesToProcess.add(new Message("Grapes", BigDecimal.valueOf(13.00), 3));
    		messagesToProcess.add(new Message("Grapes", BigDecimal.valueOf(3.50),MessageType.ADJUSTMENT_SUB));

    		messagesToProcess.add(new Message("Orange", BigDecimal.valueOf(12.00)));
    		messagesToProcess.add(new Message("Orange", BigDecimal.valueOf(12.50), 4));
    		messagesToProcess.add(new Message("Orange", BigDecimal.valueOf(3.00)));
    		
    		messagesToProcess.add(new Message("Apple", BigDecimal.valueOf(8.00)));
    		messagesToProcess.add(new Message("Apple", BigDecimal.valueOf(8.00), 2));
    		messagesToProcess.add(new Message("Apple", BigDecimal.valueOf(1.50),MessageType.ADJUSTMENT_SUB));

    		messagesToProcess.add(new Message("Grapes", BigDecimal.valueOf(13.00)));
    		messagesToProcess.add(new Message("Grapes", BigDecimal.valueOf(14.00), 3));
    		messagesToProcess.add(new Message("Grapes", BigDecimal.valueOf(2.00),MessageType.ADJUSTMENT_ADD));

    		messagesToProcess.add(new Message("Orange", BigDecimal.valueOf(7.00)));
    		messagesToProcess.add(new Message("Orange", BigDecimal.valueOf(7.50), 3));
    		messagesToProcess.add(new Message("Orange", BigDecimal.valueOf(2.00), MessageType.ADJUSTMENT_SUB));

    		messagesToProcess.add(new Message("Apple", BigDecimal.valueOf(10.00)));
    		messagesToProcess.add(new Message("Apple", BigDecimal.valueOf(11.00), 5));
    		messagesToProcess.add(new Message("Apple", BigDecimal.valueOf(2.00),MessageType.ADJUSTMENT_ADD));
    		
    		messagesToProcess.add(new Message("Grapes", BigDecimal.valueOf(12.00)));
    		messagesToProcess.add(new Message("Grapes", BigDecimal.valueOf(13.00), 3));
    		messagesToProcess.add(new Message("Grapes", BigDecimal.valueOf(3.50),MessageType.ADJUSTMENT_SUB));

    		messagesToProcess.add(new Message("Orange", BigDecimal.valueOf(12.00)));
    		messagesToProcess.add(new Message("Orange", BigDecimal.valueOf(12.50), 4));
    		messagesToProcess.add(new Message("Orange", BigDecimal.valueOf(3.00), MessageType.ADJUSTMENT_MUL));
    		
    		messagesToProcess.add(new Message("Apple", BigDecimal.valueOf(8.00)));
    		messagesToProcess.add(new Message("Apple", BigDecimal.valueOf(8.00), 2));
    		messagesToProcess.add(new Message("Apple", BigDecimal.valueOf(1.50),MessageType.ADJUSTMENT_SUB));

    		messagesToProcess.add(new Message("Grapes", BigDecimal.valueOf(13.00)));
    		messagesToProcess.add(new Message("Grapes", BigDecimal.valueOf(14.00), 3));
    		messagesToProcess.add(new Message("Grapes", BigDecimal.valueOf(2.00),MessageType.ADJUSTMENT_ADD));

    		messagesToProcess.add(new Message("Orange", BigDecimal.valueOf(7.00)));
    		messagesToProcess.add(new Message("Orange", BigDecimal.valueOf(7.50), 3));
    		messagesToProcess.add(new Message("Orange", BigDecimal.valueOf(2.00), MessageType.ADJUSTMENT_SUB));

    		messagesToProcess.add(new Message("Apple", BigDecimal.valueOf(10.00)));
    		messagesToProcess.add(new Message("Apple", BigDecimal.valueOf(11.00), 5));
    		messagesToProcess.add(new Message("Apple", BigDecimal.valueOf(2.00),MessageType.ADJUSTMENT_ADD));
    		
    		messagesToProcess.add(new Message("Grapes", BigDecimal.valueOf(12.00)));
    		messagesToProcess.add(new Message("Grapes", BigDecimal.valueOf(13.00), 3));
    		messagesToProcess.add(new Message("Grapes", BigDecimal.valueOf(3.50),MessageType.ADJUSTMENT_SUB));

    		messagesToProcess.add(new Message("Orange", BigDecimal.valueOf(12.00)));
    		messagesToProcess.add(new Message("Orange", BigDecimal.valueOf(12.50), 4));
    		messagesToProcess.add(new Message("Orange", BigDecimal.valueOf(3.00), MessageType.ADJUSTMENT_MUL));
    		
    		messagesToProcess.add(new Message("Apple", BigDecimal.valueOf(8.00)));
    		messagesToProcess.add(new Message("Apple", BigDecimal.valueOf(8.00), 2));
    		messagesToProcess.add(new Message("Apple", BigDecimal.valueOf(1.50),MessageType.ADJUSTMENT_SUB));

    		messagesToProcess.add(new Message("Grapes", BigDecimal.valueOf(13.00)));
    		messagesToProcess.add(new Message("Grapes", BigDecimal.valueOf(14.00), 3));
    		messagesToProcess.add(new Message("Grapes", BigDecimal.valueOf(2.00),MessageType.ADJUSTMENT_ADD));

    		messagesToProcess.add(new Message("Orange", BigDecimal.valueOf(7.00)));
    		messagesToProcess.add(new Message("Orange", BigDecimal.valueOf(7.50), 3));
    		messagesToProcess.add(new Message("Orange", BigDecimal.valueOf(2.00), MessageType.ADJUSTMENT_SUB));
    	
    }
}
