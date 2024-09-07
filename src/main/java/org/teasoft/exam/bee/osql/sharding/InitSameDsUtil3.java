/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.sharding;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.teasoft.exam.bee.test.ClearDsContext;
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.core.HoneyContext;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @author Kingstar
 * @since  2.0
 */
public class InitSameDsUtil3 {
	
	public static void initDS() {
		try {
			ClearDsContext.clear();

			HoneyConfig honeyConfig = HoneyConfig.getHoneyConfig();
			honeyConfig.multiDS_enable = true;
			honeyConfig.multiDS_type = 0;
			honeyConfig.multiDS_differentDbType = false;
			honeyConfig.multiDS_defalutDS="ds0"; //路由信息
			honeyConfig.setMultiDsSharding(true); //仅用于测试;在生产上,bee.dosql.multiDS.sharding应该放在配置文件中设置;且运行过程不宜更改,否则会丢失有关配置和上下文信息.
			HoneyContext.setConfigRefresh(true); //涉及路由信息更新要刷新
			
			DruidDataSource dataSource0;  //只是测试,在开发/测试阶段,不想引入DruidDataSource也可以换成SimpleDataSource
			dataSource0 = new DruidDataSource();
			dataSource0.setUrl("jdbc:mysql://localhost:3306/bee?characterEncoding=UTF-8&useSSL=false");
			dataSource0.setUsername("root");
			dataSource0.setPassword("123456");
			
//			dataSource0.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
//			dataSource0.setUsername("scott");
//			dataSource0.setPassword("Bee123456");
			
			dataSource0.init();
			


			DruidDataSource dataSource1;
			dataSource1 = new DruidDataSource();
			dataSource1.setUrl("jdbc:mysql://localhost:3306/pro?characterEncoding=UTF-8&useSSL=false");
			dataSource1.setUsername("root");
			dataSource1.setPassword("123456");
			dataSource1.init();

//			以上数据源,也可以通过XML方式配置
//			(二十二)ORM框架Bee,Spring配置多数据源实例
//			https://blog.csdn.net/abckingaa/article/details/120956130
			Map<String, DataSource> dataSourceMap = new HashMap<>();
			dataSourceMap.put("ds0", dataSource0);
			dataSourceMap.put("ds1", dataSource1); 
//			dataSourceMap.put("ds1", dataSource0); 
//			BeeFactory.getInstance().setDataSourceMap(dataSourceMap);
			HoneyContext.setDataSourceMap(dataSourceMap);//V2.1
			


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
