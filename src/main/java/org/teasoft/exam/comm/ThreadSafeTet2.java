/*
 * Copyright 2019-2024 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.comm;

import org.teasoft.honey.osql.core.BeeFactory;

/**
 * @author Kingstar
 * @since  2.4.0
 */
public class ThreadSafeTet2 {
	
	public static void main(String[] args) {

		BeeFactory.getHoneyFactory();
		BeeFactory.getHoneyFactory();
		
		BeeFactory.getInstance().getDataSource();
		System.out.println("finished");
	}

}
