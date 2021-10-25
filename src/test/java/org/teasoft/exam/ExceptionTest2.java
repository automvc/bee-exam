/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam;

import org.junit.Test;
import org.teasoft.exam.bee.osql.BuzExceptionTest;
import org.teasoft.exam.bee.osql.ExceptionTest;

/**
 * @author Kingstar
 * @since  1.9
 */
public class ExceptionTest2 {
	@Test
	public void test() {

		System.out.println("---Bee ExceptionTest2 with junit start:------");
		ExceptionTest.test();
		System.out.println("---------------------");
		BuzExceptionTest.test();
		System.out.println("---Bee ExceptionTest2 with junit end.------");
	}

}
