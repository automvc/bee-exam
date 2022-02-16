/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.special;

import org.teasoft.bee.osql.Suid;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.osql.entity.TestUser;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * 测试缓存穿透.Bee默认能抵御缓存穿透
 * @author Kingstar
 * @since  1.11
 */
public class NullUseCache {
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		try {
			
//			Cache cache=new BeeExtRedisCache();
//			BeeFactory.getHoneyFactory().setCache(cache);
			
			Suid suid = BF.getSuid();
			TestUser testUser=new TestUser();
			testUser.setId(0L);
			
			suid.select(testUser);
			suid.select(testUser); // test whether use cache
			
			
			SuidRich suidRich = BF.getSuidRich();
			suidRich.selectById(new TestUser(), -1L);
			suidRich.selectById(new TestUser(), -1L);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
