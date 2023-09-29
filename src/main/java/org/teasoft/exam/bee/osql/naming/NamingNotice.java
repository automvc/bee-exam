/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.naming;

import org.teasoft.honey.osql.core.NameTranslateHandle;
import org.teasoft.honey.osql.name.NameUtil;

/**
 * @author Kingstar
 * @since  2.1
 */
public class NamingNotice {
	
	private static String _toTableNameByClass(Class c) {
		return NameTranslateHandle.toTableName(c.getName());
	}
	
	private static String _toTableName(Object entity) {
		if(entity instanceof Class) return _toTableNameByClass((Class)entity);
		if(entity instanceof String) return _toTableName2((String)entity);
		return NameTranslateHandle.toTableName(NameUtil.getClassFullName(entity));
	}
	
	private static String _toTableName2(String entityName) {//fixed bug
		return NameTranslateHandle.toTableName(entityName);
	}
	
	public static void main(String[] args) {
//		System.out.println("------------"+_toTableNameByClass(Orders.class));
//		System.out.println("------------"+_toTableName(Orders.class));
		System.out.println("------------"+_toTableName("Orders"));
	}

}
