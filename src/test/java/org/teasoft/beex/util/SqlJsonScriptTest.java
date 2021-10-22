/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.beex.util;

import java.io.IOException;

import org.junit.Test;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.9.8
 */
public class SqlJsonScriptTest {
	
	@Test
	public void test() throws IOException{
		Logger.info(SqlJsonScript.tableJsonScript("orders"));
	}
	
}
