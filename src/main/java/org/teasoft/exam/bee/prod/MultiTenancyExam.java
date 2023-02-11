/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.prod;

import java.util.List;

import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.prod.entity.Student;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.core.HoneyContext;
import org.teasoft.honey.osql.interccept.annotation.CustomInterceptor;

/**
 * @author Kingstar
 * @since  1.9
 */
public class MultiTenancyExam {
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
		
//		Student3 student3=new Student3();
//		student3.setId(5L);
//		List list=suidRich.select(student3,10);
//		Printer.printList(list);
		
//		suidRich.setDataSourceName("ds1");
		Student student=new Student();
		student.setId(5L);
		List list2=suidRich.select(student,10);
		Printer.printList(list2);
		System.err.println("==============1111111111111==========");
		suidRich.select(student,10); //test cache
		
		}


}
