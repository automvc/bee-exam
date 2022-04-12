
package org.teasoft.exam.bee.osql;

import org.teasoft.bee.osql.Suid;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.osql.core.BeeFactoryHelper;

public class SimpleExam {
	
	public static void main(String[] args) {
		Suid suid=BeeFactoryHelper.getSuid(); //1
//		Suid suid=new ObjSQL();
		Orders orders1=new Orders();
		orders1.setId(100001L);
		orders1.setName("Bee(ORM Framework)");
		
		 suid.insert(orders1); //2
	}
}
