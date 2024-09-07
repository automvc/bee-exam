/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.moretable.modify.sharding;

import org.teasoft.exam.bee.osql.moretable.modify.Book;
import org.teasoft.exam.bee.osql.moretable.modify.BookDetail;
import org.teasoft.exam.bee.osql.moretable.modify.BookReal;
import org.teasoft.honey.osql.autogen.Ddl;

/**
 * @author Kingstar
 * @since  2.1.8
 */
public class CreateTable {
	
	public static void main(String[] args) {
		
		ShardingInitData.init(); // 分片
		InitSameDsUtil.initDS();
		
		test();
	}
	
	public static void test() {
		
//		Ddl.createTable(Book.class);
//		Ddl.createTable(BookDetail.class);
//		Ddl.createTable(BookReal.class);
		
		Ddl.createTable(Book.class,true);
		Ddl.createTable(BookDetail.class,true);
		Ddl.createTable(BookReal.class,true);
	}

}
