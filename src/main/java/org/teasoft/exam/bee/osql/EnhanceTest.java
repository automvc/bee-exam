/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.BeeFactory;

/**
 * @author Kingstar
 * @since  2.0
 */
public class EnhanceTest {

	private static SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();

	public static SuidRich getSuidRich() {
		return suidRich;
	}

	public static void setSuidRich(SuidRich suidRich) {
		EnhanceTest.suidRich = suidRich;
	}

	public static void main(String[] args) {
		test();
	}

	public static void test() {

		try {

			Orders exampleField = new Orders();
			exampleField.setUserid("bee");
			// select some fields
			List<Orders> list = suidRich.select(exampleField, "name,total"); // select Some Field
			Logger.info(list.size() + "");
			Printer.printList(list);
			
//			list = suidRich.select(Orders.class); //Type mismatch: cannot convert from List<Class<Orders>> to List<Orders>
			

		} catch (BeeException e) {
			Logger.error("In SuidRichExam (Exception):" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			Logger.error("In SuidRichExam (Exception):" + e.getMessage());
			e.printStackTrace();
		}
	}

}
