/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.special.primarykey;

import org.teasoft.bee.osql.MapSql;
import org.teasoft.bee.osql.MapSqlKey;
import org.teasoft.bee.osql.MapSqlSetting;
import org.teasoft.bee.osql.MapSuid;
import org.teasoft.honey.distribution.GenIdFactory;
import org.teasoft.honey.osql.core.BeeFactoryHelper;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.11
 */
public class InsertAndReturnIdWithPK {
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		
		MapSuid mapSuid = BeeFactoryHelper.getMapSuid();
		
		MapSql inserMapSql = BeeFactoryHelper.getMapSql();
//		inserMapSql.put(MapSqlKey.Table, "test_user");
		String tableName = "TestPrimaryKey";
		inserMapSql.put(MapSqlKey.Table, tableName);
		inserMapSql.put(MapSqlSetting.IsNamingTransfer, true);
		inserMapSql.put(MapSqlKey.PrimaryKey, "myid");
		
		inserMapSql.put("name", "test_pk");
		inserMapSql.put("remark", null);
		inserMapSql.put("remark2", "");
		long id0=mapSuid.insertAndReturnId(inserMapSql);
		Logger.info(id0);
		
		long aaa=GenIdFactory.get(tableName);
		System.err.println("第二次拿的id: "+aaa);
		inserMapSql.put("myid",aaa); //分布式ID
		long id1=mapSuid.insertAndReturnId(inserMapSql);
		Logger.info(id1);
		
		inserMapSql.put("myid",GenIdFactory.get(tableName)); //分布式ID
		inserMapSql.put(MapSqlSetting.IsIncludeEmptyString, true);
		long id2=mapSuid.insertAndReturnId(inserMapSql);
		Logger.info(id2);
		
		inserMapSql.put("myid",GenIdFactory.get(tableName)); //分布式ID
		inserMapSql.put(MapSqlSetting.IsIncludeNull, true);
		long id3=mapSuid.insertAndReturnId(inserMapSql);
		Logger.info(id3);
	}

}
