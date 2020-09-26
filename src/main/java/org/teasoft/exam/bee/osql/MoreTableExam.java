/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.MoreTable;
import org.teasoft.bee.osql.Op;
import org.teasoft.exam.bee.osql.moretable.entity.Orders;
import org.teasoft.exam.bee.osql.moretable.entity.User;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.ConditionImpl;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.7
 */
public class MoreTableExam {

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		try {
			MoreTable moreTable = BeeFactory.getHoneyFactory().getMoreTable();

			Orders orders1 = new Orders();
			orders1.setUserid("bee");
			orders1.setName("Bee(ORM Framework)");

			User user = new User();
			user.setEmail("beeUser@163.com");
			orders1.setUser(user);

			//默认不处理null和空字符串.不用再写一堆的判断;其它有值的字段全部自动作为过滤条件
			//List<Orders> list1 =moreTable.select(orders1);  //select
			List<Orders> list1 = moreTable.select(orders1, 0, 10); //select 查询前10条记录
			Logger.info("size of records:"+list1.size() + "");
			for (int i = 0; i < list1.size(); i++) {
				Logger.info(list1.get(i).toString());
			}

			Condition condition = new ConditionImpl();
			condition
			//.op("myuser.id", Op.gt,6)//模糊查询   取别名
			//.op("user.id", Op.gt,6) //模糊查询  
			.op("orders.id", Op.ge, 1001) //模糊查询  
			.start(0).size(5) //分页
//			.start(2).size(6) //分页
			;

			//默认不处理null和空字符串.不用再写一堆的判断;其它有值的字段全部自动作为过滤条件
			//List<Orders> list2 =moreTable.select(orders1,0,10);  //select 查询前10条记录
			List<Orders> list2 = moreTable.select(orders1, condition); //select
			Logger.info("size of records:"+list2.size() + "");
			for (int i = 0; i < list2.size(); i++) {
				Logger.info(list2.get(i).toString());
			}
			
			condition.selectField("orders.id,user.id,userid,total,orders.createtime");  //只查询部分字段. 没有指定查询的值都为null
			List<Orders> list3 = moreTable.select(orders1, condition); //select
			Logger.info("size of records:"+list3.size() + "");
			for (int i = 0; i < list3.size(); i++) {
				Logger.info(list3.get(i).toString());
			}

		} catch (BeeException e) {
			Logger.error("In MoreTableExam (BeeException):"+e.getMessage());
			e.printStackTrace();
		}catch (Exception e) {
			Logger.error("In MoreTableExam (Exception):"+e.getMessage());
			e.printStackTrace();
		}
	}
}
