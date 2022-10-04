
package org.teasoft.exam.bee.osql.sharding;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.FunctionType;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.core.StringConst;
import org.teasoft.honey.osql.shortcut.BF;

/**
 *  MAX("max"),MIN("min"),SUM("sum"),AVG("avg"),COUNT("count")
 *  函数使用的分片示例.
 *  //求平均值的分片,要特殊处理.详情可看ShardingExamFunAvg.java
 * @author Kingstar
 * @since  2.0
 *
 */
public class ShardingFunExam {
	
	public static void main(String[] args) {
		
		ShardingInitData.init();
		InitSameDsUtil.initDS();
		
		SuidRich suidRich=BF.getSuidRich(); //1
		Orders orders1=new Orders();
		
//		orders1.setUserid(6L);
//		orders1.setOrderid(8L);
//		suidRich.insert(orders1);
		
		Condition funCondition =BF.getCondition();
		funCondition.op(Orders_F.orderid, Op.eq, 2L);
		
		String max=suidRich.selectWithFun(orders1, FunctionType.MAX, "id");
		Logger.info("-------------max:"+max);		
		
//		Object ojb=OneTimeParameter.getAttribute(StringConst.Route_EC);
//		System.out.println(ojb);
		
		
/*		String min=suidRich.selectWithFun(orders1, FunctionType.MIN, "id");
		Logger.info("-------------min:"+min);		
		
		min=suidRich.selectWithFun(orders1, FunctionType.MIN, "id"); //测试缓存
		Logger.info("-------------min:"+min);	
		

		
		String maxWithCondtion=suidRich.selectWithFun(orders1, FunctionType.MAX, "total", funCondition);
		Logger.info("-------------max:"+maxWithCondtion);	
		
		
		int count1=suidRich.count(orders1);
		Logger.info("-------------count1:"+count1);	
		Logger.info("-------------");
		int count2=suidRich.count(orders1, funCondition);
		Logger.info("-------------count2:"+count2);	
		Logger.info("-------------");
		
		String sum1=suidRich.selectWithFun(orders1, FunctionType.SUM, Orders_F.total);
		Logger.info("-------------sum1:"+sum1);	
		Logger.info("-------------");
		String sum2=suidRich.selectWithFun(orders1, FunctionType.SUM, Orders_F.total, funCondition);
		Logger.info("-------------sum2:"+sum2);	
		Logger.info("-------------");
		
		Condition funCondition2 =BF.getCondition();
		funCondition2
		.op(Orders_F.orderid, Op.eq, 2L)
		.or()
		.op(Orders_F.orderid, Op.eq, 1L)
		;
		
		int count3=suidRich.count(orders1, funCondition2);
		Logger.info("-------------count3:"+count3);	
		Logger.info("-------------");
		
		count3=suidRich.count(orders1, funCondition2); //test cache
		Logger.info("-------------count3:"+count3);	 
		Logger.info("-------------");
		
		//求平均值的分片,要特殊处理.
		String avg1=suidRich.selectWithFun(orders1, FunctionType.AVG, Orders_F.total);
		Logger.info("-------------avg1:"+avg1);	
		Logger.info("-------------");
		String avg2=suidRich.selectWithFun(orders1, FunctionType.AVG, Orders_F.total, funCondition);
		Logger.info("-------------avg2:"+avg2);	
		Logger.info("-------------");
		
		Condition funCondition3 =BF.getCondition();
		funCondition3
		.op(Orders_F.orderid, Op.eq, 2L)
		.or()
		.op(Orders_F.orderid, Op.eq, 1L)
		;
		String avg3=suidRich.selectWithFun(orders1, FunctionType.AVG, Orders_F.total, funCondition3);
		Logger.info("-------------avg3:"+avg3);	
		Logger.info("-------------");*/
		
	}
}
