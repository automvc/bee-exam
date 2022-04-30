/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.dialect;

import org.teasoft.bee.osql.DatabaseConst;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.bee.osql.dialect.DbFeatureRegistry;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  1.11
 */
public class MyFeatureTest {
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		DbFeatureRegistry.register(DatabaseConst.SQLSERVER, new CustomerSqlServerFeature());
		SuidRich suidRich=BF.getSuidRich();
		try {
			suidRich.select(new Orders(), 10, 10);
		} catch (Exception e) {
			Logger.error(e.getMessage(), e);
		}
		
	}

}
