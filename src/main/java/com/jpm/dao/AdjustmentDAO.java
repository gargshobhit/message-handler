package com.jpm.dao;

import java.util.ArrayList;
import java.util.List;

import com.jpm.entity.AdjustmentRecord;

/*
 * This class will record all the adjustment records  
 * 
 */
public class AdjustmentDAO {

	private static List<AdjustmentRecord> adjRecords = new ArrayList<>();
	
	public static void insertAdjustmentRecord(AdjustmentRecord adjRec){
		adjRecords.add(adjRec);
		
	}
	
	public static List<AdjustmentRecord> getAllAdjustmentRecords(){
		return adjRecords;
	}
}
