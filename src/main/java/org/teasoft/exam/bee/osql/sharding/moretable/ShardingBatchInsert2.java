/*
 * Copyright 2016-2019 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.sharding.moretable;

import java.math.BigDecimal;

import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.osql.sharding.InitSameDsUtil;
import org.teasoft.exam.bee.osql.sharding.ShardingInitData;
import org.teasoft.exam.bee.osql.sharding.moretable.entity.Myorders;
import org.teasoft.exam.bee.osql.sharding.moretable.entity.Ordersdetail;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.Logger;

/**
 * 批量插入的分片
 * @author Kingstar
 * @since  2.0
 */
public class ShardingBatchInsert2 {

	private static SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();

	public static void main(String[] args) {

		ShardingInitData.init(); // 分片
		InitSameDsUtil.initDS();

		test();
	}

	public static void test() {
		
		int SIZE=20;

		Myorders[] ordersArray = new Myorders[SIZE];
		Ordersdetail[] OrdersdetailArray = new Ordersdetail[SIZE*2];
		for (int i = 0; i < SIZE; i++) {
			Myorders orders = new Myorders();
			orders.setUserid((long) i);
			orders.setOrderid((long) i);
			orders.setTotal(new BigDecimal(91 + i));
			orders.setRemark("testOneTime" + i);
			ordersArray[i] = orders;
			
			Ordersdetail ordersdetail=new Ordersdetail();
			ordersdetail.setUserid((long) i);
			ordersdetail.setOrderid((long) i);
			ordersdetail.setItem((long) i*2);
			ordersdetail.setRemark("分片测试"+i*2);
			OrdersdetailArray[i*2]=ordersdetail;
			
			Ordersdetail ordersdetail2=new Ordersdetail();
			ordersdetail2.setUserid((long) i);
			ordersdetail2.setOrderid((long) i);
			ordersdetail2.setItem((long) (i*2+1));
			ordersdetail2.setRemark("分片测试"+(i*2+1));
			OrdersdetailArray[i*2+1]=ordersdetail2;
		}
//		int insertArray = suidRich.insert(ordersArray, 3, "id,createtime,updatetime");// batch insert
//		Logger.info(insertArray);
		
		int insertArray2 = suidRich.insert(OrdersdetailArray, 3, "id");// batch insert
		Logger.info(insertArray2);
	
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
