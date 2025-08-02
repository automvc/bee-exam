/*
 * Copyright 2016-2019 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.FunctionType;
import org.teasoft.bee.osql.IncludeType;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.OrderType;
import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.SuidRich;
//import org.teasoft.exam.bee.osql.entity.LeafAlloc;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.exam.bee.osql.entity.Orders_F;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.BeeFactoryHelper;
import org.teasoft.honey.osql.core.ConditionImpl;
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.core.HoneyUtil;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  1.0
 */
public class SuidRichExam_bug {

	private static SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();

	public static SuidRich getSuidRich() {
		return suidRich;
	}

	public static void setSuidRich(SuidRich suidRich) {
		SuidRichExam_bug.suidRich = suidRich;
	}

	public static void main(String[] args) {
		test();
	}

	public static void test() {

		/*Orders orders00 = new Orders();
		
		orders00.setId(100L);
		orders00.setName("client01");
		orders00.setUserid("client00");
		orders00.setRemark("testOneTime");
		orders00.setTotal(new BigDecimal("93.99"));
		
		orders00.setSequence(""); //empty String test
		
		
		//作为过滤条件,转换时,id要改为_id;
		int insertNum00 = suidRich.insert(orders00, IncludeType.INCLUDE_NULL);
		Logger.info("insert record:" + insertNum00);
		
		int updateNum8 = suidRich.update(orders00, IncludeType.INCLUDE_EMPTY);
		Logger.info("updateNum8:  " + updateNum8);
		int updateNum9 = suidRich.update(orders00, IncludeType.INCLUDE_NULL);
		Logger.info("updateNum9:  " + updateNum9);
		int updateNum10 = suidRich.update(orders00, IncludeType.INCLUDE_BOTH);
		Logger.info("updateNum10:  " + updateNum10);
		
		
		
		 Orders orders=new Orders();
		 orders.setUserid("bee");
		 orders.setRemark("new2");
		 orders.setTotal(new BigDecimal("100"));
		 orders.setSequence("");
		 
		 int updateNum0=suidRich.updateBy(orders, "userid");
		 Logger.info("update number:  "+updateNum0);
		 
		 Logger.info("IncludeType.INCLUDE_BOTH");
		 //设置时,_id不能为空
		 int updateNum=suidRich.updateBy(orders, IncludeType.INCLUDE_BOTH, "userid,name");
		 Logger.info("update number:  "+updateNum);
		 
		 Orders testInsertAndDeleteOrders = new Orders();
		testInsertAndDeleteOrders.setRemark("test insert and delete");
		//			List<Orders> listOrders=suidRich.selectOrderBy(testInsertAndDeleteOrders, "userid,id");
		List<Orders> listOrders=suidRich.selectOrderBy(testInsertAndDeleteOrders, "id,name");
		Printer.printList(listOrders);	
		
		
		listOrders=suidRich.selectOrderBy(testInsertAndDeleteOrders, "id,name", new OrderType[] { OrderType.ASC, OrderType.DESC });
		Printer.printList(listOrders);	*/
			
		Orders orders2 = new Orders();
		orders2.setRemark("test insert and delete");
		Condition condition2 = new ConditionImpl();
		condition2.op("id", Op.ge, 100018);
		suidRich.updateById(orders2, condition2);

	}

}
