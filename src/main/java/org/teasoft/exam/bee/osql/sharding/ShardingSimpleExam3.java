
package org.teasoft.exam.bee.osql.sharding;

import java.util.List;

import org.teasoft.bee.osql.api.Suid;
import org.teasoft.exam.bee.osql.sharding.entity.Orders;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * 无查询条件. 要转成全域查询  TODO
 * @author Kingstar
 * @since  2.0
 *
 */
public class ShardingSimpleExam3 {
	
	public static void main(String[] args) {
		InitSameDsUtil.initDS();
		ShardingInitData.init();
		test();
	}

	public static void test(){
		System.out.println("------Sharding test--------ShardingSimpleExam3-----");
		
		Suid suid=BF.getSuid(); //1
		Orders orders1=new Orders();
//		orders1.setName("Bee(ORM Framework)");
		
//		Condition condition=BF.getCondition();
//		condition
//		.op(Orders_F.userid, Op.eq, 1)
//        .lParentheses()
//		.op(Orders_F.orderid, Op.eq, 1)
//		.or()
//		.op(Orders_F.orderid, Op.eq, 2)
//		.rParentheses()
//		;
		
		
	 	List<Orders> list=suid.select(orders1);
	 	Printer.printList(list);
	 	System.out.println("--------------------:");
	 	list=suid.select(orders1);
        Printer.printList(list);
		
	}
}
