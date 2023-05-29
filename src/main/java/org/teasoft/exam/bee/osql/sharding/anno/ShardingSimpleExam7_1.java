
package org.teasoft.exam.bee.osql.sharding.anno;

import java.util.List;

import org.teasoft.bee.osql.api.Suid;
import org.teasoft.exam.bee.osql.sharding.InitSameDsUtil;
import org.teasoft.exam.bee.osql.sharding.ShardingInitData;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * case 1
 * 使用Sharding注解,分表的分片值,设置javabean; + condition=null;
 * 使用了appointTab="orders1"
 * @Sharding 只能设置分库与分表使用同一分片键.
 * Sharding优于全局配置;那要考虑分库与分表用不同的分片键吗???因注解是绑定在字段上的
 * @author Kingstar
 * @since  2.0
 *
 */
public class ShardingSimpleExam7_1 {
	
	public static void main(String[] args) {
		test();
	}

	public static void test(){
		
//		ShardingInitData.init();
//		ShardingInitData.init(); //使用注解
		InitSameDsUtil.initDS();
		
//		使用了appointTab="orders1"
//		@Sharding(dsRule = "userid %2",dsName = "ds",tabRule = "userid %6",appointTab="orders1")
		
		Suid suid=BF.getSuid(); //1
		Orders orders1=new Orders();
//		orders1.setUserid(1L);  //TODO 检测设置的与计算的不一样.
		orders1.setUserid(0L);
		
//		Condition condition=BF.getCondition();
//		condition
//		.op(Orders_F.userid, Op.eq, 1)
//		;
		
		
	 	List<Orders> list=suid.select(orders1);
	 	Printer.printList(list);
	 	System.out.println("--------------------:");
	 	list=suid.select(orders1);
        Printer.printList(list);
		
	}
}
