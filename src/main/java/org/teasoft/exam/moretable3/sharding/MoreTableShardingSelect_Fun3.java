package org.teasoft.exam.moretable3.sharding;

import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.FunctionType;
import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.MoreTable;
import org.teasoft.bee.sharding.ShardingBean;
import org.teasoft.exam.bee.osql.sharding.InitSameDsUtil;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.sharding.config.ShardingConfig;

public class MoreTableShardingSelect_Fun3 {
	public static void main(String[] args) {
		ShardingConfig.addShardingBean("Orders", new ShardingBean("ds[0..1].orders[0..5]", "userid"));
		InitSameDsUtil.initDS(); //设置多个数据源
		test();
	}
	public static void test() {
		try {
			MoreTable moreTable = BF.getMoreTable();
			
			Orders orders = new Orders();
//			Long rfId=33L;
//			orders.setUserid(rfId);
//			orders.setOrderid(rfId);
			
			TestUser testUser=new TestUser();
//			testUser.setId(rfId);
//			testUser.setUsername("testSharding");
			
			orders.setTestUser(testUser);
		
//			List<Orders> list=moreTable.select(orders);
//			Printer.printList(list);
			
			Condition condition=BF.getCondition();
//			condition.selectFun(FunctionType.MAX, "orderid", "max_orderid");
//			condition.selectFun(FunctionType.MIN, "orderid", "min_orderid");
//			condition.selectFun(FunctionType.COUNT, "orderid", "count_orderid");
			condition.selectFun(FunctionType.AVG, "orderid", "avg_orderid");
//			condition.selectFun(FunctionType.SUM, "orderid", "sum_orderid");
			
//			condition.selectField("orderid");
//			
//			condition.groupBy("orderid");
			
			String funOrderid=moreTable.selectWithFun(orders, condition);
			Logger.info("fun result:"+funOrderid);
			
		} catch (BeeException e) {
			e.printStackTrace();
			Logger.error("In MoreTableInsertSharding (BeeException):"+e.getMessage());
		}catch (Exception e) {
			Logger.error("In MoreTableInsertSharding (Exception):"+e.getMessage());
			e.printStackTrace();
		}
	}
}
