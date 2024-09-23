
package org.teasoft.exam.bee.osql.sharding;

import java.util.List;

import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.OrderType;
import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.Suid;
import org.teasoft.exam.bee.osql.sharding.entity.Orders;
import org.teasoft.exam.bee.osql.sharding.entity.Orders_F;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.sharding.ShardingUtil;

/**
 * 多库多表+ 排序+分页.
 * @author Kingstar
 * @since  2.0
 */
public class ShardingPagingSort7 {
	
	public static void main(String[] args) {
		InitSameDsUtil.initDS();
		ShardingInitData.init();
		test();
	}

	public static void test(){
		System.out.println("------Sharding test--------ShardingPagingSort-----");
		
//		test(ShardingUtil.firstRecordIndex()); //要先配置数据源,才能获取到.
//		test(2);
		test(-1);
	}
	
	public static void test(int startIndex) {
		
		Suid suid=BF.getSuid(); //获取Suid实现的对象
		Orders orders1=new Orders();
		orders1.setOrderid(1L);
		List<Orders> list=suid.select(orders1);//查询orders表的数据
		
	}
}
