/*
 * Copyright 2013-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.Suid;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.1
 */
public class CacheTestJson {
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		
		 try {
				
			Suid suid=BeeFactory.getHoneyFactory().getSuid();
			SuidRich suidRich=BeeFactory.getHoneyFactory().getSuidRich();
			
			Orders orders0=new Orders();
			orders0.setUserid("bee0");
			
			Orders orders1=new Orders();
			orders1.setId(100001L);
			orders1.setName("Bee--ORM Framework");
			
			Orders orders2=new Orders();
			orders2.setUserid("bee2");
			orders2.setName("Bee--ORM Framework");
			orders2.setRemark("");  //empty String test
			
			Orders orders3=new Orders();
			orders3.setUserid("bee3");
			
			Orders orders4=new Orders();
			orders4.setUserid("bee4");
			
			Orders orders5=new Orders();
			orders5.setUserid("bee5");
			
			Orders orders6=new Orders();
			orders6.setUserid("bee6");
			
			Orders orders7=new Orders();
			orders7.setUserid("bee7");
			
			Orders orders8=new Orders();
			orders8.setUserid("bee8");
			
			Orders orders9=new Orders();
			orders9.setUserid("bee9");
			
			Orders orders10=new Orders();
			orders10.setUserid("bee10");
			
			Orders orders11=new Orders();
			orders11.setUserid("bee11");
			
			Orders orders12=new Orders();
			orders12.setUserid("bee12");
			
			
			
			suid.select(orders0);
			suid.select(orders1);
			
//			orders1.setRemark("other");
//			suid.update(orders1);
//			suid.select(orders1);
			
			suid.select(orders2);
			suid.select(orders3);
			suid.select(orders4);
			suid.select(orders5);
			suid.select(orders6);

			String json=suidRich.selectJson(orders6);
			Logger.info(json);
			List<Orders> orders6List=suid.select(orders6);
			Printer.printList(orders6List);
			
			try {
				Thread.sleep(12000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			suid.select(orders3);  //delete 0,3
			
			
			
			} catch (BeeException e) {
				Logger.error("In CacheTestJson (BeeException):"+e.getMessage());
				e.printStackTrace();
			}catch (Exception e) {
				Logger.error("In CacheTestJson (Exception):"+e.getMessage());
				e.printStackTrace();
			}
	}
}
