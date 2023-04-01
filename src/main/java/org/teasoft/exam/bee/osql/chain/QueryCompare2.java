/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.chain;

import java.util.List;

import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.OrderType;
import org.teasoft.bee.osql.PreparedSql;
import org.teasoft.bee.osql.chain.Select;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.chain.Aggregate;
import org.teasoft.honey.osql.chain.SelectImpl;
import org.teasoft.honey.osql.core.BeeFactory;

/**
 * @author Kingstar
 * @since  1.11
 */
public class QueryCompare2 {
	private static PreparedSql preparedSql = BeeFactory.getHoneyFactory().getPreparedSql();
	public static void main(String[] args) {
		 try {
				Select t = new SelectImpl();
				String sql = "";
		        t.select() //查所有列
		        
//		       t.select("name")  //也可以查具体的列
//		        .distinct("id")
//		        .select(Aggregate.max("total")) //可以用函数
				.from("orders")
				.where()
				.op("name", Op.eq, "bee")
//				.op("name", Op.like, "Bee%") 
//				.op("name", Op.like, "test2_")
				.isNotNull("createtime")
		        
//		        .orderBy("id", OrderType.ASC)
		        .orderBy("name", OrderType.ASC)
		        ;
		        
		        sql= t.toSQL();
		        List<String[]> list1= preparedSql.select(sql);
		        Printer.print(list1);
		        
		        
		        QueryCompare2 tt=new QueryCompare2();
		        int a[]=new int[10]; //初值为0
		        for (int i = 0; i < a.length; i++) {
					System.err.println(a[i]);
				}
		        tt.count(a, 10);
	}catch (Exception e) {
	   e.printStackTrace();
	}
	}
	
	public void count(int a[],int n) {
		int b[]=new int[n];
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
	}

}
