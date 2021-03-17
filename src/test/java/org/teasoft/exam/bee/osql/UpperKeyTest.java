/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import org.junit.Test;
import org.teasoft.bee.osql.SqlKeyWord;
import org.teasoft.bee.osql.UpperKey;
import org.teasoft.honey.osql.core.Logger;

/**
	* @author Kingstar
	* @since  1.9
	*/
public class UpperKeyTest {

	@Test
	public void test() {
		SqlKeyWord key = new UpperKey();
		Logger.info(key.select());
		Logger.info(key.where());
	}

}