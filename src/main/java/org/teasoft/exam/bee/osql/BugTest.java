/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.OrderType;
import org.teasoft.bee.osql.PreparedSql;
import org.teasoft.bee.osql.Suid;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.ConditionImpl;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.8
 */
public class BugTest {
	public static void main(String[] args) {
		//		TestPrepare.init();
		test();
	}

	public static void test() {

		try {

			Suid suid = BeeFactory.getHoneyFactory().getSuid();
			SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();

//			-------------------v.1.7.2--------start----------  
			Orders orders = new Orders();
			List<Orders> list1 = suid.select(orders); //select
			suid.select(orders); //select
			
			suidRich.selectJson(orders); //bug   缓存有问题. 生成的key有问题.
			
			//test batch insert
			Orders orders0=new Orders();
			orders0.setId(10010L);
			orders0.setUserid("client01");
//			orders0.setName("MVC book");
			orders0.setTotal(new BigDecimal(91));
			orders0.setRemark("testOneTime");
			
			Orders orders1=new Orders();
			orders1.setId(10011L);
			orders1.setUserid("client02");
			orders1.setRemark("testOneTime");
			orders1.setTotal(new BigDecimal(20));
			
			Orders orders2=new Orders();
			orders2.setId(1012L);
			orders2.setUserid("client03");
			orders2.setRemark("testOneTime");
			orders2.setTotal(new BigDecimal(23));

			
			Orders[] ordersArray=new Orders[3];
			ordersArray[0]=orders0;
			ordersArray[1]=orders1;
			ordersArray[2]=orders2;
			
//			int insertArray[]=suidRich.insert(ordersArray,2);//不会清缓存.应该要清除  
////			int insertArray[]=suidRich.insert(ordersArray,2,"id,datetime");//batch insert
//			for (int i = 0; i < insertArray.length; i++) {
//				Logger.info(insertArray[i]+" ,");
//			}
			int insertArray=suidRich.insert(ordersArray,2);//不会清缓存.应该要清除  
			Logger.info(insertArray);
			
//			suid.insert(orders0);
			suid.select(orders); //select
			
			
			Object obj[]=null;
//			Object obj[]=new Object[] {};
			Map map=null;
			
			PreparedSql pre=BeeFactory.getHoneyFactory().getPreparedSql();
			pre.select("select * from orders", obj);
			pre.select("select * from orders", map);
			
			
			//not bug
			Orders orders_like = new Orders();
			Condition condition_like=new ConditionImpl();
//			condition_like.op("remark", Op.like, "test%"); //not bug
//			condition_like.op("remark", Op.eq, "testx%");
			condition_like.op("remark", Op.like, "test\\%%");  //%转义    [values]: test\%%
//			condition_like.op("remark", Op.like, "test%%"); //不能转义
			
			condition_like.set("test", "test warn"); //Use set method(s) in SELECT type, but it just effect in UPDATE type! Involved field(s):
			
			List<Orders> list_like = suid.select(orders_like,condition_like); //select
			for (int i = 0; list_like!=null && i < list_like.size(); i++) {
				Logger.info(list_like.get(i).toString());
			}
			
//			-------------------v.1.7.2--------end----------  
			
			suidRich.deleteById(Orders.class, 100021);
			suidRich.deleteById(Orders.class, 100022L);
			suidRich.deleteById(Orders.class, "100023"); //bug in V1.9.0.3-20-SNAPSHOT. some database don't support set the string to number field.
			
			//在order by前忘记空格,SQL SERVER 2008报错,但mysql可以 (?占位符的形式).
			Orders testInsertAndDeleteOrders=new Orders();
			testInsertAndDeleteOrders.setRemark("testOneTime");
			List<Orders> list=suidRich.selectOrderBy(testInsertAndDeleteOrders, "id,name", new OrderType[] {OrderType.ASC,OrderType.DESC});
		    Printer.printList(list);
			
		    //V1.9.5
		    suidRich.selectById(new Orders(), 1012);
		    Long id=null;
		    suidRich.selectById(new Orders(), id);
		    
		    //V1.9.8之前  不支持   condition.set("fieldName", null);
			 Orders orders3=new Orders();
			 orders3.setId(1004L);
			 Condition condition3=new ConditionImpl();
			 condition3.op("Total", Op.ge, 90);
			 String new_remark=null;
//			 String new_remark="aaa";
			 condition3.set("remark", new_remark);
//			 case 1 : set("remark",null)   , entity field remark is null
			 suidRich.update(orders3,condition3);  //bug1
			 
			 orders3.setRemark("change Remark");
//			 case 2 : set("remark",null)   , entity field remark has value 
//			 作为更新字段，实体的非空字段默认会解析到where
			 suidRich.update(orders3,condition3);  //bug1
			 
//			 case 3 : set("remark",null)   , entity field remark has value ,也声明了updateFields
			 suidRich.update(orders3,"remark",condition3);  //bug1
			 
			 Condition condition4 =BeeFactory.getHoneyFactory().getCondition();
			 condition4.op("Total", Op.ge, 90);
			 orders3.setRemark(null);
			 new_remark=null;
			 condition4.set("remark", new_remark);
//			 case 4 : set("remark",null)   , entity field remark is null,也声明了updateFields
			 suidRich.update(orders3,"remark",condition4);  //bug1
			 
//			 case 5 :一个字段即在指定的updateFields,但也用了Condition.set(arg1,arg2)等方法设置,entity里相应的字段会按规则转化到where部分.(V1.9.8)
//			 [WARN] The field [remark] which value is 'change Remark', already set in condition! It will be ignored!
			 orders3.setRemark("new2 remark");
			 suidRich.update(orders3,"remark,Total",condition3); //bug2
			 
			 Orders orders5=new Orders();
			 orders5.setId(1004L);
			 suidRich.update(orders5,"remark");
			 
			 Orders orders6=new Orders();
			 orders6.setId(1004L);
			 orders6.setRemark("change Remark");
			 suidRich.updateBy(orders6,"id");
			 
			 
			 Condition condition7 =BeeFactory.getHoneyFactory().getCondition();
			 condition7.op("Total", Op.ge, 90);
			 new_remark=null;
			 condition7.set("remark", new_remark);
			 condition7.op("remark", Op.ge,"old remark");
			 Orders orders7=new Orders();
//			 orders7.setId(1004L);
			 
//			 orders7.setRemark("change Remark");
			 suidRich.updateBy(orders7,"remark",condition7);
			
		} catch (BeeException e) {
			e.printStackTrace();
			Logger.error("In BugTest (BeeException):"+e.getMessage());
		}catch (Exception e) {
			Logger.error("In BugTest (Exception):"+e.getMessage());
			e.printStackTrace();
		}

	}
}
