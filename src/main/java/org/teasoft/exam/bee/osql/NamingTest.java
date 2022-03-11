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
public class NamingTest {

	public static void main(String[] args) {
		//		TestPrepare.init();
		test();
	}

	public static void test() {

		Suid suid = BeeFactory.getHoneyFactory().getSuid();
		Orders orders1 = new Orders();
		
		suid.select(orders1); //select all
		
		NameTranslate oldNameTranslate=NameTranslateHandle.getNameTranslate();

		NameTranslate originalName = new OriginalName();
//		BeeFactory.getHoneyFactory().setNameTranslate(originalName);
		NameTranslateHandle.setNameTranslate(originalName);
		suid.select(orders1); //select all

		NameTranslate upperCaseUnderScoreAndCamelName = new UpperCaseUnderScoreAndCamelName();
//		BeeFactory.getHoneyFactory().setNameTranslate(upperCaseUnderScoreAndCamelName);
		NameTranslateHandle.setNameTranslate(upperCaseUnderScoreAndCamelName);
		suid.select(orders1); //select all
		
		NameTranslateHandle.setNameTranslate(oldNameTranslate); 
	}

}
