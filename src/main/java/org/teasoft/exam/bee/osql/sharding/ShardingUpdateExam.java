
package org.teasoft.exam.bee.osql.sharding;

import java.util.List;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.util.Printer;

/**
 * Update Sharding.Update的分片
 * @author Kingstar
 * @since  2.0
 *
 */
public class ShardingUpdateExam {
	
	public static void main(String[] args) {
		
		ShardingInitData.init();
		InitSameDsUtil.initDS();
		
		SuidRich suidRich=BF.getSuidRich(); //1
		
		//全域
//		Orders orders=new Orders();
//		orders.setRemark("testOneTime13");
//		orders.setId(1L);
//		int delNum=suidRich.update(orders);
//		Logger.info("-----------更新的记录数:"+delNum);
//		
//		//一表一库
//		Orders orders2=new Orders();
//		orders2.setOrderid(1L);
//		orders2.setId(1L);
//		int delNum2=suidRich.update(orders2);
//		Logger.info("-----------更新的记录数:"+delNum2);
//		
//		一库两表
//		Orders orders3=new Orders();
//		orders3.setOrderid(1L);
//		orders3.setId(1L);
//		Condition condition3=BF.getCondition();
//		condition3
//		.or()
//		.op(Orders_F.orderid, Op.eq, 2L);
////		int delNum3=suidRich.update(orders3,condition3);
//		int delNum3=suidRich.updateById(orders3,condition3);
//		Logger.info("-----------更新的记录数:"+delNum3);
//		
//		
//		//一库一表,  condition4无分片
//		Orders orders4=new Orders();
//		orders4.setOrderid(1L);
//		orders4.setId(1L);
//		Condition condition4=BF.getCondition();
////		condition4
////		.or()
////		.op(Orders_F.orderid, Op.eq, 2L);
//		int delNum4=suidRich.updateById(orders4,condition4);
//		Logger.info("-----------更新的记录数:"+delNum4);
//		
		//多库多表
//		Orders orders5=new Orders();
//		orders5.setOrderid(2L);
//		orders5.setId(1L);
//		Condition condition5=BF.getCondition();
//		condition5
//		.or()
//		.op(Orders_F.orderid, Op.eq, 9L);
//		int delNum5=suidRich.updateById(orders5,condition5);
//		Logger.info("-----------更新的记录数:"+delNum5);
		
		Orders orders6=new Orders();
		orders6.setOrderid(2L);
//		orders6.setId(1L);
		Condition condition6=BF.getCondition();
		condition6
		.or()
		.op(Orders_F.orderid, Op.eq, 9L)
		.set(Orders_F.remark, "changed by sharding!")
		;
		int delNum6=suidRich.update(orders6,condition6);
		Logger.info("-----------更新的记录数:"+delNum6);
		
		
		List<Orders> list=suidRich.select(orders6,condition6);
		Printer.printList(list);
		
		list=suidRich.select(orders6,condition6);
		
		
		
	}
}
