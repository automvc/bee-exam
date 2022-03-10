/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.test;

import org.teasoft.exam.bee.osql.entity.Clazz;
import org.teasoft.exam.bee.osql.entity.LeafAlloc;
import org.teasoft.exam.bee.osql.entity.Scores;
import org.teasoft.exam.bee.osql.entity.Student;
import org.teasoft.exam.bee.osql.entity.StudentHobby;
import org.teasoft.exam.bee.osql.entity.TestUser;
import org.teasoft.exam.bee.osql.entity.dynamic.LeafAlloc3;
import org.teasoft.exam.bee.osql.entity.dynamic.Orders;
import org.teasoft.exam.bee.osql.moretable.entity.Assigncourse;
import org.teasoft.exam.bee.osql.moretable.entity.Assignexam;
import org.teasoft.exam.bee.osql.special.primarykey.entity.CustomId;
import org.teasoft.honey.osql.autogen.Ddl;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.9
 */
public class CreateTableWithJavabean {

	public static void main(String[] args) {
		test();
	}

	public static void test() {

		try {
			
			Ddl.setDynamicParameter("version", ""); //default
			Ddl.createTable(new Orders(), true);
			
			Ddl.setDynamicParameter("month", "_202007"); //要对应实现有该注解才有效
			Ddl.createTable(new Orders(), true);
			
			Ddl.createTable(new TestUser(), true);
			
			Ddl.createTable(new LeafAlloc(), true);
//
			Ddl.setDynamicParameter("version", "2");
			Ddl.createTable(new LeafAlloc3(), true);
			
			Ddl.setDynamicParameter("version", "3");
			Ddl.createTable(new LeafAlloc3(), true);

			Ddl.createTable(new Scores(), true);
			Ddl.createTable(new Assignexam(), true);
			Ddl.createTable(new Assigncourse(), true);
			
			Ddl.createTable(new Clazz(), true);
			Ddl.createTable(new Student(), true);
			Ddl.createTable(new StudentHobby(), true);
//			
//			Ddl.createTable(new TransferRecord(), true);
//			
			Ddl.createTable(new CustomId(), true);
			
			Ddl.createTable(new Noid(), true);
//			Ddl.createTable(new CustomId(), true);
//			Ddl.createTable(new CustomId(), true);
			
			
		} catch (Exception e) {
			Logger.error("In CreateTableWithJavabean2 (Exception):" + e.getMessage());
			e.printStackTrace();
		}
	}
}
