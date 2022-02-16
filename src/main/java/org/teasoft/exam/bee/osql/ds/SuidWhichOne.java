/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.ds;

import org.teasoft.bee.osql.Suid;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.osql.core.HoneyContext;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  1.11
 */
public class SuidWhichOne {
	
	public static void main(String[] args) {
		
		Suid suid1=BF.getSuid();
		suid1.setDataSourceName("Ds1");
		
		suid1.select(new Orders());
		
		System.err.println(suid1.toString());
		System.err.println(suid1.hashCode());
		System.err.println(suid1.getDataSourceName());
		
		Suid suid2=BF.getSuid();
		suid2.setDataSourceName("Ds2");
		System.err.println(suid2.toString());
		System.err.println(suid2.hashCode());
		System.err.println(suid2.getDataSourceName());
		
		//suid2之后,接口又执行suid1的
		suid1.select(new Orders());//suid1在suid2后又执行,若直接使用线程设置,suid2定义时,却把定义的DS冲了.
		System.err.println(suid1.getDataSourceName());
		
		
		
	}

}
