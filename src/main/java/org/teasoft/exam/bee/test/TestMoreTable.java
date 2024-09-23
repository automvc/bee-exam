/*
 * Copyright 2019-2024 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.test;

import org.teasoft.bee.osql.DatabaseConst;
import org.teasoft.exam.bee.osql.annotation.listmoretable2.*;
import org.teasoft.exam.comm.TestHelper;
import org.teasoft.honey.osql.core.HoneyConfig;

/**
 * @author Kingstar
 * @since  2.4.0
 */
public class TestMoreTable {
//   不分片,测多表查询
	public static void main(String[] args) throws Exception {
		
		test();
	}

	public static void test() throws Exception {
		String DbName = HoneyConfig.getHoneyConfig().getDbName();
		if (!DatabaseConst.MYSQL.equalsIgnoreCase(DbName)) return; // 只使用MYSQL测试.

		runTest(MoreTableExam11.class);
		runTest(MoreTableExam11_2.class);
		runTest(MoreTableExam11_3.class);
		runTest(MoreTableExam11_3_2.class);
		runTest(MoreTableExam11_4.class);

	}

	public static void runTest(Class c) {
		TestHelper.runTest(c);
	}
}
