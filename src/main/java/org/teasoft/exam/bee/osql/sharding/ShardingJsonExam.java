
package org.teasoft.exam.bee.osql.sharding;

import java.util.List;

import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.osql.sharding.entity.Orders;
import org.teasoft.exam.bee.osql.sharding.entity.Orders_F;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * 分片值在javabean;
 * 1)没设置分库键; 2)设置分库键;
 * @author Kingstar
 * @since  2.0
 *
 */
public class ShardingJsonExam {
	
	public static void main(String[] args) {
		ShardingInitData.init();
		InitSameDsUtil.initDS();
		test();
	}

	public static void test(){
		System.out.println("------Sharding test--------ShardingJsonExam-----");
		
		SuidRich suidRich=BF.getSuidRich(); //1
		Orders orders1=new Orders();
//		orders1.setName("Bee(ORM Framework)");
		orders1.setOrderid(1L);  //分片值在javabean
		
		Condition condition=BF.getCondition();
		condition
		.or()
		.op(Orders_F.orderid, Op.eq, 2)
		;
		
//	 	List<Orders> list=suidRich.select(orders1,condition);
//	 	Printer.printList(list);
//	 	System.out.println("--------------------:");
	 	
	 	String json=suidRich.selectJson(orders1, condition);
		Logger.info(json);
	}
}
