
package org.teasoft.exam.bee.osql.sharding;

import java.util.List;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.Suid;
import org.teasoft.exam.bee.osql.sharding.entity.TestUsers;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.sharding.ShardingUtil;

/**
 * 分页,全域查询;排序, 但无分片
 * @author Kingstar
 * @since  2.0
 *
 */
public class ShardingPagingSort3_2 {
	
	public static void main(String[] args) {
		InitSameDsUtil.initDS();
		ShardingInitData.init();
		test();
	}

	public static void test(){
//		test(ShardingUtil.firstRecordIndex()); //要先配置数据源,才能获取到.
//		test(2);
		
		System.out.println("------Sharding test--------ShardingPagingSort3_2-----");
		test(ShardingUtil.firstRecordIndex()); //要先配置数据源,才能获取到.
		test(2);
		test(-1);
	}
	
	public static void test(int startIndex) {
		Suid suid=BF.getSuid(); //1
		TestUsers testUsers=new TestUsers();
		
		testUsers.setName("test");
		
		Condition condition=BF.getCondition();
		condition.orderBy("lastName");
		
		//全域查询
		condition
//		.start(2)   //不是首页开始.
//		.start(0)  //从首页开始
		.start(startIndex)
		.size(3);
		
		
		//条件全在condition  case 5
	 	List<TestUsers> list=suid.select(testUsers,condition);
	 	Printer.printList(list);
	 	System.out.println("--------------------:");
	 	list=suid.select(testUsers,condition);
        Printer.printList(list);
	}
}
