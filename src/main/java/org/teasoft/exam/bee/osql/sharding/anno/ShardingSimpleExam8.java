
package org.teasoft.exam.bee.osql.sharding.anno;

import java.util.List;

import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.Suid;
import org.teasoft.exam.bee.osql.sharding.InitSameDsUtil;
import org.teasoft.exam.bee.osql.sharding.ShardingInitData;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * case 2
 * Sharding Anno+ Condtion 有分片
 * @author Kingstar
 * @since  2.0
 *
 */
public class ShardingSimpleExam8 {
	
	public static void main(String[] args) {
		test();
	}

	public static void test(){
		
		InitSameDsUtil.initDS();
		ShardingInitData.init(); //使用注解
		
//		@Sharding(tabRule = "userid %6")
		Suid suid=BF.getSuid(); //1
		Orders3 orders3=new Orders3();
//		orders3.setUserid(0L);
		orders3.setUserid(3L);
		
		Condition condition=BF.getCondition();
		condition
//		.or()
		.lParentheses()
//		.op(Orders_F.orderid, Op.eq, 2)
		.op(Orders_F.userid, Op.eq, 2)
		.rParentheses()
		;
		
		
	 	List<Orders3> list=suid.select(orders3,condition);
	 	Printer.printList(list);
	 	System.out.println("--------------------:");
	 	list=suid.select(orders3,condition);
        Printer.printList(list);
		
	}
}
