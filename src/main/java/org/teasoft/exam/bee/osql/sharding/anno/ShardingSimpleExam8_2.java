
package org.teasoft.exam.bee.osql.sharding.anno;

import java.util.List;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.Suid;
import org.teasoft.exam.bee.osql.sharding.InitSameDsUtil;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * case 2
 * Sharding Anno+ Condtion有值但不是分片
 * @author Kingstar
 * @since  2.0
 *
 */
public class ShardingSimpleExam8_2 {
	
	public static void main(String[] args) {
		test();
	}

	public static void test(){
		
//		ShardingInitData.init(); //使用注解
		InitSameDsUtil.initDS();
		
//		@Sharding(tabRule = "userid %6")
		
		Suid suid=BF.getSuid(); //1
		Orders3 orders3=new Orders3();
		orders3.setUserid(1L);
		
		Condition condition=BF.getCondition();
		condition
		.op(Orders_F.name, Op.eq, "test1_6")
		;
		
		
	 	List<Orders3> list=suid.select(orders3,condition);
	 	Printer.printList(list);
	 	System.out.println("--------------------:");
	 	list=suid.select(orders3,condition);
        Printer.printList(list);
		
	}
}
