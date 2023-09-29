/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.honey.util;

import org.junit.Test;
import org.teasoft.honey.util.currency.CurrencyArithmetic;

/**
 * @author Kingstar
 * @since  2.1
 */
public class CurrencyArithmeticTest {
	
	@Test
	public void test() {
		System.out.println(CurrencyArithmetic.remainder("-1", "2"));

		int a = -1;
		int b = 2;
		int c = a % b;

		System.out.println(c);

		System.out.println(CurrencyArithmetic.add("-1", "2"));
		System.out.println(CurrencyArithmetic.subtract("-1", "2"));
		System.out.println(CurrencyArithmetic.multiply("-1", "2"));
		System.out.println(CurrencyArithmetic.divide("-1", "2"));
		System.out.println(CurrencyArithmetic.calculate("-1","+", "2"));
		System.out.println(CurrencyArithmetic.calculate("1","/", "3",2));
		
		
		
	}
}
