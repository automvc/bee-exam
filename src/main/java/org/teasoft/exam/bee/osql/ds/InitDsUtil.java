/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.ds;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.teasoft.exam.bee.test.ClearDsContext;
import org.teasoft.honey.osql.core.BeeFactory;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @author Kingstar
 * @since  1.11
 */
public class InitDsUtil {
	
	public static void initDS() {
		try {
			
			ClearDsContext.clear();

			DruidDataSource dataSource1;
			dataSource1 = new DruidDataSource();
			dataSource1.setUrl("jdbc:mysql://localhost:3306/bee?characterEncoding=UTF-8&useSSL=false");
			dataSource1.setUsername("root");
			dataSource1.setPassword("123456");
			dataSource1.init();

//			DruidDataSource dataSource2;
//			dataSource2 = new DruidDataSource();
//			dataSource2.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
//			dataSource2.setUsername("scott");
//			dataSource2.setPassword("aaa");
//			dataSource2.init();
			
					
//			DruidDataSource dataSource2;
//			dataSource2 = new DruidDataSource();
//			dataSource2.setUrl("jdbc:sqlite:bee.db");
//			dataSource2.setUsername("");
//			dataSource2.setPassword("");
//			dataSource2.init();

			DruidDataSource dataSource3;
			dataSource3 = new DruidDataSource();
			dataSource3.setUrl("jdbc:mysql://localhost:3306/pro?characterEncoding=UTF-8&useSSL=false");
			dataSource3.setUsername("root");
			dataSource3.setPassword("123456");
			dataSource3.init();

//			以上数据源,也可以通过XML方式配置
//			(二十二)ORM框架Bee,Spring配置多数据源实例
//			https://blog.csdn.net/abckingaa/article/details/120956130
			Map<String, DataSource> dataSourceMap = new LinkedHashMap<>();
			dataSourceMap.put("ds0", dataSource1);
//			dataSourceMap.put("ds1", dataSource2); //ds2
			dataSourceMap.put("ds1", dataSource1); //ds2
			dataSourceMap.put("ds2", dataSource3); //ds3
			BeeFactory.getInstance().setDataSourceMap(dataSourceMap);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
