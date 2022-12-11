/*
getMongodbBeeSql() * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.osql.entity.Student;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author AiTeaSoft
 * @since  2.0
 */
public class Test4_count {
	
	public static void main(String[] args) {
		
		SuidRich suidRich =BF.getSuidRich();
		
		Orders orders=new Orders();
		
		int c=suidRich.count(orders);
		System.out.println("count="+c);
		
		int c2=suidRich.count(orders,null);
		System.out.println("count="+c2);
		
		Condition condition=BF.getCondition();
		int c3=suidRich.count(orders,condition);
		System.out.println("count="+c3);
		
		
		Condition condition2=BF.getCondition();
		condition2.op("name", Op.eq, "mongodb2");
		int c4=suidRich.count(orders,condition2);
		System.out.println("count="+c4);
		
		orders.setAbc("[");
		Condition condition3=BF.getCondition();
		int c5=suidRich.count(orders,condition3);
		System.out.println("count="+c5);
		
		
		 c=suidRich.count(new Student());
		System.out.println("---count="+c);
		
		System.out.println("finished!");
	}

}
