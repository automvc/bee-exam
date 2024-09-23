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
		Logger.info("-------------------------- test Exception2Test start.  --------------------------");
		System.out.println("---Bee Exception2Test with junit start:------");
		ExceptionTest.test();
		System.out.println("---------------------");
		Logger.info("------------ test BuzExceptionTest start:  --------------------------");
		BuzExceptionTest.test();
		Logger.info("------------ test BuzExceptionTest finished.  --------------------------");
		System.out.println("---------------------");
		Logger.info("------------ test LikeEnhanceTest start:  --------------------------");
		LikeEnhanceTest.test(); //V1.17
		Logger.info("------------ test LikeEnhanceTest finished.  --------------------------");
		
		Logger.info("------------ test testTransactionRollback start:  --------------------------");
		testTransactionRollback();
		Logger.info("------------ test LikeEnhanceTest finished.  --------------------------");
		System.out.println("---Bee Exception2Test with junit end.------");
		
		Logger.info("-------------------------- test Exception2Test finished.  --------------------------");
	}
	
	private void testTransactionRollback() {
		try {
			TransactionExam.testRollback(true); //ThrowException and rollback
		} catch (Exception e) {
			Logger.error(e.getMessage(), e);
		}
		
	}

}
