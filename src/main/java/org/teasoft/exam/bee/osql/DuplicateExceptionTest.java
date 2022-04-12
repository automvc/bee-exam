/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.osql.entity.TestUser;
import org.teasoft.honey.osql.core.BeeFactory;

/**
 * @author Kingstar
 * @since  1.11
 */
public class DuplicateExceptionTest {
	private static SuidRich suidRich=BeeFactory.getHoneyFactory().getSuidRich();
	public static void main(String[] args) {
		TestUser testUser=new TestUser();
		testUser.setId(800001L);
		suidRich.insert(testUser);
		suidRich.insert(testUser);
		suidRich.insert(testUser);
	}

}
