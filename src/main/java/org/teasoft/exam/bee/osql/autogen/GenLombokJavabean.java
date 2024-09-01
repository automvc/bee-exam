/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.autogen;

import org.teasoft.honey.osql.autogen.GenBean;
import org.teasoft.honey.osql.autogen.GenConfig;

/**
 * @author Kingstar
 * @since  2.1
 */
public class GenLombokJavabean {
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		GenConfig config = new GenConfig();
		config.setLombokGetter(true);
		config.setLombokSetter(true);
		
//		config.setLombokData(true);
		
		config.setGenSerializable(false);
		
		GenBean genBean = new GenBean(config);
		
		genBean.genSomeBeanFile("orders");
	}

}
