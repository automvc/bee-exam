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
 * 条件是多个字段, 要更新的也是多个字段(实体里要更新的,有多个字段,Condition声明要更新的也有多个字段)
 * @author Kingstar
 * @since  2.0
 */
public class Update3 {

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		
		SuidRich suidRich = BF.getSuidRich();
		Condition condition = BF.getCondition();
		
		
		condition.setMultiply(Orders_F.num, 2);
		condition.setMultiply(Orders_F.total, 2); //condition声明要更新超过一个字段
		
		//在实体声明要更新两个字段
		Orders orders=new Orders();
		orders.setName("mongodb72"); //for filter
		orders.setAbc("test bee "); //for filter
		orders.setRemark("changed 1211"); // for update
		orders.setSequence("124"); // for update
		
//		int updateNum=suidRich.update(orders, Orders_F.num,condition); //指定只更新num字段
		int updateNum=suidRich.updateBy(orders,condition, Orders_F.name); //指定用name作为过滤条件
		Logger.info("---updateNum: "+ updateNum);
	}

}
