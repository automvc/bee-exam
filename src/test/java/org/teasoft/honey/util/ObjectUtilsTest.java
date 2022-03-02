/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.honey.util;

import java.util.Set;

import org.junit.Test;

/**
 * @author Kingstar
 * @since  1.11
 */
public class ObjectUtilsTest {
	
	@Test
	public void test() {
		
		Set set=null;
		ObjectUtils.isNotEmpty(set);
		
		String str="";
		ObjectUtils.isNotEmpty(str);
		
		String strings[]=null;
		ObjectUtils.isNotEmpty(strings);
		ObjectUtils.isEmpty(strings);
		
		int a=123;
		ObjectUtils.string(a);
		ObjectUtils.string(null);
		
	}

}
