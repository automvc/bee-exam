/*
 * Copyright 2016-2019 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.math.BigDecimal;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.IncludeType;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.BeeFactory;

/**
 * @author Kingstar
 * @since  1.6
 */
public class UpdateByExam {
	
	private static SuidRich suidRich=BeeFactory.getHoneyFactory().getSuidRich();
	
	public static SuidRich getSuidRich() {
		return suidRich;
	}
	
	public static void setSuidRich(SuidRich suidRich) {
		UpdateByExam.suidRich=suidRich;
	}
	
		
	public static void main(String[] args) {
		test();
	}
	public static void test() {
		try{
			
//		 SuidRich suidRich=BeeFactory.getHoneyFactory().getSuidRich();
		
		 Orders orders=new Orders();
		 orders.setUserid("bee");
		 orders.setRemark("new2");
		 orders.setTotal(new BigDecimal("100"));
		 orders.setSequence("");
		 
		 int updateNum0=suidRich.updateBy(orders, "userid");
		 Logger.info("update number:  "+updateNum0);
		 
		 Logger.info("IncludeType.INCLUDE_BOTH");
		 int updateNum=suidRich.updateBy(orders, IncludeType.INCLUDE_BOTH, "userid,name");
		 Logger.info("update number:  "+updateNum);
		 
		 Logger.info("IncludeType.INCLUDE_NULL");
		 suidRich.updateBy(orders, IncludeType.INCLUDE_NULL, "userid");
		 Logger.info("IncludeType.INCLUDE_EMPTY");
		 suidRich.updateBy(orders, IncludeType.INCLUDE_EMPTY, "userid");
		 
		} catch (BeeException e) {
			Logger.error("In UpdateByExam (BeeException):"+e.getMessage());
			e.printStackTrace();
		}catch (Exception e) {
			Logger.error("In UpdateByExam (Exception):"+e.getMessage());
			e.printStackTrace();
		}
	}

}
