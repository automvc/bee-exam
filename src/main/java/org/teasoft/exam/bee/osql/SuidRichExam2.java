/*
 * Copyright 2016-2019 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.math.BigDecimal;
import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.api.SuidRich;
//import org.teasoft.exam.bee.osql.entity.LeafAlloc;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.BeeFactory;

/**
 * @author Kingstar
 * @since  1.0
 */
public class SuidRichExam2 {

	private static SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();

	public static SuidRich getSuidRich() {
		return suidRich;
	}

	public static void setSuidRich(SuidRich suidRich) {
		SuidRichExam2.suidRich = suidRich;
	}

	public static void main(String[] args) {
		test();
	}

	public static void test() {

		try {

			Orders orders = new Orders();
			orders.setName("client");
			orders.setUserid("client");
			orders.setRemark("testOneTime");
			orders.setTotal(new BigDecimal("93.99"));


			int updateNum1 = suidRich.update(orders, "name,remark");
			Logger.info("updateNum1:  " + updateNum1);

			int updateNum2 = suidRich.update(orders, "name");
			Logger.info("updateNum2:  " + updateNum2);

			
//			test update(T oldEntity,T newEntity)
			Orders orders16 = new Orders(); 
			orders16.setRemark("update(T oldEntity,T newEntity)");
			orders16.setName("update(T oldEntity,T newEntity)");
			Long id16=suidRich.insertAndReturnId(orders16);
//			orders16.setId(id16);
//			System.out.println(suidRich.selectById(new Orders(), id16).toString());
			
			Orders orders16_new = new Orders(); 
			orders16_new.setRemark("by update with : update(T oldEntity,T newEntity)");
			suidRich.update(orders16, orders16_new);
//			System.out.println(suidRich.selectById(new Orders(), id16).toString());
			
			suidRich.delete(orders16_new);

		} catch (BeeException e) {
			Logger.error("In SuidRichExam2 (Exception):" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			Logger.error("In SuidRichExam2 (Exception):" + e.getMessage());
			e.printStackTrace();
		}
		//	  HoneyContext.justGetPreparedValue("abc");

		Orders exampleField = new Orders();
		exampleField.setUserid("bee");
		//      select some fields
		List<Orders> selectSomeField = suidRich.select(exampleField, "name,total");
		
		Orders one=suidRich.selectById(Orders.class,exampleField.getId());
		if(one!=null) suidRich.update(exampleField);
		else suidRich.insert(exampleField);

	}
	
//	public int save(Orders orders) {
//		Orders one = suidRich.selectById(orders, orders.getId());
//		if (one != null)
//			return suidRich.update(orders);
//		else
//			return suidRich.insert(orders);
//	}
	
//	public <T> int save2(T entity) {
//		Orders one=suidRich.selectById(entity,entity.getId());
//		if(one!=null) suidRich.update(entity);
//		else suidRich.insert(entity);
//		
//		return 0;
//	}

}
