/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.test;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.exam.bee.osql.ds.DiffDdExam;
import org.teasoft.exam.bee.osql.ds.RwDsExam;
import org.teasoft.exam.comm.TestHelper;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.9
 */
public class TestMoreDs {
	public static void main(String[] args) throws Exception{
		test();
	}
	
	public static void test() throws Exception{
		
		try {
			
		runTest(RwDsExam.class);
//		runTest(SuidExam.class);
		runTest(DiffDdExam.class);
		
	   } catch (BeeException e) {
		   Logger.error(e.getMessage());
		   e.printStackTrace();
		   throw new BeeException();
	   }catch (Exception e) {
		   Logger.error(e.getMessage());
		   e.printStackTrace();
		   throw new Exception();
	   }
	   
	}
		public static void runTest(Class c) {
			TestHelper.runTest(c);
		}
}
