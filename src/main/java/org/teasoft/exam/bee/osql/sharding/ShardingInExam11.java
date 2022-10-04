
package org.teasoft.exam.bee.osql.sharding;

import java.util.List;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.Suid;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * 在Condtion使用in,产生分片
 * @author Kingstar
 * @since  2.0
 *
 */
public class ShardingInExam11 {
	
	public static void main(String[] args) {
		
		ShardingInitData.init();  //注释掉,不注册有分片,就不会产生全域查询.
		
		InitSameDsUtil.initDS();
		
		Suid suid=BF.getSuid(); //1
		Orders orders=new Orders();
//		orders.setRemark("Bee(ORM Framework)");
		
		Long ordersId[]= {1L,2L};
		Condition condition=BF.getCondition();
		condition
//		.op(Orders_F.orderid, Op.in, ordersId)
		.op(Orders_F.orderid, Op.in, "1,2")
		;
		
		
	 	List<Orders> list=suid.select(orders,condition);
        Printer.printList(list);
        
        System.out.println("--------------------:");
        
        list=suid.select(orders,condition);
        Printer.printList(list);
		
	}
}
