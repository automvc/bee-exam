
package org.teasoft.exam.bee.mongodb.sharding;

import java.util.List;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.Suid;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.sharding.ShardingUtil;

/**
 * @author Kingstar
 * @since  2.0
 *
 */
public class ShardingPaging {
	
	public static void main(String[] args) {
		
		ShardingDoConfig.init();
		InitDsAndMongoDsUtil.initDS();
		test(ShardingUtil.firstRecordIndex()); //要先配置数据源,才能获取到.
		test(2);
		test(-1);
	}
	
	public static void test(int startIndex) {
		
		Suid suid=BF.getSuid(); //1
		Orders orders1=new Orders();
//		orders1.setName("Bee(ORM Framework)");
		
		Condition condition=BF.getCondition();
		condition
        .lParentheses()
		.op(Orders_F.userid, Op.eq, 1)
		.or()
		.op(Orders_F.userid, Op.eq, 3)
		.or()
		.op(Orders_F.userid, Op.eq, 2)
		.rParentheses()
		;
		
		//全域查询
		condition
//		.start(2)   //不是首页开始.
//		.start(0)  //从首页开始
		.start(startIndex)
		.size(1);
		
		
		//条件全在condition  case 5
	 	List<Orders> list=suid.select(orders1,condition);
	 	Printer.printList(list);
	 	System.out.println("--------------------:");
	 	list=suid.select(orders1,condition);
        Printer.printList(list);
	}
}