/*
 * Copyright 2019-2024 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.coverage;

import org.junit.Test;
import org.teasoft.honey.sharding.config.Assign;

/**
 * @author Kingstar
 * @since  2.4.0
 */
public class Other2 {
	@Test
	public void test() {

		new Assign().polling(2, 5, 2);

	}
}
