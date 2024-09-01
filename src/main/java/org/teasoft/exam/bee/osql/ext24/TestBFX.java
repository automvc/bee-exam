/*
 * Copyright 2019-2024 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.ext24;

import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.beex.osql.api.ConditionExt;
import org.teasoft.beex.osql.api.SuidRichExt;
import org.teasoft.beex.osql.shortcut.BFX;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  2.4.0
 */
public class TestBFX {
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		ConditionExt conditionExt=BFX.getConditionExt();
		conditionExt.op(Orders::getAbc, Op.eq, "value11");
		SuidRich suidRich=BF.getSuidRich();
		suidRich.count(new Orders(), conditionExt);
		
		conditionExt.selectField(Orders::getAbc,Orders::getRemark);
		suidRich.select(new Orders(), conditionExt);
		
		
		SuidRichExt suidRichExt=BFX.getSuidRichExt();
		suidRichExt.select(new Orders(),Orders::getAbc,Orders::getRemark);
		
	}
	

}
