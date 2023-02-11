/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.access.ds;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.teasoft.honey.jdbc.SimpleDataSource;
import org.teasoft.honey.osql.core.BeeFactory;

/**
 * @author Kingstar
 * @since  2.0
 */
public class InitSameAccessDsUtil {
	
	public static void initDS() {
		try {

//			DruidDataSource dataSource0;
//			dataSource0 = new DruidDataSource();
//			dataSource0.setUrl("jdbc:ucanaccess://d:/school.accdb");
//			dataSource0.setUsername("");
//			dataSource0.setPassword("");
//			dataSource0.init();
//
//			DruidDataSource dataSource1;
//			dataSource1 = new DruidDataSource();
//			dataSource1.setUrl("jdbc:ucanaccess://d:/school-pw3.accdb;jackcessOpener=org.teasoft.beex.access.BeeAccessCryptOpener");
//			dataSource1.setUsername("");
//			dataSource1.setPassword("123456");
//			dataSource1.init();
			
			SimpleDataSource dataSource0=new SimpleDataSource();
			dataSource0.setUrl("jdbc:ucanaccess://d:/school.accdb");
			dataSource0.setUsername("");
			dataSource0.setPassword("");
			dataSource0.init();
			
			SimpleDataSource dataSource1=new SimpleDataSource();
			dataSource1.setUrl("jdbc:ucanaccess://d:/school-pw3.accdb");
			dataSource1.setUsername("");
			dataSource1.setPassword("123456");
			dataSource1.init();

			Map<String, DataSource> dataSourceMap = new HashMap<>();
			dataSourceMap.put("ds0", dataSource0);
			dataSourceMap.put("ds1", dataSource1); 
			BeeFactory.getInstance().setDataSourceMap(dataSourceMap);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
