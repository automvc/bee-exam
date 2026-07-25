/*
 * Copyright 2020-2025 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.moretable3.sharding;

import java.util.ArrayList;
import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.api.MoreTable;
import org.teasoft.bee.sharding.ShardingBean;
import org.teasoft.exam.bee.osql.sharding.InitSameDsUtil;
import org.teasoft.exam.moretable3.sharding.entity.Book;
import org.teasoft.exam.moretable3.sharding.entity.BookDetail;
import org.teasoft.exam.moretable3.sharding.entity.BookReal;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.autogen.Ddl;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.sharding.config.ShardingConfig;

/**
 * @author Kingstar
 * @since  2.5.2
 */
public class MoreTableShardingDdl {

	public static void main(String[] args) {
//		ShardingInitData.init();
		ShardingConfig.addShardingBean(Book.class, new ShardingBean("ds[0..1].book[0..5]", "id"));
		ShardingConfig.addShardingBean(BookDetail.class, new ShardingBean("ds[0..1].book_detail[0..5]", "bookId"));
		ShardingConfig.addShardingBean(BookReal.class, new ShardingBean("ds[0..1].book_real[0..5]", "bookDetailId"));
		InitSameDsUtil.initDS();
		test();
	}
	
	private static void createTable() {
		Ddl.createTable(Book.class);
//		Ddl.createTable(BookDetail.class); //子表要通过显式声明创建
//		Ddl.createTable(BookReal.class);
	}

	public static void test() {
		try {
			
			createTable();
			
		} catch (BeeException e) {
			e.printStackTrace();
			Logger.error("In MoreTableInsertSharding (BeeException):" + e.getMessage());
		} catch (Exception e) {
			Logger.error("In MoreTableInsertSharding (Exception):" + e.getMessage());
			e.printStackTrace();
		}
	}

}
