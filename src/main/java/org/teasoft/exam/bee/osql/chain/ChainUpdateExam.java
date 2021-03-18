/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.chain;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.PreparedSql;
import org.teasoft.bee.osql.chain.Update;
import org.teasoft.bee.osql.exception.BeeErrorFieldException;
import org.teasoft.honey.osql.chain.UpdateImpl;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.3
 */
public class ChainUpdateExam {
	private static PreparedSql preparedSql = BeeFactory.getHoneyFactory().getPreparedSql();
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
	 try{
		Update updateSql=new UpdateImpl();
		updateSql.update("orders")
		.set("name", "Bee")
		.set("userid", "Bee")
		.set("total", 98.8)
		.where()
		.lParentheses()   //(
		.op("id", Op.ge, 100005)
		.or()
		.op("id", Op.in, 100004)
		.rParentheses()  //)
		.isNotNull("name")
		.isNull("createtime")
		.notIn("id",100001)
		.in("id", 100002,100003)
		.between("id", 100002, 100004)
		.notBetween("id", 100005, 100006)
		.notIn("name", "Bee")
		;
		
		Logger.info(updateSql.toSQL());
		if(updateSql.toSQL().equals(updateSql.toSQL())) {
			Logger.info("Getting this sql twice is same!");
		}
		int updateNum=preparedSql.modify(updateSql.toSQL());
		Logger.info("updateNum: "+updateNum);
		
		//just test sql
        try {
        	Update updateSql2=new UpdateImpl();
        	updateSql2.update("team_id")
    		.set("total", 11)
    		.set("remark", "test")
//    		.where()
    		.where("1=1")
    		.op("price", 99)
    		.op("price", Op.ge,99)
    		.and()
    		.op("name", Op.like,"Bee%")
    		.op("remark", "test2")
    		.in("orderid", "111,112")
    		;
    		Logger.info(updateSql2.toSQL());
    		
    		updateSql2.op("-- total", 99) // --
    		;
    		Logger.info(updateSql2.toSQL());
    		
		} catch (BeeErrorFieldException e) {
			Logger.info(e.getMessage());
			e.printStackTrace();
		}
		
	   } catch (BeeException e) {
			e.printStackTrace();
	   }
	}

}
