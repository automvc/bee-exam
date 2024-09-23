/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.test;

import org.teasoft.exam.bee.osql.annotation.moretable.Clazz1;
import org.teasoft.exam.bee.osql.annotation.moretable.Student1;
import org.teasoft.exam.bee.osql.commomid.Orders3;
import org.teasoft.exam.bee.osql.commomid.OrdersIdString;
import org.teasoft.exam.bee.osql.dialect.Noid2;
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
import org.teasoft.exam.bee.osql.special.ddl.Noid1;
import org.teasoft.exam.bee.osql.special.primarykey.entity.CustomId;
import org.teasoft.exam.bee.osql.special.primarykey.entity.TestPrimaryKey;
import org.teasoft.exam.bee.osql.special.type.DateType2;
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
			Ddl.createTable( Orders.class, true);
			
			Ddl.setDynamicParameter("month", "_202007"); //要对应实现有该注解才有效
			Ddl.createTable( Orders.class, true);
			
			Ddl.setDynamicParameter("month", "1"); //要对应实现有该注解才有效
			Ddl.createTable( Orders.class, true);
			
			Ddl.setDynamicParameter("month", "2"); //要对应实现有该注解才有效
			Ddl.createTable( Orders.class, false);
			
			Ddl.setDynamicParameter("month", "3"); //要对应实现有该注解才有效
			Ddl.createTable( Orders.class, false);
			
			Ddl.createTable( TestUser.class, true);
			
			Ddl.createTable( LeafAlloc.class, true);
//
			Ddl.setDynamicParameter("version", "2");
			Ddl.createTable( LeafAlloc3.class, true);
			
			Ddl.setDynamicParameter("version", "3");
			Ddl.createTable( LeafAlloc3.class, true);

			Ddl.createTable( Scores.class, true);
			Ddl.createTable( Assignexam.class, true);
			Ddl.createTable( Assigncourse.class, true);
			
			Ddl.createTable( Clazz.class, true);
			Ddl.createTable( Student.class, true);
			Ddl.createTable( StudentHobby.class, true);
//			
//			Ddl.createTable(new TransferRecord(), true);
//			
			Ddl.createTable( CustomId.class, true);
			
			Ddl.createTable( Noid.class, true);
			Ddl.createTable( Noid2.class, true);
			Ddl.createTable( Noid1.class, true);
//			Ddl.createTable(new CustomId(), true);
//			Ddl.createTable(new CustomId(), true);
			
			Ddl.createTable( Orders3.class, true);
			Ddl.createTable( OrdersIdString.class, true);
			Ddl.createTable( DateType2.class, true);
			Ddl.createTable( TestPrimaryKey.class, true);
			
			Ddl.createTable( Clazz1.class, true);
			Ddl.createTable( Student1.class, true);
			Ddl.createTable( StudentHobby.class, true);
			
		} catch (Exception e) {
			Logger.error("In CreateTableWithJavabean3 (Exception):" + e.getMessage());
			e.printStackTrace();
		}
	}
}
