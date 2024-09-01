/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.HoneyUtil;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.core.NameTranslateHandle;

/**
 * @author Kingstar
 * @since  1.11
 */
public class DeleteExam {

	private static SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();

	public static SuidRich getSuidRich() {
		return suidRich;
	}

	public static void setSuidRich(SuidRich suidRich) {
		DeleteExam.suidRich = suidRich;
	}

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		
		if(HoneyUtil.isCassandra()) {
			NameTranslateHandle.setSchemaName("store");
		}	

		try {
			Orders orders=new Orders();
			orders.setId(121L);
//			suidRich.deleteById(Orders.class, 100022L);
			int a=suidRich.delete(orders);
			System.out.println("insert num:"+a);
//			Orders exampleField = new Orders();
//			exampleField.setUserid("bee");
//			List<Orders> selectSomeField = suidRich.select(exampleField, "name,total");
//			Orders one=suidRich.selectById(Orders.class,exampleField.getId());
		} catch (BeeException e) {
			Logger.error("In SuidRichExam (Exception):" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			Logger.error("In SuidRichExam (Exception):" + e.getMessage());
			e.printStackTrace();
		}
	}

}
