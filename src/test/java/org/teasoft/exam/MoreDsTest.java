/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam;

import org.junit.Test;
import org.teasoft.exam.bee.osql.ds.DiffDdExam;
import org.teasoft.exam.bee.osql.ds.RwDsExam;
import org.teasoft.exam.bee.test.ClearDsContext;
import org.teasoft.exam.bee.test.TestMoreDs;

/**
 * @author Kingstar
 * @since  1.9
 */
public class MoreDsTest {
	@Test
	public void test() throws Exception{
		System.out.println("---Bee MoreDsTest with junit start:------");
		
		System.out.println("---Bee RwDsExam with junit start:------");
		try {
			RwDsExam.test();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ClearDsContext.clear();
		}
		System.out.println("---Bee RwDsExam with junit end.------");
		
//		RwDsExam set the ds , will affect after. need clear
		
//		try {
//			Thread.sleep(12000);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		SuidRichExam.test();
		
		
		System.out.println("---Bee DiffDdExam with junit start:------");
		
		try {
			DiffDdExam.test();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ClearDsContext.clear();
		}
		System.out.println("---Bee DiffDdExam with junit end.------");
		
		
		
		System.out.println("---Bee RwDsExam with junit start:------");
		TestMoreDs.test();
		System.out.println("---Bee RwDsExam with junit end.------");
		
		
		
		System.out.println("---Bee MoreDsTest with junit end.------");
	}

}
