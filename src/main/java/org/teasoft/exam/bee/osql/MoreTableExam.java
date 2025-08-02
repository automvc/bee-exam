/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.FunctionType;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.MoreTable;
import org.teasoft.bee.osql.api.Suid;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.osql.moretable.entity.Assigncourse;
import org.teasoft.exam.bee.osql.moretable.entity.Assignexam;
import org.teasoft.exam.bee.osql.moretable.entity.Orders;
//import org.teasoft.exam.bee.osql.moretable.entity.User;
import org.teasoft.exam.bee.osql.moretable.entity.TestUser;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.BeeFactoryHelper;
import org.teasoft.honey.osql.core.ConditionImpl;

/**
 * @author Kingstar
 * @since  1.7
 */
public class MoreTableExam {

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		try {
			MoreTable moreTable = BeeFactory.getHoneyFactory().getMoreTable();
			
//			HoneyConfig.getHoneyConfig().getDbName();
//			DbFeatureRegistry.register(DatabaseConst.SQLSERVER, null); 
//			HoneyConfig.getHoneyConfig().setDatabaseMajorVersion(0); 
			
//			DbFeatureRegistry.register(DatabaseConst.SQLSERVER, new SqlServerFeature());
			
			Orders orders1 = new Orders();
			orders1.setUserid("bee");
			orders1.setName("Bee");
			
			TestUser user = new TestUser();
			//			user.setEmail("beeUser@163.com");
			user.setName("Bee");
			orders1.setTestUser(user);
			
			//默认不处理null和空字符串.不用再写一堆的判断;其它有值的字段全部自动作为过滤条件
			//List<Orders> list1 =moreTable.select(orders1);  //select
//			List<Orders> list1 = moreTable.select(orders1, 0, 10); //select 查询前10条记录
			List<Orders> list1 = moreTable.select(orders1, 2, 10); //select 查询前10条记录
			Logger.info("size of records:"+list1.size() + "");
			for (int i = 0; i < list1.size(); i++) {
				Logger.info(list1.get(i).toString());
			}
			
			Condition condition = new ConditionImpl();
			condition
			//.op("myuser.id", Op.gt,6)//模糊查询   取别名
			//.op("user.id", Op.gt,6) //模糊查询  
			.op("orders.id", Op.ge, 1001) //模糊查询  
			.start(0).size(5) //分页
			//			.start(2).size(6) //分页
			;
			
			//默认不处理null和空字符串.不用再写一堆的判断;其它有值的字段全部自动作为过滤条件
			//List<Orders> list2 =moreTable.select(orders1,0,10);  //select 查询前10条记录
			List<Orders> list2 = moreTable.select(orders1, condition); //select
			Logger.info("size of records:"+list2.size() + "");
			for (int i = 0; i < list2.size(); i++) {
				Logger.info(list2.get(i).toString());
			}
			
			Orders ordersUpdate=new Orders();
			ordersUpdate.setUserid("bee");
			ordersUpdate.setName("Bee");
			Condition conditionUpdate=BeeFactoryHelper.getCondition();
			conditionUpdate.op("name", Op.eq, null);
			SuidRich suidRich=BeeFactoryHelper.getSuidRich();
			suidRich.update(ordersUpdate, conditionUpdate, "name");
			
			//			condition.selectField("orders.id,test_user.id,userid,total,orders.createtime");  
			condition.selectField("orders.id,testUser.id,userid,total,orders.createtime");//只查询部分字段. 没有指定查询的值都为null
			List<Orders> list3 = moreTable.select(orders1, condition); //select
			Logger.info("size of records:"+list3.size() + "");
			for (int i = 0; i < list3.size(); i++) {
				Logger.info(list3.get(i).toString());
			}
			
			//V1.9
			Assigncourse assigncourse=new Assigncourse();
			assigncourse.setStatus("1");
			
			Assignexam assignexam=new Assignexam(); //主表
			assignexam.setStatus("1");
			assignexam.setAssigncourse(assigncourse);
			
			moreTable.select(assignexam);
			
			assignexam.setClassno("aaa");
//			System.out.println("---------------select before----------------------");
//			moreTable.select(assignexam);
//			System.out.println("---------------select after----------------------");
			
			Assigncourse assigncourse2=new Assigncourse();
			assigncourse2.setId(344343344343L);
			Suid suid = BeeFactory.getHoneyFactory().getSuid();
//			System.out.println("---------------delete before----------------------");
			suid.delete(assigncourse2);
			
			moreTable.select(assignexam);//test cache
			
			List<org.teasoft.exam.bee.osql.moretable.entity.Orders> list4 =moreTable.setDynamicParameter("month", "_202007").select(orders1, 0, 10);
			Printer.printList(list4);
			List<org.teasoft.exam.bee.osql.moretable.entity.Orders> list5 =moreTable.select(orders1, 0, 10);
			Printer.printList(list5);
			
			Condition distinctCondition0=BeeFactoryHelper.getCondition();
			distinctCondition0
			.selectDistinctField("assignexam.id")
//			.selectFun(FunctionType.MAX, "assignexam.id")
//			.selectField("assignexam.id")
			;
			moreTable.select(new Assignexam(), distinctCondition0);
			
			Condition distinctCondition1=BeeFactoryHelper.getCondition();
			distinctCondition1
			.selectFun(FunctionType.MAX, "assignexam.id")
			;
			moreTable.select(new Assignexam(), distinctCondition1);

		} catch (BeeException e) {
			e.printStackTrace();
			Logger.error("In MoreTableExam (BeeException):"+e.getMessage());
		}catch (Exception e) {
			Logger.error("In MoreTableExam (Exception):"+e.getMessage());
			e.printStackTrace();
		}
	}
}
