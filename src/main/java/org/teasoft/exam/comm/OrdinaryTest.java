/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.comm;

import org.teasoft.honey.util.StringUtils;

/**
 * @author Kingstar
 * @since  1.9
 */
public class OrdinaryTest {
	
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		Object object=null;
		System.out.println(StringUtils.isBlank((String)object));
	}

}
