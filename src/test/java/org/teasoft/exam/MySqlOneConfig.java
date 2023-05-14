/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam;

import org.teasoft.bee.osql.DatabaseConst;
import org.teasoft.exam.bee.mongodb.sharding.ClearDsAndMongoDsUtil;
import org.teasoft.honey.osql.core.HoneyConfig;

/**
 * @author Kingstar
 * @since  2.1
 */
public class MySqlOneConfig {
	
	public static void reset() {
		ClearDsAndMongoDsUtil.clearConfig(); //先清空 
		HoneyConfig honeyConfig = HoneyConfig.getHoneyConfig();
		honeyConfig.setDbName(DatabaseConst.MYSQL);
		honeyConfig.setUrl("jdbc:mysql://localhost:3306/bee?characterEncoding=UTF-8&useSSL=false");
		honeyConfig.setUsername("root");
		honeyConfig.setPassword("123456");
	}

}
