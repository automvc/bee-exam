/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.honey.util;

import org.junit.Test;

/**
 * @author Kingstar
 * @since  2.1
 */
public class GroupMapTest {
	
	@Test
	public void test() {
//		public static void main(String[] args) {
		GroupMap gm=new GroupMap();
		gm.add("0", "name", "name0");
		gm.add("3", "driver", "driver3");
		gm.add("3", "name", "name3");
		gm.add("1", "name", "name1");
		gm.add("0", "name", "name0");
		gm.add("0", "pw", "pw0");
		gm.add("1", "pw", "pw1");
		
		System.out.println(gm);
		System.out.println(gm.toList());
//		[{name=name0, pw=pw0}, {name=name1, pw=pw1}, {name=name3, driver=driver3}]
//	}
	}

}
