/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
*/

package org.teasoft.exam;

import org.junit.Assert;
import org.junit.Test;
import org.teasoft.bee.osql.DatabaseConst;
import org.teasoft.exam.bee.test.TestNormal;
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.core.HoneyContext;

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

			HoneyConfig honeyConfig = HoneyConfig.getHoneyConfig();

			String dbName = HoneyConfig.getHoneyConfig().getDbName();
			if (DatabaseConst.ORACLE.equalsIgnoreCase(dbName) || DatabaseConst.H2.equalsIgnoreCase(dbName)
					|| DatabaseConst.PostgreSQL.equalsIgnoreCase(dbName)) {
				honeyConfig.genid_forAllTableLongId = true;
			}

			String oldUrl = honeyConfig.getUrl();
			String oldUsername = honeyConfig.getUsername();
			String oldPw = honeyConfig.getPassword();

			System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>test MySQL start.");
			honeyConfig.setUrl("jdbc:mysql://localhost:3306/bee?characterEncoding=UTF-8&useSSL=false");
			honeyConfig.setUsername("root");
			honeyConfig.setPassword("123456");
			TestNormal.test();
            System.err.println("===================honeyConfig.getUrl():==="+honeyConfig.getUrl());
			System.err.println("honeyConfig: "+honeyConfig.toString());
            System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>test MySQL end.");
            sleep(3);

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
			System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>test SQLite start");
			honeyConfig.setUrl("jdbc:sqlite:bee.db");
			honeyConfig.setUsername("");
			honeyConfig.setPassword("");
			TestNormal.test();
			System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>test SQLite end");
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
			System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>test Microsoft SQL Server start");
			honeyConfig.setUrl("jdbc:sqlserver://localhost:1433; databasename=bee");
			honeyConfig.setUsername("sa");
			honeyConfig.setPassword("123456");
			TestNormal.test();
			System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>test Microsoft SQL Server end");
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
			

			honeyConfig.setUrl(oldUrl);
			honeyConfig.setUsername(oldUsername);
			honeyConfig.setPassword(oldPw);
			honeyConfig.setSchemaName("");

			HoneyContext.setConfigRefresh(true);

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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
