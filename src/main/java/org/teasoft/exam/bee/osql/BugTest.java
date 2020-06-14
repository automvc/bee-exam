/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.math.BigDecimal;
import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.Suid;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.7.3
 */
public class BugTest {
	public static void main(String[] args) {
		//		TestPrepare.init();
		test();
	}

	public static void test() {

		try {

			Suid suid = BeeFactory.getHoneyFactory().getSuid();
			SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();

//			-------------------v.1.7.2--------start----------  
			Orders orders = new Orders();
			List<Orders> list1 = suid.select(orders); //select
			suid.select(orders); //select
			
			suidRich.selectJson(orders); //bug   缓存有问题. 生成的key有问题.
			
			//test batch insert
			Orders orders0=new Orders();
			orders0.setId(1007L);
			orders0.setUserid("client01");
//			orders0.setName("MVC book");
			orders0.setTotal(new BigDecimal(91));
			orders0.setRemark("testOneTime");
			
			Orders orders1=new Orders();
			orders1.setId(1008L);
			orders1.setUserid("client02");
			orders1.setRemark("testOneTime");
			orders1.setTotal(new BigDecimal(20));
			
			Orders orders2=new Orders();
			orders2.setId(1009L);
			orders2.setUserid("client03");
			orders2.setRemark("testOneTime");
			orders2.setTotal(new BigDecimal(23));

			
			Orders[] ordersArray=new Orders[3];
			ordersArray[0]=orders0;
			ordersArray[1]=orders1;
			ordersArray[2]=orders2;
			
			int insertArray[]=suidRich.insert(ordersArray,2);//不会清缓存.应该要清除  
//			int insertArray[]=suidRich.insert(ordersArray,2,"id,datetime");//batch insert
			for (int i = 0; i < insertArray.length; i++) {
				Logger.info(insertArray[i]+" ,");
			}
			
//			suid.insert(orders0);
			suid.select(orders); //select
			
//			-------------------v.1.7.2--------end----------  
			
		} catch (BeeException e) {
			e.printStackTrace();
			Logger.error("In BugTest (BeeException):"+e.getMessage());
		}catch (Exception e) {
			Logger.error("In BugTest (Exception):"+e.getMessage());
			e.printStackTrace();
		}

	}
}
