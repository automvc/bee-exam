/*
 * Copyright 2016-2019 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.math.BigDecimal;

import org.teasoft.bee.osql.IncludeType;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.6
 */
public class UpdateByExam {
	
	public static void main(String[] args) {
		test();
	}
	public static void test() {
		SuidRich suidRich=BeeFactory.getHoneyFactory().getSuidRich();
		
		 Orders orders=new Orders();
		 orders.setUserid("bee");
		 orders.setRemark("new2");
		 orders.setTotal(new BigDecimal("100"));
		 orders.setSequence("");
		 
		 int updateNum0=suidRich.updateBy(orders, "userid");
		 Logger.info("update number:  "+updateNum0);
		 
		 Logger.info("IncludeType.INCLUDE_BOTH");
		 int updateNum=suidRich.updateBy(orders, "userid,name", IncludeType.INCLUDE_BOTH);
		 Logger.info("update number:  "+updateNum);
		 
		 Logger.info("IncludeType.INCLUDE_NULL");
		 suidRich.updateBy(orders, "userid", IncludeType.INCLUDE_NULL);
		 Logger.info("IncludeType.INCLUDE_EMPTY");
		 suidRich.updateBy(orders, "userid", IncludeType.INCLUDE_EMPTY);
	}

}
