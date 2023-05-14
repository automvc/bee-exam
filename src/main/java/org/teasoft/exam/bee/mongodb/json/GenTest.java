/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.json;

import org.teasoft.exam.bee.prod.entity.Student2;
import org.teasoft.honey.osql.autogen.Ddl;

/**
 * @author Kingstar
 * @since  2.0
 */
public class GenTest {
	
	public static void main(String[] args) {
		
//		Ddl.createTable(Inventory.class);
		
//		new GenBean().genSomeBeanFile("Dept");
		
//		Ddl.createTable(Inventory.class);
		
//		Ddl.createTable(Student2.class);
		Ddl.createTable(Student2.class,true);
	}

}
