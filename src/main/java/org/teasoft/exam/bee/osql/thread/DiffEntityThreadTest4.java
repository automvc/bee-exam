/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.thread;

import org.teasoft.bee.osql.api.Suid;
import org.teasoft.exam.bee.osql.entity.TestUser;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.9.8
 */
public class DiffEntityThreadTest4 extends Thread {
	Suid suid = BeeFactory.getHoneyFactory().getSuid();
	
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			query();
		}
	}
	
	public void query() {
		try {
			suid.select(new TestUser());
		} catch (Exception e) {
			Logger.error(e.getMessage(),e);
			e.printStackTrace();
		}
	}
}
