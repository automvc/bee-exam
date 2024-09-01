/*
 * Copyright 2019-2024 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.localdatetime;

import org.teasoft.honey.osql.autogen.GenBean;
import org.teasoft.honey.osql.autogen.GenConfig;

/**
 * @author Kingstar
 * @since  2.4.0
 */
public class GenBeanExam {
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		
		GenConfig config =new GenConfig();
//		config.setPackagePath("org.teasoft.exam.bee.osql.localdatetime");
//		
//		config.setGenToString(true);
//		
//		new GenBean(config).genSomeBeanFile("localdatetime_table");
		
		config.setPackagePath("org.entity");
		config.setGenToString(true);
		new GenBean(config).genSomeBeanFile("orders");
	}

}
