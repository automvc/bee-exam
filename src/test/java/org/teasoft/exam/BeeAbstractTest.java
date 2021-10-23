/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam;

import org.junit.Assert;
import org.junit.Test;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.9.8
 */
public abstract class BeeAbstractTest {

	public abstract void test();

	@Test
	public void testTemplate() {
		boolean flag = false;
		try {
			System.out.println("--- Test with junit start.------" + this.getClass().getSimpleName());
			
			test();

			System.out.println("--- Test with junit end.------" + this.getClass().getSimpleName());

			flag = true;
		} catch (Exception e) {
			flag = false;
			Logger.error(e.getMessage(),e);
//			e.printStackTrace();
		} finally {
			Assert.assertEquals(flag, true);
		}
	}

}
