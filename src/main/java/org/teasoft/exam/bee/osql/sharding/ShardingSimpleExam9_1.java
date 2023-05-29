
package org.teasoft.exam.bee.osql.sharding;

import java.util.List;

import org.teasoft.bee.osql.api.Suid;
import org.teasoft.exam.bee.osql.sharding.entity.Orders;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.core.HoneyContext;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.osql.shortcut.HM;
import org.teasoft.honey.sharding.HintManager;

/**
 * 没设置有分片值,会产生全域查询
 *  * 但可以通过HintManager指定ds,tab
 * case ,查询是空集的情型
 * @author Kingstar
 * @since  2.0
 *
 */
public class ShardingSimpleExam9_1 {
	
	public static void main(String[] args) {
		InitSameDsUtil.initDS(); //注释掉,不注册有分片,就不会产生全域查询.
		ShardingInitData.init();
		test();
	}

	public static void test(){
		System.out.println("------Sharding test--------ShardingSimpleExam9_1-----");
		
		Suid suid=BF.getSuid(); //1
		Orders orders=new Orders();
		//没有加分片值的条件,会查所有
		orders.setRemark("Bee(ORM Framework)");
		
//		Condition condition=BF.getCondition();
//		condition
//		.op("id", Op.eq, 100001)
//		.or()
//		.op("id", Op.eq, 100002);
		
		//case ,查询是空集的情型:
		HintManager.setDataSourceName("ds1");
		HM.setTableName("orders5");
	 	List<Orders> list=suid.select(orders);
        Printer.printList(list);
        
        System.out.println("-----------------aaa---:");
        System.out.println(HoneyContext.getAppointDS());
        
        //case 使用hint后的缓存.
		HintManager.setDataSourceName("ds1");
		HintManager.setTableName("orders5");
	 	list=suid.select(orders);
        Printer.printList(list);
        
        //case 没有hint,不能用上一个使用了hint的缓存.
        list=suid.select(orders);
        Printer.printList(list);
		
	}
}
