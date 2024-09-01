/*
 * Copyright 2019-2024 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam;

import org.teasoft.exam.bee.osql.autogen.GenBeanExam;
import org.teasoft.exam.bee.osql.autogen.GenBeanSimple2;
import org.teasoft.exam.bee.osql.autogen.GenLombokJavabean;
import org.teasoft.exam.bee.osql.autogen.GenSwaggerJavabean;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  2.4.0
 */
public class GenBeanTest {

//	@Test
	public static void test() {
		try {
			GenBeanSimple2.test();
			GenLombokJavabean.test();
			GenSwaggerJavabean.test();
			GenBeanExam.test();
			org.teasoft.exam.bee.osql.localdatetime.GenBeanExam.test();
		} catch (Exception e) {
			Logger.error("---------in GenBeanTest----------: " + e.getMessage());
		}
	}

}
