/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.thread;

import org.teasoft.bee.osql.api.Suid;
import org.teasoft.exam.bee.osql.entity.TestUser;
import org.teasoft.honey.osql.core.BeeFactory;

/**
 * @author Kingstar
 * @since  1.9.8
 */
public class Test4 {
	
//	2. 线程启动前，主线程先查询一次，放缓存，
//	看下线程，是否所有的，都能从缓存取。
//
//	是的,100x50=5000都从缓存取。  org.teasoft.exam.bee.osql.thread.Test4
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		
		Suid suid = BeeFactory.getHoneyFactory().getSuid();
		suid.select(new TestUser());
		
		DiffEntityThreadTest4 array[]=new DiffEntityThreadTest4[100];
		for (int i = 0; i < array.length; i++) {
			array[i]=new DiffEntityThreadTest4();
			array[i].start();
		}
		
	}

}
