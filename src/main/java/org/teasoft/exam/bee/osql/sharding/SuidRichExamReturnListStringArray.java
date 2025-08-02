/*
 * Copyright 2016-2019 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.sharding;

import java.util.List;

import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.osql.sharding.entity.Orders;
import org.teasoft.exam.bee.osql.sharding.entity.Orders_F;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.BeeFactoryHelper;
import org.teasoft.honey.osql.core.ConditionImpl;

/**
 * 返回值是List<String[]>的查询的分片
 * @author Kingstar
 * @since  2.0
 */
public class SuidRichExamReturnListStringArray {

	private static SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();

	public static SuidRich getSuidRich() {
		return suidRich;
	}

	public static void setSuidRich(SuidRich suidRich) {
		SuidRichExamReturnListStringArray.suidRich = suidRich;
	}

	public static void main(String[] args) {
		ShardingInitData.init();
		InitSameDsUtil.initDS();
		test();
	}

	public static void test() {
		System.out.println("------Sharding test--------SuidRichExamReturnListStringArray-----");
//		try {

//			//test batch insert
//			Orders orders0 = new Orders();
//			orders0.setId(1004L);
//			orders0.setUserid(0L);
//			//		orders0.setName("MVC book");
//			orders0.setTotal(new BigDecimal(91));
//			orders0.setRemark("testOneTime");
//
//			Orders orders1 = new Orders();
//			orders1.setId(1005L);
//			orders1.setUserid(0L);
//			orders1.setRemark("testOneTime");
//			orders1.setTotal(new BigDecimal(20));
//
//			Orders orders2 = new Orders();
//			orders2.setId(1006L);
//			orders2.setUserid(0L);
//			orders2.setRemark("testOneTime");
//			orders2.setTotal(new BigDecimal(23));
//
//			Orders[] ordersArray = new Orders[3];
//			ordersArray[0] = orders0;
//			ordersArray[1] = orders1;
//			ordersArray[2] = orders2;
//
//			int insertArray = suidRich.insert(ordersArray, 2, "datetime");//batch insert
//			Logger.info(insertArray);
//
//
//			orders0.setId(1007L);
//			orders1.setId(1008L);
//			orders2.setId(1009L);
//			//		int insertArray2=suidRich.insert(ordersArray,"id,datetime");//batch insert
//			int insertArray2 = suidRich.insert(ordersArray, "datetime");//batch insert
//			Logger.info(insertArray2);
//
//			orders0.setId(10010L);
//			orders1.setId(10011L);
//			orders2.setId(10012L);
//			List<Orders> list = new ArrayList<>();
//			list.add(orders0);
//			list.add(orders1);
//			list.add(orders2);
//			int insertList = suidRich.insert(list, "datetime");//batch insert List
//			Logger.info(insertList);
//
//			Orders exampleField = new Orders();
//			exampleField.setUserid(0L);
//			//        select some fields
//			List<Orders> selectSomeField = suidRich.select(exampleField, "name,total"); //select Some Field
//			Logger.info(selectSomeField.size() + "");



			Orders ordersForString = new Orders();
//			ordersForString.setUserid(0L);
			ordersForString.setOrderid(0L);
			
//			suidRich.selectString(ordersForString);
//			List<String[]> listString = suidRich.selectString(ordersForString, "id,userid,total,createtime");
//			for (String str[] : listString) {
//				for (String s : str) {
//					System.out.print(s + "  , ");
//				}
//				Logger.info("");
//			}
			
			
			
			
			Condition conditon = new ConditionImpl();
			conditon.op("id", Op.ge, 100018);
			suidRich.selectString(ordersForString, conditon);
			
			Condition conditon2 = new ConditionImpl();
			conditon2
			.op(Orders_F.orderid, Op.eq, 6)
			.or()
			.op(Orders_F.orderid, Op.eq, 2)
			;
			
//			suidRich.selectString(ordersForString, conditon2);

			Condition distinctCondition0=BeeFactoryHelper.getCondition();
			distinctCondition0.selectDistinctField("userid");
			suidRich.selectString(new Orders(), distinctCondition0);
			
			Condition distinctCondition=BeeFactoryHelper.getCondition();
			distinctCondition.selectDistinctField("userid","uniqueUserid");
			distinctCondition.op("name", Op.nq, null);
			List<String[]> userid=suidRich.selectString(new Orders(), distinctCondition);
			Logger.info("=============================");
			Printer.print(userid);
			
	}

	

}
