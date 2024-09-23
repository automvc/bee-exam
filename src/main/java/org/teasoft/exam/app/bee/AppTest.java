/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.app.bee;

import org.teasoft.exam.app.bee.entity.LeafAlloc;
import org.teasoft.exam.app.bee.entity.Orders;
import org.teasoft.exam.app.bee.entity.Tb_inaccount;
import org.teasoft.exam.app.bee.entity.Tb_outaccount;
import org.teasoft.exam.app.bee.entity.TestUser;
import org.teasoft.honey.osql.autogen.Ddl;

/**
 * @author Kingstar
 * @since  1.17
 */
public class AppTest {
	
	public static void main(String[] args) {
		AppTest test=new AppTest();
//		test.create();
		test.testMost();
	}
	
	
	private void create() {
//        Ddl.createTable(new LeafAlloc());
//        Ddl.createTable(new Orders());;
//        Ddl.createTable(new Tb_inaccount());
//        Ddl.createTable(new Tb_outaccount());
//        Ddl.createTable(new TestUser());
		
		Ddl.createTable(LeafAlloc.class);
		Ddl.createTable(Orders.class);
		Ddl.createTable(Tb_inaccount.class);
		Ddl.createTable(Tb_outaccount.class);
		Ddl.createTable(TestUser.class);


//        HoneyContext.setCurrentAppDB(store);
//        HiLog.error(LABEL_LOG, "---------------test  create table with Object-");
//        Ddl.createTable(new Person(),false);  //权限问题?? 用这种方式,不能及时创建表.   具体原因,不知道
	}
	
	   private void testMost() {
	        System.out.println("----------------测试开始--");
	        BeeTest beeTest = new BeeTest();
////			beeTest.testCreateTable();
			beeTest.testInsertAndReturn();

			beeTest.testMoretable();
			beeTest.testBatchInsert();
//			beeTest.testFun(); //加测输出结果
			beeTest.testTran();
//			beeTest.testRollback(false);
////			beeTest.testRollback(true);

//			String appVersion=BeeTest.getAppVersionName(ApplicationRegistry.getApplication().getApplicationContext());
//			System.err.println("----------------appVersion:--"+appVersion);

			String prefix="";

        beeTest.testDelete10000();

	        long t1 = System.currentTimeMillis();
	        int a = beeTest.testBatchInsert10000();
	        long t2 = System.currentTimeMillis();
	        long  need1=(t2 - t1);
	        System.out.println(prefix+"插入1w使用时间:" + need1);
	        System.out.println(prefix+"插入的数据条数: " + a);


	        long s1 = System.currentTimeMillis();
	        beeTest.testQuery10000();
	        long s2 = System.currentTimeMillis();
	        long  need2=(s2 - s1);
	        System.out.println(prefix+"查询1w使用时间:" + need2);
	        System.out.println(prefix+"查询的数据条数: " + 10000);

	        long d1 = System.currentTimeMillis();
	        int d = beeTest.testDelete10000();
	        long d2 = System.currentTimeMillis();
	        long  need3=(d2 - d1);
	        System.out.println(prefix+"删除1w使用时间:" + need3);
	        System.out.println(prefix+"删除的数据条数: " + d);

	        long t3 = System.currentTimeMillis();
	        int b = beeTest.testBatchInsert10000Div2();
	        long t4 = System.currentTimeMillis();
	        long  need4=(t4 - t3);
	        System.out.println(prefix+"插入1w(分2批)使用时间:" + need4);
	        System.out.println(prefix+"插入的数据条数: " + b);

	        beeTest.testDelete10000();

	        System.out.println("----------------测试结束--");
	        StringBuilder appendStr = new StringBuilder();
	        appendStr.append(System.lineSeparator());
	        appendStr.append("插入1w使用时间:" + need1).append(System.lineSeparator());
	        appendStr.append("查询1w使用时间:" + need2).append(System.lineSeparator());
	        appendStr.append("删除1w使用时间:" + need3).append(System.lineSeparator());
	        appendStr.append("插入1w(分2批)使用时间:" + need4).append(System.lineSeparator());


//	        getUITaskDispatcher().asyncDispatch(() -> {
//	            logText.setText("");
//	            logText.setText(appendStr.toString());
//	        });
	 
	    }
	
}
