/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.annotation;

import java.lang.reflect.Field;

import org.teasoft.honey.osql.core.HoneyUtil;

/**
 * @author Kingstar
 * @since  2.1.8
 */
public class SetValueTest {
	
	
	public static void main(String[] args) throws Exception{
		TestUser test=new TestUser();
		Field field = test.getClass().getDeclaredField("count1");
		HoneyUtil.setAccessibleTrue(field);
		
//		field.set(test, 1);   //  private String count1;  类型不对, 会报异常: Exception in thread "main" java.lang.IllegalArgumentException: Can not set java.lang.String field org.teasoft.exam.bee.osql.annotation.TestUser.count1 to null value
		field.set(test, "1");
		
		Field field2 = test.getClass().getDeclaredField("id");
		System.out.println(field2.getName()); //获取字段名时,不需要设置true
		HoneyUtil.setAccessibleTrue(field2);
//		field2.set(test, 12);
//		field2.set(test, 12L);  //类型不对,不行
		
		field2.set(test, null); //可以设置null
		
		System.out.println(test.getCount1());
		System.out.println(test.getId());
	}

}
