/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam;

import org.junit.Assert;
import org.junit.Test;
import org.teasoft.bee.logging.Path;
import org.teasoft.bee.osql.DatabaseConst;
import org.teasoft.bee.osql.MapSqlKey;
import org.teasoft.bee.osql.MapSqlSetting;
import org.teasoft.bee.osql.annotation.JoinType;
import org.teasoft.exam.bee.osql.CallExam;
import org.teasoft.exam.bee.osql.InsertAndReturnIdTest;
import org.teasoft.exam.bee.osql.SameConnTest;
import org.teasoft.exam.bee.osql.autogen.GenBeanExam;
import org.teasoft.exam.bee.osql.autogen.GenFilesExam;
import org.teasoft.exam.bee.test.TestCache;
import org.teasoft.exam.bee.test.TestNormal;
import org.teasoft.honey.logging.Jdk14LoggingImpl;
import org.teasoft.honey.logging.NoLogging;
import org.teasoft.honey.logging.SystemLogger;
import org.teasoft.honey.osql.core.HoneyUtil;
import org.teasoft.honey.osql.core.Logger;

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
			
			GenBeanExam.test();
			GenFilesExam.test();
			
			SameConnTest.test();
			InsertAndReturnIdTest.test();
			
			if(HoneyUtil.isMysql()) {
				CallExam.test();
			}
			
			Logger.info(Path.getFullPath());
			
//          HoneyConfig.getHoneyConfig().cache_nocache;
//			SuidExamEN.test();
			
			Logger.info(JoinType.JOIN.getType());
			Logger.info(MapSqlKey.Table.getName());
			Logger.info(MapSqlSetting.IsNamingTransfer.getName());
			
			Logger.info(DatabaseConst.MYSQL);
			
//			ChangeSqlScript.test();
			
			//multi-thread test
//			Test4.test();
			
			
			NoLogging noLogging=new NoLogging();
			noLogging.info("test NoLogging");
			SystemLogger systemLogger=new SystemLogger();
			systemLogger.info("test SystemLogger");
			Jdk14LoggingImpl jdk14LoggingImpl=new Jdk14LoggingImpl("test");
			jdk14LoggingImpl.info("test Jdk14LoggingImpl");
			
			result=true;
		} catch (Exception e) {
			result=false;
		}finally {
			Assert.assertEquals(result,true);
		}
		
		System.out.println("---Bee Test with junit end.------");
	}

}
