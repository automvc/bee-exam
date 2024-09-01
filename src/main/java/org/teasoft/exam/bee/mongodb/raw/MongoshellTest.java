/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.raw;

import java.util.List;
import java.util.Map;

import org.teasoft.bee.mongodb.MongodbRawSql;
import org.teasoft.honey.util.StringParser;

import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.core.MongodbRawSqlLib;

/**
 * @author Kingstar
 * @since  2.1
 */
public class MongoshellTest {
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		MongodbRawSql pre=new MongodbRawSqlLib();
		String sql="db.inventory.deleteOne( { _id:'6447edf5a0580000bf004fd8'} )";
		int a=pre.modify(sql);
		System.err.println(a);
		
		String findSql="db.inventory.find()";
		String json=pre.selectJson(findSql);
		System.out.println(json);
		
		String findSql1="db.inventory.   //fdfdfdfdff"
				+"\n find();"
				;
		System.out.println(findSql1);
		findSql1=StringParser.removeComment(findSql1);
		System.out.println(findSql1);
		System.err.println("---------------------");
		
		String json1=pre.selectJson(findSql1);
		System.out.println(json1);
//		
//		pre.selectJson(findSql); //测试用缓存???  ok
//		pre.modify(sql);    //受影响的行数>=1,才会删缓存.
//		pre.selectJson(findSql); //测试不能用缓存???  ok
//		
//		String findSql2="db.inventory.find({ _id:809126179373058})";
		String findSql2="db.inventory.find({ _id:'6447edf5a0580000bf004fdc'})";
		String json2=pre.selectJson(findSql2);
		System.err.println(json2);
//		
//		List<Inventory> list=pre.select(findSql2, Inventory.class);
//		Printer.printList(list);
//		pre.modify("db.inventory.deleteOne({ _id:809126179373058})");
//		list=pre.select(findSql2, Inventory.class);
		
		
		List<Map<String, Object>> list2=pre.selectMapList(findSql2);
		Printer.printList(list2);
//		pre.modify("db.inventory.deleteOne({ _id:809126179373058})");
//		list2=pre.selectMapList(findSql2);
		
	}

}
