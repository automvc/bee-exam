/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.other.access;

import org.junit.Test;
import org.teasoft.exam.MySqlOneConfig;
import org.teasoft.exam.bee.access.ds.AccessDbTest;
import org.teasoft.exam.bee.mongodb.sharding.ClearDsAndMongoDsUtil;

/**
 * @author Kingstar
 * @since  2.1
 */
public class AccessDsTest {
	
	@Test
	public void test() {
		try {
			AccessDbTest.test();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MySqlOneConfig.reset(); //预防测试无序,跳到其它类
		}
		
	}

}
