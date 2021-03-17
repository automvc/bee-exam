/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam;

import org.junit.Assert;
import org.junit.Test;
import org.teasoft.bee.logging.Path;
import org.teasoft.exam.bee.osql.ConditionExam;
import org.teasoft.exam.bee.osql.InsertTest;
import org.teasoft.exam.bee.osql.SuidExam;
import org.teasoft.exam.bee.osql.SuidRichExam;
import org.teasoft.exam.bee.osql.autogen.GenBeanExam;
import org.teasoft.exam.bee.osql.autogen.GenFilesExam;
import org.teasoft.exam.bee.test.TestCache;
import org.teasoft.exam.bee.test.TestNormal;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.serviceimpl.ObjSQLRichServiceImpl;
import org.teasoft.honey.osql.serviceimpl.ObjSQLServiceImpl;

/**
 * @author Kingstar
 * @since  1.9
 */
public class BeeTest {
	
	@Test
	public void test(){
		
		System.out.println("---Bee Test with junit start:------");
		
		boolean result=false;
		try {
			TestNormal.test();
			TestCache.test();
			
			SuidExam.setSuidRich(new ObjSQLServiceImpl());
			SuidExam.test();
			SuidRichExam.setSuidRich(new ObjSQLRichServiceImpl());
			SuidRichExam.test();
			ConditionExam.setSuidRich(new ObjSQLRichServiceImpl());
			ConditionExam.test();
			InsertTest.setSuidRich(new ObjSQLRichServiceImpl());
			InsertTest.test();
			
			GenBeanExam.test();
			GenFilesExam.test();
			
			Logger.info(Path.getFullPath());
			
			result=true;
		} catch (Exception e) {
			result=false;
		}finally {
			Assert.assertEquals(result,true);
		}
		
		System.out.println("---Bee Test with junit end.------");
	}

}
