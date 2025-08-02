/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.osql.entity.TestUser;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.HoneyConfig;

/**
 * 测试单条插入遇到重复键约束, 异常捕获和显示的问题
 * @author Kingstar
 * @since  1.11
 */
public class DuplicateExceptionTest {
	private static SuidRich suidRich=BeeFactory.getHoneyFactory().getSuidRich();
	public static void main(String[] args) {
		TestUser testUser=new TestUser();
		testUser.setId(800001L);
		suidRich.insert(testUser);
		suidRich.insert(testUser);
		suidRich.insert(testUser);
		
		HoneyConfig config=HoneyConfig.getHoneyConfig();
		
		Logger.warn("----------test not Show ModifyDuplicateException-----------------");
		config.notShowModifyDuplicateException=true;  //不显示
		int a=suidRich.insert(testUser);
		Logger.warn(a);  //0 ,如果有需要可通过返回结果判断
		
		Logger.warn("----------test not Catch ModifyDuplicateException-----------------");
		config.notCatchModifyDuplicateException=true; //不捕获
		suidRich.insert(testUser);
	}

}
