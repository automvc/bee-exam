/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.tran;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.teasoft.beex.mongodb.ds.MongodbSimpleDataSource;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.HoneyConfig;

/**
 * @author Kingstar
 * @since  2.0
 */
public class InitDsAndMongoDsUtil {
	
	public static void initDS() {
		try {

			MongodbSimpleDataSource dataSource0=new MongodbSimpleDataSource("mongodb://127.0.0.1:28011/testa,127.0.0.1:28012/testa,127.0.0.1:28013/testa","","");//没有设置用户名和密码,仅用于测试
//			MongodbSimpleDataSource dataSource1=new MongodbSimpleDataSource("mongodb://localhost:28018/ds1","","");

			Map<String, DataSource> dataSourceMap = new LinkedHashMap<>();
			dataSourceMap.put("ds0", dataSource0); 
//			dataSourceMap.put("ds1", dataSource1);
			dataSourceMap.put("ds1", dataSource0);
			
			BeeFactory.getInstance().setDataSourceMap(dataSourceMap);
			HoneyConfig.getHoneyConfig().multiDS_enable=true;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
