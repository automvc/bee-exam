/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.honey.util;

import org.junit.Test;

/**
 * @author Kingstar
 * @since  2.1.8
 */
public class NumUtilTest {
	
	@Test
	public void test() {
		System.out.println(NumUtil.getRandomNum(6));
		System.out.println(NumUtil.getRandomNum6());
		
		System.out.println(NumUtil.isMobileNum11("12345678912"));
		System.out.println(NumUtil.isMobileNum11("22345678912"));
		System.out.println(NumUtil.isMobileNum11("123456789123"));
		System.out.println(NumUtil.isMobileNum11("12399999999"));
		System.out.println(NumUtil.isMobileNum11("1239999999a"));
		System.out.println(NumUtil.isMobileNum11("1239999999_"));
	}

}
