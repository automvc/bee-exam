/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.beex.poi.entity;

import org.junit.Test;
import org.teasoft.honey.osql.autogen.Ddl;

/**
 * @author Kingstar
 * @since  1.9
 */
public class CreateTableWithJavabean2 {
	@Test
	public void test() {
		Ddl.createTable( LeftszInfo.class, true);
	}

}
