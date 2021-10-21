/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam;

import org.junit.Assert;
import org.junit.Test;
import org.teasoft.exam.bee.osql.ConditionExam;
import org.teasoft.exam.bee.osql.DynamicTableExam;
import org.teasoft.exam.bee.osql.InsertAndReturnIdTest;
import org.teasoft.exam.bee.osql.InsertTest;
import org.teasoft.exam.bee.osql.SelectById;
import org.teasoft.exam.bee.osql.SuidExam;
import org.teasoft.exam.bee.osql.SuidRichExam;
import org.teasoft.exam.bee.osql.UpdateByExam;
import org.teasoft.exam.bee.osql.UpdateSetExam;
import org.teasoft.honey.osql.serviceimpl.ObjSQLRichServiceImpl;
import org.teasoft.honey.osql.serviceimpl.ObjSQLServiceImpl;

/**
 * @author Kingstar
 * @since  1.9
 */
public class ServiceTest {
	@Test
	public void test() {

		boolean result = false;
		try {
			System.out.println("================ServiceTest==========start====");
			SuidExam.setSuid(new ObjSQLServiceImpl());
			SuidExam.test();
			System.out.println("================ServiceTest============SuidExam finished==");
			SuidRichExam.setSuidRich(new ObjSQLRichServiceImpl());
			SuidRichExam.test();
			
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
			
			DynamicTableExam.setSuidRich(new ObjSQLServiceImpl());
			DynamicTableExam.test();
			
			DynamicTableExam.setSuidRich(new ObjSQLRichServiceImpl());
			DynamicTableExam.test();
			
			InsertAndReturnIdTest.setSuidRich(new ObjSQLServiceImpl());
			InsertAndReturnIdTest.test();
			
			System.out.println("================ServiceTest==========end====");

			result = true;
		} catch (Exception e) {
			result = false;
		} finally {
			Assert.assertEquals(result, true);
		}

	}
}
