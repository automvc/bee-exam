
package org.teasoft.exam.bee.osql;

import java.util.List;

import org.teasoft.bee.osql.api.Suid;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.core.BeeFactoryHelper;

public class SimpleExam_bug11 {
	
	public static void main(String[] args) {
		
//		HoneyConfig.getHoneyConfig().setLoggerType("harmonyLog");
//		HoneyConfig.getHoneyConfig().setDbName("SQLite");
////		HoneyConfig.getHoneyConfig().isHarmony=true;
		
		
		Suid suid=BeeFactoryHelper.getSuid(); //1
		Orders orders1=new Orders();
//		orders1.setId(100001L);
		orders1.setName("Bee(ORM Framework)");
//		orders1.setName("Bee(\"ORM\" Framework)");
//		orders1.setName("Bee('ORM' Framework)");
		
		suid.select(orders1);
		List<Orders> list=suid.select(orders1);
		
		System.out.println(list.size());
		Printer.printList(list);
		System.out.println(orders1.toString());
		System.out.println(orders1.getName());
		
		Orders orders0=list.get(0);
		System.out.println(orders0.toString());
		
//		suid.insert(orders1);
		
//		 suid.insert(orders1); //2.1 插入
		suid.select(orders1); //2.2 查询
		
	}
}
