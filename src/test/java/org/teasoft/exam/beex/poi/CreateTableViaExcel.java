/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.beex.poi;

import org.teasoft.beex.autogen.DdlViaExcel;

/**
 * @author Kingstar
 * @since  1.11
 */
public class CreateTableViaExcel {

	public static void main(String[] args) {
		String sheetName0 = "stock-库存"; //表名与中文名用"-"分开
//		String sheetName1 = "out_stock-出库";
//		String sheetName2 = "customs_list-报关清单";
//		String sheetNames[] = { sheetName0, sheetName1, sheetName2 };
		String sheetNames[] = { sheetName0};
		String checkTitle = "字段名,类型,中文注解,英文注解";

//		String excelFullPath = "D:\\bee-test\\数据表-test.xlsx";

		String baseDir=System.getProperty("user.dir")+"\\src\\main\\resources\\excel\\";
		String excelFullPath =baseDir+"数据表-test.xlsx";
		DdlViaExcel.createTable(excelFullPath, sheetNames, checkTitle,true);

	}

}
