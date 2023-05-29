/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.special;

import org.teasoft.bee.osql.api.Suid;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.osql.entity.TestUser;
import org.teasoft.honey.osql.core.HoneyConfig;
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
			
			HoneyConfig.getHoneyConfig().cache_timeout=10;  //20毫秒
			HoneyConfig.getHoneyConfig().cache_levelTwoTimeout=6; //6秒
//			HoneyContext.setConfigRefresh(true); //没有触发机会
			
//			Cache cache=new BeeExtRedisCache();
//			BeeFactory.getHoneyFactory().setCache(cache);
			
			Suid suid = BF.getSuid();
			TestUser testUser=new TestUser();
			testUser.setId(0L);
			
			suid.select(testUser);
			suid.select(testUser); // test whether use cache
			
			
			SuidRich suidRich = BF.getSuidRich();
			suidRich.selectById(TestUser.class, -1L);
			suidRich.selectById(TestUser.class, -1L);
			
			//放在这没用.要放到第一个查询前.
//			HoneyConfig.getHoneyConfig().cache_timeout=20;  //20毫秒
//			HoneyConfig.getHoneyConfig().cache_levelTwoTimeout=6; //6秒
////			HoneyContext.setConfigRefresh(true); //没有触发机会
			
			//测试二级缓存的抵御缓存穿透能力
			suidRich.selectById(TestUser.class, -1L);
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			suidRich.selectById(TestUser.class, -1L);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
