/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam;

import org.junit.Test;
import org.teasoft.exam.bee.osql.BuzExceptionTest;
import org.teasoft.exam.bee.osql.ExceptionTest;
import org.teasoft.exam.bee.osql.TransactionExam;
import org.teasoft.exam.bee.osql.special.LikeEnhanceTest;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.9
 */
public class Exception2Test {
	@Test
	public void test() {

		System.out.println("---Bee Exception2Test with junit start:------");
		ExceptionTest.test();
		System.out.println("---------------------");
		BuzExceptionTest.test();
		System.out.println("---------------------");
		LikeEnhanceTest.test(); //V1.17
		testTransactionRollback();
		System.out.println("---Bee Exception2Test with junit end.------");
	}
	
	private void testTransactionRollback() {
		try {
			TransactionExam.testRollback(true); //ThrowException and rollback
		} catch (Exception e) {
			Logger.error(e.getMessage(), e);
		}
		
	}

}
