/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.comm;

import org.teasoft.beex.mongodb.ds.MongoContext;
import org.teasoft.exam.bee.test.ClearDsContext;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.core.HoneyContext;

/**
 * @author Kingstar
 * @since  2.0
 */
public class ClearDsUtil {
	
	public static void  clearConfig() {
//		try {
	        //clear
//			HoneyConfig.getHoneyConfig().multiDS_enable = false;
//			HoneyConfig.getHoneyConfig().multiDS_type = 0;
//			HoneyConfig.getHoneyConfig().multiDS_differentDbType = false;
//			HoneyConfig.getHoneyConfig().multiDS_sharding=false;
//			
//			BeeFactory.getInstance().setDataSource(null);
//	        BeeFactory.getInstance().setDataSourceMap(null);
//	        
//	        HoneyContext.removeCurrentConnection();
//	        MongoContext.removeClientSession();
//	        MongoContext.removeMongoClient();
//	        
//	        HoneyContext.setConfigRefresh(true);
			
			ClearDsContext.clear();

//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

}
