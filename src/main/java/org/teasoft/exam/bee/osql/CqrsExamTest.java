/*
 * Copyright 2022-2026 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import org.teasoft.bee.osql.FunctionType;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.OrderType;
import org.teasoft.bee.osql.api.cqrs.Command;
import org.teasoft.bee.osql.api.cqrs.Query;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  3.0.0
 */
public class CqrsExamTest {

	private static int a = 1;

	public static void main(String[] args) {
		test();
	}

	public static void test() {

		Query query = BF.getQuery();
		org.teasoft.exam.bee.osql.entity.Orders orders1 = new org.teasoft.exam.bee.osql.entity.Orders();
		query.select(orders1); // select all

		query.select(orders1);
		query.select(orders1, BF.getCondition());

//		Query query=new QueryImpl();
		query.select(orders1, 0, 10);
		query.select(orders1, 10);

		query.select(orders1, "id,name");
		query.select(orders1, 0, 10, "id,name");

		query.selectJson(orders1, "id,name");
		query.selectJson(orders1, 0, 10, "id,name");
		query.selectJson(orders1);
		query.selectJson(orders1, BF.getCondition());

		query.selectString(orders1, "id,name");
		query.selectString(orders1, BF.getCondition());

		query.selectFirst(orders1, BF.getCondition());
		query.selectOne(orders1);

		query.count(orders1);
		query.count(orders1, BF.getCondition());

		orders1.setId(1001L + a);
		query.exist(orders1);

		query.selectString(orders1);
		query.selectOrderBy(orders1, "id");
//		query.selectOrderBy(orders1, "id", {OrderType.DESC,OrderType.ASC});
		query.selectOrderBy(orders1, "id", new OrderType[] { OrderType.ASC });

		query.selectById(org.teasoft.exam.bee.osql.entity.Orders.class, 1001L + a);
		query.selectById(org.teasoft.exam.bee.osql.entity.Orders.class, 1001 + a);
		query.selectById(org.teasoft.exam.bee.osql.entity.Orders.class, 1001 + a + "");
		query.selectByIds(org.teasoft.exam.bee.osql.entity.Orders.class, 1001 + a + "");

		query.selectWithFun(orders1, FunctionType.COUNT, "id");
		query.selectWithFun(orders1, FunctionType.COUNT, "id", BF.getCondition());

		query.getDataSourceName();
		query.getInterceptorChain();

		Command command = BF.getCommand();

		org.teasoft.exam.bee.osql.entity.Orders orders2 = new org.teasoft.exam.bee.osql.entity.Orders();
		orders2.setId(1001L + a);
		a++;
		orders2.setRemark("test for save");
		command.save(orders2);

		orders2.setRemark("update");
		command.update(orders2, "id");
		
		command.update(orders2, BF.getCondition().set("remark", "update2"));
		command.updateBy(orders2, BF.getCondition().op("remark",Op.eq, "update2"),"id");
		
		command.updateBy(orders2, "id");
		
		command.getDataSourceName();
		command.getInterceptorChain();
		
		query.beginSameConnection();
		query.count(orders1);
		query.count(orders1, BF.getCondition());
		query.endSameConnection();
		
		command.beginSameConnection();
		command.updateBy(orders2, "id");
		command.updateBy(orders2, "id");
		command.endSameConnection();

		try {
			command.createTable(Orders.class, false);
		} catch (Exception e) {

		}
		
	}

}
