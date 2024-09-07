/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.moretable.modify.sharding;

import java.util.ArrayList;
import java.util.List;

import org.teasoft.bee.sharding.ShardingBean;
import org.teasoft.exam.bee.mongodb.entity.Noid0;
import org.teasoft.exam.bee.osql.moretable.modify.Book2;
import org.teasoft.exam.bee.osql.moretable.modify.BookDetail;
import org.teasoft.exam.bee.osql.moretable.modify.BookReal;
import org.teasoft.exam.bee.osql.sharding.moretable.entity.Myorders;
import org.teasoft.exam.bee.osql.sharding.moretable.entity.Ordersdetail;
import org.teasoft.exam.bee.osql.special.ddl.TestMyUser;
import org.teasoft.honey.sharding.config.ShardingConfig;

/**
 * @author Kingstar
 * @author Kingstar
 * @since  2.0
 */
public class ShardingInitData {
	
	public static void init() {
		
//		ShardingBean shardingBean=new ShardingBean();
//		shardingBean.setTabField("orderid");
//		shardingBean.setFullNodes("ds[0..1].orders[0..5]");
		
		ShardingConfig.addShardingBean("Orders",new ShardingBean("ds[0..1].orders[0..5]", "orderid")); //ok
		
		
		ShardingBean shardingBean2=new ShardingBean();
		shardingBean2.setTabField("userid");
		shardingBean2.setTabRule("userid %6");
		
		shardingBean2.setDsField("userid");
		shardingBean2.setDsRule("userid%6/3");
		shardingBean2.setDsName("ds"); //数据源基本名称
		
		shardingBean2.setFullNodes("ds[0..1].myorders[0..5]");
//		ShardingRegistry.register(Myorders.class, shardingBean2);
		ShardingConfig.addShardingBean(Myorders.class, shardingBean2);
		
		ShardingBean shardingBean3=new ShardingBean();
		shardingBean3.setTabField("userid");
		shardingBean3.setTabRule("userid %6");
		
		shardingBean3.setDsField("userid");
		shardingBean3.setDsRule("userid%6/3");
		shardingBean3.setDsName("ds"); //数据源基本名称
//		shardingBean2.setFullNodes("ds[0..1].ordersdetail[0..5]");//test exception :shardingBean2
		shardingBean3.setFullNodes("ds[0..1].ordersdetail[0..5]");
//		ShardingRegistry.register(Ordersdetail.class, shardingBean3);
		ShardingConfig.addShardingBean(Ordersdetail.class, shardingBean3);
		
		//最佳实践:
		//只需要设置setFullNodes和表分片键(表分片字段).
		//然后会根据表分片字段的值的余数,对应到[0..n]个表.
		
		List<String> broadcastTabList =new ArrayList<>();
//		broadcastTabList.add("ordersdetail");
		ShardingConfig.addBroadcastTable(broadcastTabList);
		
		ShardingConfig.addShardingBean("Scores",new ShardingBean("ds[0].scores[0..1]")); //配置单库的
		
		//配置广播表
		ShardingConfig.addShardingBean(Noid0.class,new ShardingBean("ds[0..1].noid0[]"));
		ShardingConfig.addBroadcastTable("noid0");
		
		ShardingConfig.addShardingBean(Noid0.class,new ShardingBean("ds[0..1].noid1[]"));
		ShardingConfig.addBroadcastTable("noid1");
		
		ShardingConfig.addShardingBean("test_user",new ShardingBean("ds[0..1].test_user[0..5]", "id"));
		ShardingConfig.addShardingBean("test_users",new ShardingBean("ds[0..1].test_users[0..5]", "id"));
		ShardingConfig.addShardingBean(TestMyUser.class,new ShardingBean("ds[0..1].test_my_user[0..5]", "id"));
		
		//2.4.0
//		ShardingConfig.addShardingBean(Book2.class,new ShardingBean("ds[0..1].book[0..5]", "id")); 
//		ShardingConfig.addShardingBean(Book.class,new ShardingBean("ds[0..1].book[0..5]", "id")); 
		ShardingConfig.addShardingBean("book",new ShardingBean("ds[0..1].book[0..5]", "id")); 
		ShardingConfig.addShardingBean(BookDetail.class,new ShardingBean("ds[0..1].book_detail[0..5]", "bookId")); //ok
		ShardingConfig.addShardingBean(BookReal.class,new ShardingBean("ds[0..1].book_real[0..5]", "bookDetailId")); //ok
	}
	

}
