/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.moretable26.moretable3;

import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.api.MoreTable;
import org.teasoft.exam.moretable26.moretable3.entity.Orders2026;
import org.teasoft.exam.moretable26.moretable3.entity.TestUser;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.BeeFactory;

/**
 * 多表查询，带条件
 * @author Kingstar
 * @since  3.0.0
 */
public class MoreTableExam2 {

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		try {
			MoreTable moreTable = BeeFactory.getHoneyFactory().getMoreTable();
			
			
			Orders2026 orders1 = new Orders2026();
			orders1.setUserid("bee");
//			orders1.setName("Bee");
			
			TestUser user = new TestUser();
			//			user.setEmail("beeUser@163.com");
//			user.setName("Bee");
			orders1.setTestUser(user);
			
			List<Orders2026> list1 = moreTable.select(orders1, 0, 10); //select 查询前10条记录
			
			if (list1!=null) {
			for (int i = 0; i < list1.size(); i++) {
				Logger.info(list1.get(i).toString());
			}
			}
			

		} catch (BeeException e) {
			e.printStackTrace();
			Logger.error("In MoreTableExam (BeeException):"+e.getMessage());
		}catch (Exception e) {
			Logger.error("In MoreTableExam (Exception):"+e.getMessage());
			e.printStackTrace();
		}
	}
}
