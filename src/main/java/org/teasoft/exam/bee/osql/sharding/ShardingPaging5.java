
package org.teasoft.exam.bee.osql.sharding;

import java.util.List;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.Suid;
import org.teasoft.bee.sharding.ShardingBean;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.sharding.ShardingUtil;
import org.teasoft.honey.sharding.config.ShardingConfig;

/**
 * 分页, 多库多表; 无排序
 * 分片字段是String类型
 * @author Kingstar
 * @since  2.0
 */
public class ShardingPaging5 {
	
	public static void main(String[] args) {
		
		InitSameDsUtil.initDS();
		
//		ShardingInitData.init();
		ShardingBean shardingBean=new ShardingBean();
		shardingBean.setTabField("remark");
		shardingBean.setFullNodes("ds[0..1].orders[0..5]");
//		ShardingRegistry.register(Orders.class, shardingBean);
		ShardingConfig.addShardingBean(Orders.class, shardingBean);
		
		test(ShardingUtil.firstRecordIndex()); //要先配置数据源,才能获取到.   从首条.
//		test(2); //非首条
//		test(-1);//不使用start
	}
	
	public static void test(int startIndex) {
		
		Suid suid=BF.getSuid(); //1
		Orders orders1=new Orders();
		orders1.setUserid(3L);
		
		Condition condition=BF.getCondition();
		condition
//		.op(Orders_F.userid, Op.eq, 0)
        .lParentheses()  //(
		.op(Orders_F.orderid, Op.eq, 1)
		.or()  // or
		.op(Orders_F.orderid, Op.eq, 2)
		.or()
		.op(Orders_F.orderid, Op.eq, 4)
		.rParentheses()  // )
		
		.op(Orders_F.remark, Op.eq, "String类型分片值")
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
        
        
        //全表查询, 分页; 批量插入,  modify等
		
	}
}
