
package org.teasoft.exam.bee.osql.sharding;

import java.util.List;

import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.Suid;
import org.teasoft.exam.bee.osql.sharding.entity.Orders;
import org.teasoft.exam.bee.osql.sharding.entity.Orders_F;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.sharding.ShardingUtil;

/**
 * 分页, 同库多表; 无排序
 * 使用union all改写,不用担心无排序的影响.
 * @author Kingstar
 * @since  2.0
 *
 */
public class ShardingPaging3 {
	
	public static void main(String[] args) {
		ShardingInitData.init();
		InitSameDsUtil.initDS();
		test();
	}

	public static void test(){
		
		System.out.println("------Sharding test--------ShardingPaging3-----");
		test(ShardingUtil.firstRecordIndex()); //要先配置数据源,才能获取到.
//		test(2);
//		test(-1);
	}
	
	public static void test(int startIndex) {
		
		Suid suid=BF.getSuid(); //1
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
//		.start(1)   //不是首页开始.
//		.start(0)  //从首页开始
		
		.start(startIndex)
		.size(2);
		
		
		//条件全在condition  case 5
	 	List<Orders> list=suid.select(orders1,condition);
	 	Printer.printList(list);
	 	System.out.println("--------------------:");
	 	list=suid.select(orders1,condition);
        Printer.printList(list);
		
	}
}
