/*
 * Copyright 2019-2024 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.util.List;

import org.teasoft.bee.osql.api.Suid;
import org.teasoft.exam.comm.Printer;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  2.4.0
 */
public class SuidExamSelectAll {
	
	public static void main(String[] args) {
		Suid suid=BF.getSuid();
		List<Orders> list=suid.select(new Orders());
		Printer.printList(list);
	}

}
