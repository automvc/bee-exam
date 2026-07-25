
package org.teasoft.exam.bee.osql.sharding;

import java.util.List;

import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.Suid;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.osql.sharding.entity.Orders;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * 条件全在condition(javabean没有设置)  case x
 * @author Kingstar
 * @since  2.4.2
 *
 */
public class ShardingSimpleExam2_7 {
	
	public static void main(String[] args) {
		InitSameDsUtil.initDS();
		ShardingInitData.init();
		test();
	}

	public static void test(){
		System.out.println("------Sharding test--------ShardingSimpleExam-----");
		
		Suid suid=BF.getSuid(); //1
		Orders orders1=new Orders();
		
		Condition condition=BF.getCondition();
//		condition.start(20);
//		condition.size(100);
		;
		
//		condition
//		.op(Orders_F.orderid, Op.eq, 0)
////		.or()
////		.op(Orders_F.orderid, Op.eq, 1)
////		.or()
////		.op(Orders_F.orderid, Op.eq, 2)
//		;
		
		//条件全在condition  case 5
	 	List<Orders> list=suid.select(orders1,condition);
	 	Printer.printList(list);
	 	System.out.println("--------------------:");
	 	
	 	Orders ordersUpdate=new Orders();
	 	ordersUpdate.setId(390991362129976L);
////	 	ordersUpdate.setUserid(1L);
////	 	ordersUpdate.setOrderid(2L);
//	 	ordersUpdate.setRemark("update test, need delete cache");
//	 	suid.update(ordersUpdate);
	 	
	 	SuidRich suidRich=BF.getSuidRich();
	 	suidRich.deleteById(Orders.class, 1052711105593419L);
	 	
	 	list=suid.select(orders1,condition);
        Printer.printList(list);
        
        //全表查询, 分页; 批量插入,  modify等
		
	}
}
