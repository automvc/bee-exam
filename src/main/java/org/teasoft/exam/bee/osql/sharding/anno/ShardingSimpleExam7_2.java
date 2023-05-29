
package org.teasoft.exam.bee.osql.sharding.anno;

import java.util.List;

import org.teasoft.bee.osql.api.Suid;
import org.teasoft.exam.bee.osql.sharding.InitSameDsUtil;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * 使用Sharding注解,分表的分片值,设置javabean;
 * @Sharding 只能设置分库与分表使用同一分片键.
 * 使用了appointDS="ds0"
 * Sharding优于全局配置;那要考虑分库与分表用不同的分片键吗???因注解是绑定在字段上的
 * @author Kingstar
 * @since  2.0
 *
 */
public class ShardingSimpleExam7_2 {
	
	public static void main(String[] args) {
		test();
	}

	public static void test(){
		
//		ShardingInitData.init();//使用注解
		InitSameDsUtil.initDS();
		
//		appointDS="ds0"
//		@Sharding(appointDS="ds0",dsRule = "userid %2",dsName = "ds",tabRule = "userid %6")
		Suid suid=BF.getSuid(); //1
		Orders2 orders2=new Orders2();
		orders2.setUserid(1L);
		
		
	 	List<Orders2> list=suid.select(orders2);
	 	Printer.printList(list);
	 	System.out.println("--------------------:");
	 	list=suid.select(orders2);
        Printer.printList(list);
		
	}
}
