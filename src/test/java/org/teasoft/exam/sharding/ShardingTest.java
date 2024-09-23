/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.sharding;

import org.junit.Test;
import org.teasoft.exam.MySqlOneConfig;
import org.teasoft.exam.bee.osql.sharding.MoreSQLFunction;
import org.teasoft.exam.bee.osql.sharding.ShardingBatchInsert2;
import org.teasoft.exam.bee.osql.sharding.ShardingFunAvgExam;
import org.teasoft.exam.bee.osql.sharding.ShardingFunExam;
import org.teasoft.exam.bee.osql.sharding.ShardingGroup;
import org.teasoft.exam.bee.osql.sharding.ShardingGroup1_2;
import org.teasoft.exam.bee.osql.sharding.ShardingGroup1_3;
import org.teasoft.exam.bee.osql.sharding.ShardingGroup1_4;
import org.teasoft.exam.bee.osql.sharding.ShardingGroup1_5;
import org.teasoft.exam.bee.osql.sharding.ShardingGroup1_6;
import org.teasoft.exam.bee.osql.sharding.ShardingGroup2;
import org.teasoft.exam.bee.osql.sharding.ShardingGroup3;
import org.teasoft.exam.bee.osql.sharding.ShardingGroup4;
import org.teasoft.exam.bee.osql.sharding.ShardingInExam11;
import org.teasoft.exam.bee.osql.sharding.ShardingJsonExam;
import org.teasoft.exam.bee.osql.sharding.ShardingPaging;
import org.teasoft.exam.bee.osql.sharding.ShardingPaging01;
import org.teasoft.exam.bee.osql.sharding.ShardingPaging2;
import org.teasoft.exam.bee.osql.sharding.ShardingPaging3;
import org.teasoft.exam.bee.osql.sharding.ShardingPaging4;
import org.teasoft.exam.bee.osql.sharding.ShardingPagingSort;
import org.teasoft.exam.bee.osql.sharding.ShardingPagingSort2;
import org.teasoft.exam.bee.osql.sharding.ShardingPagingSort2StringArray;
import org.teasoft.exam.bee.osql.sharding.ShardingPagingSort3;
import org.teasoft.exam.bee.osql.sharding.ShardingPagingSort3_2;
import org.teasoft.exam.bee.osql.sharding.ShardingPagingSort4;
import org.teasoft.exam.bee.osql.sharding.ShardingPagingSort5;
import org.teasoft.exam.bee.osql.sharding.ShardingPagingSort6;
import org.teasoft.exam.bee.osql.sharding.ShardingPagingSortStringArray;
import org.teasoft.exam.bee.osql.sharding.ShardingPaging_Just_ShardingDs;
import org.teasoft.exam.bee.osql.sharding.ShardingSimpleExam;
import org.teasoft.exam.bee.osql.sharding.ShardingSimpleExam1;
import org.teasoft.exam.bee.osql.sharding.ShardingSimpleExam1_2;
import org.teasoft.exam.bee.osql.sharding.ShardingSimpleExam3;
import org.teasoft.exam.bee.osql.sharding.ShardingSimpleExam4;
import org.teasoft.exam.bee.osql.sharding.ShardingSimpleExam4_2;
import org.teasoft.exam.bee.osql.sharding.ShardingSimpleExam5;
import org.teasoft.exam.bee.osql.sharding.ShardingSimpleExam6;
import org.teasoft.exam.bee.osql.sharding.ShardingSimpleExam9;
import org.teasoft.exam.bee.osql.sharding.ShardingSimpleExam9_1;
import org.teasoft.exam.bee.osql.sharding.ShardingSimpleExam9_2;
import org.teasoft.exam.bee.osql.sharding.ShardingUpdateBroadcastExam;
import org.teasoft.exam.bee.osql.sharding.ShardingUpdateExam;
import org.teasoft.exam.bee.osql.sharding.SuidRichExamReturnListStringArray;
import org.teasoft.exam.bee.osql.sharding.Test4_insertBroadcastTable;
import org.teasoft.exam.bee.osql.sharding.Test4_selectBroadcastTable;
import org.teasoft.exam.bee.osql.sharding.Test4_updateBroadcastTable;
import org.teasoft.exam.bee.osql.sharding.entity.Orders;
import org.teasoft.exam.bee.test.TestMoreTable;
import org.teasoft.honey.osql.autogen.Ddl;
import org.teasoft.honey.osql.core.HoneyConfig;

/**
 * @author Kingstar
 * @since  2.1
 */
public class ShardingTest extends BaseShardingTest2{
	
	@Test
	public void test() {
		
		System.out.println("---Bee ShardingTest with junit start:------");
		Ddl.createTable(Orders.class,true);
		try {
		ShardingBatchInsert2.test();
		ShardingBatchInsert2.test();
//		ShardingBatchInsertExam.test();
		MoreSQLFunction.test();
		ShardingFunAvgExam.test();
		ShardingFunExam.test();
		ShardingGroup.test();
		ShardingGroup1_2.test();
		ShardingGroup1_3.test();
		ShardingGroup1_4.test();
		ShardingGroup1_5.test();
		ShardingGroup1_6.test();
		ShardingGroup2.test();
		ShardingGroup3.test();
		ShardingGroup4.test();
		ShardingInExam11.test();
		ShardingJsonExam.test();
		ShardingPaging.test();
		ShardingPaging01.test();
		ShardingPaging2.test();
		ShardingPaging3.test();
		ShardingPaging4.test();
		
		ShardingBatchInsert2.test();
		
		ShardingPagingSort.test();
		ShardingPagingSort2.test();
		ShardingPagingSort2StringArray.test();
		ShardingPagingSort3.test();
		ShardingPagingSort3_2.test();
		ShardingPagingSort4.test();
		ShardingPagingSort5.test();
		ShardingPagingSort6.test();
		
		ShardingSimpleExam.test();
		ShardingSimpleExam1.test();
		ShardingSimpleExam1_2.test();
		ShardingSimpleExam3.test();
		ShardingSimpleExam4.test();
		ShardingSimpleExam4_2.test();
		ShardingSimpleExam5.test();
		ShardingSimpleExam6.test();
		ShardingSimpleExam9.test();
		ShardingSimpleExam9_1.test();
		ShardingSimpleExam9_2.test();
		ShardingUpdateBroadcastExam.test();
		ShardingUpdateExam.test();
		SuidRichExamReturnListStringArray.test();
		Test4_insertBroadcastTable.test();
		Test4_selectBroadcastTable.test();
		Test4_updateBroadcastTable.test();
		
		try {
		//bug??  it is ok when run single
		  HoneyConfig.getHoneyConfig().sharding_forkJoinBatchInsert=true;
		  ShardingBatchInsert2.test();
		  HoneyConfig.getHoneyConfig().sharding_forkJoinBatchInsert=false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try {
		ShardingPagingSortStringArray.test();
		ShardingPaging_Just_ShardingDs.test();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		TestMoreTable.test();
		
//		ShardingDeleteExam.test();
//		ShardingPaging2_deleteCache.test();
//		try {
//		ShardingBatchInsertExam.setSuidRich(BF.getSuidRich());
//		ShardingBatchInsertExam.test();
//		} catch (Exception e) {
//			Logger.error(e.getMessage(),e);
//			e.printStackTrace();
//		}
//		
//		ShardingInsertExam10.test();    //not set sharding value
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		System.out.println("---Bee ShardingTest with junit end:------");
		MySqlOneConfig.reset(); //预防测试无序,跳到其它类
	}
	}

}
