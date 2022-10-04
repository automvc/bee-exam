
package org.teasoft.exam.bee.osql.sharding;

import java.util.List;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.Suid;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.sharding.ShardingUtil;

/**
 * 分页,全域查询;排序, 但无分片
 * @author Kingstar
 * @since  2.0
 *
 */
public class ShardingPagingSort3 {
	
	public static void main(String[] args) {
//		test(ShardingUtil.firstRecordIndex()); //要先配置数据源,才能获取到.
//		test(2);
		
		ShardingInitData.init();
		InitSameDsUtil.initDS();
		test(ShardingUtil.firstRecordIndex()); //要先配置数据源,才能获取到.
		test(2);
		test(-1);
	}
	
	public static void test(int startIndex) {
//		ShardingInitData.init();
//		InitSameDsUtil.initDS();
		
		Suid suid=BF.getSuid(); //1
		Orders orders1=new Orders();
//		orders1.setName("Bee(ORM Framework)");
		
		Condition condition=BF.getCondition();
		condition.orderBy(Orders_F.id);
		
		//全域查询
		condition
//		.start(2)   //不是首页开始.
//		.start(0)  //从首页开始
		.start(startIndex)
		.size(3);
		
		
		//条件全在condition  case 5
	 	List<Orders> list=suid.select(orders1,condition);
	 	Printer.printList(list);
	 	System.out.println("--------------------:");
	 	list=suid.select(orders1,condition);
        Printer.printList(list);
	}
}
