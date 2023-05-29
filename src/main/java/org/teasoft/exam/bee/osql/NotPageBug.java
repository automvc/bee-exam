/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.util.List;

import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.core.BeeFactoryHelper;

/**
 * @author Kingstar
 * @since  1.9
 */
public class NotPageBug {
	
	private static SuidRich suidRich = BeeFactoryHelper.getSuidRich();
	public static void main(String[] args) {
		int rows = 5;
		for (int i = 1; i <= 4; i++) {
			int page=i;
			//mysql 第一页从0开始, 虽然还是返回5条,但会跳过第0条记录.  oracle正确
//			List<Orders> list = suidRich.select(new Orders(), (page - 1) * rows+1, rows); 
			//oracle 第1页会少一个记录(一页5条,但首页却只有4条). 因oracle是从1开始算开始记录的.  mysql正常
			List<Orders> list = suidRich.select(new Orders(), (page - 1) * rows, rows); 
			Printer.printList(list);
//			for (int j = 0; j < list.size(); j++) {
//				System.out.println(list.get(j).getId());
//			}
			
		}

	}

}
