/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.coverage;

import org.junit.Test;
import org.teasoft.honey.osql.core.BeeInitPreLoadService;

/**
 * @author Kingstar
 * @since  1.17
 */
public class Other {
	
	@Test
	public void test() {
		BeeInitPreLoadService.init();
	}

}
