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
public class MoreTableShardingInsert2 {

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
		Ddl.createTable(BookDetail.class);
		Ddl.createTable(BookReal.class);
	}

	public static void test() {
		try {
			
//			createTable();
			
			MoreTable moreTable = BF.getMoreTable();

			Book entity = new Book();
			entity.setId2(16L); // 使用用户填写的值,并会设置到外键中.
			entity.setIsbn("isbn123456");
			entity.setName("Java开发");

			BookDetail bookDetail = new BookDetail();
//			bookDetail.setBookId(returnId); //框架会帮填
			bookDetail.setCodeId("2001");
			bookDetail.setRemark("第一本");

			BookDetail bookDetail2 = new BookDetail();
			bookDetail2.setCodeId("2002");
			bookDetail2.setRemark("第2本");

			BookReal bookReal = new BookReal();
			bookReal.setRemark("测试OneHasOne");
			
			bookDetail.setBookReal(bookReal);

//			entity.setBookDetail(bookDetail);
			List<BookDetail> bookDetailList=new ArrayList<>();
			bookDetailList.add(bookDetail);
			bookDetailList.add(bookDetail2);
			
			entity.setBookDetailList(bookDetailList);

			int num = moreTable.insert(entity);
			Logger.info("num:" + num);

		} catch (BeeException e) {
			e.printStackTrace();
			Logger.error("In MoreTableInsertSharding (BeeException):" + e.getMessage());
		} catch (Exception e) {
			Logger.error("In MoreTableInsertSharding (Exception):" + e.getMessage());
			e.printStackTrace();
		}
	}

}
