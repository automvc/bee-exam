/*
 * Copyright 2016-2019 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.FunctionType;
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
	
	private static SuidRich suidRich=BeeFactory.getHoneyFactory().getSuidRich();
	
	public static SuidRich getSuidRich() {
		return suidRich;
	}
	
	public static void setSuidRich(SuidRich suidRich) {
		ConditionExam.suidRich=suidRich;
	}
	
	public static void main(String[] args) {
		test();
	}
	public static void test() {
       try{
		Suid suid = BeeFactory.getHoneyFactory().getSuid();
		Orders orders = new Orders();
		
		SimpleDateFormat defaultFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		orders.setName("Bee(ORM Framework)"); //等于的条件,会默认转换
		orders.setTotal(new BigDecimal("100"));  //不会再处理.因为between已有用
		
		 Condition condition=new ConditionImpl();
		 condition
//		 .op("1=1 -- userid", Op.like, "bee%") // test invalid field
		 .op("userid", Op.like, "bee%") //模糊查询
//		 .set("userid", 2)
		 .between("total", 90, 100)     //范围查询
		 .op("name", Op.nq, null)     //is not null
//		 .between("createtime","2020-03-01","2020-03-03")
//		 .between("createtime",DateUtil.currentDate(),DateUtil.currentDate())
//		 .between("createtime",new Date(),new Date())
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
//		Logger.info("--------------------------------");
//		Logger.info(end-start);
		
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
		.op("Total", Op.le, 0.01)
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
		
		
//		SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
		Orders Orders_update=new Orders();
		Orders_update.setRemark("test");
		Orders_update.setAbc("test for update");
		Condition conditionUpdate=new ConditionImpl();
		conditionUpdate
		.op("Total", Op.ge, 97)
		.op("remark", Op.like, "test%") //当condition设置有remark:1)updateBy指定remark为where条件时,实体的remark设置会无效;
		;                                //2)当update指定remark为需要更新的字段时,实体的remark设置的值为需要更新的值,而condition中设置remark的值会转化为SQL中where的条件
		
		int updateBy_NumByCondition=suidRich.updateBy(Orders_update, "remark", conditionUpdate);//point to where field
		Logger.info("updateBy_NumByCondition: "+updateBy_NumByCondition);
		
		
		Orders_update.setRemark("test for set");
		conditionUpdate.setAdd("total", 1);  //不受updateFields声明的set字段限制
		int updateNumCondition=suidRich.update(Orders_update, "remark", conditionUpdate); //point to set field
		Logger.info("updateNumCondition: "+updateNumCondition);
		
		
			Orders orders11 = new Orders();

			orders11.setUserid("bee");

			Condition condition_add_forUpdate = new ConditionImpl();
			condition_add_forUpdate.op("id", Op.eq, 100003).forUpdate(); // 用for update锁住某行记录    一般用于事务中
			List<Orders> list11 = suid.select(orders11, condition_add_forUpdate);
			for (int i = 0; i < list11.size(); i++) {
				Logger.info(list11.get(i).toString());
			}
			
			
			 //V1.9
			 //group by userid having count(userid)>=?
			 Condition conditionHaving=new ConditionImpl();
			 conditionHaving.selectField("userid");
			 conditionHaving.groupBy("userid")
			 .having(FunctionType.COUNT, "userid", Op.ge, 1)
			 ;
			 List<Orders> list12 = suid.select(new Orders(), conditionHaving);
			 
			 //set with field
			 Condition conditionSetWithField=new ConditionImpl();
			 conditionSetWithField.setWithField("name","userid");
			 conditionSetWithField.op("name", Op.eq, null);
			 int updateNum= suidRich.update(new Orders(), conditionSetWithField);
			 Logger.info("updateNum use SetWithField: "+updateNum);
			 
			 //OpWithField
			 Condition conditionOpWithField=new ConditionImpl();
			 conditionOpWithField.opWithField("name",Op.eq,"userid");
//			 conditionOpWithField.op("userid", Op.eq, "Bee")
			 ;
			 Orders orders14= new Orders();
//			 orders14.setUserid("Bee2"); //will be parsed
			 List<Orders> list14 = suid.select(orders14, conditionOpWithField);
			 Logger.info("record num by select use opWithField: "+list14.size());
			 
			 Condition conditionHaving2=new ConditionImpl();
			 conditionHaving2
			 .selectField("userid")
			 .groupBy("userid")
			 .having(FunctionType.COUNT, "*", Op.ge, 2)
			 .having(FunctionType.COUNT, "distinct(userid)", Op.ge, 1)
			 ;
			 List<Orders> list15 = suid.select(new Orders(), conditionHaving2);
			 Logger.info(list15.size());
			 
		} catch (BeeException e) {
			Logger.error("In ConditionExam (BeeException):"+e.getMessage());
			e.printStackTrace();
		}catch (Exception e) {
			Logger.error("In ConditionExam (Exception):"+e.getMessage());
			e.printStackTrace();
		}
	}
}
