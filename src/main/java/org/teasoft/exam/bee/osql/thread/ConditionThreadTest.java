/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.thread;

import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.Suid;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.ConditionImpl;

/**
 * @author Kingstar
 * @since  1.9.8
 */
public class ConditionThreadTest extends Thread {
	Suid suid = BeeFactory.getHoneyFactory().getSuid();
	
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			query();
		}
	}
	
	public void query() {
		try {
			
			Orders orders = new Orders();

			orders.setName("Bee(ORM Framework)"); //等于的条件,会默认转换
			orders.setAbc("test1");

			Condition condition = new ConditionImpl();
			condition
			.op("userid", Op.in, "Bee,Bee2")
			.op("createtime", Op.ge, "2020-03-01")
            .op("createtime", Op.le, "2020-03-03");

			List<Orders> list1 = suid.select(orders, condition);

		} catch (BeeException e) {
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

}
