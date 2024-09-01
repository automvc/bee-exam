/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.util.ArrayList;
import java.util.List;

import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.Suid;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  2.2
 */
public class Bug218Test {
	
	public static void main(String[] args) {
		
//		org.teasoft.bee.osql.BeeSQLException: No value specified for parameter 1
		Suid suid=BF.getSuid();
		Condition condition=BF.getCondition();
		List<String> list=new ArrayList<>();
//		list.add(11);
//		list.add(22);
		condition.op("name", Op.in,list); //作为in的 list为空时,会报错; 2.1.8 bug
		
//		suid.select(orders, condition);
		suid.select(new Orders(), condition);
	}

}
