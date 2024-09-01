/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.chain;

import java.util.List;

import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.api.PreparedSql;
import org.teasoft.bee.osql.chain.Select;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.chain.SelectImpl;
import org.teasoft.honey.osql.core.BeeFactory;

/**
 * @author Kingstar
 * @since  1.11
 */
public class QueryCompare {
	private static PreparedSql preparedSql = BeeFactory.getHoneyFactory().getPreparedSql();
	
	public void query(String name) {
		Select t = new SelectImpl();
        t.select() //查所有列
//        t.select("name")  //也可以查具体的列
		.from("orders")
		.where()
		.op("name", Op.eq, name)
		.isNotNull("createtime")
        ;
        
        List<String[]> list0= preparedSql.select(t.toSQL());
        Printer.print(list0);
        
        List<Orders> list= preparedSql.select(t.toSQL(),Orders.class); //bug
        Printer.printList(list);
        
        String sql="select * from orders where name='Bee' and createtime is not null ;";
        List<String[]> list2= preparedSql.select(sql);
        Printer.print(list2);
        
	}
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		QueryCompare query=new QueryCompare();
		query.query("Bee");
	}

}
