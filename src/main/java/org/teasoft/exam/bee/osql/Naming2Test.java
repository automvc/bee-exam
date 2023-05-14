/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import org.teasoft.bee.osql.NameTranslate;
import org.teasoft.bee.osql.Suid;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.NameTranslateHandle;
import org.teasoft.honey.osql.name.OriginalName;
import org.teasoft.honey.osql.name.UpperCaseUnderScoreAndCamelName;

/**
 * @author Kingstar
 * @since  1.9
 */
public class Naming2Test {

	public static void main(String[] args) {
		test();
	}

	public static void test() {

		Suid suid = BeeFactory.getHoneyFactory().getSuid();
		Orders orders1 = new Orders();
//		System.out.println(NameTranslateHandle.getNameTranslate().toString());
		suid.select(orders1); //select all
		
		System.out.println(NameTranslateHandle.getNameTranslate().toString());
		NameTranslate upperCaseUnderScoreAndCamelName = new UpperCaseUnderScoreAndCamelName();
		suid.setNameTranslateOneTime(upperCaseUnderScoreAndCamelName);  //设置了,要清空字段的缓存.
		suid.select(orders1); //select all
		System.out.println(NameTranslateHandle.getNameTranslate().toString());
		
	}

}
