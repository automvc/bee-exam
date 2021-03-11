/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.math.BigDecimal;
import java.util.List;

import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.Logger;

//v1.8.99之前会有问题 
//在SqlLib:
//bug :Lock wait timeout exceeded; 
//如果分批处理时有异常,如主键冲突,则又没有提交,就关不了连接.
//所以需要先将提交改回原来的状态.
//要是原来就是自动提交,报异常,还是不能关

/**
 * @author Kingstar
 * @since  1.9
 */
public class LockWaitTimeout {
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		
		SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
		
		//test batch insert
		Orders orders0=new Orders();
		orders0.setId(1004L);
		orders0.setUserid("client01");
//		orders0.setName("MVC book");
		orders0.setTotal(new BigDecimal(91));
		orders0.setRemark("testOneTime");
		
		Orders orders1=new Orders();
		orders1.setId(1005L);
		orders1.setUserid("client02");
		orders1.setRemark("testOneTime");
		orders1.setTotal(new BigDecimal(20));
		
		Orders orders2=new Orders();
		orders2.setId(1006L);
		orders2.setUserid("client03");
		orders2.setRemark("testOneTime");
		orders2.setTotal(new BigDecimal(23));
		
		Orders[] ordersArray=new Orders[3];
		ordersArray[0]=orders0;
		ordersArray[1]=orders1;
		ordersArray[2]=orders2;
		
////		int insertArray[]=suidRich.insert(ordersArray,2);
//		int insertArray[]=suidRich.insert(ordersArray,2,"id,datetime");//batch insert
//		for (int i = 0; i < insertArray.length; i++) {
//			Logger.info(insertArray[i]+" ,");
//		}
		
//		int insertArray=suidRich.insert(ordersArray,2,"id,datetime");//batch insert
		int insertArray=suidRich.insert(ordersArray,2,"datetime");//batch insert
		Logger.info(insertArray);
		
		
		Orders order_more=new Orders();
		order_more.setRemark("testOneTime");
		
		// test paging
		Logger.info("test paging");
		suidRich.select(order_more,3);
		List<Orders> listMore=suidRich.select(order_more,0,3);
//		List<Orders> listMore=suidRich.select(order_more,1,5);
		for (int i = 0; i < listMore.size(); i++) {
			Logger.info(listMore.get(i).toString());
		}
		
		int deleteNum2=suidRich.delete(order_more);
		Logger.info("deleteNum2: "+deleteNum2);
	}

}
