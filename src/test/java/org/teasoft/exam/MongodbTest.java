/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam;

import org.junit.Assert;
import org.junit.Test;
import org.teasoft.bee.osql.DatabaseConst;
import org.teasoft.exam.bee.mongodb.SelectAll;
import org.teasoft.exam.bee.mongodb.SelectGroupBy;
import org.teasoft.exam.bee.mongodb.SelectOrderBy;
import org.teasoft.exam.bee.mongodb.SelectWithFun;
import org.teasoft.exam.bee.test.ClearDsContext;
import org.teasoft.exam.comm.TestPrepare;
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.core.HoneyContext;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  2.0
 */
public class MongodbTest {
	@Test
	public void test(){
		
		System.out.println("---MongodbTest with junit start:------");
		
		boolean result=false;
		try {
			
			ClearDsContext.clear();
			
			HoneyConfig honeyConfig = HoneyConfig.getHoneyConfig();

			String oldUrl = honeyConfig.getUrl();
			String oldUsername = honeyConfig.getUsername();
			String oldPw = honeyConfig.getPassword();
			
			honeyConfig.setUrl("mongodb://localhost:27017/bee/");
			honeyConfig.setUsername("");
			honeyConfig.setPassword("");
//			HoneyContext.setConfigRefresh(true);
			
			TestPrepare.init("normal("+HoneyContext.getDbDialect()+")");
			
			SelectAll.test();
			SelectGroupBy.test();
			SelectOrderBy.test();
			SelectWithFun.test();
			
			
			
			honeyConfig.setUrl(oldUrl);
			honeyConfig.setUsername(oldUsername);
			honeyConfig.setPassword(oldPw);
			honeyConfig.setSchemaName("");

			HoneyContext.setConfigRefresh(true);
			
			result=true;
		} catch (Exception e) {
			e.printStackTrace();
			Logger.error(e.getMessage(), e);
			result=false;
		}finally {
			Assert.assertEquals(result,true);
		}
		
		System.out.println("---MongodbTest with junit end.------");
	}
}
