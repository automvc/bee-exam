/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.prod;

/**
 * @author Kingstar
 * @since  1.11
 */
public class InitDsUtil {
	
	public static void initDS() {
		
		org.teasoft.exam.bee.osql.ds.InitDsUtil.initDS();
//		try {
//
//			DruidDataSource dataSource1;
//			dataSource1 = new DruidDataSource();
//			dataSource1.setUrl("jdbc:mysql://localhost:3306/bee?characterEncoding=UTF-8&useSSL=false");
//			dataSource1.setUsername("root");
//			dataSource1.setPassword("123456");
//			dataSource1.init();
//
////			DruidDataSource dataSource2;
////			dataSource2 = new DruidDataSource();
////			dataSource2.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
////			dataSource2.setUsername("scott");
////			dataSource2.setPassword("aaa");
////			dataSource2.init();
//			
//					
//			DruidDataSource dataSource2;
//			dataSource2 = new DruidDataSource();
//			dataSource2.setUrl("jdbc:sqlite:bee.db");
//			dataSource2.setUsername("");
//			dataSource2.setPassword("");
//			dataSource2.init();
//
//			DruidDataSource dataSource3;
//			dataSource3 = new DruidDataSource();
//			dataSource3.setUrl("jdbc:mysql://localhost:3306/pro?characterEncoding=UTF-8&useSSL=false");
//			dataSource3.setUsername("root");
//			dataSource3.setPassword("123456");
//			dataSource3.init();
//
////			以上数据源,也可以通过XML方式配置
////			(二十二)ORM框架Bee,Spring配置多数据源实例
////			https://blog.csdn.net/abckingaa/article/details/120956130
//			Map<String, DataSource> dataSourceMap = new HashMap<>();
//			dataSourceMap.put("ds1", dataSource1);
//			dataSourceMap.put("ds2", dataSource2); //ds2s
//			dataSourceMap.put("ds3", dataSource3); //ds3
//			BeeFactory.getInstance().setDataSourceMap(dataSourceMap);
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}

}
