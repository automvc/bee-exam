/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.superclass.supertestmore;

import org.teasoft.honey.osql.autogen.Ddl;

/**
 * @author Kingstar
 * @since  1.9
 */
public class CreateTableWithJavabean_SupperClass {
	public static void main(String[] args) {
		
//		Ddl.createTable(EntityClass.class, true); 
		
		Ddl.createTable(School.class, true); 
		Ddl.createTable(Course.class, true); 
	}

}
