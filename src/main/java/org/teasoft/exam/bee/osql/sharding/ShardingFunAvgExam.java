
package org.teasoft.exam.bee.osql.sharding;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.FunctionType;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * Sharding AVG.求平均值的分片
 * @author Kingstar
 * @since  2.0
 *
 */
public class ShardingFunAvgExam {
	
	public static void main(String[] args) {
		
		ShardingInitData.init();
		InitSameDsUtil.initDS();
		
		SuidRich suidRich=BF.getSuidRich(); //1
		Orders orders=new Orders();
		
		
		//全域查询,分片
		String avg1=suidRich.selectWithFun(orders, FunctionType.AVG, Orders_F.total);
		Logger.info("-------------avg1:"+avg1);	
		Logger.info("-------------");
		
		//一库一表, 不用分片
		Condition funCondition =BF.getCondition();
		funCondition.op(Orders_F.orderid, Op.eq, 2L);
		String avg2=suidRich.selectWithFun(orders, FunctionType.AVG, Orders_F.total, funCondition);
		Logger.info("-------------avg2:"+avg2);	
		Logger.info("-------------");
		
		//一库多表,要分片.
		Condition funCondition3 =BF.getCondition();
		funCondition3
		.op(Orders_F.orderid, Op.eq, 2L)
		.or()
		.op(Orders_F.orderid, Op.eq, 1L)
		;
		String avg3=suidRich.selectWithFun(orders, FunctionType.AVG, Orders_F.total, funCondition3);
		Logger.info("-------------avg3:"+avg3);	
		Logger.info("-------------");
		
	}
}
