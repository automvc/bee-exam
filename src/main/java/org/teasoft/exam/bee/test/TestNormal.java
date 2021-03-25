/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.test;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.DatabaseConst;
import org.teasoft.exam.bee.distribution.IdTest;
import org.teasoft.exam.bee.osql.BugTest;
import org.teasoft.exam.bee.osql.ConditionExam;
import org.teasoft.exam.bee.osql.DynamicTableExam;
import org.teasoft.exam.bee.osql.ExceptionTest;
import org.teasoft.exam.bee.osql.InsertTest;
import org.teasoft.exam.bee.osql.LockWaitTimeout;
import org.teasoft.exam.bee.osql.MapSuidExam;
import org.teasoft.exam.bee.osql.MoreSQLFunction;
import org.teasoft.exam.bee.osql.MoreTableExam;
import org.teasoft.exam.bee.osql.NamingTest;
import org.teasoft.exam.bee.osql.ObjSQLServiceExam;
import org.teasoft.exam.bee.osql.PreparedSqlExam;
import org.teasoft.exam.bee.osql.SelectById;
import org.teasoft.exam.bee.osql.SelectFun;
import org.teasoft.exam.bee.osql.SuidExam;
import org.teasoft.exam.bee.osql.SuidExamEN;
import org.teasoft.exam.bee.osql.SuidExamEN_SQLite;
import org.teasoft.exam.bee.osql.SuidRichExam;
import org.teasoft.exam.bee.osql.TransactionExam;
import org.teasoft.exam.bee.osql.UpdateByExam;
import org.teasoft.exam.bee.osql.UpdateSetExam;
import org.teasoft.exam.bee.osql.UpdateSetExam_SQLite;
import org.teasoft.exam.bee.osql.UseJson;
import org.teasoft.exam.bee.osql.chain.ChainSelectExam;
import org.teasoft.exam.bee.osql.chain.ChainUpdateExam;
import org.teasoft.exam.bee.osql.chain.UnionSelectExam;
import org.teasoft.exam.bee.osql.ds.RwDsExam;
import org.teasoft.exam.comm.OrdinaryTest;
import org.teasoft.exam.comm.TestHelper;
import org.teasoft.exam.comm.TestPrepare;
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.core.HoneyContext;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.util.DateUtil;

/**
 * @author Kingstar
 * @since  1.7.2
 */
public class TestNormal {
	
	public static void main(String[] args) throws Exception{
		test();
	}
	
	public static void test() throws Exception{
		
		//set DB info in JavaCode
//		HoneyConfig.getHoneyConfig().setDriverName(driverName);
//		String url="jdbc:mysql://localhost:3306/bee?characterEncoding=UTF-8";
//		String username="root";
//		String password="";
//		HoneyConfig.getHoneyConfig().setUrl(url);
//		HoneyConfig.getHoneyConfig().setUsername(username);
//		HoneyConfig.getHoneyConfig().setPassword(password);
//		
//		HoneyConfig.getHoneyConfig().loggerType="systemLogger";
//		HoneyConfig.getHoneyConfig().loggerType="fileLogger";
		
//		HoneyConfig.getHoneyConfig().dbName="mysql";
	  
		
//	   TestPrepare.init("normal");
//	   TestPrepare.init("normal(MySQL)");
//	   TestPrepare.init("normal(Oracle)");
//	   TestPrepare.init("normal(SQLite)");
//	   TestPrepare.init("normal(H2)");
//	   TestPrepare.init("normal(PostgreSQL)");
		
		TestPrepare.init("normal("+HoneyContext.getDbDialect()+")");
		
	    try {
	    	
	    ClearAndInitTestTable.main(null);   //TODO Notice! Just For test.
	    
		String DbName=HoneyConfig.getHoneyConfig().getDbName();
		
		
			
		//How to generate the Javabean,please see GenBeanExam.
		//生成Javabean,请查看GenBeanExam.

//		style 1:
//		TestHelper.markStart("SuidExam.test");
//		SuidExam.test();
//		TestHelper.markEnd("SuidExam.test");
		
//		style 2:		
//		TestHelper.runTest(SuidExam.class);
		
//		style 3:
		runTest(SuidExam.class);
		runTest(SuidExamEN.class);
		runTest(SuidRichExam.class);
		runTest(UpdateByExam.class);
		
		runTest(PreparedSqlExam.class);
		
		runTest(TransactionExam.class);
		
		
		runTest(ConditionExam.class);
		
		runTest(MoreTableExam.class);
		
		runTest(UseJson.class);
		runTest(BugTest.class);
		
		if (DatabaseConst.SQLite.equalsIgnoreCase(DbName)) {
		   runTest(UpdateSetExam_SQLite.class);
		}else{
		   runTest(UpdateSetExam.class);
		}
		
		
		runTest(InsertTest.class);
		runTest(DynamicTableExam.class);
		
		//v1.9
		runTest(MoreSQLFunction.class);
		runTest(SelectFun.class);
//		runTest(More.class);
		runTest(MapSuidExam.class);
		
		
		runTest(LockWaitTimeout.class);
		runTest(SuidExamEN_SQLite.class);
		runTest(UpdateSetExam_SQLite.class);
		runTest(SelectById.class);
		
		runTest(ObjSQLServiceExam.class);
		runTest(NamingTest.class);
		
		runTest(IdTest.class);
		
		//chain coding
		runTest(ChainUpdateExam.class); 
		runTest(ChainSelectExam.class); 
		runTest(UnionSelectExam.class);
		
//		HoneyConfig.getHoneyConfig().sqlKeyWordCase="upper"; //can not change after running.
//		runTest(SuidExam.class);
		
		runTest(OrdinaryTest.class);
		
//		runTest(ExceptionTest.class);
		
//		runTest(RwDsExam.class);
		
	   } catch (BeeException e) {
		   Logger.error(e.getMessage());
		   e.printStackTrace();
		   throw new BeeException();
	   }catch (Exception e) {
		   Logger.error(e.getMessage());
		   e.printStackTrace();
		   throw new Exception();
	   }
		
	   System.out.println(DateUtil.currentDate()+"  test normal Finished!");
	   
//	   HoneyContext.justGetPreparedValue("abc");
	   
	   //test
//	   LoggerFactory._checkSize();
	}
	
	public static void runTest(Class c) {
		TestHelper.runTest(c);
	}

}
