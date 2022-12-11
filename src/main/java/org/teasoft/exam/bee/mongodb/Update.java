/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.shortcut.BF;


/**
 * @author Kingstar
 * @since  2.0
 */
public class Update {

	public static void main(String[] args) {
		
		SuidRich suidRich = BF.getSuidRich();
		Condition condition = BF.getCondition();
		
		
		condition.setMultiply(Orders_F.num, 2);
		
		Orders orders=new Orders();
		orders.setName("mongodb72");
		
//		int updateNum=suidRich.update(orders, Orders_F.num,condition); //指定只更新num字段
		int updateNum=suidRich.updateBy(orders, Orders_F.name,condition); //指定用name作为过滤条件
		Logger.info("---updateNum: "+ updateNum);
	}

}
