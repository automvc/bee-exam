/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.sharding;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.teasoft.beex.mongodb.ds.MongodbSimpleDataSource;
import org.teasoft.honey.osql.core.BeeFactory;

/**
 * @author Kingstar
 * @since  1.11
 */
public class InitDsAndMongoDsUtil {
	
	public static void initDS() {
		try {

			MongodbSimpleDataSource dataSource0=new MongodbSimpleDataSource("mongodb://localhost:27017/ds0","","");
			MongodbSimpleDataSource dataSource1=new MongodbSimpleDataSource("mongodb://localhost:28018/ds1","","");

			Map<String, DataSource> dataSourceMap = new LinkedHashMap<>();
			dataSourceMap.put("ds0", dataSource0); 
			dataSourceMap.put("ds1", dataSource1);
			
			BeeFactory.getInstance().setDataSourceMap(dataSourceMap);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
