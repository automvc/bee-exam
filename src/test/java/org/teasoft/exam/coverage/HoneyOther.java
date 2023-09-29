/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.coverage;

import org.junit.Test;
import org.teasoft.honey.osql.autogen.GenConfig;
import org.teasoft.honey.osql.core.BootApplicationProp;
import org.teasoft.honey.osql.core.NoCache;

/**
 * @author Kingstar
 * @since  1.17
 */
public class HoneyOther {
	
	@Test
	public void test() {
		GenConfig genConfig=new GenConfig();
		genConfig.getBaseDir();
		genConfig.getCommentPlace();
		genConfig.getDbName();
		genConfig.getEncode();
		genConfig.getEntityNamePre();
		genConfig.getFieldFilePrefix();
		genConfig.getFieldFileRelativeFolder();
		genConfig.getFieldFileSuffix();
		genConfig.getPackagePath();
		genConfig.getQueryColumnCommnetSql();
		genConfig.getQueryTableCommnetSql();
		genConfig.getQueryTableSql();
		
		NoCache noCache=new NoCache();
		noCache.add("test noCache", null);
		noCache.clear("test noCache");
		noCache.get("test noCache");
		
//		BeeActiveProp prop=new BeeActiveProp("bee-dev.properties");
		BootApplicationProp prop=new BootApplicationProp();
		prop.getKeys();
		prop.getProp(BootApplicationProp.DATASOURCE_URL);
		prop.getPropText(BootApplicationProp.DATASOURCE_USERNAME);
		
	}

}
