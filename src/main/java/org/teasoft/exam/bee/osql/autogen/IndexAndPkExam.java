/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.autogen;

import org.teasoft.exam.bee.osql.entity.TestUser;
import org.teasoft.honey.osql.autogen.Ddl;

/**
 * 测试创建索引
 * @author Kingstar
 * @since  1.17
 */
public class IndexAndPkExam {
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		Ddl.createTable(TestUser.class, false); //如果还没有表,则创建表
		
		//1. 一般索引
		Ddl.indexNormal(TestUser.class, "name", "test_index_name");
		Ddl.indexNormal(TestUser.class, "username,lastName", "test_index_name2");//有字段转换
		//CREATE INDEX test_index2 ON test_user(username,last_name)
		
		//索引名称采用默认的
		Ddl.indexNormal(TestUser.class, "name");
		Ddl.indexNormal(TestUser.class, "username,lastName");//有字段转换
		
		
		//2.唯一索引
		Ddl.unique(TestUser.class, "name", "test_uk_index_name21");
		Ddl.unique(TestUser.class, "username,lastName", "test_uk_index_name22");//有字段转换
		
		//索引名称采用默认的
		Ddl.unique(TestUser.class, "name");
		Ddl.unique(TestUser.class, "username,lastName");//有字段转换
		
		//3.联合主键    一个表只能定义一个主键(可以同时用多个字段)
//		Ddl.primaryKey(new TestUser(), "name", "test_pk_name31");
//		Ddl.primaryKey(new TestUser(), "id,lastName", "test_pk_name32");//有字段转换
		
//		Ddl.primaryKey(new TestUser(), "name");
//		Ddl.primaryKey(new TestUser(), "username,lastName");//有字段转换
		
		
		//异常测试
//		Ddl.indexNormal(new TestUser(), "--", "test_index_name");
//		Ddl.indexNormal(new TestUser(), "name", "test_index_name--");
	}

}
