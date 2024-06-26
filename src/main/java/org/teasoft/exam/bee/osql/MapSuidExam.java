/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.util.Map;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.DatabaseConst;
import org.teasoft.bee.osql.MapSqlKey;
import org.teasoft.bee.osql.MapSqlSetting;
import org.teasoft.bee.osql.api.MapSql;
import org.teasoft.bee.osql.api.MapSuid;
import org.teasoft.bee.osql.dialect.DbFeatureRegistry;
import org.teasoft.honey.distribution.GenIdFactory;
import org.teasoft.honey.osql.core.BeeFactoryHelper;
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.util.ObjectUtils;

/**
 * @author Kingstar
 * @since  1.9
 */
public class MapSuidExam {
	public static void main(String[] args) {
		test();
//		test2();
	}

	public static void test() {
	
		try {
			
			//sql server>=2012 ,use old type,用回旧语法
//			HoneyConfig.getHoneyConfig().getDbName();
//			DbFeatureRegistry.register(DatabaseConst.SQLSERVER, null); 
//			HoneyConfig.getHoneyConfig().setDatabaseMajorVersion(0); 
			
			MapSuid mapSuid = BeeFactoryHelper.getMapSuid();
			
			MapSql mapSql = BeeFactoryHelper.getMapSql();

		    mapSql.put(MapSqlKey.Table, "test_user");
//			mapSql.put(MapSqlKey.Table, "testUser");
			mapSql.put(MapSqlKey.SelectColumns, "name,password");
			mapSql.put(MapSqlKey.OrderBy, "name");
			
			mapSql.put(MapSqlSetting.IsNamingTransfer, true);
//			mapSql.put(MapSqlSetting.IsIncludeEmptyString, true);
			mapSql.put(MapSqlSetting.IsIncludeNull, true);

			mapSql.put("name", "Bee");
			mapSql.put("email", ""); //emptyString
			mapSql.put("lastName", null);
//			mapSql.put("last_name", null);

			String json = mapSuid.selectJson(mapSql);
			Logger.info(json);
//		    mapSuid.selectJson(mapSql); //test cache

			mapSuid.select(mapSql);
			mapSuid.select(mapSql);
			
			mapSql.size(5);
			mapSuid.select(mapSql);
			
			mapSql.start(2);
			mapSql.size(5);
			mapSuid.select(mapSql);

			Map map = mapSuid.selectOne(mapSql);
			if (ObjectUtils.isNotEmpty(map)) {
				Logger.info(map.get("name").toString());
				Logger.info(map.get("password").toString());
			}
			mapSuid.selectOne(mapSql);
			
			
			MapSql inserMapSql = BeeFactoryHelper.getMapSql();
//			inserMapSql.put(MapSqlKey.Table, "test_user");
			inserMapSql.put(MapSqlKey.Table, "testUser");
			inserMapSql.put(MapSqlSetting.IsNamingTransfer, true);
			
			inserMapSql.put("email", "test@gmail.com");
			inserMapSql.put("password", "password@gmail.com");
			inserMapSql.put("lastName", "MapSuid");
			inserMapSql.put("name", "");
			inserMapSql.put("username", null);
//			inserMapSql.put("id",1);
			inserMapSql.put("id",GenIdFactory.get("testUser")); //分布式ID
			
			
			long id1=mapSuid.insert(inserMapSql);
			Logger.info(id1);
			
			inserMapSql.put("id",GenIdFactory.get("testUser")); //分布式ID
			inserMapSql.put(MapSqlSetting.IsIncludeEmptyString, true);
			long id2=mapSuid.insert(inserMapSql);
			Logger.info(id2);
			
			inserMapSql.put("id",GenIdFactory.get("testUser")); //分布式ID
			inserMapSql.put(MapSqlSetting.IsIncludeNull, true);
			long id3=mapSuid.insert(inserMapSql);
			Logger.info(id3);
			
			mapSuid.selectOne(mapSql);
			
			MapSql mapSql2 = BeeFactoryHelper.getMapSql();
			//模拟修改密码
		    mapSql2.put(MapSqlKey.Table, "test_user");
			mapSql2.put(MapSqlSetting.IsNamingTransfer, false);
			mapSql2.put(MapSqlSetting.IsIncludeEmptyString, false);
			mapSql2.put("id", 800001L);
			mapSql2.put("password", "bee");
			mapSql2.putNew("password", "bee-new");		
			mapSuid.update(mapSql2);
			
			
			
			MapSql mapSql3 = BeeFactoryHelper.getMapSql();

		    mapSql3.put(MapSqlKey.Table, "test_user");
			mapSql3.put(MapSqlKey.SelectColumns, "name,password");
			mapSql3.put(MapSqlKey.OrderBy, "name,password desc"); //多字段排序
//			mapSql3.put(MapSqlKey.OrderBy, "-- name,password desc"); //多字段排序
			
			mapSql3.put(MapSqlSetting.IsNamingTransfer, true);
			

			String json3 = mapSuid.selectJson(mapSql3);
			Logger.info(json3);
			
			
			mapSql3.start(2);
			mapSql3.size(5);
			mapSuid.selectJson(mapSql3);

		} catch (BeeException e) {
			e.printStackTrace();
			Logger.error("In MapSuidExam (BeeException):" + e.getMessage());
		} catch (Exception e) {
			Logger.error("In MapSuidExam (Exception):" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	private static void test2() {
		
		MapSuid mapSuid = BeeFactoryHelper.getMapSuid();
		MapSql mapSql = BeeFactoryHelper.getMapSql();
//	    mapSql.put(MapSqlKey.Table, "orders--"); // 过滤
	    mapSql.put(MapSqlKey.Table, "orders"); 
		mapSql.put(MapSqlKey.SelectColumns, "*");
		mapSql.put(MapSqlSetting.IsNamingTransfer, true);
		String json = mapSuid.selectJson(mapSql);
		
		Logger.info(json);
//		System.err.println(json);
	}

}
