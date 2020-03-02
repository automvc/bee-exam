/*
 * Copyright 2016-2019 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.osql.entity.User;
import org.teasoft.honey.osql.core.BeeFactory;

/**
 * @author Kingstar
 * @since  1.0
 */
public class SuidRichExam {
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test(){
		try {
			SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
			suidRich.selectById(new User(), "800001,800002");
			suidRich.selectById(new User(), 800001);
			suidRich.selectById(new User(), 800001L);
		} catch (BeeException e) {
			e.printStackTrace();
		}
	}

}
