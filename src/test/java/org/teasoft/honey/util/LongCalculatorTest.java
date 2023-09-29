/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.honey.util;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.teasoft.honey.util.currency.LongCalculator;

/**
 * @author Kingstar
 * @since  2.1.8
 */
public class LongCalculatorTest {
	
	@Test
	public void test() {
		LongCalculator.preCheckExpression("10-1*9");
		LongCalculator.calculate("10-1*9");
		
		Map<String,String> map=new HashMap<>();
		map.put("a", "9");
		LongCalculator.calculate("10-1*a",map);
	}

}
