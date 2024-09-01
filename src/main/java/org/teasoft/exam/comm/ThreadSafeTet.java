/*
 * Copyright 2019-2024 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.comm;

import org.teasoft.honey.osql.core.HoneyConfig;

/**
 * @author Kingstar
 * @since  2.4.0
 */
public class ThreadSafeTet {
	
	public static void main(String[] args) {
		Object obj=HoneyConfig.class;
		System.out.println(obj.toString()); //不会解发static{}, construct method.
		
		System.out.println(HoneyConfig.getHoneyConfig()); //会触发.
		System.out.println("finished");
	}

}
