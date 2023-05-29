/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.util.List;

import org.teasoft.bee.osql.api.Suid;
import org.teasoft.bee.osql.api.SuidRich;
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
	private static SuidRich suidRich=BeeFactory.getHoneyFactory().getSuidRich();
	
	public static Suid getSuid() {
		return suid;
	}
	
	public static void setSuid(Suid suid) {
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
		suid.setDynamicParameter("month", "_202007").select(orders);
		
		
//		@Entity("LeafAlloc3${version}")
		
		LeafAlloc leafAlloc=new LeafAlloc();
		List<LeafAlloc> list1=suid.setDynamicParameter("version", "2").select(leafAlloc);
		
//		
//		suid.setDynamicParameter("version", "2");
//		List<LeafAlloc3> list2=suid.select(leafAlloc);
		
		System.out.println("----------------");
		suidRich.setDynamicParameter("version", "2");
		suidRich.select(leafAlloc,5);
		
		suidRich.setDynamicParameter("version", "2").select(leafAlloc,5);
		suidRich.select(leafAlloc,5);
		suidRich.setDynamicParameter("version", "2").select(leafAlloc);
		suidRich.select(leafAlloc,5);
		
		Logger.info(list1.size());
//		Logger.info(list2.size());
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
