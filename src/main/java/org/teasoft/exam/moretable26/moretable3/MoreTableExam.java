/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.moretable26.moretable3;

import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.MoreTable;
import org.teasoft.exam.moretable26.moretable3.entity.Orders2026;
import org.teasoft.exam.moretable26.moretable3.entity.TestUser;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.ConditionImpl;

/**
 * @author Kingstar
 * @since  3.0.0
 */
public class MoreTableExam {

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		try {
			MoreTable moreTable = BeeFactory.getHoneyFactory().getMoreTable();
			
			
			Orders2026 orders1 = new Orders2026();
//			orders1.setUserid("bee");
//			orders1.setName("Bee");
			
			TestUser user = new TestUser();
			//			user.setEmail("beeUser@163.com");
//			user.setName("Bee");
			orders1.setTestUser(user);
			
			//默认不处理null和空字符串.不用再写一堆的判断;其它有值的字段全部自动作为过滤条件
			//List<Orders> list1 =moreTable.select(orders1);  //select
//			List<Orders> list1 = moreTable.select(orders1, 0, 10); //select 查询前10条记录
			List<Orders2026> list1 = moreTable.select(orders1, 2, 9); //select 查询前10条记录
			
			if (list1!=null) {
//			Logger.info("size of records:"+list1.size() + "");
			for (int i = 0; i < list1.size(); i++) {
				Logger.info(list1.get(i).toString());
			}
			}
			
//			Condition condition = new ConditionImpl();
//			condition
//			//.op("myuser.id", Op.gt,6)//模糊查询   取别名
//			//.op("user.id", Op.gt,6) //模糊查询  
//			.op("orders2026.id", Op.ge, 1001) //模糊查询  
//			.start(0).size(5) //分页
//			//			.start(2).size(6) //分页
//			;
//			
//			
//			//默认不处理null和空字符串.不用再写一堆的判断;其它有值的字段全部自动作为过滤条件
//			//List<Orders> list2 =moreTable.select(orders1,0,10);  //select 查询前10条记录
//			List<Orders2026> list2 = moreTable.select(orders1, condition); //select
//			if (list2!=null) {
//			Logger.info("size of records:"+list2.size() + "");
//			for (int i = 0; i < list2.size(); i++) {
//				Logger.info(list2.get(i).toString());
//			}
//			}

		} catch (BeeException e) {
			e.printStackTrace();
			Logger.error("In MoreTableExam (BeeException):"+e.getMessage());
		}catch (Exception e) {
			Logger.error("In MoreTableExam (Exception):"+e.getMessage());
			e.printStackTrace();
		}
	}
}
