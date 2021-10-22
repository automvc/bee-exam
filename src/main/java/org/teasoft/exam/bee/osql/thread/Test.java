/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.thread;

/**
 * @author Kingstar
 * @since  1.9.8
 */
public class Test {
	
	public static void main(String[] args) {
		ConditionThreadTest test=new ConditionThreadTest();
		test.start();
		
		ConditionThreadTest test2=new ConditionThreadTest();
		test2.start();
		
		ConditionThreadTest test3=new ConditionThreadTest();
		test3.start();
	}

}
