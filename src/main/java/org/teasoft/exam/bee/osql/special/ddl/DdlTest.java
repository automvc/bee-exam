/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.special.ddl;

import org.teasoft.exam.bee.mongodb.entity.Noid0;
import org.teasoft.honey.osql.autogen.Ddl;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  1.11
 */
public class DdlTest {

	public static void main(String[] args) {
		test();
	}

	public static void test() {
//		Ddl.createTable(new NoTypeHowDdl(),true);
//		Ddl.createTable(new Noid0(),true);
//		Ddl.createTable(Noid1.class,true);
//		BF.getPreparedSql().modify("drop table noid1");  //2.4.0.8 fixed ERROR: table "noid1" does not exist
//		Ddl.createTable(Noid1.class);
		
		Ddl.createTable(Noid1.class,true);
		
		Ddl.createTable(Noid1.class,true);
	}

}
