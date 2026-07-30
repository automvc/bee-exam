/*
 * Copyright 2022-2026 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.quickstart.suid;

import java.util.List;

import org.entity.Orders;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.OrderType;
import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.honey.osql.core.ConditionImpl;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.osql.util.DateUtil;

/**
 * Rich use for Select/Update/Insert/Delete.
 * 
 * @author Kingstar
 * @since  3.0.0
 */
public class SuidRichExam {

	public static void main(String[] args) {
		SuidRich suidRich = BF.getSuidRich();

		Orders orders1 = new Orders();
//		orders1.setName("Bee(ORM Framework)");

//		orders1.setUserid("bee%");

		// 1: 分页查询, 原生分页, 简单易用, 性能高
		List<Orders> list1 = suidRich.select(orders1, 0, 10); // select paging
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i).toString());
		}

		// 条件构造器Condition; 实现复杂过滤/排序/分组等
		Condition condition = new ConditionImpl();
		condition
//		 .op("1=1 -- userid", Op.like, "bee%") // test invalid field
//		 .lParentheses()    //(  左括号
				.op("userid", Op.like, "bee%") // 模糊查询
//		 .rParentheses()    //) 右括号
//		 .op("userid", Op.like, "%") //模糊查询   测试非法模糊查询
//		 .set("userid", 2)
//		 .between("total", 90, 100)     //范围查询
//		 .op("name", Op.nq, null)     //is not null
//		 .between("createtime","2020-03-01","2020-03-03")
//		 .between("createtime","2021-07-25 17:57:46",DateUtil.currentDate())
				.orderBy("userid", OrderType.ASC) // 排序
				.start(0).size(100) // 分页
		;

		List<Orders> list2 = suidRich.select(orders1, condition); // select paging
		for (int i = 0; i < list2.size(); i++) {
			System.out.println(list2.get(i).toString());
		}

		// SuidRich, 还支持批量插入;复杂更新等.
	}

}
