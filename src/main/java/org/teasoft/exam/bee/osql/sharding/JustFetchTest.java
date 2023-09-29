/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.sharding;

import org.teasoft.exam.bee.mongodb.entity.OrdersGroupResponse;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  2.1.8
 */
public class JustFetchTest {

	
	public static void main(String[] args) {
		BF.getSuidRich().select(new OrdersGroupResponse());
	}
}
