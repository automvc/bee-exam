
package org.teasoft.exam.bee.osql.sharding;

import org.teasoft.bee.osql.api.Suid;
import org.teasoft.exam.bee.osql.sharding.entity.Orders;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * 单条插入
 * 要有分片值,有分片值,会路由到具体的一库一表,在拦截器设置ds,tab.其它与不是sharding时的逻辑类似.
 * 没有分片就会报错；只设置了ds,或都不设置tab,ds引发了全域操作，都会报异常。
 * @author Kingstar
 * @since  2.0
 *
 */
public class ShardingInsertExam10 {
	
	public static void main(String[] args) {
		ShardingInitData.init();
		InitSameDsUtil.initDS();
		test();
	}

	public static void test(){
		Logger.info("------Sharding test--------ShardingInsertExam10-----");
		
		Suid suid=BF.getSuid(); //1
		Orders orders1=new Orders();
		
//		orders1.setUserid(6L);
		orders1.setOrderid(8L);
		suid.insert(orders1);
		
//	 	List<Orders> list=suid.select(orders1);
//	 	Printer.printList(list);
//	 	System.out.println("--------------------:");
//	 	list=suid.select(orders1);
//        Printer.printList(list);
		
	}
}
