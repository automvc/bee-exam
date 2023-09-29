/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.honey.util;

import org.junit.Test;
import org.teasoft.honey.util.currency.CurrencyExpressionArith;

/**
 * @author Kingstar
 * @since  2.1.8
 */
public class CurrencyExpressionArithTest {
	
	@Test
	public void test() {
		
		System.out.println(CurrencyExpressionArith.preCheckExpression("10-1*9"));
		
	}

}
