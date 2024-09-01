/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.util.List;

import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  2.1.10
 */
public class NotExam {
	private static SuidRich suidRich = BF.getSuidRich();
	public static void main(String[] args) {
		
		Condition condition=BF.getCondition();
		condition.op("remark", Op.eq, "remark");
		condition.op("abc", Op.eq, "remark"); //测试自动加and
//		condition.and(); //可自动加and
		condition.not();
		condition.lParentheses(); //left
		condition.op("name", Op.eq, "client");
		condition.op("abc", Op.eq, "client");
		condition.rParentheses();//right
		
		
		 List<Orders> list=suidRich.select(new Orders(),condition);
		 Printer.printList(list);
	}

}
