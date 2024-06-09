/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.FunctionType;
import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.MoreTable;
import org.teasoft.exam.bee.osql.moretable.entity.Assignexam;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.BeeFactoryHelper;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * example for MoreTable methods:selectWithFun,count 
 * @author Kingstar
 * @since  1.9.8
 */
public class MoreTableFun {

	public static void main(String[] args) {
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
//			 List<Assignexam> list=moreTable.select(new Assignexam(), distinctCondition0);
//			 Printer.printList(list);
			 
			 
			 Condition funCondition =BF.getCondition();
//			 funCondition.selectFun(FunctionType.COUNT, "Assignexam.id", "count1");
//			 funCondition.selectFun(FunctionType.MIN, "Assignexam.id", "count1");
//			 funCondition.selectFun(FunctionType.COUNT, "*", "count1");
			 funCondition.selectFun(FunctionType.COUNT, "*");
			 String fun0= moreTable.selectWithFun(new Assignexam(),funCondition);
			 Logger.info(fun0);
			 
			 funCondition.selectFun(FunctionType.COUNT, "*");
			 String fun= moreTable.selectWithFun(new Assignexam(),BF.getCondition().selectFun(FunctionType.MAX, "Assignexam.id"));
			 
			 int fun2= moreTable.count(new Assignexam());
			 Logger.info(fun2);
			 
			 int fun4= moreTable.count(new Assignexam(),BF.getCondition());
			 Logger.info(fun4);
			 
//			 moreTable.selectWithFun(new Assignexam(),BF.getCondition()); //test exception
//			 Condition c3=BF.getCondition();
//			 c3.selectFun(FunctionType.COUNT, "*");
//			 c3.selectFun(FunctionType.MAX, "Assignexam.id");
//			 moreTable.selectWithFun(new Assignexam(),c3);  //test exception

		} catch (BeeException e) {
			e.printStackTrace();
			Logger.error("In MoreTableFun (BeeException):" + e.getMessage());
		} catch (Exception e) {
			Logger.error("In MoreTableFun (Exception):" + e.getMessage());
			e.printStackTrace();
		}
	}

}
