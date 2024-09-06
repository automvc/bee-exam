/*
 * Copyright 2019-2024 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.special.pgsql;

import java.util.List;

import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;

//import entity.PgType1;

/**
 * @author Kingstar
 * @since  2.4.0
 */
public class PgSuidExam {

	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		SuidRich suidRich = BF.getSuidRich();
		
		
		PgType1 pgType = new PgType1();
		pgType.setId(6);
		pgType.setName("Example Name");
//	        pgType.setJson1("{\"key\":\"value\"}");  
		pgType.setJson1("{\"key\":\"value\",\"key6\":\"value6\"}");
		pgType.setJsonb2("{\"key6\":\"value6\"}");

		pgType.setBytea3(new byte[] { 0x01, 0x02, 0x03 });
		suidRich.insert(pgType);

		PgType1 pgType6 = new PgType1();
		
		List<PgType1> list = suidRich.select(pgType6);
		Printer.printList(list);
		
		
		pgType.setJson1("{\"key\":\"value\",\"key6-update\":\"value6-update\"}");
		pgType.setJsonb2("{\"key6-update\":\"value6-update\"}");
		
		suidRich.update(pgType);
		list = suidRich.select(pgType6);
		Printer.printList(list);
		
	}

}
