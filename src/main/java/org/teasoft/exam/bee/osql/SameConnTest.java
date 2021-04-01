/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.Suid;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.osql.entity.LeafAlloc;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.ConditionImpl;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.9
 */
public class SameConnTest {
	private static Suid suid = BeeFactory.getHoneyFactory().getSuid();
	private static SuidRich suidRich=BeeFactory.getHoneyFactory().getSuidRich();

	public static Suid getSuid() {
		return suid;
	}

	public static void setSuidRich(Suid suid) {
		SameConnTest.suid = suid;
	}

	public static void main(String[] args) {
		test();
	}

	public static void test() {

		try {
			
			Orders orders11 = new Orders();
			orders11.setId(100001L);
			
//			suid.select(orders11);

			suid.beginSameConnection(); //test miss
			suid.select(orders11);
			suid.select(orders11);
			
			try {
				System.out.println("=====================================");
				Condition condition_add_forUpdate = new ConditionImpl();
				condition_add_forUpdate.op("id", Op.eq, 100003)
	 //		    .start(1).size(300)    //oracle have exception, when use "for update"
				.size(300)
//				.forUpdate() // 用for update锁住某行记录
				;
				List<Orders> list11 = suidRich.select(orders11, condition_add_forUpdate); //SQL SERVER :  只有 DECLARE CURSOR 才允许使用 FOR UPDATE 子句。
				for (int i = 0; i < list11.size(); i++) {
					Logger.info(list11.get(i).toString());
	 //			    suidRich.update(list11.get(i));  //test 
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			orders11.setId(100002L);
			suid.select(orders11);
			suid.endSameConnection();
			
			suid.select(orders11);
			
			suid.beginSameConnection(); //test miss
			suid.select(orders11);
			suid.select(orders11);
			
			orders11.setId(100002L);
			suid.select(orders11);
			suid.endSameConnection();
			
			orders11.setName("Bee(ORM Framework)");
			int updateNum=suid.update(orders11);   //update
			
			suid.select(orders11);

		} catch (BeeException e) {
			Logger.error("In SuidExam (BeeException):" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			Logger.error("In SuidExam (Exception):" + e.getMessage());
			e.printStackTrace();
		}
	}

}
