/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.osql.core.BeeFactoryHelper;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.8
 */
public class InsertTest {

	private static SuidRich suidRich = BeeFactoryHelper.getSuidRich();

	public static SuidRich getSuidRich() {
		return suidRich;
	}

	public static void setSuidRich(SuidRich suidRich) {
		InsertTest.suidRich = suidRich;
	}

	public static void main(String[] args) {
		test();
	}

	public static void test() {

		try {

			Orders orders = new Orders();
			orders.setName("client");
			orders.setUserid("client");
			orders.setRemark("testOneTime");
			orders.setTotal(new BigDecimal("93.99"));
			//		orders.setId(1L);

			int insertNum = suidRich.insert(orders);
			Logger.info(insertNum);

			Orders orders1 = new Orders();
			orders1.setName("client");
			orders1.setUserid("client");
			orders1.setRemark("testOneTime");
			orders1.setTotal(new BigDecimal("94.99"));
			orders1.setSequence(""); //empty String test
			//		orders1.setId(1008L);  //the id already exist in db. test exception

			int insertNum1 = suidRich.insert(orders);
			//		int insertNum1=suidRich.insert(orders1);
			Logger.info(insertNum1);

			Orders orders2 = new Orders();
			orders2.setName("Bee");
			orders2.setUserid("client");
			orders2.setRemark("testOneTime");
			orders2.setTotal(new BigDecimal("95.99"));

			Thread.sleep(2000);

			Orders[] ordersArray = new Orders[3];
			ordersArray[0] = orders;
			//		orders.setId(102L);
			ordersArray[1] = orders1;
			ordersArray[2] = orders2;

			//		int insertArray[]=suidRich.insert(ordersArray);//batch insert
			//		for (int i = 0; i < insertArray.length; i++) {
			//			Logger.info(insertArray[i]+" ,");
			//		}
			int insertArray = suidRich.insert(ordersArray);//batch insert
			//		int insertArray=suidRich.insert(ordersArray,"id");//batch insert    PostgreSQL
			Logger.info(insertArray);

			int insertArray2 = suidRich.insert(ordersArray, 2);//batch insert
			Logger.info(insertArray2);

			List<Orders> list1 = suidRich.select(orders1); //select
			for (int i = 0; i < list1.size(); i++) {
				Logger.info(list1.get(i).toString());
			}

			Orders[] ordersArray2 = new Orders[1];
			ordersArray2[0] = orders;
			suidRich.insert(ordersArray2);

			List<Orders> list = new ArrayList<>();
			list.add(orders);
			list.add(orders1);
			list.add(orders2);

			int insertArray3 = suidRich.insert(list, 1);//batch insert
			Logger.info("insertArray3's size : " + insertArray3);

			Orders orders3 = new Orders();
			orders3.setUserid("orders3");
			Orders orders4 = new Orders();
			orders4.setUserid("orders4");
			list.add(orders3);
			list.add(orders4);
			Logger.info("-------------------------------");
			int insertArray5 = suidRich.insert(list, 2);//batch insert
			Logger.info("insertArray5's size : " + insertArray5);

		} catch (BeeException e) {
			Logger.error("In InsertTest (Exception):" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			Logger.error("In InsertTest (Exception):" + e.getMessage());
			e.printStackTrace();
		}

	}

}
