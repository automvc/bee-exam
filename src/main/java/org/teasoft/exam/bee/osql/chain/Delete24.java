/*
 * Copyright 2019-2024 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.chain;

import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.api.PreparedSql;
import org.teasoft.bee.osql.chain.Delete;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.osql.shortcut.CSF;

/**
 * @author Kingstar
 * @since  2.4.0
 */
public class Delete24 {
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		PreparedSql pre=BF.getPreparedSql();
		String count0=pre.selectFun("select count(*) from orders0_copy1");
		Logger.info("before delete ,the count:"+count0);
		
		Delete del=CSF.getDelete();
		del.delete("orders0_copy1");
		del.where();
		del.op("id", Op.gt, 20);
		int r=pre.modify(del.toSQL());
		Logger.info("delete count ,the count:"+r);
		
		String count1=pre.selectFun("select count(*) from orders0_copy1");
		Logger.info("after delete ,the count:"+count1);
//		Logger.info(count0==(r+count1));
		
		Delete drop=CSF.getDelete();
		drop.drop("orders0_copy1");
		pre.modify(del.toSQL());
		
	}
}
