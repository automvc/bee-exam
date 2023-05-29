/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb;

import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.mongodb.entity.Orders;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  2.0
 */
public class Delete {

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		SuidRich suidRich = BF.getSuidRich();
		
		Orders orders=new Orders();
		orders.setRemark("changed 12112");
//		json=suidRich.selectJson(orders, c);  //test cache
//		System.out.println(json);
		
		System.out.println("finished!");
		
		int delNum = suidRich.delete(orders);
		Logger.info("delNum:" + delNum);
		
//		orders=new Orders();
//		orders.setId(null);
		 delNum = suidRich.deleteById(Orders.class, 10278);
		Logger.info("delNum (by id):" + delNum);
		
		
	}

}
