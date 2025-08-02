/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.chain;

import java.util.List;

import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.api.PreparedSql;
import org.teasoft.bee.osql.chain.Select;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.shortcut.CSF;
import org.teasoft.honey.util.Printer;

/**
 * @author Kingstar
 * @since  2.1.10
 */
public class NotExam {
	
private static PreparedSql preparedSql = BeeFactory.getHoneyFactory().getPreparedSql();
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		
	 try {
//		Select t = new SelectImpl();
		Select t = CSF.getSelect();
		String sql = "";
        t
        .select("*")
//        .select(Aggregate.max("total"))
		.from("orders")
//		.from("abc") //如何检测已经使用了from,不能再用了??
		.where()
		
		.not()
		.lParentheses()
		.op("name", Op.eq, "client")
		.rParentheses()
//		.between("total", 10, 100)
//		.notBetween("total", 90, 100)
//		.isNotNull("createtime")
		.isNull("createtime")
        
//        .groupBy("name")
//        .orderBy("id", OrderType.ASC)
//        .orderBy("name", OrderType.ASC)
        ;
        
        
//      sql= t.from("abc") //重新用t写,就可以从原来的开始.
        sql= t.toSQL();
        List<String[]> list1= preparedSql.select(sql);
        Printer.print(list1);
        
	   } catch (Exception e) {
				Logger.error(e.getMessage());
				e.printStackTrace();
		   }
	        
	        Logger.info("NotExam finished....");
	}

}
