/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.util.List;

import org.teasoft.bee.osql.Suid;
import org.teasoft.exam.bee.osql.entity.dynamic.LeafAlloc;
import org.teasoft.exam.bee.osql.entity.dynamic.Orders;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.8
 */
public class DynamicTableExam {
	
	private static Suid suid = BeeFactory.getHoneyFactory().getSuid();
	
	public static Suid getSuid() {
		return suid;
	}
	
	public static void setSuidRich(Suid suid) {
		DynamicTableExam.suid=suid;
	}
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		try {
			

//		Suid suid=BeeFactory.getHoneyFactory().getSuid();
		
//		@Table("Orders_${month}")
//		public class Orders
		
		Orders orders=new Orders();
		suid.setDynamicParameter("month", "202007").select(orders);
		
		
//		@Entity("LeafAlloc${version}")
		
		LeafAlloc leafAlloc=new LeafAlloc();
		List<LeafAlloc> list1=suid.setDynamicParameter("version", "2").select(leafAlloc);
		
		suid.setDynamicParameter("version", "2");
		List<LeafAlloc> list2=suid.select(leafAlloc);
		
		Logger.info(list1.size());
		Logger.info(list2.size());
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
