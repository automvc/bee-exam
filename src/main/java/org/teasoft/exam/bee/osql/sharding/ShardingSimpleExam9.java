
package org.teasoft.exam.bee.osql.sharding;

import java.util.List;

import org.teasoft.bee.osql.api.Suid;
import org.teasoft.exam.bee.osql.sharding.entity.Orders;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * 没设置有分片值,会产生全域查询
 * @author Kingstar
 * @since  2.0
 *
 */
public class ShardingSimpleExam9 {
	
	public static void main(String[] args) {
		ShardingInitData.init();  //注释掉,不注册有分片,就不会产生全域查询.
		InitSameDsUtil.initDS();
		test();
	}

	public static void test(){
		System.out.println("------Sharding test--------ShardingSimpleExam9-----");
		
		Suid suid=BF.getSuid(); //1
		Orders orders=new Orders();
		//没有加分片值的条件,会查所有
		orders.setRemark("Bee(ORM Framework)");
		
//		Condition condition=BF.getCondition();
//		condition
//		.op("id", Op.eq, 100001)
//		.or()
//		.op("id", Op.eq, 100002);
		
		
	 	List<Orders> list=suid.select(orders);
        Printer.printList(list);
        
        System.out.println("--------------------:");
        
        list=suid.select(orders);
        Printer.printList(list);
		
	}
}
