/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.special.performance;

import org.teasoft.bee.osql.api.Suid;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.osql.annotation.Orders;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  1.11
 */
public class TestPerformance {

	private static Suid suid = BF.getSuid();

	public static void main(String[] args) {
		
//		long a=System.currentTimeMillis();
//
//		for (int i = 0; i < 2000; i++) {
//			Orders orders = new Orders();
//			orders.setRemark(i + "");
//			suid.insert(orders);
//		}
//		long b=System.currentTimeMillis();
//		System.out.println((b-a)/1000);
		
		suid.beginSameConnection();
		suid.select(new Orders());
		
		long c=System.currentTimeMillis();
		suid.select(new Orders());
		long d=System.currentTimeMillis();
		System.out.println((d-c));
		
		SuidRich suidRich=BF.getSuidRich();
		long e=System.currentTimeMillis();
		suidRich.select(new Orders());
		long f=System.currentTimeMillis();
		System.out.println((f-e));
		
		suid.endSameConnection();
	}

}
