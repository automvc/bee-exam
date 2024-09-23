/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.sharding.moretable;

import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.MoreTable;
import org.teasoft.exam.bee.osql.moretable.entity.Assignexam;
import org.teasoft.exam.bee.osql.sharding.InitSameDsUtil;
import org.teasoft.exam.bee.osql.sharding.ShardingInitData;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.BeeFactoryHelper;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.9.8
 */
public class MoreTableFun {

	public static void main(String[] args) {
		
		ShardingInitData.init(); // 分片
		InitSameDsUtil.initDS();
		
		test();
	}

	public static void test() {
		try {
			MoreTable moreTable = BeeFactory.getHoneyFactory().getMoreTable();
			Condition distinctCondition0 = BeeFactoryHelper.getCondition();
			distinctCondition0.selectDistinctField("assignexam.id") 
			//	.selectFun(FunctionType.MAX, "assignexam.id")
			//	.selectField("assignexam.id")
			;
			 List<Assignexam> list=moreTable.select(new Assignexam(), distinctCondition0);
			 Printer.printList(list);

		} catch (BeeException e) {
			e.printStackTrace();
			Logger.error("In MoreTableExam (BeeException):" + e.getMessage());
		} catch (Exception e) {
			Logger.error("In MoreTableExam (Exception):" + e.getMessage());
			e.printStackTrace();
		}
	}

}
