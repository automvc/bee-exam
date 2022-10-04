/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.sharding.moretable;

import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.MoreTable;
import org.teasoft.exam.bee.osql.moretable.entity.Orders20;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.9.8
 */
public class MoreTableExam198 {

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		try {
			MoreTable moreTable = BeeFactory.getHoneyFactory().getMoreTable();

//			TestUser2 testuser2 = new TestUser2();
//			moreTable.select(testuser2);
			
//			TestUser11 testuser11 = new TestUser11();
//			moreTable.select(testuser11);
			
//			Assignexam assignexam=new Assignexam();
//			assignexam.setCreater("SYS");
//			testuser11.setAssignexam(assignexam);
//			moreTable.select(testuser11);
//			
//			Assigncourse assigncourse=new Assigncourse();
//			assigncourse.setName("test two layer");
//			assignexam.setAssigncourse(assigncourse);
//			moreTable.select(testuser11);
//			
//			Condition condition=BeeFactoryHelper.getCondition();
//			condition.opOn("assignexam.status", Op.eq, "1");
//			moreTable.select(testuser11,condition);
//			
//			Condition condition2=BeeFactoryHelper.getCondition();
//			condition2.opOn("assigncourse.status", Op.eq, "1");
//			condition2.opOn("assigncourse.creater", Op.eq, "all"); //value不是字段, 与连接的表达式两边都是字段不一样.
//			moreTable.select(testuser11,condition2);
//			
//			
//			Condition condition3=BeeFactoryHelper.getCondition();
////			condition3.opOn("assignexam.status", Op.eq, "1");
//			condition3.opOn("assigncourse.status", Op.eq, "2");
//			condition3.opOn("assignexam.status", Op.eq, "1");// change order
//			condition3.opOn("assigncourse.creater", Op.eq, "all"); 
//			moreTable.select(testuser11,condition3);
//			
//			
//			TestUser011 testuser011 = new TestUser011();
//			Condition condition4=BeeFactoryHelper.getCondition();
////			condition4.opOn("table2.status", Op.eq, "1");
//			condition4.opOn("assigncourse.status", Op.eq, "2");
//			condition4.opOn("table2.status", Op.eq, "1");// change order  别名
//			condition4.opOn("assigncourse.creater", Op.eq, "all"); 
//			moreTable.select(testuser011,condition4); 
			
			
			
			Orders20 orders20=new Orders20();
			List list20=moreTable.select(orders20);
			Printer.printList(list20);
			
//			Orders20 orders20_2=new Orders20();
//			Condition condition5=BeeFactoryHelper.getCondition();
//			condition5.selectField("orders.id,orders.name,TestUser.id");
//			List list20_2=moreTable.select(orders20_2,condition5);
//			Printer.printList(list20_2);
			
			
//			Noid noid=new Noid();  //无从表注解
//			moreTable.select(noid);

		} catch (BeeException e) {
			e.printStackTrace();
			Logger.error("In MoreTableExam (BeeException):" + e.getMessage());
		} catch (Exception e) {
			Logger.error("In MoreTableExam (Exception):" + e.getMessage());
			e.printStackTrace();
		}
	}

}