
package org.teasoft.exam.bee.mongodb;

import java.util.List;

import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.mongodb.entity.Orders;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.sharding.ShardingUtil;

/**
 * @author Kingstar
 * @since  2.0
 *
 */
public class ShardingPaging2_deleteCache {
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		
//		ShardingDoConfig.init();
//		InitDsAndMongoDsUtil.initDS();
		test(ShardingUtil.firstRecordIndex()); //要先配置数据源,才能获取到.
//		test(2);
//		test(-1);
	}
	
	public static void test(int startIndex) {
		
		SuidRich suidRich=BF.getSuidRich(); //1
		Orders orders1=new Orders();
//		orders1.setName("Bee(ORM Framework)");
		
		Condition condition=BF.getCondition();
//		condition
////		.op(Orders_F.userid, Op.eq, 0)
//        .lParentheses()
//		.op(Orders_F.orderid, Op.eq, 1)
//		.or()
//		.op(Orders_F.orderid, Op.eq, 2)
//		.or()
//		.op(Orders_F.orderid, Op.eq, 3)
//		.rParentheses()
//		;
		
		//全域查询
		condition
//		.start(2)   //不是首页开始.
//		.start(0)  //从首页开始
		.start(startIndex)
		.size(5);
		
		
		//条件全在condition  case 5
	 	List<Orders> list=suidRich.select(orders1,condition);
	 	Printer.printList(list);
	 	System.out.println("--------------------:");
	 	
	 	
	 	int delNum=suidRich.deleteById(Orders.class, 10014);
	 	System.out.println("delNum: "+delNum);
	 	
//	 	condition.size(6);
	 	list=suidRich.select(orders1,condition);
        Printer.printList(list);
	}
}
