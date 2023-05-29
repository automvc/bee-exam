/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import org.teasoft.bee.osql.NameTranslate;
import org.teasoft.bee.osql.api.Suid;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.NameTranslateHandle;
import org.teasoft.honey.osql.name.UpperCaseUnderScoreAndCamelName;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  1.9
 */
public class Naming3Test {

	public static void main(String[] args) {
		test();
	}

	public static void test() {

		Suid suid = BeeFactory.getHoneyFactory().getSuid();
		Orders orders1 = new Orders();
		
		System.out.println(NameTranslateHandle.getNameTranslate().toString());
		
//		V2.1.5.1 bug.   设置了,就放上下文,即使只用一次,但设置了不用,   别的对象,即使不是Suid同种类型,也会拿到上下文中的NameTranslate
		NameTranslate upperCaseUnderScoreAndCamelName = new UpperCaseUnderScoreAndCamelName();
		suid.setNameTranslateOneTime(upperCaseUnderScoreAndCamelName); 
		
//		suid.select(orders1); //select all
//		System.out.println(NameTranslateHandle.getNameTranslate().toString());
		
		SuidRich suidRich=BF.getSuidRich();
		suidRich.select(orders1); 
		
	}

}
