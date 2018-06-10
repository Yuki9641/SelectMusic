package org.yyama.Common;

import java.util.LinkedHashMap;
import java.util.Map;

public class Common {
	
	public static Map<String,String> getSelectedCategoryItems(){
	     Map<String, String> selectCategoryMap = new LinkedHashMap<String, String>();
	     selectCategoryMap.put("1", "J-POP");
	     selectCategoryMap.put("2", "洋楽");
	     selectCategoryMap.put("3", "演歌");
	     selectCategoryMap.put("4", "アニメ");
	     selectCategoryMap.put("5", "ボカロ");
	     return selectCategoryMap;
	 } 
	
	public static Map<String, String> getSelectedLimit() {
		Map<String, String> selectLimitMap = new LinkedHashMap<String, String>();
		
		selectLimitMap.put("1", "1");
		selectLimitMap.put("2", "2");
		selectLimitMap.put("3", "3");
		selectLimitMap.put("4", "4");
		selectLimitMap.put("5", "5");
		selectLimitMap.put("6", "6");
		selectLimitMap.put("7", "7");
		selectLimitMap.put("8", "8");
		selectLimitMap.put("9", "9");
		selectLimitMap.put("10", "10");
		
		return selectLimitMap;
	}

}
