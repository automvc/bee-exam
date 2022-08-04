/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.honey.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
		ObjectUtils.isNotEmpty(new HashSet());
		
		List list=null;
		ObjectUtils.isNotEmpty(list);
		ObjectUtils.isNotEmpty(new ArrayList());
		
		Map map=null;
		ObjectUtils.isNotEmpty(map);
		ObjectUtils.isNotEmpty(new HashMap());
		
		String str="";
		ObjectUtils.isEmpty(str);
		ObjectUtils.isNotEmpty(str);
		
		String strings[]=null;
		ObjectUtils.isNotEmpty(strings);
		ObjectUtils.isEmpty(strings);
		
		int a=123;
		ObjectUtils.string(a);
		ObjectUtils.string(null);
		
	}

}
