/*
 * Copyright 2016-2019 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.OrderType;
import org.teasoft.bee.osql.Suid;
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
//		orders.setTotal(new BigDecimal("100"));  //不会再处理.因为between已有用
		
		 Condition condition=new ConditionImpl();
		 condition
		 .op("userid", Op.like, "bee%") //模糊查询
		 .between("total", 90, 100)     //范围查询
		 .between("createtime","2020-03-01","2020-03-03")
		 .orderBy("userid",OrderType.ASC) //排序
		 .start(0).size(10)              //分页
		 ;

		List<Orders> list2 = suid.select(orders, condition);
		for (int i = 0; i < list2.size(); i++) {
			Logger.info(list2.get(i).toString());
		}
		
	  } catch (BeeException e) {
		 e.printStackTrace();
		 Logger.error(e.getMessage());
	  }
	}
}
