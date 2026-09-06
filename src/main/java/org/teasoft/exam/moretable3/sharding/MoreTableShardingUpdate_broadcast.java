/*
 * Copyright 2020-2025 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.moretable3.sharding;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.api.MoreTable;
import org.teasoft.bee.sharding.ShardingBean;
import org.teasoft.exam.bee.osql.sharding.InitSameDsUtil;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.sharding.config.ShardingConfig;

/**
 * 主表与广播子表test_user关联
 * @author Kingstar
 * @since  2.5.2
 */
public class MoreTableShardingUpdate_broadcast {
	
	public static void main(String[] args) {
//		ShardingInitData.init();
		ShardingConfig.addShardingBean("Orders", new ShardingBean("ds[0..1].orders[0..5]", "userid"));

//		ShardingConfig.addShardingBean(TestUser.class,new ShardingBean("ds[0..1].test_users[]"));
//		ShardingConfig.addBroadcastTable("test_users");
		
		ShardingConfig.addShardingBean(TestUser.class,new ShardingBean("ds[0..1].test_user[]"));
		ShardingConfig.addBroadcastTable("test_user");
		
		InitSameDsUtil.initDS();
		test();
	}

	public static void test() {
		try {
			MoreTable moreTable = BeeFactory.getHoneyFactory().getMoreTable();
			
			
			Orders orders = new Orders();
//			orders.setId(10032L);
			orders.setId(1273372453371973L);
//			Long rfId=32L;
			Long rfId=800001L;
			orders.setUserid(rfId);
			orders.setOrderid(rfId);
			
			TestUser testUser=new TestUser();
			testUser.setId(rfId);
			testUser.setUsername("testSharding");
			
			orders.setTestUser(testUser);
			
			orders.setRemark("update-Broadcast");
			testUser.setName("aaa");
			
			moreTable.update(orders);
			
//			List<Orders> list=moreTable.select(orders);
//			Printer.printList(list);
			
		} catch (BeeException e) {
			e.printStackTrace();
			Logger.error("In MoreTableInsertSharding (BeeException):"+e.getMessage());
		}catch (Exception e) {
			Logger.error("In MoreTableInsertSharding (Exception):"+e.getMessage());
			e.printStackTrace();
		}
	}

}
/*
[INFO] [Bee] Parse DataSourceMap: dataSource name to database name , result: {ds0=MySQL, ds1=MySQL}
[INFO] [Bee] ========= get the dbName from HoneyConfig is: MySQL
[DEBUG] The layer is: 1, class is: class org.teasoft.exam.moretable3.sharding.Orders, alias is: orders
[DEBUG] The layer is: 2, class is: org.teasoft.exam.moretable3.sharding.TestUser, alias is: test_user
[INFO] [Bee] Reset the DataSource OneTime, ds name:ds1
[INFO] [Bee] Reset the tabName OneTime, tabName:orders3
[INFO] [Bee] update SQL: update orders3 set userid=? , orderid=? , remark=? where id=?   [values]: 800001(Long),800001(Long),update-Broadcast(String),1273372453371973(Long)
[Bee] update SQL:  ( ExecutableSql )
update orders3 set userid=800001 , orderid=800001 , remark='update-Broadcast' where id=1273372453371973 ;
[INFO] [Bee] ========= the current DataSource name is :ds1
[INFO]  | <--  Affected rows: 0
[INFO] [Bee] update SQL: update test_user set name=? , username=? where id=?   [values]: aaa(String),testSharding(String),800001(Long)
[Bee] update SQL:  ( ExecutableSql )
update test_user set name='aaa' , username='testSharding' where id=800001 ;
[INFO] ========= Do sharding , the size of sub operation is :2
[INFO] [Bee] modify SQL(sharding 2) : update test_user set name=? , username=? where id=?   [values]: aaa(String),testSharding(String),800001(Long)
[Bee] modify SQL(sharding 2) :  ( ExecutableSql )
update test_user set name='aaa' , username='testSharding' where id=800001 ;
[INFO] [Bee] modify SQL(sharding 1) : update test_user set name=? , username=? where id=?   [values]: aaa(String),testSharding(String),800001(Long)
[Bee] modify SQL(sharding 1) :  ( ExecutableSql )
update test_user set name='aaa' , username='testSharding' where id=800001 ;
[INFO] [Bee] ========= the current DataSource name is :ds0 (sharding 1)
[INFO] [Bee] ========= the current DataSource name is :ds1 (sharding 2)
[INFO]  | <--  Affected rows: 1 (sharding 1)
[INFO]  | <--  Affected rows: 1 (sharding 2)
[INFO]  | <--  Affected rows: 2
[INFO] update sub entity:org.teasoft.exam.moretable3.sharding.TestUser, Affected rows: 2

*/
