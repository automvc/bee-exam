/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.math.BigDecimal;
import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.8
 */
public class InsertTest {
	
	private static SuidRich suidRich=BeeFactory.getHoneyFactory().getSuidRich();
	
	public static SuidRich getSuidRich() {
		return suidRich;
	}
	
	public static void setSuidRich(SuidRich suidRich) {
		InsertTest.suidRich=suidRich;
	}
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {

	  try{
		  
//		SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
		
		Orders orders=new Orders();
		orders.setName("client");
		orders.setUserid("client");
		orders.setRemark("testOneTime");
		orders.setTotal(new BigDecimal("93.99"));
		
//		int insertNum=suidRich.insert(orders);
//		Logger.info(insertNum);
		
		Orders orders1=new Orders();
		orders1.setName("client");
		orders1.setUserid("client");
		orders1.setRemark("testOneTime");
		orders1.setTotal(new BigDecimal("93.99"));
		orders1.setSequence("");  //empty String test
//		orders1.setId(1008L);  //the id already exist in db. test exception
		
		int insertNum1=suidRich.insert(orders);
//		int insertNum1=suidRich.insert(orders1);
		Logger.info(insertNum1);
		
		Orders orders2=new Orders();
		orders2.setName("Bee");
		orders2.setUserid("client");
		orders2.setRemark("testOneTime");
		orders2.setTotal(new BigDecimal("93.99"));
		
		Thread.sleep(2000);
		

		Orders[] ordersArray=new Orders[3];
		ordersArray[0]=orders;
		ordersArray[1]=orders1;
		ordersArray[2]=orders2;
		
//		int insertArray[]=suidRich.insert(ordersArray);//batch insert
//		for (int i = 0; i < insertArray.length; i++) {
//			Logger.info(insertArray[i]+" ,");
//		}
		int insertArray=suidRich.insert(ordersArray);//batch insert
//		int insertArray=suidRich.insert(ordersArray,"id");//batch insert    PostgreSQL
		Logger.info(insertArray);
		
		int insertArray2=suidRich.insert(ordersArray,2);//batch insert
		Logger.info(insertArray2);
		
		List<Orders> list1 = suidRich.select(orders1); //select
		for (int i = 0; i < list1.size(); i++) {
			Logger.info(list1.get(i).toString());
		}
		
	  } catch (BeeException e) {
		  Logger.error("In SuidRichExam (Exception):"+e.getMessage());
		  e.printStackTrace();
	  }catch (Exception e) {
		  Logger.error("In SuidRichExam (Exception):"+e.getMessage());
		  e.printStackTrace();
	  }
		
	}

}
