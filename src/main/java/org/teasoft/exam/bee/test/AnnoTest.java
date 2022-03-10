/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.teasoft.bee.osql.annotation.Ignore;
import org.teasoft.bee.osql.annotation.JoinTable;
import org.teasoft.honey.osql.core.HoneyUtil;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.11
 */
public class AnnoTest {
	public static void main(String[] args) throws Exception{
		test();
	}
	public static void test(){
		
		try {
			

		String entityFullName="org.teasoft.exam.bee.osql.moretable.entity.Orders";
		Object entity = Class.forName(entityFullName).newInstance();
		Field fields[] = entity.getClass().getDeclaredFields();
		
		int len = fields.length;
		for (int i = 0; i < len; i++) {
			if (isSkipField(fields[i])) {
//				System.err.println(fields[i].getName());
				Logger.info(fields[i].getName());
			}
		}
		
		} catch (Exception e) {
//			Logger.error("------------");
//			Logger.error(e.getClass().getName());
			Logger.error(e.getMessage(), e);
		}
	}
	
	public static boolean isSkipField(Field field) {
		if (field != null) {
//			if ("serialVersionUID".equals(field.getName())) return true;
//			if (field.isAnnotationPresent(Ignore.class)) return true; //v1.9
//			if (field.isAnnotationPresent(JoinTable.class)) return true;
			if (field.isSynthetic()) return true;
		}
		return false;
	}

}
