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
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.core.HoneyContext;

/**
 * @author Kingstar
 * @since  2.0
 */
public class InitDsAndMongoDsUtil {
	
	public static void initDS() {
		try {

			
			
			HoneyConfig config=HoneyConfig.getHoneyConfig();
			config.multiDS_enable=true;
			config.multiDS_differentDbType=false;
			config.multiDS_sharding=true;
//			config.multiDS_defalutDS="ds0";
//			HoneyContext.setConfigRefresh(true); //涉及路由信息更新要刷新
//			HoneyContext.setDsMapRefresh(true); //在配置文件中修改才要刷新解析
			
			MongodbSimpleDataSource dataSource0=new MongodbSimpleDataSource("mongodb://localhost:27017/ds0","","");//没有设置用户名和密码,仅用于测试
//			MongodbSimpleDataSource dataSource0=new MongodbSimpleDataSource("mongodb://localhost:27017/testa","","");一般的数据库名也是可以的
			MongodbSimpleDataSource dataSource1=new MongodbSimpleDataSource("mongodb://localhost:28018/ds1","","");

			Map<String, DataSource> dataSourceMap = new LinkedHashMap<>();
			dataSourceMap.put("ds0", dataSource0);  //key值需要数据后缀,有规则可以处理更加高效.
			dataSourceMap.put("ds1", dataSource1);

			BeeFactory.getInstance().setDataSourceMap(dataSourceMap);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
