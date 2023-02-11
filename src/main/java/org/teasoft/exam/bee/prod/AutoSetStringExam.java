/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.prod;

import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.prod.entity.Orders;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.core.HoneyContext;

/**
 * @author Kingstar
 * @since  1.9
 */
public class AutoSetStringExam {
	private static SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
	static {
		InitDsUtil.initDS();
	}
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		HoneyConfig.getHoneyConfig().multiDS_enable = true; //使用多数据源  多个数据源时必须设置
		HoneyConfig.getHoneyConfig().multiDS_differentDbType=true;  //同时要使用多种数据库,一定要设置
		HoneyContext.setConfigRefresh(true); 
		
////		suidRich.getInterceptorChain().addInterceptor(new MyAnnotationInterceptor());
//		suidRich.getInterceptorChain().addInterceptor(new CustomInterceptor());
		
		suidRich.setDataSourceName("ds1");
//		test1();
		Orders orders=new Orders();
		suidRich.select(orders,10);
		
		suidRich.setDataSourceName("ds2");
//		test1();
		suidRich.select(orders,10);
		
		}


}
