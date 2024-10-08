/*
 * Copyright 2016-2019 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.sharding;

import java.math.BigDecimal;

import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.osql.sharding.entity.Orders;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * 批量插入的分片
 * @author Kingstar
 * @since  2.0
 */
public class ShardingBatchInsert2 {

//	private static SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
	private static SuidRich suidRich = null; //要是在Java代码里加配置,应该在添加配置的代码后,才获取对象.

	public static void main(String[] args) {

		test();
	}

	public static void test(){
		System.out.println("------Sharding test--------ShardingBatchInsert2-----");
		ShardingInitData.init(); // 分片
		InitSameDsUtil.initDS();
		if(suidRich==null) suidRich = BF.getSuidRich(); //在添加配置的代码后,才获取对象.
		test0();
	}

	public static void test0() {
		
		int SIZE=20;

		Orders[] ordersArray = new Orders[SIZE];
		for (int i = 0; i < SIZE; i++) {
			Orders orders = new Orders();
			orders.setUserid((long) i);
			orders.setOrderid((long) i);
			orders.setTotal(new BigDecimal(91 + i));
			orders.setRemark("testOneTime" + i);
			ordersArray[i] = orders;
		}
//		int insertArray = suidRich.insert(ordersArray, 3, "id,createtime,updatetime");// bug
		int insertArray = suidRich.insert(ordersArray, 3);// batch insert
		Logger.info(insertArray);
	
//		int r=0;
//		long t1=System.currentTimeMillis();
//		for (int i = 0; i < 1000; i++) {
//			int b=suidRich.insert(ordersArray, 3, "id,createtime,updatetime");// batch insert
//		    r+=b;
//		}
//		long t2=System.currentTimeMillis();
//		System.out.println("用时:"+(t2-t1));
//		Logger.info(r);
	}

}
