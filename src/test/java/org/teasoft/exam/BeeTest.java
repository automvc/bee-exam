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
import org.teasoft.exam.bee.osql.HoneyConfigReset;
import org.teasoft.exam.bee.osql.InsertAndReturnIdTest;
import org.teasoft.exam.bee.osql.KotlinTest;
import org.teasoft.exam.bee.osql.RedisCacheExpireTest;
import org.teasoft.exam.bee.osql.RedisCacheTest;
import org.teasoft.exam.bee.osql.SameConnTest;
import org.teasoft.exam.bee.osql.TransactionExam;
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
			
			BeeFactory beeFactory=BeeFactory.getInstance();
			beeFactory.setDataSource(null);
			beeFactory.setTransaction(null);
			
			//V1.11
			InsertAndReturnIdWithPK.test();
			PrimaryKeyTest.test();
			SelectByIdWithPK.test();
			
			JustFetchExam.test();
			CharTest.test();
			AnnoTest.test();
			
			KotlinTest.test();
			
			TransactionExam.testRollback(true); //ThrowException and rollback
			
			HoneyConfigReset.test(); //just run one time, put in last.
			result=true;
		} catch (Exception e) {
			e.printStackTrace();
			Logger.error(e.getMessage(), e);
			result=false;
		}finally {
			Assert.assertEquals(result,true);
		}
		
		System.out.println("---Bee Test with junit end.------");
	}

}
