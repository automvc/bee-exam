/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.prod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.teasoft.bee.osql.api.Suid;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.prod.entity.Student18;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.interccept.annotation.DictI18nDefaultHandler;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  1.9
 */
public class DictI18nExam {
	private static SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
	static {
//		InitDsUtil.initDS();
	}
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
//		HoneyConfig.getHoneyConfig().multiDS_enable = true; //使用多数据源  多个数据源时必须设置
//		HoneyConfig.getHoneyConfig().multiDS_differentDbType=true;  //同时要使用多种数据库,一定要设置
//		HoneyContext.setConfigRefresh(true); 
		
//		suidRich.getInterceptorChain().addInterceptor(new MyAnnotationInterceptor());
//		suidRich.getInterceptorChain().addInterceptor(new CustomInterceptor());
		
		
		DictI18nDefaultHandler.setDictMap(getDictI18nFromDB());
		
		
		suidRich.setDataSourceName("ds1");
		Student18 student18=new Student18();
		List list=suidRich.select(student18,10);
//		List list=suidRich.select(student18,1,10);
//		List list=suidRich.select(student18);
		Printer.printList(list);
		
		}
	
	
	private static Map<String, Map> getDictI18nFromDB() {
		Suid suid=BF.getSuid();
		DictI18n dict=null;
		Map<String, Map> langMap=new HashMap<>();
		Map<String, Map> tableColumn=null;//=new HashMap<>();
		Map<String, String> pairMap =null;// new HashMap<>();
//		 langMap.put("CN", tableColumn);
		List<DictI18n> list=suid.select(new DictI18n());
		for (int i = 0; i < list.size(); i++) {
			dict=list.get(i);
			String pairKey=dict.getTableName().toLowerCase()+":"+dict.getColName().toLowerCase();  //不区分大小写
			
			tableColumn=langMap.get(dict.getLang());
			if(tableColumn==null) {
				pairMap = new HashMap<>();
				pairMap.put(dict.getKey1(), dict.getValue1());
				tableColumn=new HashMap<>();
				tableColumn.put(pairKey, pairMap);
				langMap.put(dict.getLang(), tableColumn);
			}else {
				pairMap=tableColumn.get(pairKey);
				if(pairMap!=null) {
					pairMap.put(dict.getKey1(), dict.getValue1());
				}else {
					pairMap = new HashMap<>();
					pairMap.put(dict.getKey1(), dict.getValue1());
					tableColumn.put(pairKey, pairMap);
				}
			}
		}
		return langMap;
	}
	
	
	

}
