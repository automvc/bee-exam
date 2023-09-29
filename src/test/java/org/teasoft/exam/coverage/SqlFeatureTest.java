/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.coverage;

import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.dialect.oracle.OracleFeature;
import org.teasoft.honey.osql.dialect.sqlserver.SqlServerFeature2012;

/**
 * @author Kingstar
 * @since  2.1.8
 */
public class SqlFeatureTest {
	
	public void test() {
		SqlServerFeature2012 t=new SqlServerFeature2012();
		t.toPageSql("select * from orders", 10);
		t.toPageSql("select * from orders", 10,10);
		
		String old=HoneyConfig.getHoneyConfig().sqlKeyWordCase;
		HoneyConfig.getHoneyConfig().sqlKeyWordCase="upper";
		t.toPageSql("select * from orders", 10);
		t.toPageSql("select * from orders", 10,10);
		
		OracleFeature t2=new OracleFeature();
		t2.toPageSql("select * from orders", 10);
		t2.toPageSql("select * from orders", 10,10);
		
		HoneyConfig.getHoneyConfig().sqlKeyWordCase=old;
	}

}
