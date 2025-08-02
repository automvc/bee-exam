/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.commomid;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.teasoft.bee.osql.MapSqlKey;
import org.teasoft.bee.osql.MapSqlSetting;
import org.teasoft.bee.osql.api.MapSql;
import org.teasoft.bee.osql.api.MapSuid;
import org.teasoft.bee.osql.api.Suid;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.autogen.Ddl;
import org.teasoft.honey.osql.core.BeeFactoryHelper;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  1.17
 */
public class StringIdUUIDTest {
	
	public static void main(String[] args) {
		test();
	}
	public static void test() {
		
		System.out.println(Integer.MAX_VALUE);
		
		Ddl.createTable(Orders3.class, true);
		
		Orders3 orders=new Orders3();
		orders.setName("Bee");
		Suid suid=BF.getSuid();
		suid.insert(orders);
		
		Orders3 orders2=new Orders3();
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
