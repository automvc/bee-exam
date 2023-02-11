/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb;

import java.util.List;

import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.osql.entity.LeafAlloc;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  2.0
 */
public class Select_CollectionNotExist {
	public static void main(String[] args) {
		SuidRich suidRich = BF.getSuidRich();
//		List<Orders3> list=suidRich.select(new Orders3());
//		System.err.println(list.size());
//		Printer.printList(list);
		
		List<LeafAlloc> list3=suidRich.select(new LeafAlloc());
		System.err.println(list3.size());
		Printer.printList(list3);
		;
		
		suidRich.select(new LeafAlloc());
		
//		System.err.println("------------------------------------------");
//		list=suidRich.select(new Orders3());
//		System.err.println(list.size());
//		Printer.printList(list);
		
		
	}
}
