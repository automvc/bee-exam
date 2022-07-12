package org.teasoft.exam.beex.poi;
/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

import java.util.List;

import org.junit.Test;
import org.teasoft.beex.autogen.DdlViaExcel;
import org.teasoft.beex.poi.ExcelReader;

/**
 * @author Kingstar
 * @since  1.9
 */

public class ExcelReader_Create_Table_Test {
	
	@Test
	public void test() throws Exception{
		try {
			

		System.out.println("================ExcelReaderTest==========start====");
		
//		String fullPath = "D:\\bee-test\\数据表-test.xlsx";
		
		String baseDir=System.getProperty("user.dir")+"\\src\\main\\resources\\excel\\";
		String fullPath =baseDir+"数据表-test.xlsx";
		
		String[] checkTitles= {"字段名","类型","中文注解","英文注解"};
//		String[] checkTitles= {"序号1","班级","姓名2","离深时间	","目的地","离深交通工具","返深时间","返深交通工具","家长联系电话"};
//		String[] checkTitles= {"序号","班级","姓名","离深时间	","目的地","离深交通工具","返深时间","返深交通工具"};
		List<String[]> list0 = ExcelReader.checkAndReadExcel(fullPath,checkTitles,0);
		
		List<String[]> list = ExcelReader.readExcel(fullPath);
		String col[] = null;
		for (int i = 0; list!=null && i < list.size(); i++) {
			col = list.get(i);
			
			for (int j = 0; j < col.length; j++) {
				System.out.print(col[j] + "   ");
//				Logger.info(col[j] + "   ");
			}
//			Logger.info(col.length);
//			Logger.info("");
			System.out.println();
		}
		
		ExcelReader.checkAndReadExcel(fullPath,checkTitles);
		ExcelReader.checkAndReadExcel(fullPath,"字段名,类型,中文注解,英文注解",0);
		
		list = ExcelReader.readExcel(fullPath,"Sheet1");
		list = ExcelReader.readExcel(fullPath,"Sheet1",0,2);
		
		ExcelReader.readExcel(fullPath,0,2);
		
		
		System.out.println("===============-----------------------");
		
		ExcelReader.checkAndReadExcel(fullPath,"字段名,类型,中文注解,英文注解",0); //默认是检测第一个sheet的
//		list = ExcelReader.readExcel(fullPath,"stock-库存");
//		list = ExcelReader.readExcel(fullPath,"customs_list-报关清单",1,-1); // by sheet name
		
		ExcelReader.checkAndReadExcel(fullPath,2,"字段名,类型,中文注解,英文注解",0);  //check sheet 2
		list = ExcelReader.readExcel(fullPath,0,1,-1); // by sheet index
		String create_sql0=DdlViaExcel.toCreateTableSQLForMySQL(list, "customs_list");
		System.out.println(create_sql0);
		
		
		} catch (Exception e) {
	        e.printStackTrace();
		}
		
		System.out.println("================ExcelReaderTest==========end====");
	}

}
