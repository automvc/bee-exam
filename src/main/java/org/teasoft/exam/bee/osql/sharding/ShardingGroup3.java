
package org.teasoft.exam.bee.osql.sharding;

import java.util.List;

import org.teasoft.bee.osql.FunctionType;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.OrderType;
import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.Suid;
import org.teasoft.exam.bee.osql.sharding.entity.OrdersGroupResponse;
import org.teasoft.exam.bee.osql.sharding.entity.Orders_F;
import org.teasoft.exam.bee.osql.sharding.entity.Orders_F3;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.sharding.ShardingUtil;

/**
 * 
 * @author Kingstar
 * @since  2.0
 */
public class ShardingGroup3 {
	
	public static void main(String[] args) {
		ShardingInitData.init();
		InitSameDsUtil.initDS();
		test();
	}

	public static void test(){
		System.out.println("------Sharding test--------ShardingGroup3-----");
		
		test(ShardingUtil.firstRecordIndex()); //要先配置数据源,才能获取到.   从首条.
//		test(2); //非首条
//		test(-1);//不使用start
	}
	
	public static void test(int startIndex) {
		
		Suid suid=BF.getSuid(); //1
		OrdersGroupResponse orders1=new OrdersGroupResponse();
//		orders1.setName("Bee(ORM Framework)");
		
		Condition condition=BF.getCondition();
		condition
        .lParentheses()
		.op(Orders_F.orderid, Op.eq, 1)
		.or()
		.op(Orders_F.orderid, Op.eq, 2)
		.or()
		.op(Orders_F.orderid, Op.eq, 3)
		.or()
		.op(Orders_F.orderid, Op.eq, 4)
		.or()
		.op(Orders_F.orderid, Op.eq, 5)
		.rParentheses()
		;
		
		condition.selectFun(FunctionType.MAX, Orders_F.total,"maxTotal");
//		condition.selectField("userId,orderid"); //userId bug
		condition.selectField("userid,orderid");
		
		condition.groupBy(Orders_F3.userId);
		condition.groupBy(Orders_F3.orderid);
		
//		condition.orderBy("userid",OrderType.DESC);// bug
//		condition.orderBy("userId",OrderType.DESC);// bug
		condition.orderBy("userid",OrderType.ASC);
//		condition.orderBy("userId",OrderType.ASC);
//		condition.orderBy("total",OrderType.DESC);
		
		condition
//		.start(6)
		.start(0)
//		.start(1)
		.size(10);
		
		
		//条件全在condition  case 5
	 	List<OrdersGroupResponse> list=suid.select(orders1,condition);
	 	Printer.printList(list);
//	 	System.out.println("--------------------:");
//	 	list=suid.select(orders1,condition);
//        Printer.printList(list);
        
        
        //全表查询, 分页; 批量插入,  modify等
        
        
//        https://www.cnblogs.com/azai/archive/2010/01/09/1642781.html
		
	}
}
