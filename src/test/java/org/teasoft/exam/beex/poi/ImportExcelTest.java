/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.beex.poi;

import java.util.List;

import org.junit.Test;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.beex.poi.ExcelReader;
import org.teasoft.exam.beex.poi.entity.LeftszInfo;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.util.SuidHelper;

/**
 * @author Kingstar
 * @since  1.9
 */
public class ImportExcelTest {
	
	@Test	
	public void test() throws Exception{
		String fullPath = "D:\\test.xlsx";
		String[] checkTitles = { "序号", "班级", "姓名", "离深时间	", "目的地", "离深交通工具", "返深时间", "返深交通工具", "家长联系电话" };
		List<String[]> list = ExcelReader.checkAndReadExcel(fullPath, checkTitles, 1); //标题在第1行.(从0开始的.)
		String fieldNames = "orderno,,name,leftdate,target,vehicle1,comedate,vehicle2,mobileno"; //每列对应的字段名
		if (list != null) {
			List<LeftszInfo> listLeftszInfo = SuidHelper.parseToEntity(list, 2, list.size() - 2, fieldNames, new LeftszInfo());
			SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
			suidRich.insert(listLeftszInfo);
		}
	}

}
