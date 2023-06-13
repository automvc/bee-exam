/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.sharding;

import org.junit.Test;
import org.teasoft.exam.MySqlOneConfig;
import org.teasoft.exam.bee.mongodb.sharding.ShardingPaging2_deleteCache;
import org.teasoft.exam.bee.osql.sharding.MoreSQLFunction;
import org.teasoft.exam.bee.osql.sharding.ShardingBatchInsert2;
import org.teasoft.exam.bee.osql.sharding.ShardingBatchInsertExam;
import org.teasoft.exam.bee.osql.sharding.ShardingDeleteExam;
import org.teasoft.exam.bee.osql.sharding.ShardingFunAvgExam;
import org.teasoft.exam.bee.osql.sharding.ShardingFunExam;
import org.teasoft.exam.bee.osql.sharding.ShardingGroup;
import org.teasoft.exam.bee.osql.sharding.ShardingGroup1_2;
import org.teasoft.exam.bee.osql.sharding.ShardingGroup1_3;
import org.teasoft.exam.bee.osql.sharding.ShardingGroup2;
import org.teasoft.exam.bee.osql.sharding.ShardingGroup3;
import org.teasoft.exam.bee.osql.sharding.ShardingGroup4;
import org.teasoft.exam.bee.osql.sharding.ShardingInExam11;
import org.teasoft.exam.bee.osql.sharding.ShardingInsertExam10;
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
import org.teasoft.honey.osql.autogen.Ddl;
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  2.1
 */
public class Sharding2Test extends BaseShardingTest2{
	
	@Test
	public void test() {
		
		System.out.println("---Bee Sharding2Test with junit start:------");
		System.out.println("---------------db: "+HoneyConfig.getHoneyConfig().getDbName());
		Ddl.createTable(Orders.class,true);
		try {
	
		
		HoneyConfig.getHoneyConfig().sharding_forkJoinBatchInsert=true;
		ShardingBatchInsert2.test();
		HoneyConfig.getHoneyConfig().sharding_forkJoinBatchInsert=false;
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		System.out.println("---Bee Sharding2Test with junit end:------");
		MySqlOneConfig.reset(); //预防测试无序,跳到其它类
	}
	}

}
