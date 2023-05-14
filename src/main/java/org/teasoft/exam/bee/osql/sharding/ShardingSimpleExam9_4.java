
package org.teasoft.exam.bee.osql.sharding;

import java.util.List;

import org.teasoft.bee.osql.Suid;
import org.teasoft.bee.sharding.ShardingBean;
import org.teasoft.exam.bee.osql.sharding.entity.Orders;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.core.HoneyContext;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.sharding.HintManager;
import org.teasoft.honey.sharding.config.ShardingConfig;

/**
 * 没设置有分片值,会产生全域查询
 * 但可以通过HintManager指定ds,tab
 * case ,查询是有值的情型
 * @author Kingstar
 * @since  2.0
 *
 */
public class ShardingSimpleExam9_4 {
	
	public static void main(String[] args) {
		InitSameDsUtil.initDS();
		test();
	}

	public static void test(){
		System.out.println("------Sharding test--------ShardingSimpleExam9_4-----");
		
//		ShardingInitData.init();  //注释掉,不注册有分片,就不会产生全域查询.
		
		ShardingConfig.addShardingBean("Orders",new ShardingBean("ds[0..1].orders[0..5]", "orderid", "orderid"));
		
		Suid suid=BF.getSuid(); //1
		Orders orders=new Orders();
		//没有加分片值的条件,会查所有
		orders.setRemark("Bee(ORM Framework)");
		
		List<Orders> list=null;
        
        orders.setOrderid(5L); //可以分片, 但使用HintManager,应该不用bean设置的值,是要用HintManager的值
//		HintManager.setDataSourceName("ds0");
		HintManager.setTableName("orders1");  //只设置tab时,首先会反查ds,得到ds为ds0;  能反查,不会使用计算得来的ds1
	 	list=suid.select(orders);
        Printer.printList(list);
        
		
	}
}
