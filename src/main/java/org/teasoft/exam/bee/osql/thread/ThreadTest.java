/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.thread;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.exam.bee.test.TestNormal;

/**
 * @author Kingstar
 * @since  1.9.8
 */
public class ThreadTest extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			query();
		}
	}
	
	public void query() {
		try {
			
			TestNormal.test();

		} catch (BeeException e) {
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		ThreadTest test=new ThreadTest();
		test.start();
		
		ThreadTest test2=new ThreadTest();
		test2.start();
		
		ThreadTest test3=new ThreadTest();
		test3.start();
	}

}
