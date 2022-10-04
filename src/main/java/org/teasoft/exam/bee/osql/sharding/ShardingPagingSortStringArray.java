
package org.teasoft.exam.bee.osql.sharding;

import java.util.List;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.OrderType;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.sharding.ShardingUtil;

/**
 * 多库多表+ 排序+分页.
 * List<String[]> list=suidRich.selectString(orders1,condition);
 * @author Kingstar
 * @since  2.0
 */
public class ShardingPagingSortStringArray {
	
	public static void main(String[] args) {
		
		ShardingInitData.init();
		InitSameDsUtil.initDS();
		test(ShardingUtil.firstRecordIndex()); //要先配置数据源,才能获取到.
//		test(2);
//		test(-1);
	}
	
	public static void test(int startIndex) {
		
		SuidRich suidRich=BF.getSuidRich(); //1
		Orders orders1=new Orders();
//		orders1.setName("Bee(ORM Framework)");
		
		Condition condition=BF.getCondition();
		condition
        .lParentheses()
		.op(Orders_F.userid, Op.eq, 1)
		.or()
		.op(Orders_F.userid, Op.eq, 2)
		.or()
		.op(Orders_F.userid, Op.eq, 3)
		.rParentheses()
		.or()
		.op(Orders_F.orderid, Op.eq, 3)
		;
		
		condition
		.orderBy(Orders_F.id)
//		.orderBy(Orders_F.userid, OrderType.DESC)
		.orderBy(Orders_F.userid, OrderType.ASC)
		;
		
		condition
//		.start(6)
		.start(startIndex)
		.size(5);
		
		
		//条件全在condition  case 5
		List<String[]> list=suidRich.selectString(orders1,condition);
	 	Printer.print(list);
	 	System.out.println("--------------------:");
	 	list=suidRich.selectString(orders1,condition);
        Printer.print(list);
        
        
        //全表查询, 分页; 批量插入,  modify等
		
	}
}
