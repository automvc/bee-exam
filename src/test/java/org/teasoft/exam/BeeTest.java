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
import org.teasoft.bee.osql.search.Operator;
import org.teasoft.exam.bee.osql.CallExam;
import org.teasoft.exam.bee.osql.HoneyConfigReset;
import org.teasoft.exam.bee.osql.InsertAndReturnIdTest;
import org.teasoft.exam.bee.osql.KotlinTest;
import org.teasoft.exam.bee.osql.RedisCacheExpireTest;
import org.teasoft.exam.bee.osql.RedisCacheTest;
import org.teasoft.exam.bee.osql.SameConnTest;
import org.teasoft.exam.bee.osql.annotation.JustFetchExam;
import org.teasoft.exam.bee.osql.autogen.GenBeanExam;
import org.teasoft.exam.bee.osql.autogen.GenFilesExam;
import org.teasoft.exam.bee.osql.special.primarykey.InsertAndReturnIdWithPK;
import org.teasoft.exam.bee.osql.special.primarykey.PrimaryKeyTest;
import org.teasoft.exam.bee.osql.special.primarykey.SelectByIdWithPK;
import org.teasoft.exam.bee.test.AnnoTest;
import org.teasoft.exam.bee.test.CharTest;
import org.teasoft.exam.bee.test.TestCache;
import org.teasoft.exam.bee.test.TestMoreDs;
import org.teasoft.exam.bee.test.TestNormal;
import org.teasoft.honey.logging.Jdk14LoggingImpl;
import org.teasoft.honey.logging.NoLogging;
import org.teasoft.honey.logging.SystemLogger;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.HoneyConfig;
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
			
			TestMoreDs.test();
			
			GenBeanExam.test();
			GenFilesExam.test();
			
			SameConnTest.test();
			InsertAndReturnIdTest.test();
			
			//二级缓存
			boolean oldFlag=HoneyConfig.getHoneyConfig().cache_useLevelTwo;
			HoneyConfig.getHoneyConfig().cache_useLevelTwo=true;
			RedisCacheTest.test();
			RedisCacheExpireTest.test();
			HoneyConfig.getHoneyConfig().cache_useLevelTwo=oldFlag;
			
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
			noLogging.debug("test NoLogging");
			noLogging.trace("test NoLogging");
			noLogging.warn("test NoLogging");
			noLogging.error("test NoLogging");
			noLogging.warn("test NoLogging",new Throwable("test NoLogging"));
			noLogging.error("test NoLogging",new Throwable("test NoLogging"));
			
			SystemLogger systemLogger=new SystemLogger();
			systemLogger.info("test SystemLogger");
			systemLogger.debug("test SystemLogger");
			systemLogger.trace("test SystemLogger");
			systemLogger.warn("test SystemLogger");
			systemLogger.error("test SystemLogger");
			systemLogger.warn("test SystemLogger",new Throwable("test SystemLogger"));
			systemLogger.error("test SystemLogger",new Throwable("test SystemLogger"));
			
			Jdk14LoggingImpl jdk14LoggingImpl=new Jdk14LoggingImpl("test");
			jdk14LoggingImpl.info("test Jdk14LoggingImpl");
			jdk14LoggingImpl.debug("test Jdk14LoggingImpl");
			jdk14LoggingImpl.trace("test Jdk14LoggingImpl");
			jdk14LoggingImpl.warn("test Jdk14LoggingImpl");
			jdk14LoggingImpl.error("test Jdk14LoggingImpl");
			jdk14LoggingImpl.warn("test Jdk14LoggingImpl",new Throwable("test Jdk14LoggingImpl"));
			jdk14LoggingImpl.error("test Jdk14LoggingImpl",new Throwable("test Jdk14LoggingImpl"));
			
			Operator operator=Operator.like;
			jdk14LoggingImpl.info(operator.getOperator());
			BeeFactory beeFactory=BeeFactory.getInstance();
			beeFactory.setDataSource(null);
			beeFactory.setTransaction(null);
			
			KotlinTest.test();
			HoneyConfigReset.test(); //just run one time
			
			//V1.11
			InsertAndReturnIdWithPK.test();
			PrimaryKeyTest.test();
			SelectByIdWithPK.test();
			
			JustFetchExam.test();
			CharTest.test();
			AnnoTest.test();
			
			result=true;
		} catch (Exception e) {
			result=false;
		}finally {
			Assert.assertEquals(result,true);
		}
		
		System.out.println("---Bee Test with junit end.------");
	}

}
