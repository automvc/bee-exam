/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.util.Map;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.MapSql;
import org.teasoft.bee.osql.MapSqlKey;
import org.teasoft.bee.osql.MapSqlSetting;
import org.teasoft.bee.osql.MapSuid;
import org.teasoft.honey.osql.core.BeeFactoryHelper;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.util.ObjectUtils;

/**
 * @author Kingstar
 * @since  1.9
 */
public class MapSuidExam {
	public static void main(String[] args) {
		test();
		test2();
	}

	public static void test() {
	
		try {
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
			
			
			long id1=mapSuid.insert(inserMapSql);
			Logger.info(id1);
			
			inserMapSql.put(MapSqlSetting.IsIncludeEmptyString, true);
			long id2=mapSuid.insert(inserMapSql);
			Logger.info(id2);
			
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
	    mapSql.put(MapSqlKey.Table, "orders--"); //TODO 过滤
		mapSql.put(MapSqlKey.SelectColumns, "*");
		mapSql.put(MapSqlSetting.IsNamingTransfer, true);
		String json = mapSuid.selectJson(mapSql);
		
		Logger.info(json);
//		System.err.println(json);
	}

}
