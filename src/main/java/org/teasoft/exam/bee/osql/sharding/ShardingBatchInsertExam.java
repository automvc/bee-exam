/*
 * Copyright 2016-2019 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.sharding;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.osql.sharding.entity.Orders;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.Logger;

/**
 * 批量插入的分片
 * @author Kingstar
 * @since  2.0
 */
public class ShardingBatchInsertExam {

//	private static SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
	private static SuidRich suidRich = null;

	public static SuidRich getSuidRich() {
		return suidRich;
	}

	public static void setSuidRich(SuidRich suidRich) {
		ShardingBatchInsertExam.suidRich = suidRich;
	}

	public static void main(String[] args) {
		System.out.println("------Sharding test--------ShardingBatchInsertExam-----");
		ShardingInitData.init(); // 分片
		InitSameDsUtil.initDS();
		test0();
	}

	public static void test(){
		if(suidRich==null)
		    suidRich = BeeFactory.getHoneyFactory().getSuidRich();
		
		test0();
	}

	public static void test0() {

			//test batch insert
			Orders orders0 = new Orders();
//			orders0.setId(10004L);
			orders0.setUserid(0L);
			orders0.setOrderid(0L);
			orders0.setTotal(new BigDecimal(91));
			orders0.setRemark("testOneTime");

			Orders orders1 = new Orders();
//			orders1.setId(10005L);
//			orders1.setUserid(0L);
			orders1.setOrderid(4L);
			orders1.setRemark("testOneTime");
			orders1.setTotal(new BigDecimal(20));

			Orders orders2 = new Orders();
//			orders2.setId(10006L);
			orders2.setUserid(5L);
			orders2.setOrderid(4L);
			orders2.setRemark("testOneTime");
			orders2.setTotal(new BigDecimal(23));

			Orders[] ordersArray = new Orders[3];
			ordersArray[0] = orders0;
			ordersArray[1] = orders1;
			ordersArray[2] = orders2;

			int insertArray = suidRich.insert(ordersArray, 2, "datetime");//batch insert
			Logger.info(insertArray);


		/*	orders0.setId(1007L);
			orders1.setId(1008L);
			orders2.setId(1009L);
			//		int insertArray2=suidRich.insert(ordersArray,"id,datetime");//batch insert
			int insertArray2 = suidRich.insert(ordersArray, "datetime");//batch insert
			Logger.info(insertArray2);
		
			orders0.setId(10010L);
			orders1.setId(10011L);
			orders2.setId(10012L);
			List<Orders> list = new ArrayList<>();
			list.add(orders0);
			list.add(orders1);
			list.add(orders2);
			int insertList = suidRich.insert(list, "datetime");//batch insert List
			Logger.info(insertList);*/

//			Orders exampleField = new Orders();
//			exampleField.setUserid(0L);
//			//        select some fields
//			List<Orders> selectSomeField = suidRich.select(exampleField, "name,total"); //select Some Field
//			Logger.info(selectSomeField.size() + "");



			
	}

	

}
