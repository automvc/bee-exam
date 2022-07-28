/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.special;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.PreparedSql;
import org.teasoft.bee.osql.Suid;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.CustomSql;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  1.0
 */
public class LikeTest {
	
	public static void main(String[] args) {
		test();
	}
	public static void test() {
       try{
		Suid suid = BeeFactory.getHoneyFactory().getSuid();
		
		Orders orders = new Orders();
		
		 Condition condition=BF.getCondition();
		 
//		 condition
////		 .op("1=1 -- userid", Op.like, "bee%") // test invalid field
////		 .op("userid", Op.like, "bee%") //模糊查询
//		 .op("userid", Op.like, "%") //模糊查询     只有%或_, 从1.17开始,Bee会抛出异常. 
////		 .op("userid", Op.like, "_")
////		 .op("userid", Op.like, "") 
////		 使用Op.like,调用方需要对传入的字符进行过滤,特别是1.17之前的版本.
//		 ;
		 
		List<Orders> list2 =null;
				
		list2=suid.select(orders, condition);
//		for (int i = 0; i < list2.size(); i++) {
//			Logger.info(list2.get(i).toString());
//		}
		
		
		condition=BF.getCondition();
		condition.op("userid", Op.like, "test\\%"); //userid是test%
		list2 = suid.select(orders, condition);
		for (int i = 0; i < list2.size(); i++) {
			Logger.info(list2.get(i).toString());
		}
		
		condition=BF.getCondition();
		condition.op("userid", Op.like, "test%"); //test开关的
		list2 = suid.select(orders, condition);
		for (int i = 0; i < list2.size(); i++) {
			Logger.info(list2.get(i).toString());
		}
		
		condition=BF.getCondition();
		condition.op("userid", Op.like, "test_"); //test开关有5个字符的
		list2 = suid.select(orders, condition);
		for (int i = 0; i < list2.size(); i++) {
			Logger.info(list2.get(i).toString());
		}
		
		
		condition=BF.getCondition();
		condition.op("userid", Op.like, "test\\_"); //userid是test_
		list2 = suid.select(orders, condition);
		for (int i = 0; i < list2.size(); i++) {
			Logger.info(list2.get(i).toString());
		}
		
		condition=BF.getCondition();
		condition.op("userid", Op.likeLeft, "test"); //likeLeft
		list2 = suid.select(orders, condition);
		for (int i = 0; i < list2.size(); i++) {
			Logger.info(list2.get(i).toString());
		}
		
		condition=BF.getCondition();
		condition.op("userid", Op.likeRight, "test"); //likeRight
		list2 = suid.select(orders, condition);
		for (int i = 0; i < list2.size(); i++) {
			Logger.info(list2.get(i).toString());
		}
		
		condition=BF.getCondition();
		condition.op("userid", Op.likeLeftRight, "test"); //likeLeftRight
		list2 = suid.select(orders, condition);
		for (int i = 0; i < list2.size(); i++) {
			Logger.info(list2.get(i).toString());
		}
		
		condition=BF.getCondition();
		condition.op("userid", Op.likeLeft, "test%"); //likeLeft
		list2 = suid.select(orders, condition);
		for (int i = 0; i < list2.size(); i++) {
			Logger.info(list2.get(i).toString());
		}
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//		condition=BF.getCondition();
//		condition.op("userid", Op.likeLeft, ""); //likeLeft
//		list2 = suid.select(orders, condition);
//		for (int i = 0; i < list2.size(); i++) {
//			Logger.info(list2.get(i).toString());
//		}
		
//		condition=BF.getCondition();
//		condition.op("userid", Op.likeLeft, null); //likeLeft
//		list2 = suid.select(orders, condition);
//		for (int i = 0; i < list2.size(); i++) {
//			Logger.info(list2.get(i).toString());
//		}
		
		condition=BF.getCondition();
		condition.op("userid", Op.likeLeft, "test\\%"); //likeLeft
		list2 = suid.select(orders, condition);
		for (int i = 0; i < list2.size(); i++) {
			Logger.info(list2.get(i).toString());
		}
		
		condition=BF.getCondition();
		condition.op("userid", Op.likeLeft, "test_"); //likeLeft
		list2 = suid.select(orders, condition);
		for (int i = 0; i < list2.size(); i++) {
			Logger.info(list2.get(i).toString());
		}
		
		condition=BF.getCondition();
		condition.op("userid", Op.likeLeft, "test\\u0025"); //likeLeft
		list2 = suid.select(orders, condition);
		for (int i = 0; i < list2.size(); i++) {
			Logger.info(list2.get(i).toString());
		}
		
/*		condition=BF.getCondition();
		condition.op("userid", Op.notLikeLeft, "test%"); //notLikeLeft
		list2 = suid.select(orders, condition);
		for (int i = 0; i < list2.size(); i++) {
			Logger.info(list2.get(i).toString());
		}
		
		condition=BF.getCondition();
		condition.op("userid", Op.notLikeLeft, ""); //notLikeLeft
		list2 = suid.select(orders, condition);
		for (int i = 0; i < list2.size(); i++) {
			Logger.info(list2.get(i).toString());
		}
		
		condition=BF.getCondition();
		condition.op("userid", Op.notLikeLeft, "A"); //notLikeLeft
		list2 = suid.select(orders, condition);
		for (int i = 0; i < list2.size(); i++) {
			Logger.info(list2.get(i).toString());
		}*/
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>2");
		
		condition=BF.getCondition();
		condition.op("userid", Op.like, "\\\u0025\\\u0025"); //like  \u0025 is %  转义 \%是\\\u0025
		list2 = suid.select(orders, condition);
		for (int i = 0; i < list2.size(); i++) {
			Logger.info(list2.get(i).toString());
		}
		
		condition=BF.getCondition();
		condition.op("userid", Op.likeLeft, "\\\u0025"); //like  \u0025 is %  转义 \%是\\\u0025
		list2 = suid.select(orders, condition);
		for (int i = 0; i < list2.size(); i++) {
			Logger.info(list2.get(i).toString());
		}
		
		//查询 userid=\u0025
		condition=BF.getCondition();
		condition.op("userid", Op.like, "\\\\u0025"); //like  \u0025 is %
		list2 = suid.select(orders, condition);
		for (int i = 0; i < list2.size(); i++) {
			Logger.info(list2.get(i).toString());
		}
		
		
		}catch (Exception e) {
			Logger.error("In ConditionExam (Exception):"+e.getMessage());
			e.printStackTrace();
		}
	}

}
