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
import org.teasoft.exam.bee.osql.DeleteBy;
import org.teasoft.exam.bee.osql.DynamicTableExam;
import org.teasoft.exam.bee.osql.InsertTest;
import org.teasoft.exam.bee.osql.LockWaitTimeout;
import org.teasoft.exam.bee.osql.MapSuidExam;
import org.teasoft.exam.bee.osql.MapSuidExam24;
import org.teasoft.exam.bee.osql.MoreSQLFunction;
import org.teasoft.exam.bee.osql.MoreTableExam;
import org.teasoft.exam.bee.osql.NamingTest;
import org.teasoft.exam.bee.osql.PreparedSqlExam;
import org.teasoft.exam.bee.osql.PreparedSqlUpdateExam;
import org.teasoft.exam.bee.osql.SearchExam;
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
import org.teasoft.exam.bee.osql.annotation.moretable.MoreTableExam24Suid;
import org.teasoft.exam.bee.osql.chain.Chain;
import org.teasoft.exam.bee.osql.chain.ChainSelectExam;
import org.teasoft.exam.bee.osql.chain.ChainSelectExam2;
import org.teasoft.exam.bee.osql.chain.ChainUpdateExam;
import org.teasoft.exam.bee.osql.chain.Delete24;
import org.teasoft.exam.bee.osql.chain.Insert24;
import org.teasoft.exam.bee.osql.chain.QueryCompare;
import org.teasoft.exam.bee.osql.chain.QueryCompare2;
import org.teasoft.exam.bee.osql.chain.Select24;
import org.teasoft.exam.bee.osql.chain.UnionSelectExam;
import org.teasoft.exam.bee.osql.chain.Update24;
import org.teasoft.exam.bee.osql.commomid.IntSerialIdTest;
import org.teasoft.exam.bee.osql.commomid.NotLongId;
import org.teasoft.exam.bee.osql.commomid.StringIdTest;
import org.teasoft.exam.bee.osql.commomid.StringIdUUIDTest;
import org.teasoft.exam.bee.osql.dialect.MyFeatureTest;
import org.teasoft.exam.bee.osql.dialect.PagingExam;
import org.teasoft.exam.bee.osql.ext24.TestBFX;
import org.teasoft.exam.bee.osql.localdatetime.LocalDateTimeExam;
import org.teasoft.exam.bee.osql.localdatetime.LocalDateTimeExam2;
import org.teasoft.exam.bee.osql.localdatetime.LocalDateTimeExam3;
import org.teasoft.exam.bee.osql.moretable.modify.CreateTable;
import org.teasoft.exam.bee.osql.moretable.modify.MoreInsert40;
import org.teasoft.exam.bee.osql.moretable.modify.MoreInsert40_2;
import org.teasoft.exam.bee.osql.moretable.modify.MoreInsert50;
import org.teasoft.exam.bee.osql.moretable.modify.MoreInsert60;
import org.teasoft.exam.bee.osql.moretable.modify.MoreUpdate2;
import org.teasoft.exam.bee.osql.moretable.modify.MoreUpdate3;
import org.teasoft.exam.bee.osql.moretable.modify.sharding.MoreModify;
import org.teasoft.exam.bee.osql.moretable.modify.sharding.MoreUpdate;
import org.teasoft.exam.bee.osql.naming.DiffNamingTest;
import org.teasoft.exam.bee.osql.special.ColumnAnnoTest;
import org.teasoft.exam.bee.osql.special.LikeTest;
import org.teasoft.exam.bee.osql.special.ddl.DdlTest;
import org.teasoft.exam.bee.osql.special.type.DateTypeTest;
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
//		String url="jdbc:mysql://localhost:3306/bee?characterEncoding=UTF-8&amp;useSSL=false";
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
		
		
	    try {
	    	TestPrepare.init("normal("+HoneyContext.getDbDialect()+")");
	    	
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
		runTest(PreparedSqlUpdateExam.class);
		
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
		runTest(MapSuidExam24.class);
		
		runTest(LockWaitTimeout.class);
		runTest(SuidExamEN_SQLite.class);
		runTest(UpdateSetExam_SQLite.class);
		runTest(SelectById.class);
		
//		runTest(ObjSQLServiceExam.class);
		runTest(NamingTest.class);
		
		runTest(IdTest.class);
		
		//chain coding
		runTest(ChainUpdateExam.class); 
		runTest(ChainSelectExam.class); 
		
		try {
				if (!DatabaseConst.SQLite.equalsIgnoreCase(DbName))
					runTest(UnionSelectExam.class);
		} catch (Exception e) {
			Logger.warn("Exception in UnionSelectExam(confirm the DB whether support the union): "+e.getMessage());
		}
		
		
		runTest(ChainSelectExam2.class);
		runTest(Insert24.class);
//		runTest(NotExam.class); //some databse donot support : !(name='client' and abc='client')
		runTest(QueryCompare.class);
		runTest(QueryCompare2.class);
		runTest(Select24.class);
		
		runTest(Chain.class);
		
		if (DatabaseConst.MYSQL.equalsIgnoreCase(DbName)) {
			runTest(Update24.class);  //语法是否支持.
			runTest(Delete24.class);
		}
		
		runTest(TestBFX.class);
		
		runTest(CreateTable.class);
		runTest(MoreInsert40.class);
		runTest(MoreInsert40_2.class);
		runTest(MoreInsert50.class);
		runTest(MoreInsert60.class);
		runTest(MoreModify.class);
		runTest(MoreUpdate.class);
		runTest(MoreUpdate2.class);
		runTest(MoreUpdate3.class);
		runTest(org.teasoft.exam.bee.osql.moretable.update.MoreUpdate2.class);
		
		
//		HoneyConfig.getHoneyConfig().sqlKeyWordCase="upper"; //can not change after running.
//		runTest(SuidExam.class);
		
		runTest(OrdinaryTest.class);
		
		runTest(PagingExam.class);
		
		runTest(MoreTableExam24Suid.class);
		
		if (DatabaseConst.SQLSERVER.equalsIgnoreCase(DbName)) {
		    runTest(MyFeatureTest.class);
		}
		
//		runTest(ExceptionTest.class);
//		
//		runTest(RwDsExam.class);
//		runTest(DiffDdExam.class);
		
		runTest(DeleteBy.class);
		runTest(SearchExam.class);
		
		runTest(DdlTest.class);
		
		runTest(IntSerialIdTest.class);
		runTest(StringIdTest.class);
		runTest(StringIdUUIDTest.class);
		runTest(NotLongId.class);
		runTest(ColumnAnnoTest.class);
		runTest(LikeTest.class);
		runTest(DiffNamingTest.class);
		runTest(DateTypeTest.class);
		
//		runTest(KotlinTest.class);
//		runTest(HoneyConfigReset.class);
		
		if (DatabaseConst.ORACLE.equalsIgnoreCase(DbName)) {
		    runTest(LocalDateTimeExam.class);
		    runTest(LocalDateTimeExam2.class);
		    runTest(LocalDateTimeExam3.class);
		}
		
		
		//test lower/upper key work  
//		String oldCase=HoneyConfig.getHoneyConfig().sqlKeyWordCase;
//		HoneyConfig.getHoneyConfig().sqlKeyWordCase="upper";
//		runTest(SuidRichExam.class);
//		HoneyConfig.getHoneyConfig().sqlKeyWordCase=oldCase;
		
		
		
	   } catch (BeeException e) {
//		   Logger.error(e.getMessage(),e);
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
