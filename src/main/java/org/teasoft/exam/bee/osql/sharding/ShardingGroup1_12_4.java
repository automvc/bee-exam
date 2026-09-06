
package org.teasoft.exam.bee.osql.sharding;

import java.util.List;

import org.teasoft.bee.osql.FunctionType;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.OrderType;
import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.osql.sharding.entity.OrdersGroupResponse;
import org.teasoft.exam.bee.osql.sharding.entity.Orders_F;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * SuidRich 可以使用多个selectFun
 * @author Kingstar
 * @since  2.0
 */
public class ShardingGroup1_12_4 {
	
	public static void main(String[] args) {
		ShardingInitData.init();
		InitSameDsUtil.initDS();
		test();
	}

	public static void test(){
		System.out.println("------Sharding test--------ShardingGroup-----");
		
//		test0(ShardingUtil.firstRecordIndex()); //要先配置数据源,才能获取到.   从首条.
//		test0(2); //非首条
		test0(-1);//不使用start
	}
	
	public static void test0(int startIndex) {
		
		try {
			
		
		
		SuidRich suidRich=BF.getSuidRich(); //1
		OrdersGroupResponse orders1=new OrdersGroupResponse();
//		orders1.setName("Bee(ORM Framework)");
		
		Condition condition=BF.getCondition();
		condition
        .lParentheses()
		.op(Orders_F.orderid, Op.eq, 1)
		.or()
		.op(Orders_F.orderid, Op.eq, 2)
		.or()
		.op(Orders_F.orderid, Op.eq, 4)
		.rParentheses()
		;
		
		condition.selectFun(FunctionType.MAX, Orders_F.total,"maxTotal"); //无avg,且返回T
//		condition.selectFun(FunctionType.AVG, Orders_F.total,"avgTotal");
//		condition.selectField("userid,orderid");
		
//		condition.selectField("name");
//		condition.groupBy(Orders_F.name);
//		condition.orderBy("name",OrderType.DESC);
		
		condition
//		.start(6)
		.start(startIndex)
//		.start(1)
		.size(10);
		
		
		//条件全在condition  case 5
//	 	List<OrdersGroupResponse> list=suidRich.select(orders1,condition);
//	 	Printer.printList(list);
	 	
	 	List<String[]> list2=suidRich.selectString(orders1,condition);
	 	Printer.print(list2);
        
        
//        https://www.cnblogs.com/azai/archive/2010/01/09/1642781.html
	 	
		} catch (Exception e) {
			Logger.error("ShardingGroup1_6 have exception : "+e.getMessage());
			e.printStackTrace();
		}
		
	}
}
