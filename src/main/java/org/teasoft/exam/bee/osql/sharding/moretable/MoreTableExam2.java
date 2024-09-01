/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.sharding.moretable;

import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.MoreTable;
import org.teasoft.exam.bee.osql.sharding.InitSameDsUtil;
import org.teasoft.exam.bee.osql.sharding.ShardingInitData;
import org.teasoft.exam.bee.osql.sharding.moretable.entity.Myorders;
import org.teasoft.exam.bee.osql.sharding.moretable.entity.Ordersdetail;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  2.0
 */
public class MoreTableExam2 {

	public static void main(String[] args) {
		
		ShardingInitData.init(); // 分片
		InitSameDsUtil.initDS();
		
		test();
	}

	public static void test() {
		try {
			MoreTable moreTable = BeeFactory.getHoneyFactory().getMoreTable();
			
			Myorders orders1 = new Myorders();
			orders1.setUserid(2L);
			
//			//一库一表
//			List<Myorders> list1 = moreTable.select(orders1, 0, 10); //select 查询前10条记录
//			Logger.info("size of records:"+list1.size() + "");
//            Printer.printList(list1);
			
			
			//一库多表
			Condition condition = BF.getCondition();
			condition
//			.op("orders.Userid", Op.eq, 2) 
			.op("userid", Op.eq, 2) 
			.start(0).size(10) //分页
			;
			
			Ordersdetail ordersdetail=new Ordersdetail();
//			ordersdetail.setRemark("aaa");
			orders1.setOrdersdetail(ordersdetail);
			
//			List<Myorders> list2 = moreTable.select(orders1, condition); //select
//			Logger.info("size of records:"+list2.size() + "");
//			Printer.printList(list2);
			
			
			List<String[]> list3 = moreTable.selectString(orders1, condition); //select
			Logger.info("size of records:"+list3.size() + "");
			Printer.print(list3);
			
			
//			//全域查询.  但分页不准确. 数量,排序 TODO
//			List<Myorders> list3 = moreTable.select(new Myorders(), 0, 10); // select 查询前10条记录
//			Logger.info("size of records:" + list3.size() + "");
//			Printer.printList(list3);
			
			
			
			
			
			
			
			
			
//			Orders ordersUpdate=new Orders();
//			ordersUpdate.setUserid("bee");
//			ordersUpdate.setName("Bee");
//			Condition conditionUpdate=BeeFactoryHelper.getCondition();
//			conditionUpdate.op("name", Op.eq, null);
//			SuidRich suidRich=BeeFactoryHelper.getSuidRich();
//			suidRich.update(ordersUpdate, "name", conditionUpdate);
//			
//			//			condition.selectField("orders.id,test_user.id,userid,total,orders.createtime");  
//			condition.selectField("orders.id,testUser.id,userid,total,orders.createtime");//只查询部分字段. 没有指定查询的值都为null
//			List<Orders> list3 = moreTable.select(orders1, condition); //select
//			Logger.info("size of records:"+list3.size() + "");
//			for (int i = 0; i < list3.size(); i++) {
//				Logger.info(list3.get(i).toString());
//			}
//			
//			//V1.9
//			Assigncourse assigncourse=new Assigncourse();
//			assigncourse.setStatus("1");
//			
//			Assignexam assignexam=new Assignexam(); //主表
//			assignexam.setStatus("1");
//			assignexam.setAssigncourse(assigncourse);
//			
//			moreTable.select(assignexam);
//			
//			assignexam.setClassno("aaa");
////			System.out.println("---------------select before----------------------");
////			moreTable.select(assignexam);
////			System.out.println("---------------select after----------------------");
//			
//			Assigncourse assigncourse2=new Assigncourse();
//			assigncourse2.setId(344343344343L);
//			Suid suid = BeeFactory.getHoneyFactory().getSuid();
////			System.out.println("---------------delete before----------------------");
//			suid.delete(assigncourse2);
//			
//			moreTable.select(assignexam);//test cache
//			
//			List<org.teasoft.exam.bee.osql.moretable.entity.Orders> list4 =moreTable.setDynamicParameter("month", "_202007").select(orders1, 0, 10);
//			Printer.printList(list4);
//			List<org.teasoft.exam.bee.osql.moretable.entity.Orders> list5 =moreTable.select(orders1, 0, 10);
//			Printer.printList(list5);
//			
//			Condition distinctCondition0=BeeFactoryHelper.getCondition();
//			distinctCondition0
//			.selectDistinctField("assignexam.id")
////			.selectFun(FunctionType.MAX, "assignexam.id")
////			.selectField("assignexam.id")
//			;
//			moreTable.select(new Assignexam(), distinctCondition0);
//			
//			Condition distinctCondition1=BeeFactoryHelper.getCondition();
//			distinctCondition1
//			.selectFun(FunctionType.MAX, "assignexam.id")
//			;
//			moreTable.select(new Assignexam(), distinctCondition1);

		} catch (BeeException e) {
			e.printStackTrace();
			Logger.error("In MoreTableExam (BeeException):"+e.getMessage());
		}catch (Exception e) {
			Logger.error("In MoreTableExam (Exception):"+e.getMessage());
			e.printStackTrace();
		}
	}
}
