/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.moreds;

import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  2.1.8
 */
public class MoreDsTest {
	
	public static void main(String[] args) {
		SuidRich suidRich=BF.getSuidRich();
		suidRich.setDataSourceName("ds0");
		suidRich.select(new Orders());
		
		suidRich.setDataSourceName("ds1");
		suidRich.select(new Orders());
	}

}
