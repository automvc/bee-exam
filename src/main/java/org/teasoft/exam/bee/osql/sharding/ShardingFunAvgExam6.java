
package org.teasoft.exam.bee.osql.sharding;

import org.teasoft.bee.osql.FunctionType;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.osql.sharding.entity.Orders;
import org.teasoft.exam.bee.osql.sharding.entity.Orders_F;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * Sharding SUM
 * @author Kingstar
 * @since  2.0
 *
 */
public class ShardingFunAvgExam6 {
	
	public static void main(String[] args) {
		ShardingInitData.init();
		InitSameDsUtil.initDS();
		
//		for (int i = 0; i < 100; i++) {
			test();
//			System.out.println("-------------------------------finishing ....-------------: "+i);
//		}
		System.out.println("finished!");
		
	}

	public static void test(){
		System.out.println("------Sharding test--------ShardingFunAvgExam-----");
		
		SuidRich suidRich=BF.getSuidRich(); //1
		Orders orders=new Orders();
		
		
//		//全域查询,分片
//		String avg1=suidRich.selectWithFun(orders, FunctionType.AVG, Orders_F.total);
//		Logger.info("-------------avg1:"+avg1);	
//		Logger.info("-------------");
//		
//		//一库一表, 不用分片
//		Condition funCondition =BF.getCondition();
//		funCondition.op(Orders_F.orderid, Op.eq, 2L);
//		String avg2=suidRich.selectWithFun(orders, FunctionType.AVG, Orders_F.total, funCondition);
//		Logger.info("-------------avg2:"+avg2);	
//		Logger.info("-------------");
		
		//一库多表,要分片.
		Condition funCondition3 =BF.getCondition();
		funCondition3
		.op(Orders_F.orderid, Op.eq, 2L)
		.or()
		.op(Orders_F.orderid, Op.eq, 1L)
		.or()
		.op(Orders_F.orderid, Op.eq, 4L)
		;
		funCondition3.selectField(Orders_F.orderid);
		String result=suidRich.selectWithFun(orders, FunctionType.MAX, Orders_F.total, funCondition3);
		
		Logger.info("-------------MAX:  "+result);	
		Logger.info("-------------");
		
	}
}
