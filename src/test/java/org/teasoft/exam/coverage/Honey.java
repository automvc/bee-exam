/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.coverage;

import org.junit.Test;
import org.teasoft.honey.distribution.UUID;
import org.teasoft.honey.logging.Logger;

/**
 * @author Kingstar
 * @since  1.17
 */
public class Honey {

	@Test
	public void test() {
		Logger.info(UUID.getId(true));
	}
}
