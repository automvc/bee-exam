
package org.teasoft.exam.bee.osql.sharding;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.osql.sharding.entity.Orders;
import org.teasoft.exam.bee.osql.sharding.entity.Orders_F;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * Delete Sharding.Delete的分片
 * @author Kingstar
 * @since  2.0
 *
 */
public class ShardingDeleteExam {
	
	public static void main(String[] args) {
		System.out.println("-----------Sharding test--------ShardingDeleteExam-----");
		ShardingInitData.init();
		InitSameDsUtil.initDS();
		test();
	}

	public static void test(){
		SuidRich suidRich=BF.getSuidRich(); //1
		
		//全域
		Orders orders=new Orders();
		orders.setRemark("testOneTime13");
		int delNum=suidRich.delete(orders);
		Logger.info("-----------删除的记录数:"+delNum);
		
		//一表一库
		Orders orders2=new Orders();
		orders2.setOrderid(1L);
		int delNum2=suidRich.delete(orders2);
		Logger.info("-----------删除的记录数:"+delNum2);
		
		//一库两表
		Orders orders3=new Orders();
		orders3.setOrderid(1L);
		Condition condition3=BF.getCondition();
		condition3
		.or()
		.op(Orders_F.orderid, Op.eq, 2L);
		int delNum3=suidRich.delete(orders3,condition3);
		Logger.info("-----------删除的记录数:"+delNum3);
		
		//一库一表,  condition4无分片
		Orders orders4=new Orders();
		orders4.setOrderid(1L);
		Condition condition4=BF.getCondition();
//		condition4
//		.or()
//		.op(Orders_F.orderid, Op.eq, 2L);
		int delNum4=suidRich.delete(orders4,condition4);
		Logger.info("-----------删除的记录数:"+delNum4);
		
		//多库多表
		Orders orders5=new Orders();
		orders5.setOrderid(2L);
		Condition condition5=BF.getCondition();
		condition5
		.or()
		.op(Orders_F.orderid, Op.eq, 9L);
		int delNum5=suidRich.delete(orders5,condition5);
		Logger.info("-----------删除的记录数:"+delNum5);
		
		//测试删除整个表的数据.
		//bee.osql.notDeleteWholeRecords=true  设置了为true,测控制不给删除.
		Orders orders6=new Orders();
		int delNum6=suidRich.delete(orders6);
		Logger.info("-----------删除的记录数:"+delNum6);
		
	}
}
