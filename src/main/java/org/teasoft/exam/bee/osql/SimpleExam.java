
package org.teasoft.exam.bee.osql;

import org.teasoft.bee.osql.api.Suid;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.osql.core.BeeFactoryHelper;

public class SimpleExam {
	
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
		suid.select(orders1);
		
		System.out.println(orders1.toString());
		System.out.println(orders1.getName());
		
//		suid.insert(orders1);
		
//		 suid.insert(orders1); //2.1 插入
		suid.select(orders1); //2.2 查询
		
	}
}
