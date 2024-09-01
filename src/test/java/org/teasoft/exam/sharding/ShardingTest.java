/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.sharding;

import org.junit.Test;
import org.teasoft.exam.MySqlOneConfig;
import org.teasoft.exam.bee.osql.sharding.MoreSQLFunction;
import org.teasoft.exam.bee.osql.sharding.*;
import org.teasoft.exam.bee.osql.sharding.entity.Orders;
import org.teasoft.honey.osql.autogen.Ddl;

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
		ShardingPagingSortStringArray.test();
		ShardingPaging_Just_ShardingDs.test();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//bug??
//		HoneyConfig.getHoneyConfig().sharding_forkJoinBatchInsert=true;
//		ShardingBatchInsert2.test();
//		HoneyConfig.getHoneyConfig().sharding_forkJoinBatchInsert=false;
		
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
