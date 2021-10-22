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
public class Test3 {
	
//	1.将缓存放到与线程数大点， 过时时间足够(不会过时)
//	看从缓存获取的总量,是否是总访问数-线程数。
//	意思就是所有线程访问了一遍后， 都可以从缓存拿到数据，而且都是从最新下标处取的。
//	若所在线程都一样的查询，应该都归为同一个下标取了。
//
//	是的。  org.teasoft.exam.bee.osql.thread.Test3
	
	public static void main(String[] args) {
		
		DiffEntityThreadTest3 array[]=new DiffEntityThreadTest3[10];
		for (int i = 0; i < array.length; i++) {
			array[i]=new DiffEntityThreadTest3();
			array[i].start();
		}
		
	}

}
