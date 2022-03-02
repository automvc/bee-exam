package org.teasoft.exam.beex.poi;
/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

import java.util.List;

import org.junit.Test;
import org.teasoft.beex.poi.ExcelReader;

/**
 * @author Kingstar
 * @since  1.9
 */

public class ExcelReaderTest {
	
	@Test
	public void test() throws Exception{
		try {
			

		System.out.println("================ExcelReaderTest==========start====");
		
		String fullPath = "D:\\test2.xlsx";
//		String fullPath = "D:\\test-dataType.xlsx";
		String[] checkTitles= {"序号","班级","姓名","离深时间	","目的地","离深交通工具","返深时间","返深交通工具","家长联系电话"};
//		String[] checkTitles= {"序号1","班级","姓名2","离深时间	","目的地","离深交通工具","返深时间","返深交通工具","家长联系电话"};
//		String[] checkTitles= {"序号","班级","姓名","离深时间	","目的地","离深交通工具","返深时间","返深交通工具"};
		List<String[]> list0 = ExcelReader.checkAndReadExcel(fullPath,checkTitles,1);
		
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
		
		list = ExcelReader.readExcel(fullPath,"Sheet1");
		
		} catch (Exception e) {
            e.printStackTrace();
		}
		
		System.out.println("================ExcelReaderTest==========end====");
	}

}
