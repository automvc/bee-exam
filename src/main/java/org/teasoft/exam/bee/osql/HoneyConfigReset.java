/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import org.teasoft.bee.osql.SuidRich;
import org.teasoft.honey.osql.core.BeeFactoryHelper;
import org.teasoft.honey.osql.core.HoneyConfig;

/**
 * @author Kingstar
 * @since  1.9.8
 */
public class HoneyConfigReset {
	
	public static void main(String[] args) {
		test();
	}
	public static void test() {
	
		HoneyConfig.getHoneyConfig().resetBeeProperties("D:\\temp\\"); //  bee.properties所在的路径
		SpecialTest.testNoId();
		
		HoneyConfig.getHoneyConfig().resetBeeProperties("D:\\temp"); //  bee.properties所在的路径
		SpecialTest.testNoId();
		
		HoneyConfig.getHoneyConfig().active="test";//重新new后,值不见了
		HoneyConfig.getHoneyConfig().type=1; //重新new后,值不见了
		HoneyConfig.getHoneyConfig().resetBeeProperties("D:\\temp"); //  bee.properties所在的路径
		SpecialTest.testNoId();
	}

}
