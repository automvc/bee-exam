/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.teasoft.bee.mongodb.MongodbBeeSql;
import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.beex.mongodb.MongodbSqlLib;
import org.teasoft.honey.osql.core.MongodbObjSQLRich;
import org.teasoft.honey.osql.mongodb.MongodbBeeSqlRegister;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.util.Printer;

/**
 * @author AiTeaSoft
 * @since  2.0
 */
public class Test2_Between3 {
	
	public static void main(String[] args) {
		
		SuidRich suidRich =BF.getSuidRichForMongodb();
		Orders orders=new Orders();
		Condition condtion=BF.getCondition();
		
		orders=new Orders();
		List<Orders> list=suidRich.select(orders,condtion);
		Printer.printList(list);
		
		System.out.println("finished!");
	}

}
