/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.coverage;

import org.junit.Test;
import org.teasoft.honey.distribution.PearFlowerId;
import org.teasoft.honey.osql.core.HoneyConfig;

/**
 * @author Kingstar
 * @since  1.17
 */
public class DistributeIdTest {

	@Test
	public void test() {
		HoneyConfig.getHoneyConfig().genid_startYear = 2022;
		PearFlowerId pearFlowerId=new PearFlowerId();
	}

}
