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
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.util.ObjectUtils;

/**
 * @author Kingstar
 * @since  1.9
 */
public class MapSuidExam {
	public static void main(String[] args) {
		test();
	}

	public static void test() {

		try {
			MapSuid mapSuid = BeeFactory.getHoneyFactory().getMapSuid();
			MapSql mapSql = BeeFactory.getHoneyFactory().getMapSql();

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

		} catch (BeeException e) {
			e.printStackTrace();
			Logger.error("In MapSuid (BeeException):" + e.getMessage());
		} catch (Exception e) {
			Logger.error("In MapSuid (Exception):" + e.getMessage());
			e.printStackTrace();
		}
	}

}
