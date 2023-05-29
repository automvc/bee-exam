/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.special;

import java.util.List;

import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.Suid;
import org.teasoft.exam.bee.osql.entity.TestUser;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.core.BeeFactoryHelper;
//import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  1.9.8
 */
public class UseNull {

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		try {
//			Suid suid = BF.getSuid();
			Suid suid = BeeFactoryHelper.getSuid();
			Condition condition10 = BeeFactoryHelper.getCondition();
			//where email is null
			condition10.op("email", Op.eq, null);
			List<TestUser> list10 = suid.select(new TestUser(), condition10);
			Printer.printList(list10);
			
			//where email is not null
			Condition condition11 = BeeFactoryHelper.getCondition();
			condition11.op("email", Op.nq, null);
//			condition11.op("email", Op.notEqual, null);
			List<TestUser> list11 = suid.select(new TestUser(), condition11);
			Printer.printList(list11);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
