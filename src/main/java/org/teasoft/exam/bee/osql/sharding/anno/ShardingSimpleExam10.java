
package org.teasoft.exam.bee.osql.sharding.anno;

import java.util.List;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.Suid;
import org.teasoft.exam.bee.osql.sharding.InitSameDsUtil;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * String类型分片值
 * @author Kingstar
 * @since  2.0
 *
 */
public class ShardingSimpleExam10 {
	
	public static void main(String[] args) {
		
		InitSameDsUtil.initDS();
//		ShardingInitData.init(); //使用注解
		
//		@Sharding(tabRule = "userid %6")
		Suid suid=BF.getSuid(); //1
		Orders4 orders4=new Orders4();
		orders4.setRemark("String类型分片值");
		
		List<Orders4> list=null;
		
	 	list=suid.select(orders4,null);
	 	Printer.printList(list);
	 	System.out.println("--------------------:");
	 	list=suid.select(orders4,null);
        Printer.printList(list);
        
        
		Condition condition=BF.getCondition();
		condition
//		.or()
		.lParentheses()
		.op(Orders_F.userid,Op.eq, 4)
		.rParentheses()
		;
		
	 	list=suid.select(orders4,condition);
	 	Printer.printList(list);
	 	System.out.println("--------------------:");
	 	list=suid.select(orders4,condition);
        Printer.printList(list);
		
	}
}
