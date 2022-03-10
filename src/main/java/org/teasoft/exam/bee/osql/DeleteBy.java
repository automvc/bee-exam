/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.11
 */
public class DeleteBy {

	private static SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();

	public static SuidRich getSuidRich() {
		return suidRich;
	}

	public static void setSuidRich(SuidRich suidRich) {
		DeleteBy.suidRich = suidRich;
	}

	public static void main(String[] args) {
		test();
	}

	public static void test() {

		try {
			suidRich.deleteById(Orders.class, 100021);
			suidRich.deleteById(Orders.class, 100022L);
			suidRich.deleteById(Orders.class, "100023");
			
			Orders exampleField = new Orders();
			exampleField.setUserid("bee");
			List<Orders> selectSomeField = suidRich.select(exampleField, "name,total");
			Orders one=suidRich.selectById(exampleField,exampleField.getId());
		} catch (BeeException e) {
			Logger.error("In SuidRichExam (Exception):" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			Logger.error("In SuidRichExam (Exception):" + e.getMessage());
			e.printStackTrace();
		}
	}

}
