/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.honey.osql.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kingstar
 * @since  1.11
 */
public class NameCheckUtilTest {
	
	@Test
	public void test() {
		String name="abc//aaa";
		
		boolean f=NameCheckUtil.isIllegal(name);
		System.out.println(f);
		
		Assert.assertEquals(f,true);
		
		int a1=1;
		
	}

}
