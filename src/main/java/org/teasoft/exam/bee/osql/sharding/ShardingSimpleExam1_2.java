
package org.teasoft.exam.bee.osql.sharding;

import java.util.List;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.Suid;
import org.teasoft.exam.bee.osql.sharding.entity.Orders;
import org.teasoft.exam.bee.osql.sharding.entity.Orders_F;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * 条件全在condition+javabean设置的是表分片键  case 5
 * 若用List存表,则两个地方设置的相同,会产生多余查询.
 * [0, 0, 1, 2]  根据表列表,拆分子句就不准确.
 * 使用无重复元素的List解决
 * @author Kingstar
 * @since  2.0
 *
 */
public class ShardingSimpleExam1_2 {
	
	public static void main(String[] args) {
		InitSameDsUtil.initDS();
		ShardingInitData.init();
		test();
	}

	public static void test(){
		System.out.println("------Sharding test--------ShardingSimpleExam1_2-----");
		
		Suid suid=BF.getSuid(); //1
		Orders orders1=new Orders();
//		orders1.setAbc("Bee(ORM Framework)"); //javabean设置的不是分片键
		orders1.setOrderid(6L); //javabean设置的是表分片键
		
		Condition condition=BF.getCondition();
		condition
		.op(Orders_F.userid, Op.eq, 0)
		.or()
		.op(Orders_F.userid, Op.eq, 1)
		.or()
		.op(Orders_F.userid, Op.eq, 3)
        .lParentheses()
		.op(Orders_F.orderid, Op.eq, 1)
		.or()
		.op(Orders_F.orderid, Op.eq, 2)
//		.or()
//		.op(Orders_F.orderid, Op.eq, 3)
		.rParentheses()
		;
		
//		条件全在condition+javabean没有设置  case 5
	 	List<Orders> list=suid.select(orders1,condition);
	 	Printer.printList(list);
	 	System.out.println("--------------------:");
	 	list=suid.select(orders1,condition);
        Printer.printList(list);
        
//        条件在javabean和condition
        System.out.println("-----------------条件在javabean和condition---");
        
//        条件在javabean和condition;  比上一个查询多了一个查询条件;
		Condition condition2=BF.getCondition();
		condition2
		.op(Orders_F.userid, Op.eq, 0)
		.op(Orders_F.userid, Op.eq, 1)
        .lParentheses()
		.op(Orders_F.orderid, Op.eq, 1)
		.or()
		.op(Orders_F.orderid, Op.eq, 2)
		.or()
		.op(Orders_F.orderid, Op.eq, 0) //加多一个分片值.  变成3个子查询.  前两个子查询,要利用上缓存. 总查询不能用缓存.
		                                //TODO 子查询不能利用上缓存; 因为sql没有拆分,是用总的sql,而总的sql不一样,sql key就不一样,就用不上缓存了.
		.rParentheses()
		;
        
	 	System.out.println("--------------------:");
	 	list=suid.select(orders1,condition2);
        Printer.printList(list);
        System.out.println("--------------------:");
	 	list=suid.select(orders1,condition2);
        Printer.printList(list);
        
//        只是javabean有条件; 分是否有分片值
      //条件全在condition   分是否有分片值
//        条件在javabean和condition   应该有四种
        //要能区分出,非一库一表分片, 是主线程,还是子线程;  主线程的话,缓存要加表列表(要排序);否则缓存不准确
        
        //全表查询, 分页; 批量插入,  modify等
		
	}
}
