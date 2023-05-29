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
 * update, value of set part use NewEntity
 * @author Kingstar
 * @since  2.0
 */
public class Update_NewOld {

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		
		SuidRich suidRich = BF.getSuidRich();
		
		Orders oldOrders=new Orders();
		oldOrders.setId(759217816338436L);
		oldOrders.setRemark("testOneTime");
		oldOrders.setName("client");
		
		Orders newOrders=new Orders();
//		newOrders.setId(759217816338436L);
		newOrders.setRemark("testOneTime-update by old new");
		
		int updateNum=suidRich.update(oldOrders, newOrders); 
		Logger.info("---updateNum: "+ updateNum);
	}

}
