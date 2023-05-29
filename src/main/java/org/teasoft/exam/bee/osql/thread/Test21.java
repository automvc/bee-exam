/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.thread;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.api.Suid;
import org.teasoft.exam.bee.osql.entity.TestUser;
import org.teasoft.honey.osql.core.BeeFactory;

/**
 * @author Kingstar
 * @since  1.9.8
 */
public class Test21 {
	static Suid suid = BeeFactory.getHoneyFactory().getSuid();

	public static void main(String[] args) {
		try {
			for (int i = 0; i < 50; i++) {
				suid.select(new TestUser());
				suid.select(new TestUser());
			}
		} catch (BeeException e) {
			e.printStackTrace();
//			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
//			System.exit(0);
		}
	}

}
