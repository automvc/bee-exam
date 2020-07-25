/*
 * Copyright 2016-2019 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.math.BigDecimal;
import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.OrderType;
import org.teasoft.bee.osql.Suid;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.ConditionImpl;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.6
 */
public class ConditionExam {
	
	public static void main(String[] args) {
		test();
	}
	public static void test() {
       try{
		Suid suid = BeeFactory.getHoneyFactory().getSuid();
		Orders orders = new Orders();
		
		orders.setName("Bee(ORM Framework)"); //等于的条件,会默认转换
		orders.setTotal(new BigDecimal("100"));  //不会再处理.因为between已有用
		
		 Condition condition=new ConditionImpl();
		 condition
		 .op("userid", Op.like, "bee%") //模糊查询
		 .between("total", 90, 100)     //范围查询
//		 .between("createtime","2020-03-01","2020-03-03")
		 .orderBy("userid",OrderType.ASC) //排序
		 .start(0).size(10)              //分页
		 ;
		 
//       测试顺序异常
//		 condition
//		 .orderBy("name")
//		 .groupBy("userid") 
//		 ;
		 
//		long start=System.currentTimeMillis();
//		for (int k = 0; k < 10000; k++) {
		List<Orders> list2 = suid.select(orders, condition);
		for (int i = 0; i < list2.size(); i++) {
			Logger.info(list2.get(i).toString());
		}
//		}
//		long end=System.currentTimeMillis();
//		System.out.println("--------------------------------");
//		System.out.println(end-start);
		
		condition.selectField("userid,total,createtime");//只查询部分字段
//		
		List<Orders> list3 = suid.select(orders, condition);
		for (int i = 0; i < list3.size(); i++) {
			Logger.info(list3.get(i).toString());
		}
		
		//insert 2 records
		Orders orders1 = new Orders();
		orders1.setUserid("test condition");
		orders1.setRemark("test condition delete");
		orders1.setTotal(new BigDecimal("0.01"));
		suid.insert(orders1);
		Orders orders2 = new Orders();
		orders2.setUserid("test condition");
		orders2.setRemark("test condition delete");
		orders2.setTotal(new BigDecimal("0.01"));
		suid.insert(orders2);
		
		Condition conditionDel=new ConditionImpl();
		conditionDel
		.op("remark", Op.like, "test condition %")
		.op("Total", Op.le, "0.01")
//		.groupBy("userid")  //DELETE do not support the opType: groupBy!
//		.orderBy("name")
		;
		
		Orders ordersDel = new Orders();
		ordersDel.setUserid("test condition");
		int delNum=suid.delete(ordersDel, conditionDel);
		
//		test bee.osql.donot.allowed.deleteWholeRecords=true
//		Condition emptyCondition=new ConditionImpl();
////		emptyCondition.size(1);
//		Orders ordersDel = new Orders();
//		int delNum=suid.delete(ordersDel, emptyCondition);
		Logger.info("delete(T entity,Condition condition), delete record num:"+delNum);
		
		
		SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
		Orders Orders_update=new Orders();
		Orders_update.setRemark("test");
		Orders_update.setAbc("test for update");
		Condition conditionUpdate=new ConditionImpl();
		conditionUpdate
		.op("Total", Op.ge, "97")
		.op("remark", Op.like, "test%") //当condition设置有remark:1)updateBy指定remark为where条件时,实体的remark设置会无效;
		;                                //2)当update指定remark为需要更新的字段时,实体的remark设置的值为需要更新的值,而condition中设置remark的值会转化为SQL中where的条件
		
		int updateBy_NumByCondition=suidRich.updateBy(Orders_update, "remark", conditionUpdate);//point to where field
		Logger.info("updateBy_NumByCondition: "+updateBy_NumByCondition);
		
		
		Orders_update.setRemark("test for set");
		int updateNumCondition=suidRich.update(Orders_update, "remark", conditionUpdate); //point to set field
		Logger.info("updateNumCondition: "+updateNumCondition);
		
		
		} catch (BeeException e) {
			Logger.error("In ConditionExam (BeeException):"+e.getMessage());
			e.printStackTrace();
		}catch (Exception e) {
			Logger.error("In ConditionExam (Exception):"+e.getMessage());
			e.printStackTrace();
		}
	}
}
