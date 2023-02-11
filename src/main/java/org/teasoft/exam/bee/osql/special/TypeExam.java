/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.special;

import java.util.List;

import org.teasoft.bee.osql.Suid;
import org.teasoft.exam.bee.osql.entity2.TypeTest;
import org.teasoft.honey.osql.core.BeeFactoryHelper;

/**
 * @author Kingstar
 * @since  1.11
 */
public class TypeExam {
	public static void main(String[] args) {
		Suid suid = BeeFactoryHelper.getSuid();
		TypeTest typeTest = new TypeTest();
		typeTest.setId(34);
		List<TypeTest> list = suid.select(typeTest);
		System.out.println(list);
	}

}
