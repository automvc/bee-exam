
package org.teasoft.exam.bee.osql.sharding;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.Suid;
import org.teasoft.bee.sharding.ShardingBean;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.sharding.ShardingUtil;
import org.teasoft.honey.sharding.config.ShardingConfig;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 仅分表; 只分表,不分库(只有一个库)
 * 分页; 无排序
 * @author Kingstar
 * @since  2.0
 */
public class ShardingPaging_Just_ShardingTable {
	
	public static void main(String[] args) throws SQLException{
		
//		InitSameDsUtil.initDS();//仅分表,只有一个数据源,不应该使用多个.
		
		DruidDataSource dataSource0;
		dataSource0 = new DruidDataSource();
		dataSource0.setUrl("jdbc:mysql://localhost:3306/bee?characterEncoding=UTF-8&useSSL=false");
		dataSource0.setUsername("root");
		dataSource0.setPassword("123456");
		dataSource0.init();
		
		//只分表,不分库(只有一个库)
		Map<String, DataSource> dataSourceMap = new HashMap<>();
		dataSourceMap.put("ds", dataSource0);  //只有一个库
		BeeFactory.getInstance().setDataSourceMap(dataSourceMap);
		
		ShardingBean shardingBean=new ShardingBean();
		shardingBean.setTabField(Orders_F.userid);
		shardingBean.setFullNodes("ds[].orders[0..2]"); //只分表,不分库(只有一个库)
//		shardingBean.setFullNodes("ds[].orders[0..5]");
//		shardingBean.setFullNodes("ds[0,1].orders[0..5]");//ok  分库分表
//		shardingBean.setFullNodes("ds[0..1].orders[0..5]");//ok 分库分表
		ShardingConfig.addShardingBean(Orders.class, shardingBean);
		
		test(ShardingUtil.firstRecordIndex()); //要先配置数据源,才能获取到.   从首条.
//		test(2); //非首条
//		test(-1);//不使用start
	}
	
	public static void test(int startIndex) {
		
		Suid suid=BF.getSuid(); //1
		Orders orders1=new Orders();
		
		Condition condition=BF.getCondition();
		condition
//		.op(Orders_F.userid, Op.eq, 0)
        .lParentheses()
		.op(Orders_F.userid, Op.eq, 1)
		.or()
		.op(Orders_F.userid, Op.eq, 3)
		.rParentheses()
		;
		
		condition
//		.start(6)
		.start(0)
		.size(2);
		
		
		//条件全在condition  case 5
	 	List<Orders> list=suid.select(orders1,condition);
	 	Printer.printList(list);
	 	System.out.println("--------------------:");
	 	list=suid.select(orders1,condition);
        Printer.printList(list);
        
	}
}
