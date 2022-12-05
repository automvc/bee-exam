/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.ds;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.teasoft.beex.mongodb.MongodbSimpleDataSource;
import org.teasoft.honey.osql.core.BeeFactory;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @author Kingstar
 * @since  1.11
 */
public class InitDsAndMongoDsUtil {
	
	public static void initDS() {
		try {

			MongodbSimpleDataSource dataSource0=new MongodbSimpleDataSource("mongodb://localhost:27017/bee","","");
			
			DruidDataSource dataSource1;
			dataSource1 = new DruidDataSource();
			dataSource1.setUrl("jdbc:mysql://localhost:3306/bee?characterEncoding=UTF-8&useSSL=false");
			dataSource1.setUsername("root");
			dataSource1.setPassword("123456");
			dataSource1.init();

			DruidDataSource dataSource2;
			dataSource2 = new DruidDataSource();
			dataSource2.setUrl("jdbc:mysql://localhost:3306/pro?characterEncoding=UTF-8&useSSL=false");
			dataSource2.setUsername("root");
			dataSource2.setPassword("123456");
			dataSource2.init();

//			以上数据源,也可以通过XML方式配置
//			(二十二)ORM框架Bee,Spring配置多数据源实例
//			https://blog.csdn.net/abckingaa/article/details/120956130
			Map<String, DataSource> dataSourceMap = new LinkedHashMap<>();
			dataSourceMap.put("ds0", dataSource0); 
			dataSourceMap.put("ds1", dataSource1);
			dataSourceMap.put("ds2", dataSource2); 
			
			BeeFactory.getInstance().setDataSourceMap(dataSourceMap);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
