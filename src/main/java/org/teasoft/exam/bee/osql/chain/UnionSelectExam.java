/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.chain;

import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.PreparedSql;
import org.teasoft.bee.osql.chain.Select;
import org.teasoft.bee.osql.chain.UnionSelect;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.chain.SelectImpl;
import org.teasoft.honey.osql.chain.UnionSelectImpl;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.3
 */
public class UnionSelectExam {
	
	private static PreparedSql preparedSql = BeeFactory.getHoneyFactory().getPreparedSql();
	
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
	  try{	
	   Select joinSelect =new SelectImpl();
		joinSelect.select("*")
		.from("orders,test_user")
		.where("orders.name=test_user.name")
		.start(0)
		.size(10)
		;
		
		Logger.info(joinSelect.toSQL());
		if(joinSelect.toSQL().equals(joinSelect.toSQL())) {
			Logger.info("Getting this sql twice is same!");
		}
		
        List<String[]> list1= preparedSql.select(joinSelect.toSQL());
        Printer.print(list1);
		
		UnionSelect unionSelect =new UnionSelectImpl();
		Select select1 =new SelectImpl();
		Select select2 =new SelectImpl();
		select1.select()
		.from("orders")
		.where()
		.op("userid", Op.eq, "client01")
		;
		select2.select()
		.from("orders")
		.where()
		.op("userid", Op.eq, "bee")
		;
		unionSelect.union(select1, select2);
        List<String[]> list2= preparedSql.select(unionSelect.toSQL());
        Printer.print(list2);
        
		unionSelect.unionAll(select1, select2);
        List<String[]> list3= preparedSql.select(unionSelect.toSQL());
        Printer.print(list3);
	  } catch (BeeException e) {
		e.printStackTrace();
	  }
	}
}
