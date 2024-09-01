
package org.teasoft.exam.bee.osql.sharding;

import java.util.List;

import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.Suid;
import org.teasoft.bee.sharding.ShardingBean;
import org.teasoft.exam.bee.osql.sharding.entity.Orders;
import org.teasoft.exam.bee.osql.sharding.entity.Orders_F;
import org.teasoft.exam.bee.test.ClearDsContext;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.core.HoneyContext;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.sharding.ShardingUtil;
import org.teasoft.honey.sharding.config.ShardingConfig;

/**
 * 仅分库 ;只分库,不分表(每个库的表名都一个;有多个库)
 * 分页; 无排序
 * @author Kingstar
 * @since  2.0
 */
public class ShardingPaging_Just_ShardingDs {
	
	public static void main(String[] args) {
		ClearDsContext.clear();
		InitSameDsUtil.initDS();
		test();
	}

	public static void test(){
		System.out.println("------Sharding test--------ShardingPaging_Just_ShardingDs-----");
		Logger.info("------Sharding test--------ShardingPaging_Just_ShardingDs-----");
		
		ShardingBean shardingBean=new ShardingBean();
		shardingBean.setDsField(Orders_F.userid);
		shardingBean.setDsName("ds");
		shardingBean.setDsRule("userid%2");
		shardingBean.setFullNodes("ds[0..1].orders[]"); //只分库,不分表(每个库的表名都一个;有多个库)
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
		.op(Orders_F.userid, Op.eq, 2)
		.rParentheses()
		;
		
		condition.selectField("id,userid");
		
		condition
//		.start(6)
		.start(0)
		.size(2);
		
		
		//条件全在condition  case 5
	 	List<Orders> list=suid.select(orders1,condition); //bug;No value specified for parameter 1 ;    select id, userid from orders where (userid=? or userid=?) limit 0,2
	 	//可能是多条语句共用一个上下文;被前面的清除了上下文
	 	Printer.printList(list);
	 	System.out.println("--------------------:");
	 	Logger.info("-------------ShardingPaging_Just_ShardingDs-------:");
//	 	list=suid.select(orders1,condition);
//        Printer.printList(list);
        
//        String sql0="select id, userid from orders[$#(index)#$] where (userid=? or userid=?) limit 0,2";  //作为id的sql与运行的sql不一样
//        List listPV=HoneyContext.justGetPreparedValue(sql0); 
//        System.err.println("分片时,主线程上下文是否已被删除? "+listPV.size());
	}
}
