/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.honey.util;

import org.junit.Assert;
import org.junit.Test;
import org.teasoft.honey.util.currency.LongArithmetic;

/**
 * @author Kingstar
 * @since  2.1.8
 */
public class LongArithmeticTest {

	@Test
	public void test() {
//		LongArithmetic.add("1", "2");
//		LongArithmetic.subtract("1", "2");
//		LongArithmetic.multiply("1", "2");

		Assert.assertEquals("3", LongArithmetic.add("1", "2"));
		Assert.assertEquals("-1", LongArithmetic.subtract("1", "2"));
		Assert.assertEquals("2", LongArithmetic.multiply("1", "2"));
	}

}
