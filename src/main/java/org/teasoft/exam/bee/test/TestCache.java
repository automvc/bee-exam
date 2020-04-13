/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.test;

import org.teasoft.exam.bee.osql.CacheTest;
import org.teasoft.exam.bee.osql.CacheTestDel;
import org.teasoft.exam.bee.osql.CacheTestInsertArray;
import org.teasoft.exam.bee.osql.CacheTestJson;
import org.teasoft.exam.comm.TestHelper;
import org.teasoft.exam.comm.TestPrepare;
import org.teasoft.honey.osql.util.DateUtil;

/**
 * @author Kingstar
 * @since  1.7.2
 */
public class TestCache {
	
	public static void main(String[] args) {
		TestPrepare.init("cache");
		
		runTest(CacheTest.class);
		runTest(CacheTestDel.class);
		runTest(CacheTestInsertArray.class);
		runTest(CacheTestJson.class);
		
		System.out.println(DateUtil.currentDate()+"  test cache Finished!");
		
		
	}
	
	public static void runTest(Class c) {
		TestHelper.runTest(c);
	}

}
