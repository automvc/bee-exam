
package org.teasoft.exam.bee.osql.sharding;

import java.util.List;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.Op;
//import org.teasoft.bee.osql.Condition;
//import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.Suid;
import org.teasoft.exam.bee.osql.sharding.entity.Orders;
import org.teasoft.exam.bee.osql.sharding.entity.Orders_F;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * 分表的分片值,只设置在condtion的一库一表
 * @author Kingstar
 * @since  2.0
 *
 */
public class ShardingSimpleExam6 {
	
	public static void main(String[] args) {
		InitSameDsUtil.initDS();
		ShardingInitData.init();
		test();
	}

	public static void test(){
		System.out.println("------Sharding test--------ShardingSimpleExam6-----");
		
		Suid suid=BF.getSuid(); //1
		Orders orders1=new Orders();
		
		Condition condition=BF.getCondition();
		condition
//		.op(Orders_F.userid, Op.eq, 1)
//        .lParentheses()
//		.op(Orders_F.orderid, Op.eq, 1)
//		.or()
		.op(Orders_F.orderid, Op.eq, 2)
//		.rParentheses()
		;
		
		
	 	List<Orders> list=suid.select(orders1,condition);
	 	Printer.printList(list);
	 	System.out.println("--------------------:");
	 	list=suid.select(orders1,condition);
        Printer.printList(list);
		
	}
}
