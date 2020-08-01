/*
 * Copyright 2016-2019 the original author.All rights reserved.
 * Kingstar(aiteasoft@163.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.test;

import java.util.Map;

import org.teasoft.bee.osql.PreparedSql;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.7.2
 */
public class ClearAndInitTestTable {
	
	@SuppressWarnings({"rawtypes","unchecked","deprecation"}) 
	public static void main(String[] args) {
		PreparedSql preparedSql = BeeFactory.getHoneyFactory().getPreparedSql();
		Map mapUpdate=null;
//		int deleteOrdersNum=preparedSql.modify("delete from orders", mapUpdate);
		int deleteOrdersNum=preparedSql.modify("TRUNCATE orders", mapUpdate);
		Logger.info("deleteOrdersNum: "+deleteOrdersNum);
		
//		int deleteUserNum=preparedSql.modify("delete from user", mapUpdate);
		int deleteUserNum=preparedSql.modify("TRUNCATE user", mapUpdate);
		Logger.info("deleteUserNum: "+deleteUserNum);
		
		int deleteLeafNum=preparedSql.modify("TRUNCATE leaf_alloc", mapUpdate);
		Logger.info("deleteLeafNum: "+deleteLeafNum);  //TRUNCATE 没有返回删除的行

		
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>insert	
		
		String insertOrders1="INSERT INTO `orders` VALUES ('100001', 'bee', 'Bee(ORM Framework)', '95.01', '2020-03-02 11:29:28', 'test', '12345601', 'test1', '2020-03-02 16:34:19');";
		String insertOrders2="INSERT INTO `orders` VALUES ('100002', 'bee', 'Bee(ORM Framework)', '96.01', '2020-03-02 11:29:28', 'test%a', '12345602', 'test2', '2020-03-02 16:34:19');";
		String insertOrders3="INSERT INTO `orders` VALUES ('100003', 'bee', 'Bee(ORM Framework)', '97.01', '2020-03-02 11:29:28', 'testx%', '12345603', 'test3', '2020-03-02 16:34:19');";
		
//		String sqls[]=new String[3];
//		sqls[0]=insertOrders1;
//		sqls[1]=insertOrders2;
//		sqls[2]=insertOrders3;
//		BeeSql beeSql=BeeFactory.getHoneyFactory().getBeeSql();
////		beeSql.batch(sqls);//不能这样用.因为该方法是用prepare的,是占位符的,会用sqls数组的第一个作为所有语句的模板.若第一个语句是静态的,则会有主键冲突.
//		System.out.println(beeSql.batch(sqls));
		
		preparedSql.modify(insertOrders1, mapUpdate);
		preparedSql.modify(insertOrders2, mapUpdate);
		preparedSql.modify(insertOrders3, mapUpdate);
		
		
		String insertUser1="INSERT INTO `user` VALUES ('800001', 'beeUser@163.com', null, 'Bee', 'bee', 'bee', null);";
		String insertUser2="INSERT INTO `user` VALUES ('800002', 'honey@163.com', null, 'Honey', 'honey', 'honey', '2020-03-02 16:41:33');";
		preparedSql.modify(insertUser1, mapUpdate);
		preparedSql.modify(insertUser2, mapUpdate);
		
		
		String insertLeaf1="INSERT INTO `leaf_alloc` VALUES ('456537470402562', 'test', '100', '100', 'test segment', '2020-07-04 22:42:09', '1');";
		String insertLeaf2="INSERT INTO `leaf_alloc` VALUES ('456537470402563', 'order', '100', '100', 'order segment', '2020-07-04 22:42:10', '1');";
		preparedSql.modify(insertLeaf1, mapUpdate);
		preparedSql.modify(insertLeaf2, mapUpdate);
		
	}

}
