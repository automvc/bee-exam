/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb;

import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.mongodb.entity.Orders;
import org.teasoft.exam.bee.mongodb.entity.Orders_F;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.shortcut.BF;


/**
 * @author Kingstar
 * @since  2.0
 */
public class Update_All {

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		
		SuidRich suidRich = BF.getSuidRich();
		Condition condition = BF.getCondition();
		
		
		condition.setMultiply(Orders_F.num, 2);
		
		Orders orders=new Orders();
//		orders.setName("mongodb72");
		orders.setRemark("test update all-2");
		
		int updateNum=suidRich.update(orders, Orders_F.remark); 
//		int updateNum=suidRich.updateBy(orders, Orders_F.name,condition); //指定用name作为过滤条件
		Logger.info("---updateNum: "+ updateNum);
	}

}
