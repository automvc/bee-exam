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
import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.FunctionType;
import org.teasoft.bee.osql.IncludeType;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.OrderType;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.osql.entity.LeafAlloc;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.exam.bee.osql.entity.TestUser;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.ConditionImpl;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.0
 */
public class SuidRichExam {
	
	private static SuidRich suidRich=BeeFactory.getHoneyFactory().getSuidRich();
	
	public static SuidRich getSuidRich() {
		return suidRich;
	}
	
	public static void setSuidRich(SuidRich suidRich) {
		SuidRichExam.suidRich=suidRich;
	}

	public static void main(String[] args) {
		test();
	}

	public static void test() {

	  try{
		
		Orders orders=new Orders();
		orders.setName("client");
		orders.setUserid("client");
		orders.setRemark("testOneTime");
		orders.setTotal(new BigDecimal("93.99"));
		
		orders.setSequence("");  //empty String test
		
		int insertNum0=suidRich.insert(orders);
		Logger.info("insert record:"+insertNum0);
		
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
		int updateNum9=suidRich.update(orders00,IncludeType.INCLUDE_NULL); 
		Logger.info("updateNum9:  "+updateNum9);
		int updateNum10=suidRich.update(orders00,IncludeType.INCLUDE_BOTH); 
		Logger.info("updateNum10:  "+updateNum10);
		
//		//update默认主键为id时,无id字段或id为null异常处理. 
//		orders00.setId(null); 
//		int updateNum11=suidRich.update(orders00,IncludeType.INCLUDE_NULL);
//		Logger.info("updateNum11:  "+updateNum11);
//		int updateNum12=suidRich.update(orders00,IncludeType.INCLUDE_EMPTY);
//		Logger.info("updateNum12:  "+updateNum12);
		
		int deleteNum=suidRich.delete(orders00);
		Logger.info("deleteNum: "+deleteNum);
		
		//test batch insert
		Orders orders0=new Orders();
		orders0.setId(1004L);
		orders0.setUserid("client01");
//		orders0.setName("MVC book");
		orders0.setTotal(new BigDecimal(91));
		orders0.setRemark("testOneTime");
		
		Orders orders1=new Orders();
		orders1.setId(1005L);
		orders1.setUserid("client02");
		orders1.setRemark("testOneTime");
		orders1.setTotal(new BigDecimal(20));
		
		Orders orders2=new Orders();
		orders2.setId(1006L);
		orders2.setUserid("client03");
		orders2.setRemark("testOneTime");
		orders2.setTotal(new BigDecimal(23));

		
		Orders[] ordersArray=new Orders[3];
		ordersArray[0]=orders0;
		ordersArray[1]=orders1;
		ordersArray[2]=orders2;
		
////		int insertArray[]=suidRich.insert(ordersArray,2);
//		int insertArray[]=suidRich.insert(ordersArray,2,"id,datetime");//batch insert
//		for (int i = 0; i < insertArray.length; i++) {
//			Logger.info(insertArray[i]+" ,");
//		}
		
//		int insertArray=suidRich.insert(ordersArray,2,"id,datetime");//batch insert
		int insertArray=suidRich.insert(ordersArray,2,"datetime");//batch insert
		Logger.info(insertArray);
		
		
//		int insertArray2[]=suidRich.insert(ordersArray,"id,datetime");//batch insert
//		for (int i = 0; i < insertArray2.length; i++) {
//			Logger.info(insertArray2[i]+" ,");
//		}
		
		orders0.setId(1007L);
		orders1.setId(1008L);
		orders2.setId(1009L);
//		int insertArray2=suidRich.insert(ordersArray,"id,datetime");//batch insert
		int insertArray2=suidRich.insert(ordersArray,"datetime");//batch insert
		Logger.info(insertArray2);
		
		orders0.setId(10010L);
		orders1.setId(10011L);
		orders2.setId(10012L);
		List<Orders> list=new ArrayList<>();
		list.add(orders0);
		list.add(orders1);
		list.add(orders2);
		int insertList=suidRich.insert(list,"datetime");//batch insert List
		Logger.info(insertList);
				
		Orders exampleField=new Orders();
		exampleField.setUserid("bee");
//        select some fields
		List<Orders> listSome=suidRich.select(exampleField, "name,total");
		Logger.info(listSome.size()+"");
		
		LeafAlloc leafAlloc=new LeafAlloc();
		suidRich.select(leafAlloc, "maxId");  //check the selectFields
		
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
//		List<Orders> listMore=suidRich.select(order_more,1,5);
		for (int i = 0; i < listMore.size(); i++) {
			Logger.info(listMore.get(i).toString());
		}
		
		
//		int deleteNum2=suidRich.delete(order_more);   // bug : Lock wait timeout exceeded;
//		Logger.info("deleteNum2: "+deleteNum2);
		

		List<TestUser> listSelectByIds=suidRich.selectByIds(new TestUser(), "800001,800002");  //PostgreSQL 是强类型,不能这种用
		for (int i = 0; i < listSelectByIds.size(); i++) {
			Logger.info(listSelectByIds.get(i).toString());
			Logger.info("=============================================");
		}
		
		TestUser testUser1=suidRich.selectById(new TestUser(), 800001);
		Logger.info(testUser1.toString());
		
		TestUser testUser2=suidRich.selectById(new TestUser(), 800001L);
		
		TestUser testUser3=suidRich.selectById(new TestUser(), "800001");
		Logger.info(testUser3.toString());
//		test Exception
//		TestUser testUser3=suidRich.selectById(new TestUser(), "800001,800001");
//		Logger.info(testUser3.toString());

		int deleteNum3=suidRich.deleteById(TestUser.class, 800001);
		Logger.info("deleteNum3: "+deleteNum3);
		
		suidRich.insert(testUser2);
		
		String json=suidRich.selectJson(new TestUser());
		Logger.info("selectJson(new User()):");
		Logger.info(json);
		
		
		Orders orders18=new Orders();
		orders18.setId(100018L);
		orders18.setUserid("client18");
		orders18.setRemark("test insert and delete");
		orders18.setTotal(new BigDecimal("18.18"));
		
		Orders orders19=new Orders();
		orders19.setId(100019L);
		orders19.setUserid("client19");
		orders19.setRemark("test insert and delete");
		orders19.setTotal(new BigDecimal("19.19"));
		
		Orders orders20=new Orders();
		orders20.setId(100020L);
		orders20.setUserid("client20");
		orders20.setRemark("test insert and delete");
		orders20.setTotal(new BigDecimal("20.20"));
		List<Orders> list1820=new ArrayList<>();
		list1820.add(orders18);
		list1820.add(orders19);
		list1820.add(orders20);
		suidRich.insert(list1820, 2);
		
		Orders testInsertAndDeleteOrders=new Orders();
		testInsertAndDeleteOrders.setRemark("test insert and delete");
		suidRich.delete(testInsertAndDeleteOrders, IncludeType.EXCLUDE_BOTH);
		suidRich.insert(list1820);
		
		orders18.setId(100018+3L);
		orders19.setId(100019+3L);
		orders20.setId(100020+3L);
		suidRich.insert(list1820, 3,"remark"); // donot insert remark field.
		

		suidRich.count(testInsertAndDeleteOrders);
		suidRich.select(testInsertAndDeleteOrders, IncludeType.EXCLUDE_BOTH);
		suidRich.selectJson(testInsertAndDeleteOrders, IncludeType.EXCLUDE_BOTH);
		Condition testInsertAndDeleteConditon=new ConditionImpl();
		testInsertAndDeleteConditon.op("id", Op.ge, 100018);
		suidRich.select(testInsertAndDeleteOrders, IncludeType.EXCLUDE_BOTH,testInsertAndDeleteConditon);
		suidRich.selectJson(testInsertAndDeleteOrders, IncludeType.EXCLUDE_BOTH,testInsertAndDeleteConditon);
		suidRich.select(testInsertAndDeleteOrders,testInsertAndDeleteConditon);
		suidRich.selectJson(testInsertAndDeleteOrders,testInsertAndDeleteConditon);
		suidRich.count(testInsertAndDeleteOrders,testInsertAndDeleteConditon);
		suidRich.selectOrderBy(testInsertAndDeleteOrders, "id");
		suidRich.selectOrderBy(testInsertAndDeleteOrders, "id,name", new OrderType[] {OrderType.ASC,OrderType.DESC});
		
		testInsertAndDeleteOrders.setId(100021L);
		suidRich.selectOne(testInsertAndDeleteOrders);
		suidRich.selectString(testInsertAndDeleteOrders,testInsertAndDeleteConditon);
		suidRich.select(testInsertAndDeleteOrders, "id,Remark,userid", 0, 10);
		suidRich.selectWithFun(testInsertAndDeleteOrders, FunctionType.MAX, "total", testInsertAndDeleteConditon);
		suidRich.updateById(testInsertAndDeleteOrders,testInsertAndDeleteConditon);
		
		suidRich.delete(testInsertAndDeleteOrders, IncludeType.EXCLUDE_BOTH);
		suidRich.delete(testInsertAndDeleteOrders,testInsertAndDeleteConditon);
		suidRich.deleteById(Orders.class, 100021);
		suidRich.deleteById(Orders.class, 100022L);
		suidRich.deleteById(Orders.class, "100023");
		
	  } catch (BeeException e) {
		  Logger.error("In SuidRichExam (Exception):"+e.getMessage());
		  e.printStackTrace();
	  }catch (Exception e) {
		  Logger.error("In SuidRichExam (Exception):"+e.getMessage());
		  e.printStackTrace();
	  }
		
	}

}
