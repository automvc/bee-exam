
package org.teasoft.exam.bee.osql.sharding;

import java.util.List;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.FunctionType;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.OrderType;
import org.teasoft.bee.osql.Suid;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.sharding.ShardingUtil;

/**
 * 
 * @author Kingstar
 * @since  2.0
 */
public class ShardingGroup2 {
	
	public static void main(String[] args) {
		
		ShardingInitData.init();
		InitSameDsUtil.initDS();
		test(ShardingUtil.firstRecordIndex()); //要先配置数据源,才能获取到.   从首条.
//		test(2); //非首条
//		test(-1);//不使用start
	}
	
	public static void test(int startIndex) {
		
		Suid suid=BF.getSuid(); //1
		OrdersGroupResponse0 orders1=new OrdersGroupResponse0();
//		orders1.setName("Bee(ORM Framework)");
		
		Condition condition=BF.getCondition();
		condition
        .lParentheses()
		.op(Orders_F.orderid, Op.eq, 1)
		.or()
		.op(Orders_F.orderid, Op.eq, 2)
		.rParentheses()
		;
		
		condition.selectFun(FunctionType.MAX, Orders_F.total,"maxTotal");
		condition.selectFun(FunctionType.AVG, Orders_F.total,"avgTotal");
		condition.selectField("userid,orderid");
		
		condition.groupBy(Orders_F.userid);
		condition.groupBy(Orders_F.orderid);
		
		condition.orderBy("userid",OrderType.DESC);// bug
//		condition.orderBy("userid",OrderType.ASC);
//		condition.orderBy("total",OrderType.DESC);
		
		condition
//		.start(6)
		.start(0)
//		.start(1)
		.size(5);
		
		
		//条件全在condition  case 5
	 	List<OrdersGroupResponse0> list=suid.select(orders1,condition);
	 	Printer.printList(list);
//	 	System.out.println("--------------------:");
//	 	list=suid.select(orders1,condition);
//        Printer.printList(list);
        
        
        //全表查询, 分页; 批量插入,  modify等
        
        
//        https://www.cnblogs.com/azai/archive/2010/01/09/1642781.html
		
	}
}
