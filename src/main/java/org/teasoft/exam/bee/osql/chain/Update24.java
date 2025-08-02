/*
 * Copyright 2019-2024 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.chain;

import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.api.PreparedSql;
import org.teasoft.bee.osql.chain.Update;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.osql.shortcut.CSF;

/**
 * @author Kingstar
 * @since  2.4.0
 */
public class Update24 {
	
	private static PreparedSql preparedSql = BF.getPreparedSql();
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		
		Update update=CSF.getUpdate();
		
//		update t2,t  --虽然只是更新一张表，但应该将两个表都写入，不然set和where 处不能引用另一个表的字段。
//		set t2.b=t.b
//		where t2.a=t.a

		update.update("t2,t")
		.setWithField("t2.b", "t.b")
//		.where("t2.a=t.a");
		.where()
		.opWithField("t2.a", Op.eq, "t.a");
		try {
			preparedSql.modify(update.toSQL());
		} catch (Exception e) {
			Logger.warn("Exception in Update24.  "+e.getMessage());
		}
		
		update=CSF.getUpdate();
		update.update("t2").update("t")
		.setWithField("t2.b", "t.b")
		.setAdd("total", 2)
		.set("price", 20)
//		.where("t2.a=t.a");
		.where()
		.op("id", 111)
		.opWithField("t2.a", Op.eq, "t.a");
		
		
	}

}
