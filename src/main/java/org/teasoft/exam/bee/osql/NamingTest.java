/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import org.teasoft.bee.osql.NameTranslate;
import org.teasoft.bee.osql.api.Suid;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.NameTranslateHandle;
import org.teasoft.honey.osql.name.OriginalName;
import org.teasoft.honey.osql.name.UpperCaseUnderScoreAndCamelName;

/**
 * @author Kingstar
 * @since  1.9
 */
public class NamingTest {

	public static void main(String[] args) {
		test();
	}

	public static void test() {

		Suid suid = BeeFactory.getHoneyFactory().getSuid();
		Orders orders1 = new Orders();
		System.out.println(NameTranslateHandle.getNameTranslate().toString());
		suid.select(orders1); //select all
		
//		NameTranslate oldNameTranslate=NameTranslateHandle.getNameTranslate();

		NameTranslate originalName = new OriginalName();
//		BeeFactory.getHoneyFactory().setNameTranslate(originalName);
//		NameTranslateHandle.setNameTranslate(originalName);
		suid.setNameTranslateOneTime(originalName);
		suid.select(orders1); //select all
		
		System.out.println(NameTranslateHandle.getNameTranslate().toString());
		NameTranslate upperCaseUnderScoreAndCamelName = new UpperCaseUnderScoreAndCamelName();
//		BeeFactory.getHoneyFactory().setNameTranslate(upperCaseUnderScoreAndCamelName);
//		NameTranslateHandle.setNameTranslate(upperCaseUnderScoreAndCamelName);
		suid.setNameTranslateOneTime(upperCaseUnderScoreAndCamelName);
		suid.select(orders1); //select all
		System.out.println(NameTranslateHandle.getNameTranslate().toString());
		
//		NameTranslateHandle.setNameTranslate(oldNameTranslate); 
//		NameTranslateHandle.setNameTranslate(null); 
		
	}

}
