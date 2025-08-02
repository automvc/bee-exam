/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.comm;

import org.teasoft.exam.bee.test.ClearDsContext;
import org.teasoft.honey.logging.Logger;

/**
 * @author Kingstar
 * @since  1.7.2
 */
public class TestHelper {
	
	public static void markStart(String startMsg){
		Logger.info("[bee-exam] ===================="+startMsg+"======start:");
	}
	
	public static void markEnd(String endMsg){
		Logger.info("[bee-exam] ===================="+endMsg+"======end.\n");
	}
	
	
	public static void runTest(Class c) {
		
		try {
//			c.getName()
			String simpleName=c.getSimpleName();
			markStart(simpleName+".test");
			c.getMethod("test", null).invoke(null, null);
//		           如果底层方法是静态的，那么可以忽略指定的 obj 参数。该参数可以为 null。 
			markEnd(simpleName+".test");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			 e.printStackTrace();
		}finally {
			ClearDsContext.clear(); //2.1
		}
	}

}
