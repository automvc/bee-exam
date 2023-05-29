/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import org.teasoft.bee.osql.api.MoreTable;
import org.teasoft.bee.osql.api.Suid;
import org.teasoft.exam.bee.osql.entity.Columns;
import org.teasoft.exam.bee.osql.entity.Tables2;
import org.teasoft.honey.osql.core.BeeFactory;

/**
 * @author Kingstar
 * @since  1.9.8
 */
public class KotlinTest {
	
	private static Suid suid=BeeFactory.getHoneyFactory().getSuid();
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		
//		Tables tables=new Tables();
		Tables2 tables=new Tables2();
		tables.setTableId(1);
		System.out.println(suid.select(tables));
		
		Columns columns=new Columns();
		columns.setTableId(1);
		System.out.println(suid.select(columns));
		
		
		MoreTable moreTable=BeeFactory.getHoneyFactory().getMoreTable();
		System.out.println(moreTable.select(tables));
		
	}

}
