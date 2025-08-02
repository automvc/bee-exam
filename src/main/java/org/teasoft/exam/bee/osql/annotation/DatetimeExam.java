/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.annotation;

import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.api.Suid;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.BeeFactory;

/**
 * @author Kingstar
 * @since  1.11
 */
public class DatetimeExam {
	
	public static void main(String[] args) {
		test();
	}
	public static void test() {
		
	  try{
		Suid suid=BeeFactory.getHoneyFactory().getSuid();
		
		Orders orders1=new Orders();
//		orders1.setId(100001L);
//		orders1.setName("Bee(ORM Framework)");
		
		List<Orders> list1 =suid.select(orders1);  //select
		for (int i = 0; i < list1.size(); i++) {
			Logger.info(list1.get(i).toString());
		}
		
		suid.select(orders1); 
		
//		
//		suid.select(orders1);
//		
//		orders1.setName("Bee(ORM Framework)");
//		int updateNum=suid.update(orders1);   //update
//		Logger.info("update record:"+updateNum);
//		
//		Orders orders2=new Orders();
//		orders2.setUserid("bee");
//		orders2.setName("Bee");
//		orders2.setTotal(new BigDecimal("91.99"));
//		orders2.setRemark("");  //empty String test
//		
//		int insertNum=suid.insert(orders2); //insert
//		Logger.info("insert record:"+insertNum);
//		
//		int deleteNum=suid.delete(orders2);   //delete
//		Logger.info("delete record:"+deleteNum);
//		
//		List<Orders> list2 =suid.select(orders1); //select  confirm the data
//		for (int i = 0; i < list2.size(); i++) {
//			Logger.info(list2.get(i).toString());
//		}
		
		} catch (BeeException e) {
			Logger.error("In DatetimeExam (BeeException):"+e.getMessage());
			e.printStackTrace();
		}catch (Exception e) {
			Logger.error("In DatetimeExam (Exception):"+e.getMessage());
			e.printStackTrace();
		}
	}
}
