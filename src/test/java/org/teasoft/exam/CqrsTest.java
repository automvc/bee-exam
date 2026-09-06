/*
 * Copyright 2022-2026 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam;

import org.junit.Test;
import org.teasoft.exam.bee.osql.CqrsCommandTest;
import org.teasoft.exam.bee.osql.CqrsExamTest;

/**
 * @author Kingstar
 * @since  3.0.0
 */
public class CqrsTest {
	@Test
	public void test() {
		CqrsExamTest.test();
		CqrsCommandTest.test();
	}

}
