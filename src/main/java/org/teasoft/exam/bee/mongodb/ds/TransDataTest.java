/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.ds;

import java.util.List;

import org.teasoft.bee.osql.SuidRich;
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  2.1
 */
public class TransDataTest {
	private static SuidRich suidRich = null;
//	static SuidRich suidRich =BF.getSuidRichForMongodb();
//	static SuidRich suidRich =BF.getSuidRich();
//	private static PreparedSql preparedSql = null;
	
	static {
		HoneyConfig.getHoneyConfig().multiDS_enable = true;
		HoneyConfig.getHoneyConfig().multiDS_differentDbType=true;
		InitOtherDsAndMongoDsUtil.initDS();
		HoneyConfig.getHoneyConfig().naming_translateType=1;
	}
	
	public static void main(String[] args) {
		suidRich =BF.getSuidRich();
		suidRich.setDataSourceName("ds1");
		List<Orderhistory> list=suidRich.select(new Orderhistory());
		
		SuidRich suidRich2 =BF.getSuidRichForMongodb(); //明确是获取mongodb的
		suidRich2.setDataSourceName("ds0");
		suidRich2.insert(list);
		
	}

}
