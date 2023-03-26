/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.beex.util;



import org.teasoft.exam.BeeAbstractTest;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.9.8
 */
public class SqlJsonScriptTest2 extends BeeAbstractTest{

	@Override
	public void test() {
		try {
//			int a=1/0;
			Logger.info(SqlJsonScript.tableJsonScript("orders"));
		} catch (Exception e) {
			Logger.error(e.getMessage(),e);
		}
	}

}
