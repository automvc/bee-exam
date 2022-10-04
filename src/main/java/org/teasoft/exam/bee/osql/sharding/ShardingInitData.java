/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.sharding;

import java.util.ArrayList;
import java.util.List;

import org.teasoft.bee.sharding.ShardingBean;
import org.teasoft.exam.bee.osql.sharding.moretable.entity.Myorders;
import org.teasoft.exam.bee.osql.sharding.moretable.entity.Ordersdetail;
import org.teasoft.honey.sharding.config.ShardingConfig;

/**
 * @author Kingstar
 * @author Kingstar
 * @since  2.0
 */
public class ShardingInitData {
	
	static {
		
//		InterceptorChainRegistry.addInterceptor(new CustomInterceptor()); //添加定制拦截器.
		
		ShardingBean shardingBean=new ShardingBean();
		shardingBean.setTabField("orderid");
		
//		shardingBean.setTabRule("orderid%6");
//		shardingBean.setTabName("orders");
		
//		shardingBean.setDsField(Orders_F.orderid);
//		shardingBean.setDsRule("orderid%6/3");
//		shardingBean.setDsName("ds"); //数据源基本名称
		
		shardingBean.setActualDataNodes("ds[0..1].orders[0..5]");
		
		
//		ShardingRegistry.register(Orders.class, shardingBean);
//		ShardingConfig.addShardingBean(Orders.class, shardingBean);
		
		ShardingConfig.addShardingBean(Orders.class,new ShardingBean("ds[0..1].orders[0..5]", "orderid"));
		
		
		ShardingBean shardingBean2=new ShardingBean();
		shardingBean2.setTabField("userid");
		shardingBean2.setTabRule("userid %6");
		
		shardingBean2.setDsField("userid");
		shardingBean2.setDsRule("userid%6/3");
		shardingBean2.setDsName("ds"); //数据源基本名称
		
		shardingBean2.setActualDataNodes("ds[0..1].myorders[0..5]");
//		ShardingRegistry.register(Myorders.class, shardingBean2);
		ShardingConfig.addShardingBean(Myorders.class, shardingBean2);
		
		ShardingBean shardingBean3=new ShardingBean();
		shardingBean3.setTabField("userid");
		shardingBean3.setTabRule("userid %6");
		
		shardingBean3.setDsField("userid");
		shardingBean3.setDsRule("userid%6/3");
		shardingBean3.setDsName("ds"); //数据源基本名称
//		shardingBean2.setActualDataNodes("ds[0..1].ordersdetail[0..5]");//test exception :shardingBean2
		shardingBean3.setActualDataNodes("ds[0..1].ordersdetail[0..5]");
//		ShardingRegistry.register(Ordersdetail.class, shardingBean3);
		ShardingConfig.addShardingBean(Ordersdetail.class, shardingBean3);
		
		//最佳实践:
		//只需要设置setActualDataNodes和表分片键(表分片字段).
		//然后会根据表分片字段的值的余数,对应到[0..n]个表.
		
		List<String> broadcastTabList =new ArrayList<>();
//		broadcastTabList.add("ordersdetail");
		ShardingConfig.addBroadcastTabList(broadcastTabList);
	}
	
	public static void init() {}

}
