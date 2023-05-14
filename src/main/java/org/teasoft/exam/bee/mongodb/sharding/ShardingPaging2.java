
package org.teasoft.exam.bee.mongodb.sharding;

import java.util.List;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.Suid;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.sharding.ShardingUtil;

/**
 * 分页,全域查询;无排序,无分片
 * DB使用id排序?? 但合并后的id未必是有序的. 而且每次子查询的顺序不一样,可能会导致不同的结果.所以要加一个主键排序.
 * 若查询的列，没有查主键列，该如何??   使用串行查询。
 * @author Kingstar
 * @since  2.0
 *
 */
public class ShardingPaging2 {
	
	public static void main(String[] args) {
		try {
			InitDsAndMongoDsUtil.initDS();
			ShardingDoConfig.init();
			test();
		} finally {
			ClearDsAndMongoDsUtil.clearConfig();
		}
	}

	public static void test() {
		
		test(ShardingUtil.firstRecordIndex()); //要先配置数据源,才能获取到.
		test(2);
		test(-1);
	}
	
	public static void test(int startIndex) {
		
		Suid suid=BF.getSuid(); //1
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
	 	List<Orders> list=suid.select(orders1,condition);
	 	Printer.printList(list);
	 	System.out.println("--------------------:");
	 	
	 	
	 	
//	 	condition.size(6);
	 	list=suid.select(orders1,condition);
        Printer.printList(list);
	}
}
