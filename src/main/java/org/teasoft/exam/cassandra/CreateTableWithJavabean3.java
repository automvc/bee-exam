/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.cassandra;

import org.teasoft.honey.osql.autogen.Ddl;

/**
 * @author Kingstar
 * @since  1.9
 */
public class CreateTableWithJavabean3 {
	public static void main(String[] args) {
//		Ddl.createTable(new CassandraTable(), false);
		Ddl.createTable(new CassandraTable(), true);
		System.exit(0);
	}

}
