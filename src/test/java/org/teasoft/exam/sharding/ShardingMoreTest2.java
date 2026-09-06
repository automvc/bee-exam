/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.sharding;

import org.junit.Test;
import org.teasoft.exam.MySqlOneConfig;
import org.teasoft.exam.bee.mongodb.sharding.ShardingPaging;
//import org.teasoft.exam.bee.osql.moretable.modify.sharding.ShardingInitData;
import org.teasoft.exam.bee.osql.sharding.moretable.MoreTableExam;
import org.teasoft.exam.bee.osql.sharding.moretable.MoreTableExam11;
import org.teasoft.exam.bee.osql.sharding.moretable.MoreTableExam198;
import org.teasoft.exam.bee.osql.sharding.moretable.MoreTableExam198_2;
import org.teasoft.exam.bee.osql.sharding.moretable.MoreTableExam2;
import org.teasoft.exam.bee.osql.sharding.moretable.MoreTableExam3;
import org.teasoft.exam.bee.osql.sharding.moretable.MoreTableExam4;
import org.teasoft.exam.bee.osql.sharding.moretable.MoreTableExam5;
import org.teasoft.exam.bee.osql.sharding.moretable.MoreTableExam6;
import org.teasoft.exam.bee.osql.sharding.moretable.MoreTableExam7;
import org.teasoft.exam.bee.osql.sharding.moretable.MoreTableExam7_2;
import org.teasoft.exam.bee.osql.sharding.moretable.MoreTableFun;
import org.teasoft.exam.bee.osql.sharding.moretable.ShardingBatchInsert2;
import org.teasoft.exam.moretable3.moretable3select5._11111.MoreTableSelect_list_filter5_11111;
import org.teasoft.exam.moretable3.sharding.MoreTableShardingDdl;
import org.teasoft.exam.moretable3.sharding.MoreTableShardingDelete;
import org.teasoft.exam.moretable3.sharding.MoreTableShardingInsert;
import org.teasoft.exam.moretable3.sharding.MoreTableShardingInsert2;
import org.teasoft.exam.moretable3.sharding.MoreTableShardingSelect;
import org.teasoft.exam.moretable3.sharding.MoreTableShardingSelect2;
import org.teasoft.exam.moretable3.sharding.MoreTableShardingSelect3;
import org.teasoft.exam.moretable3.sharding.MoreTableShardingSelect3_justOrderBy;
import org.teasoft.exam.moretable3.sharding.MoreTableShardingSelect3_justOrderBy2;
import org.teasoft.exam.moretable3.sharding.MoreTableShardingSelect3_justOrderBy3;
import org.teasoft.exam.moretable3.sharding.MoreTableShardingSelect3_justOrderBy4;
import org.teasoft.exam.moretable3.sharding.MoreTableShardingSelect4;
import org.teasoft.exam.moretable3.sharding.MoreTableShardingSelect5;
import org.teasoft.exam.moretable3.sharding.MoreTableShardingSelect_Fun;
import org.teasoft.exam.moretable3.sharding.MoreTableShardingSelect_Fun10;
import org.teasoft.exam.moretable3.sharding.MoreTableShardingSelect_Fun11;
import org.teasoft.exam.moretable3.sharding.MoreTableShardingSelect_Fun12;
import org.teasoft.exam.moretable3.sharding.MoreTableShardingSelect_Fun13;
import org.teasoft.exam.moretable3.sharding.MoreTableShardingSelect_Fun2;
import org.teasoft.exam.moretable3.sharding.MoreTableShardingSelect_Fun3;
import org.teasoft.exam.moretable3.sharding.MoreTableShardingSelect_Fun4;
import org.teasoft.exam.moretable3.sharding.MoreTableShardingSelect_Fun5;
import org.teasoft.exam.moretable3.sharding.MoreTableShardingSelect_Fun6;
import org.teasoft.exam.moretable3.sharding.MoreTableShardingSelect_Fun7;
import org.teasoft.exam.moretable3.sharding.MoreTableShardingSelect_Fun8;
import org.teasoft.exam.moretable3.sharding.MoreTableShardingSelect_Fun9;
import org.teasoft.exam.moretable3.sharding.MoreTableShardingSelect_broadcast;
import org.teasoft.exam.moretable3.sharding.MoreTableShardingUpdate;
import org.teasoft.exam.moretable3.sharding.MoreTableShardingUpdate_broadcast;

/**
 * @author Kingstar
 * @since  2.1
 */
public class ShardingMoreTest2 extends BaseShardingTest2 {

	@Test
	public void test() {

		System.out.println("---Bee ShardingMoreTest2 with junit start:------");
		try {
			MoreTableExam.test();
			MoreTableExam11.test();
			MoreTableExam198.test();
			MoreTableExam198_2.test();
			MoreTableExam2.test();
			MoreTableExam3.test();
			MoreTableExam4.test();
			MoreTableExam5.test();
			MoreTableExam6.test();
			MoreTableExam7.test();
			MoreTableExam7_2.test();
//			MoreTableExam8.test();
			MoreTableFun.test();
			ShardingBatchInsert2.test();


			MoreTableSelect_list_filter5_11111.test();
			MoreTableShardingDdl.test();
			MoreTableShardingDelete.test();
			MoreTableShardingInsert.test();
			MoreTableShardingInsert2.test(); //after insert, HoneyContext.getTabSuffix():null
			MoreTableShardingSelect.test();
			MoreTableShardingSelect_broadcast.test();
			MoreTableShardingSelect_Fun.test();
			MoreTableShardingSelect_Fun10.test();
			MoreTableShardingSelect_Fun11.test();
			MoreTableShardingSelect_Fun12.test();
			MoreTableShardingSelect_Fun13.test();
			MoreTableShardingSelect_Fun2.test();
			MoreTableShardingSelect_Fun3.test();
			MoreTableShardingSelect_Fun4.test();
			MoreTableShardingSelect_Fun5.test();
			MoreTableShardingSelect_Fun6.test();
			MoreTableShardingSelect_Fun7.test();
			MoreTableShardingSelect_Fun8.test();
			MoreTableShardingSelect_Fun9.test();
			MoreTableShardingSelect2.test();
			MoreTableShardingSelect3.test();
			MoreTableShardingSelect3_justOrderBy.test();
			MoreTableShardingSelect3_justOrderBy2.test();
			MoreTableShardingSelect3_justOrderBy3.test();
			MoreTableShardingSelect3_justOrderBy4.test();
			MoreTableShardingSelect4.test();
			MoreTableShardingSelect5.test();
			MoreTableShardingUpdate.test();
			MoreTableShardingUpdate_broadcast.test();
//			ShardingInitData.test();
			ShardingPaging.test();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("---Bee ShardingMoreTest2 with junit end:------");
			MySqlOneConfig.reset(); // 预防测试无序,跳到其它类
		}
	}

}
