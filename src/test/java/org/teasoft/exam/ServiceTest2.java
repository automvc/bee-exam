/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam;

import org.junit.Assert;
import org.junit.Test;
import org.teasoft.bee.osql.api.Suid;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.osql.ConditionExam;
import org.teasoft.exam.bee.osql.DynamicTableExam;
import org.teasoft.exam.bee.osql.InsertAndReturnIdTest;
import org.teasoft.exam.bee.osql.InsertTest;
import org.teasoft.exam.bee.osql.ObjSQLServiceExam;
import org.teasoft.exam.bee.osql.SelectById;
import org.teasoft.exam.bee.osql.SuidExam;
import org.teasoft.exam.bee.osql.SuidRichExam;
import org.teasoft.exam.bee.osql.UpdateByExam;
import org.teasoft.exam.bee.osql.UpdateSetExam;
import org.teasoft.exam.bee.osql.annotation.DatetimeExam;
import org.teasoft.exam.bee.osql.annotation.DatetimeExam2;
import org.teasoft.exam.bee.osql.ds.DiffDdExamCustomerSql;
import org.teasoft.exam.bee.osql.ds.SuidWhichOne;
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.core.HoneyContext;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.serviceimpl.ObjSQLRichServiceImpl;
import org.teasoft.honey.osql.serviceimpl.ObjSQLServiceImpl;

/**
 * @author Kingstar
 * @since  1.9
 */
public class ServiceTest2 {
	@Test
	public void test() {
		
		//Mongodb执行后,重新设置成mysql
		HoneyConfig config=HoneyConfig.getHoneyConfig();
		config.setUrl("jdbc:mysql://127.0.0.1:3306/bee?characterEncoding=UTF-8&useAffectedRows=true&useSSL=false");
		config.setUsername("root");
		config.setPassword("123456");
		HoneyContext.setConfigRefresh(true);

		boolean result = false;
		try {
			System.out.println("================ServiceTest==========start====");
			SuidExam.setSuid(new ObjSQLServiceImpl());
			SuidExam.test();
			System.out.println("================ServiceTest============SuidExam finished==");
			
			try {
				SuidRichExam.setSuidRich(new ObjSQLRichServiceImpl());
				SuidRichExam.test();
			} catch (Exception e) {
				e.printStackTrace();
				Logger.error(e.getMessage(), e);
			}
			
			ConditionExam.setSuidRich(new ObjSQLRichServiceImpl());
			ConditionExam.test();
			
			InsertTest.setSuidRich(new ObjSQLRichServiceImpl());
			InsertTest.test();
			
			SelectById.setSuidRich(new ObjSQLRichServiceImpl());
			SelectById.test();
			
			UpdateByExam.setSuidRich(new ObjSQLRichServiceImpl());
			UpdateByExam.test();
			
			UpdateSetExam.setSuidRich(new ObjSQLRichServiceImpl());
			UpdateSetExam.test();
			
			DynamicTableExam.setSuid(new ObjSQLServiceImpl());
			DynamicTableExam.test();
			
			SuidRich suidRichService=new ObjSQLRichServiceImpl();
			suidRichService.setDynamicParameter("month", "_202007");
//			DynamicTableExam.setSuid(new ObjSQLServiceImpl());
			DynamicTableExam.setSuid(suidRichService);
			DynamicTableExam.test();
			
			InsertAndReturnIdTest.setSuid(new ObjSQLServiceImpl());
			InsertAndReturnIdTest.test();
			InsertAndReturnIdTest.test();
			InsertAndReturnIdTest.setSuidRich(new ObjSQLRichServiceImpl());
			InsertAndReturnIdTest.test();
			
			ObjSQLServiceExam.test();
//			
			DiffDdExamCustomerSql.setSuidRich(new ObjSQLRichServiceImpl());
			DiffDdExamCustomerSql.test();
			
			Suid suidService=new ObjSQLServiceImpl();
			suidService.setDataSourceName("ds3-test");
//			SuidWhichOne.setSuid(new ObjSQLServiceImpl());
			SuidWhichOne.setSuid(suidService);
			SuidWhichOne.test();
			
			DatetimeExam.test();
			DatetimeExam2.test();
			
			System.out.println("================ServiceTest==========end====");

			result = true;
		} catch (Exception e) {
			result = false;
		} finally {
			Assert.assertEquals(result, true);
		}

	}
}
