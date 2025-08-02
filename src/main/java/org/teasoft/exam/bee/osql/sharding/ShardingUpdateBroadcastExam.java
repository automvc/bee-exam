
package org.teasoft.exam.bee.osql.sharding;

import java.util.List;

import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.osql.sharding.entity.Orders;
import org.teasoft.exam.bee.osql.sharding.entity.Orders_F;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.util.Printer;

/**
 * Update Sharding.Update的分片
 * @author Kingstar
 * @since  2.0
 *
 */
public class ShardingUpdateBroadcastExam {
	
	public static void main(String[] args) {
		ShardingInitData.init();
		InitSameDsUtil.initDS();
		test();
	}

	public static void test(){
		System.out.println("------Sharding test--------ShardingUpdateBroadcastExam-----");
		
		SuidRich suidRich=BF.getSuidRich(); //1
		
		Orders orders6=new Orders();
		orders6.setOrderid(2L);
//		orders6.setId(1L);
		Condition condition6=BF.getCondition();
		condition6
		.or()
		.op(Orders_F.orderid, Op.eq, 9L)
		.set(Orders_F.remark, "changed by sharding!")
		;
		
		int delNum6=suidRich.update(orders6,condition6);
		Logger.info("-----------更新的记录数:"+delNum6);
		
		
		List<Orders> list=suidRich.select(orders6,condition6);
		Printer.printList(list);
		
		list=suidRich.select(orders6,condition6);
		
		
		
	}
}
