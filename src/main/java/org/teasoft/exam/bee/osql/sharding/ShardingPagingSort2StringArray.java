
package org.teasoft.exam.bee.osql.sharding;

import java.util.List;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.OrderType;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.osql.sharding.entity.Orders;
import org.teasoft.exam.bee.osql.sharding.entity.Orders_F;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.sharding.ShardingUtil;

/**
 * 同库多个表 +分页 +  排序
 * List<String[]> list=suidRich.selectString(orders1,condition);
 * @author Kingstar
 * @since  2.0
 */
public class ShardingPagingSort2StringArray {
	
	public static void main(String[] args) {
		InitSameDsUtil.initDS();
		ShardingInitData.init();
		test();
	}

	public static void test(){
		System.out.println("------Sharding test--------ShardingPagingSort2StringArray-----");
		
//		test(ShardingUtil.firstRecordIndex()); //要先配置数据源,才能获取到.
		test0(2);
//		test(-1);
	}
	
	public static void test0(int startIndex) {
		
		SuidRich suidRich=BF.getSuidRich();  //1
		Orders orders1=new Orders();
//		orders1.setName("Bee(ORM Framework)");
		
		Condition condition=BF.getCondition();
		condition
//		.op(Orders_F.userid, Op.eq, 0)
        .lParentheses()
		.op(Orders_F.orderid, Op.eq, 1)
		.or()
		.op(Orders_F.orderid, Op.eq, 2)
		.or()
		.op(Orders_F.orderid, Op.eq, 0)
		.rParentheses()
		;
		
		condition
		.orderBy("id")
		.orderBy("userid", OrderType.DESC)
//		.orderBy("userid", OrderType.ASC)
		;
		
		condition
//		.start(6)
//		.start(1)
		.start(startIndex)
		.size(2);
		
		
		//条件全在condition  case 5
	 	List<String[]> list=suidRich.selectString(orders1,condition);
	 	Printer.print(list);
	 	System.out.println("--------------------:");
	 	list=suidRich.selectString(orders1,condition);
        Printer.print(list);
        
        
        //全表查询, 分页; 批量插入,  modify等
		
	}
}
