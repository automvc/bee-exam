/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.special;

import java.util.List;

import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.Suid;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * V1.11及之前版本， 使用Op.like， 需要判断值是否为空字段，是否只含有匹配符(%和_)
 * <br>Op.like可以创建比左右匹配更复杂的模糊查询,但需要防止,最终的值只包含有匹配符(%和_)
 * <br>在V1.17( 1.17.0.9) 中,能明确%使用在左还是右,还是同时使用在左右, 则应该选用:likeLeft,likeRight,likeLeftRight;
 * <br>Bee框架会对这三种用法的值进行转义(匹配符%,由框架添加), 转义后值中的%(如果有),只代表符号%.
 * <br>where 条件中,不建议只使用not like一个过滤条件(结合其它条件使用则可以)
 * @author Kingstar
 * @since  1.17
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
		condition.op("userid", Op.like, "test%"); //test开头的
		list2 = suid.select(orders, condition);
		for (int i = 0; i < list2.size(); i++) {
			Logger.info(list2.get(i).toString());
		}
		
		condition=BF.getCondition();
		condition.op("userid", Op.like, "test_"); //test开头有5个字符的
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
		condition.op("userid", Op.likeLeft, "test\u0025"); //likeLeft  match:userid=test%
		list2 = suid.select(orders, condition);
		for (int i = 0; i < list2.size(); i++) {
			Logger.info(list2.get(i).toString());
		}
		
		condition=BF.getCondition();
		condition.op("userid", Op.likeLeft, "test\\u0025"); //likeLeft ; match: userid=test\u0025
		list2 = suid.select(orders, condition);
		for (int i = 0; i < list2.size(); i++) {
			Logger.info(list2.get(i).toString());
		}
		
		condition=BF.getCondition();
		condition.op("userid", Op.likeLeft, "test\\\\u0025"); //likeLeft ; match: userid=test\u0025
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
		
		condition=BF.getCondition();
		condition.op("name", Op.like, "12%"); 
		list2 = suid.select(new Orders(), condition);
		for (int i = 0; i < list2.size(); i++) {
			Logger.info(list2.get(i).toString());
		}
		
		condition=BF.getCondition();
		condition.op("name", Op.likeLeftRight, "12"); 
		list2 = suid.select(new Orders(), condition);
		for (int i = 0; i < list2.size(); i++) {
			Logger.info(list2.get(i).toString());
		}
		
		
		}catch (Exception e) {
			Logger.error("In ConditionExam (Exception):"+e.getMessage());
			e.printStackTrace();
		}
	}

}
