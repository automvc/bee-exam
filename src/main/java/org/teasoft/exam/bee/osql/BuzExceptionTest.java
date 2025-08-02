/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.exam.bee.osql.entity.TestUser;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.BeeFactory;

/**
 * @author Kingstar
 * @since  1.9.8
 */
public class BuzExceptionTest {
	private static SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();

	public static SuidRich getSuidRich() {
		return suidRich;
	}

	public static void setSuidRich(SuidRich suidRich) {
		BuzExceptionTest.suidRich = suidRich;
	}

	public static void main(String[] args) {
		test();
	}

	public static void test() {
//		test update(T oldEntity,T newEntity)
		Orders orders16 = new Orders(); 
		orders16.setRemark("update(T oldEntity,T newEntity)");
		orders16.setName("update(T oldEntity,T newEntity)");
		try {
			suidRich.update(new TestUser(), orders16);
		} catch (Exception e) {
			Logger.error(e.getMessage(), e);
		}
		try {
			suidRich.update(new Orders(), orders16);
		} catch (Exception e) {
			Logger.error(e.getMessage(), e);
		}
		try {
			suidRich.update(orders16, new Orders());
		} catch (Exception e) {
			Logger.error(e.getMessage(), e);
		}
	}

}
