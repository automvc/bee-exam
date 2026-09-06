
package org.teasoft.exam.bee.osql.sharding;

import java.util.List;

import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.Suid;
import org.teasoft.exam.bee.osql.sharding.entity.Orders;
import org.teasoft.exam.bee.osql.sharding.entity.Orders_F;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.autogen.Ddl;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.sharding.ShardingUtil;

/**
 * 分页, 多库多表; 无排序
 * test SelectRsWrap
 * @author Kingstar
 * @since  2.0
 */
public class ShardingPaging02Pg {
	
	public static void main(String[] args) {
		ShardingInitData.init();
//		InitSameDsUtil.initDS();
		InitSameDsUtilPg.initDS();
		test();
	}

	public static void test(){
		Logger.info("------Sharding test--------ShardingPaging-----");
		
		test(ShardingUtil.firstRecordIndex()); //要先配置数据源,才能获取到.   从首条.
//		test(2); //非首条
//		test(-1);//不使用start
	}
	
	public static void test(int startIndex) {
		
		Suid suid = BF.getSuid(); // 1
		Orders orders1 = new Orders();

//		Ddl.createTable(Orders.class, true);
//		return;
		
		
		Condition condition=BF.getCondition();
		condition
//		.op(Orders_F.userid, Op.eq, 0)
        .lParentheses()
		.op(Orders_F.orderid, Op.eq, 1)
		.or()
		.op(Orders_F.orderid, Op.eq, 2)
//		.or()
//		.op(Orders_F.orderid, Op.eq, 3)
		.rParentheses()
		;
		
		condition
//		.start(6)
//		.start(0)
		.start(1)
		.size(1);
		
		
		//条件全在condition  case 5
	 	List<Orders> list=suid.select(orders1,condition);
	 	Printer.printList(list);
        
		
	}
}
