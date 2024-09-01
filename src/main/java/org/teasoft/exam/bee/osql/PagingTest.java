/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  2.1.10
 */
public class PagingTest {
	
	public static void main(String[] args) {
		BF.getSuidRich().select(new Orders(),10,10);
	}

}
