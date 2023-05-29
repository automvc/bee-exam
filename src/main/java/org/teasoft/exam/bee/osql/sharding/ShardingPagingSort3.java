
package org.teasoft.exam.bee.osql.sharding;

import java.util.List;

import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.Suid;
import org.teasoft.exam.bee.osql.sharding.entity.Orders;
import org.teasoft.exam.bee.osql.sharding.entity.Orders_F;
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
//		System.out.println("-------------------------------start ....-------------: ");
		InitSameDsUtil.initDS();
		ShardingInitData.init();
//		System.out.println("-------------------------------start ....after init-------------: ");
//		for (int i = 0; i < 100; i++) {
			test();
//			System.out.println("-------------------------------finishing ....-------------: "+i);
//		}
//		System.out.println("finished!");
	}

	public static void test(){
//		test(ShardingUtil.firstRecordIndex()); //要先配置数据源,才能获取到.
//		test(2);
		
		System.out.println("------Sharding test--------ShardingPagingSort3-----");
//		test0(ShardingUtil.firstRecordIndex()); //要先配置数据源,才能获取到.
		test0(2);
//		System.out.println("-------------------------------finish one ....");
		test0(2);
//		test0(-1);
	}
	
	public static void test0(int startIndex) {
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
	 	System.out.println("--------------------select finished.");
//	 	List<Orders> list2=suid.select(orders1,condition);  //多一次查询,就会出问题,很久不会结束  已解决. V2.1.5.4
	 	list=suid.select(orders1,condition);
        Printer.printList(list);
	}
}
