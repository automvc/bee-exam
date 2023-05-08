/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.test;

import java.sql.Timestamp;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.DatabaseConst;
import org.teasoft.exam.bee.osql.ds.DiffDdExam;
import org.teasoft.exam.bee.osql.ds.DiffDdExam0;
import org.teasoft.exam.bee.osql.ds.DiffDdExam00;
import org.teasoft.exam.bee.osql.ds.DiffDdExam000;
import org.teasoft.exam.bee.osql.ds.DiffDdExam00bug;
import org.teasoft.exam.bee.osql.ds.DiffDdExamCustomerSql;
import org.teasoft.exam.bee.osql.ds.RwDsExam;
import org.teasoft.exam.bee.osql.ds.SuidWhichOne;
import org.teasoft.exam.comm.TestHelper;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.type.TimestampTypeHandler;
import org.teasoft.honey.osql.type.TypeHandlerRegistry;

/**
 * @author Kingstar
 * @since  1.9
 */
public class TestMoreDs {
	
	public static void main(String[] args) throws Exception{
		test();
	}
	
	public static void test() throws Exception{
		//javabean Timestamp updateTime;    mysql 存的是字符.
		TypeHandlerRegistry.register(Timestamp.class, new TimestampTypeHandler<Timestamp>(),DatabaseConst.MYSQL,true);
		try {
			test0();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ClearDsContext.clear();
		}
		
	}
	
	public static void test0() throws Exception{
		
		try {
			
		runTest(RwDsExam.class);
//		runTest(SuidExam.class);
		runTest(DiffDdExam.class);
		
		runTest(DiffDdExam0.class);
		runTest(DiffDdExam00.class);
		runTest(DiffDdExam000.class);
		runTest(DiffDdExam00bug.class);
		runTest(DiffDdExamCustomerSql.class);
		runTest(SuidWhichOne.class);
		
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
