/*
 * Copyright 2019-2024 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.extend;

import java.util.List;

import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * //	#bee.osql.openEntityCanExtend=true
 * @author Kingstar
 * @since  2.4.0
 */
public class ExtendEntityTest {
	
//	#bee.osql.openEntityCanExtend=true
	public static void main(String[] args) {
		SuidRich suidRich=BF.getSuidRich();
		List<Orders> list1=suidRich.select(new Orders());
		Printer.printList(list1);
		List<Myorders> list2=suidRich.select(new Myorders());
		Printer.printList(list2);
	}

}
