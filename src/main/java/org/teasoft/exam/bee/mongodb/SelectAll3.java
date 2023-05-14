/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb;

import java.util.List;

import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.mongodb.entity.Orders3;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  2.0
 */
public class SelectAll3 {
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		SuidRich suidRich = BF.getSuidRich();
		List<Orders3> list=suidRich.select(new Orders3());
		System.err.println(list.size());
		Printer.printList(list);
		
		System.err.println("------------------------------------------");
		list=suidRich.select(new Orders3());
		System.err.println(list.size());
		Printer.printList(list);
	}
}
