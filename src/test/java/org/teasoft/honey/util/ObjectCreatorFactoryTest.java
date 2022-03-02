/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.honey.util;

import org.junit.Test;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.11
 */
public class ObjectCreatorFactoryTest {
	
	@Test
	public void test() {
		
		Object short1=ObjectCreatorFactory.create("1", short.class);
		Logger.info("create(\"1\", short.class)  :  "+short1.getClass().getName());
		
		Object byte1=ObjectCreatorFactory.create("1", byte.class);
		Logger.info("create(\"1\", byte.class)  :  "+byte1.getClass().getName());
		
		Object long1=ObjectCreatorFactory.create("1", long.class);
		Logger.info("create(\"1\", long.class)  :  "+long1.getClass().getName());
		
		
		test2(); //class
		
	}
	
	public void test2() {
		
		Object short1=ObjectCreatorFactory.create("1", Short.class);
		Logger.info("create(\"1\", short.class)  :  "+short1.getClass().getName());
		
		Object byte1=ObjectCreatorFactory.create("1", Byte.class);
		Logger.info("create(\"1\", byte.class)  :  "+byte1.getClass().getName());
		
		Object long1=ObjectCreatorFactory.create("1", Long.class);
		Logger.info("create(\"1\", long.class)  :  "+long1.getClass().getName());
		
	}

}
