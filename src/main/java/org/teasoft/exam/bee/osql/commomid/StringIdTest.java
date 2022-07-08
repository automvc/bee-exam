/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.commomid;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.teasoft.bee.osql.MapSql;
import org.teasoft.bee.osql.MapSqlKey;
import org.teasoft.bee.osql.MapSqlSetting;
import org.teasoft.bee.osql.MapSuid;
import org.teasoft.bee.osql.Suid;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.honey.osql.core.BeeFactoryHelper;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  1.17
 */
public class StringIdTest {
	
	public static void main(String[] args) {
		test();
	}
	public static void test() {
		
		System.out.println(Integer.MAX_VALUE);
		
		Orders2 orders=new Orders2();
		orders.setName("Bee");
		Suid suid=BF.getSuid();
		suid.insert(orders);
		
		Orders2 orders2=new Orders2();
		orders2.setName("Bee");
		orders2.setRemark("2222");
		
		List list=new ArrayList();
		list.add(orders);
		list.add(orders2);
		
		SuidRich suidRich=BF.getSuidRich();
		suidRich.insert(list);
		
		
		
		MapSql inserMapSql = BeeFactoryHelper.getMapSql();
		inserMapSql.put(MapSqlKey.Table, "testUser");
		inserMapSql.put(MapSqlSetting.IsNamingTransfer, true);
		
		inserMapSql.put("email", "test@gmail.com");
		inserMapSql.put("password", "password@gmail.com");
		inserMapSql.put("lastName", "MapSuid");
		inserMapSql.put("name", "");
		inserMapSql.put("username", null);
		inserMapSql.put(MapSqlSetting.IsGenId, true);
		inserMapSql.put(MapSqlSetting.IsUseIntegerId, true);
//		inserMapSql.put("id",GenIdFactory.get("testUser")); //分布式ID
		
		MapSuid mapSuid =BF.getMapSuid();
		long id1=mapSuid.insert(inserMapSql);
		Logger.info(id1);
		
		
		String uuid= UUID.randomUUID().toString();
		System.out.println(uuid);
	}

}
