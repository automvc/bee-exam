/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.autogen;

import org.teasoft.exam.bee.osql.entity.Student;
import org.teasoft.honey.osql.autogen.Ddl;

/**
 * @author Kingstar
 * @since  1.9
 */
public class CreateTableWithJavabean2 {
	public static void main(String[] args) {
		Ddl.createTable(new Student(), false); //测试有Boolean类型,   在oracle生成表
	}

}
