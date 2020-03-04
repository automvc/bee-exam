/*
 * Copyright 2016-2019 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.math.BigDecimal;
import java.util.List;

import org.teasoft.bee.osql.FunctionType;
import org.teasoft.bee.osql.IncludeType;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.exam.bee.osql.entity.User;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.0
 */
public class SuidRichExam {

	public static void main(String[] args) {
		test();
	}

	public static void test() {

		
		SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
		
		Orders orders=new Orders();
		orders.setName("client");
		orders.setUserid("client");
		orders.setRemark("testOneTime");
		orders.setTotal(new BigDecimal("93.99"));
		
		orders.setSequence("");  //empty String test
		
		
		int insertNum1=suidRich.insert(orders,IncludeType.INCLUDE_NULL);
		Logger.info("insert record:"+insertNum1);
		
		int insertNum2=suidRich.insert(orders,IncludeType.INCLUDE_EMPTY);
		Logger.info("insert record:"+insertNum2);
		
		int insertNum3=suidRich.insert(orders,IncludeType.INCLUDE_BOTH);
		Logger.info("insert record:"+insertNum3);
		
		
		int updateNum1=suidRich.update(orders, "name,remark");
		Logger.info("updateNum1:  "+updateNum1);
		
		int updateNum2=suidRich.update(orders, "name");
		Logger.info("updateNum2:  "+updateNum2);
		
//		ObjSQLException: updateFieldList at least include one field.
//		int updateNum3=suidRich.update(orders, "");
//		Logger.info("updateNum3:  "+updateNum3);
		
		int updateNum4=suidRich.update(orders, "name",IncludeType.INCLUDE_EMPTY);
		Logger.info("updateNum4:  "+updateNum4);
		
		int updateNum5=suidRich.update(orders, "name",IncludeType.INCLUDE_NULL);
		Logger.info("updateNum5:  "+updateNum5);
		
		int updateNum6=suidRich.update(orders, "name",IncludeType.INCLUDE_BOTH);
		Logger.info("updateNum6:  "+updateNum6);
		
		int updateNum4_2=suidRich.update(orders, "name,total",IncludeType.INCLUDE_EMPTY);
		Logger.info("updateNum4_2:  "+updateNum4_2);
		
		int updateNum5_2=suidRich.update(orders, "name,total",IncludeType.INCLUDE_NULL);
		Logger.info("updateNum5_2:  "+updateNum5_2);
		
		int updateNum6_2=suidRich.update(orders, "name,total",IncludeType.INCLUDE_BOTH);
		Logger.info("updateNum6_2:  "+updateNum6_2);
		
		//the id field of entity must not be null !
//		int updateNum8_0=suidRich.update(orders,IncludeType.INCLUDE_EMPTY);
//		Logger.info("updateNum8_0:  "+updateNum8_0);
		

		
		
		Orders orders00=new Orders();
		
		orders00.setId(100L);
		orders00.setName("client01");
		orders00.setUserid("client00");
		orders00.setRemark("testOneTime");
		orders00.setTotal(new BigDecimal("93.99"));
		
		orders00.setSequence("");  //empty String test
		
		String funCount=suidRich.selectWithFun(orders, FunctionType.COUNT,"total");
		String funMax=suidRich.selectWithFun(orders, FunctionType.MAX,"total");
		String funMin=suidRich.selectWithFun(orders, FunctionType.MIN,"total");
		String funAvg=suidRich.selectWithFun(orders, FunctionType.AVG,"total");
		String funSum=suidRich.selectWithFun(orders, FunctionType.SUM,"total");
		
		Logger.info("funCount:"+funCount);
		Logger.info("funMax:"+funMax);
		Logger.info("funMin:"+funMin);
		Logger.info("funAvg:"+funAvg);
		Logger.info("funSum:"+funSum);
		
		int insertNum00=suidRich.insert(orders00,IncludeType.INCLUDE_NULL);
		Logger.info("insert record:"+insertNum00);
		
		int updateNum8=suidRich.update(orders00,IncludeType.INCLUDE_EMPTY);
		Logger.info("updateNum8:  "+updateNum8);
		int updateNum9=suidRich.update(orders00,IncludeType.INCLUDE_NULL); //TODO
		Logger.info("updateNum9:  "+updateNum9);
		int updateNum10=suidRich.update(orders00,IncludeType.INCLUDE_BOTH); //TODO
		Logger.info("updateNum10:  "+updateNum10);
		
		
		int deleteNum=suidRich.delete(orders00);
		Logger.info("deleteNum: "+deleteNum);
		
		//test batch insert
		Orders orders0=new Orders();
		orders0.setId(1007L);
		orders0.setUserid("client01");
//		orders0.setName("MVC book");
		orders0.setTotal(new BigDecimal(91));
		orders0.setRemark("testOneTime");
		
		Orders orders1=new Orders();
		orders1.setId(1008L);
		orders1.setUserid("client02");
		orders1.setRemark("testOneTime");
		orders1.setTotal(new BigDecimal(20));
		
		Orders orders2=new Orders();
		orders2.setId(1009L);
		orders2.setUserid("client03");
		orders2.setRemark("testOneTime");
		orders2.setTotal(new BigDecimal(23));

		
		Orders[] ordersArray=new Orders[3];
		ordersArray[0]=orders0;
		ordersArray[1]=orders1;
		ordersArray[2]=orders2;
		
//		int insertArray[]=suidRich.insert(ordersArray,2);
		int insertArray[]=suidRich.insert(ordersArray,2,"id,datetime");//batch insert
		for (int i = 0; i < insertArray.length; i++) {
			Logger.info(insertArray[i]+" ,");
		}
		
		int insertArray2[]=suidRich.insert(ordersArray,"id,datetime");//batch insert
		for (int i = 0; i < insertArray2.length; i++) {
			Logger.info(insertArray2[i]+" ,");
		}
		
		
		Orders exampleField=new Orders();
		exampleField.setUserid("bee");
//        select some fields
		List<Orders> listSome=suidRich.select(exampleField, "name,total");
		Logger.info(listSome.size()+"");
		
		Orders ordersForString=new Orders();
		ordersForString.setUserid("client01");
//		List<String[]> listString=
		suidRich.selectString(ordersForString);
		List<String[]> listString=suidRich.selectString(ordersForString,"id,userid,total,createtime");
		for (String str[]:listString) {
//			String str[]=listString.get(i);
			for (String s:str) {
				Logger.info(s+"  , ");
			}
			Logger.info("");
		}
		

		
		Orders order_more=new Orders();
		order_more.setRemark("testOneTime");
		
		// test paging
		Logger.info("test paging");
		suidRich.select(order_more,3);
		List<Orders> listMore=suidRich.select(order_more,0,3);
		for (int i = 0; i < listMore.size(); i++) {
			Logger.info(listMore.get(i).toString());
		}
		
		
		int deleteNum2=suidRich.delete(order_more);
		Logger.info("deleteNum2: "+deleteNum2);
		

		suidRich.selectById(new User(), "800001,800002");
		suidRich.selectById(new User(), 800001);
		User userTest=suidRich.selectById(new User(), 800001L).get(0);
		
		int deleteNum3=suidRich.deleteById(User.class, 800001);
		Logger.info("deleteNum3: "+deleteNum3);
		
		suidRich.insert(userTest);
		
	}

}
