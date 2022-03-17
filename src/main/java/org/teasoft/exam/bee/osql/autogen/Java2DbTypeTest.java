/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.autogen;

import java.util.HashMap;
import java.util.Map;

import org.teasoft.bee.osql.DatabaseConst;
import org.teasoft.honey.osql.autogen.Java2DbType;

/**
 * @author Kingstar
 * @since  1.11
 */
public class Java2DbTypeTest {

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		
		Map<String, String> map = new HashMap<>();
		map.put("javaType", "Db_type");
		Java2DbType.appendJava2DbType(DatabaseConst.MYSQL, map);
		System.out.println(Java2DbType.getJava2DbType(DatabaseConst.MYSQL));

		Java2DbType.appendJava2DbType(DatabaseConst.DB2, map);
		System.out.println(Java2DbType.getJava2DbType(DatabaseConst.DB2));
	}

}
