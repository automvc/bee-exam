
package org.teasoft.exam.bee.osql.sharding;

import java.util.List;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.Suid;
import org.teasoft.bee.sharding.ShardingBean;
import org.teasoft.exam.bee.osql.sharding.entity.Orders;
import org.teasoft.exam.bee.osql.sharding.entity.Orders_F;
import org.teasoft.exam.bee.test.ClearDsContext;
import org.teasoft.exam.comm.Printer;
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
	 	List<Orders> list=suid.select(orders1,condition);
	 	Printer.printList(list);
	 	System.out.println("--------------------:");
	 	list=suid.select(orders1,condition);
        Printer.printList(list);
        
	}
}
