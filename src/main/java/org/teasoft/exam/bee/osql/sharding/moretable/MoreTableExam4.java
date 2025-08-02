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
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  2.0
 */
public class MoreTableExam4 {

	public static void main(String[] args) {
		
		ShardingInitData.init(); // 分片
		InitSameDsUtil.initDS();
		
		test();
	}

	public static void test() {
		try {
			MoreTable moreTable = BeeFactory.getHoneyFactory().getMoreTable();
			
			Myorders orders1 = new Myorders();
//			orders1.setUserid(2L);
			
			//一库多表
			Condition condition = BF.getCondition();
			condition
			.op("myorders.userid", Op.eq, 3) 
//			.op("myorders.userid", Op.eq, 1) 
//			.op("ordersdetail.userid", Op.eq, 1) 
//			.op("userid", Op.eq, 2) 
			.start(0).size(10) //分页
			;
			
			Ordersdetail ordersdetail=new Ordersdetail();
			orders1.setOrdersdetail(ordersdetail);
			
//			List<Myorders> list2 = moreTable.select(orders1, condition); //select
//			Logger.info("size of records:"+list2.size() + "");
//			Printer.printList(list2);
			
//			List<String[]> list3 = moreTable.selectString(orders1, condition); 
//			Logger.info("size of records:"+list3.size() + "");
//			Printer.print(list3);
			
			String resultJosn=moreTable.selectJson(orders1, condition); 
			Logger.info("--MoreTable---resultJosn: "+resultJosn);

		} catch (BeeException e) {
			e.printStackTrace();
			Logger.error("In MoreTableExam (BeeException):"+e.getMessage());
		}catch (Exception e) {
			Logger.error("In MoreTableExam (Exception):"+e.getMessage());
			e.printStackTrace();
		}
	}
}
