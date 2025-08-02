/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.chain;

import java.util.List;

import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.OrderType;
import org.teasoft.bee.osql.api.PreparedSql;
import org.teasoft.bee.osql.chain.Select;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.chain.Aggregate;
import org.teasoft.honey.osql.chain.SelectImpl;
import org.teasoft.honey.osql.core.BeeFactory;

/**
 * @author Kingstar
 * @since  1.9
 */
public class ChainSelectExam2 {
	private static PreparedSql preparedSql = BeeFactory.getHoneyFactory().getPreparedSql();
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		
	 try {
		Select t = new SelectImpl();
		String sql = "";
//      t.select("*")
        t
        .select("name")
//        .distinct("id")
        .select(Aggregate.max("total"))
//        .select("max(price)")
//        .distinct("name")
		.from("orders")
//		.from("abc") //如何检测已经使用了from,不能再用了??
		.where()
//		.op("userid", Op.eq, "client01")
//		.and()  //default will add
//		.op("name", Op.like, "Bee%")  要考虑注入攻击
//		.op("name", Op.like, "test2_")
		.op("name", Op.notLike, "Bee%") //自己拼字符,占位形式不能自动
//		.op("category", Op.in, "food,fruit")
		.between("total", 10, 100)
//		.notBetween("total", 90, 100)
		.isNotNull("createtime")
        
        .groupBy("name")
//        .orderBy("id", OrderType.ASC)
        .orderBy("name", OrderType.ASC)
        ;
        
        
//      sql= t.from("abc") //重新用t写,就可以从原来的开始.
        sql= t.toSQL();
        List<String[]> list1= preparedSql.select(sql);
        Printer.print(list1);
        
        List<String[]> list2= preparedSql.select(t.toSQL());
        Printer.print(list2);
        
	   } catch (Exception e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
	   }
        
        Logger.info("ChainSelectExam finished....");
        
	}

}
