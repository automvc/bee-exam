
package org.teasoft.exam.bee.osql.sharding;

import java.util.List;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.Suid;
import org.teasoft.bee.sharding.ShardingBean;
import org.teasoft.exam.bee.osql.sharding.entity.Orders;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.osql.shortcut.HM;
import org.teasoft.honey.sharding.config.ShardingConfig;

/**
 * //查某个节点的所有分表
 * @author Kingstar
 * @since  2.0
 *
 */
public class ShardingSimpleExam9_6 {
	
	public static void main(String[] args) {
		InitSameDsUtil.initDS();
		test();
	}

	public static void test(){
		System.out.println("------Sharding test--------ShardingSimpleExam9_6-----");
		
//		ShardingInitData.init();  //注释掉,不注册有分片,就不会产生全域查询.
		
		ShardingConfig.addShardingBean("Orders",new ShardingBean("ds[0..1].orders[0..5]", "orderid", "orderid"));
		
		Suid suid=BF.getSuid(); //1
		Orders orders=new Orders();
		//没有加分片值的条件,会查所有
//		orders.setRemark("Bee(ORM Framework)");
		
		List<Orders> list=null;
        
		HM.setDataSourceName("ds0");  //查某个节点的所有分表
//		HintManager.setTableName("orders1");  //只设置tab时,首先会反查ds,得到ds为ds0;  能反查,不会使用计算得来的ds1
		
		Condition c=BF.getCondition();
		c.op("orderid", Op.in, "1,2,3");
	 	list=suid.select(orders,c);
        Printer.printList(list);
        
		
	}
}
