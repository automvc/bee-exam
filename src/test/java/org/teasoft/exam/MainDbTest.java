/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
*/

package org.teasoft.exam;

import org.junit.Assert;
import org.junit.Test;
import org.teasoft.bee.osql.DatabaseConst;
import org.teasoft.exam.bee.test.ClearDsContext;
import org.teasoft.exam.bee.test.TestNormal;
import org.teasoft.honey.osql.core.HoneyConfig;

/**
 * @author Kingstar
 * @since  1.9
 */
public class MainDbTest {
	@Test
	public void test() {

		System.out.println("---Bee MainDbTest with junit start:------");

		boolean result = false;
		try {

			
//			HoneyConfig honeyConfig = HoneyConfig.getHoneyConfig();
			
			ClearDsContext.clear();
//			honeyConfig.multiDS_enable=false;
//			honeyConfig.multiDS_sharding=false;
//			BeeFactory beeFactory=BeeFactory.getInstance();  //只是在测试同时用多数DB时,会用到.   在setUrl清空,不好,会把原有的ds清空,那实际是要的.
//			beeFactory.setDataSource(null);
//			beeFactory.setDataSourceMap(null);
//			beeFactory.setTransaction(null);
			

//			String dbName = HoneyConfig.getHoneyConfig().getDbName();
//			if (DatabaseConst.ORACLE.equalsIgnoreCase(dbName) || DatabaseConst.H2.equalsIgnoreCase(dbName)
//					|| DatabaseConst.PostgreSQL.equalsIgnoreCase(dbName)) {
//				honeyConfig.genid_forAllTableLongId = true;
//			}
			
			HoneyConfig honeyConfig = HoneyConfig.getHoneyConfig();

//			String oldUrl = honeyConfig.getUrl();
//			String oldUsername = honeyConfig.getUsername();
//			String oldPw = honeyConfig.getPassword();

			System.err.println();
			honeyConfig.setDbName(DatabaseConst.SQLite);
			System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>test SQLite start");
			honeyConfig.setUrl("jdbc:sqlite:bee.db");
			honeyConfig.setUsername("");
			honeyConfig.setPassword("");
			TestNormal.test();
			System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>test SQLite end");
			sleep(3);
			
			
			
			System.err.println();
			System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>test Microsoft SQL Server start");
			honeyConfig.setUrl("jdbc:sqlserver://localhost:1433; databasename=bee");
			honeyConfig.setUsername("sa");
			honeyConfig.setPassword("123456");
			TestNormal.test();
			System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>test Microsoft SQL Server end");
			sleep(3);
			
			
			
//			honeyConfig.genid_forAllTableLongId = true;
			
			System.err.println();
			System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>test Oracle start");
			honeyConfig.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
			honeyConfig.setUsername("scott");
			honeyConfig.setPassword("Bee123456");
			System.err.println("(oracle) honeyConfig: "+honeyConfig.toString());
			TestNormal.test();
			System.err.println("===================honeyConfig.getUrl():==="+honeyConfig.getUrl());
			System.err.println("honeyConfig: "+honeyConfig.toString());
			System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>test Oracle end");
			sleep(3);

			
			System.err.println();
			System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>test H2 start");
			honeyConfig.setUrl("jdbc:h2:D:/JavaWeb/h2/data/bee");
			honeyConfig.setUsername("sa");
			honeyConfig.setPassword("sa");
			TestNormal.test();
			System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>test H2 end");
			sleep(3);

			
			System.err.println();
			System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>test PostgreSQL start");
			honeyConfig.setDriverName("org.postgresql.Driver");
			honeyConfig.setUrl("jdbc:postgresql://127.0.0.1:5432/bee");
			honeyConfig.setUsername("Administrator");
			honeyConfig.setPassword("");
			TestNormal.test();
			System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>test PostgreSQL end");
			sleep(3);
			
//			honeyConfig.genid_forAllTableLongId = false;
			
//			System.err.println();
//			System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>test Cassandra start");
//			honeyConfig.setUrl("jdbc:cassandra://127.0.0.1:9042");
//			honeyConfig.setUsername("");
//			honeyConfig.setPassword("");
//			
//			honeyConfig.setSchemaName("store");
//			
//			TestNormal.test();
//			System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>test Cassandra end");
			
//			System.err.println(); //Mongodb很多用法与JDBC不一样,不能用这个测.
//			System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>test Mongodb start");
//			honeyConfig.setDbName("MongoDB");
//			honeyConfig.setUrl("mongodb://localhost:27017/bee/");
//			honeyConfig.setUsername("");
//			honeyConfig.setPassword("");
//			TestNormal.test();
//			System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>test Mongodb end");
//			sleep(3);
			

//			honeyConfig.setUrl(oldUrl);
//			honeyConfig.setUsername(oldUsername);
//			honeyConfig.setPassword(oldPw);
//			honeyConfig.setSchemaName("");
//			HoneyContext.setConfigRefresh(true);
			
			System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>test MySQL start.");
			honeyConfig.setDbName(DatabaseConst.MYSQL);
			honeyConfig.setUrl("jdbc:mysql://localhost:3306/bee?characterEncoding=UTF-8&useSSL=false");
			honeyConfig.setUsername("root");
			honeyConfig.setPassword("123456");
			TestNormal.test();
            System.err.println("===================honeyConfig.getUrl():==="+honeyConfig.getUrl());
			System.err.println("honeyConfig: "+honeyConfig.toString());
            System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>test MySQL end.");
            sleep(2);

			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			Assert.assertEquals(result, true);
		}

		System.out.println("---Bee MainDbTest with junit end.------");
	}
	
	private void sleep(int second) {
		try {
			Thread.sleep(second*1000);
//			HoneyConfig.getHoneyConfig().multiDS_enable=true;
//			HoneyConfig.getHoneyConfig().multiDS_differentDbType=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
