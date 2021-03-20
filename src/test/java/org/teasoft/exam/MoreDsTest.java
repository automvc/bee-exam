/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam;

import org.junit.Test;
import org.teasoft.exam.bee.osql.SuidRichExam;
import org.teasoft.exam.bee.osql.ds.RwDsExam;

/**
 * @author Kingstar
 * @since  1.9
 */
public class MoreDsTest {
	@Test
	public void test(){
		System.out.println("---Bee MoreDsTest with junit start:------");
		SuidRichExam.test();
		
		System.out.println("---Bee RwDsExam with junit start:------");
		RwDsExam.test();
		System.out.println("---Bee RwDsExam with junit end.------");
		
//		RwDsExam set the ds , will affect after.
		
		try {
			Thread.sleep(12000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		SuidRichExam.test();
		System.out.println("---Bee MoreDsTest with junit end.------");
	}

}
