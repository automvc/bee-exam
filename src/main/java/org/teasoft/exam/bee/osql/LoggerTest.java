/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.osql.core.BeeFactoryHelper;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.9.8
 */
public class LoggerTest {
	
	private static SuidRich suidRich = BeeFactoryHelper.getSuidRich();
	
	public static SuidRich getSuid() {
		return suidRich;
	}
	
	public static void setSuidRich(SuidRich suidRich) {
		LoggerTest.suidRich=suidRich;
	}
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		Logger.debug("print debug log message.");
		Logger.info("print info log message.");
		Logger.warn("print info warn message.");
		suidRich.select(new Orders(),0,1);
	}

}
