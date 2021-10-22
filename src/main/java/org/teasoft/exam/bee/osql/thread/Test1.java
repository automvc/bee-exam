/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.thread;

import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.util.DateUtil;

/**
 * @author Kingstar
 * @since  1.9.8
 */
public class Test1 {
	
	public static void main(String[] args) {
		
		Logger.error(DateUtil.currentDate());
		
//		DiffEntityThreadTest1 test=new DiffEntityThreadTest1();
//		test.start();
//		
//		DiffEntityThreadTest1 test2=new DiffEntityThreadTest1();
//		test2.start();
//		
//		DiffEntityThreadTest1 test3=new DiffEntityThreadTest1();
//		test3.start();
		
		DiffEntityThreadTest1 array[]=new DiffEntityThreadTest1[10];
		for (int i = 0; i < array.length; i++) {
			array[i]=new DiffEntityThreadTest1();
			array[i].start();
		}
		
	}

}
