/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.special.ddl;

import java.util.HashMap;
import java.util.Map;

import org.teasoft.bee.osql.DatabaseConst;
import org.teasoft.honey.osql.autogen.Ddl;
import org.teasoft.honey.osql.autogen.Java2DbType;

/**
 * @author Kingstar
 * @since  1.11
 */
public class DdlTest {

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		Ddl.createTable(new NoTypeHowDdl());
	}

}
