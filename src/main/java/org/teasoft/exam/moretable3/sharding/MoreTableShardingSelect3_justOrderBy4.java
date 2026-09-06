package org.teasoft.exam.moretable3.sharding;

import java.util.List;
import java.util.Map;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.MoreTable;
import org.teasoft.bee.sharding.ShardingBean;
import org.teasoft.exam.bee.osql.sharding.InitSameDsUtil;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.sharding.config.ShardingConfig;

public class MoreTableShardingSelect3_justOrderBy4 {
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
			
			Condition condition = BF.getCondition();
			
			condition.selectField("orders.userId");
			
			condition.orderBy("orders.userId");
			condition.orderBy("orders.orderid");
			
//			在ShardingReg的这个方法可以debug看到设置的值。
//			public static void regShardingSort(Map<String, String> orderByMap) {
			
			List<String[]> list=moreTable.selectString(orders, condition);
			Printer.print(list);
		} catch (BeeException e) {
			e.printStackTrace();
			Logger.error("In MoreTableInsertSharding (BeeException):"+e.getMessage());
		}catch (Exception e) {
			Logger.error("In MoreTableInsertSharding (Exception):"+e.getMessage());
			e.printStackTrace();
		}
	}
}
