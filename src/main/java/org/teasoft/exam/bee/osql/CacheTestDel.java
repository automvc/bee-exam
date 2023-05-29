/*
 * Copyright 2013-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.util.Iterator;
import java.util.ServiceLoader;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.Cache;
import org.teasoft.bee.osql.api.Suid;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.1
 */
public class CacheTestDel {
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
//		Cache cache=new BeeExtRedisCache();
//		BeeFactory.getHoneyFactory().setCache(cache);
		
//		ServiceLoader.load(Cache.class);
		
//		BeeFactory.getHoneyFactory().setCache(ServiceLoader.load(Cache.class));
		
		
		ServiceLoader<Cache> caches = ServiceLoader.load(Cache.class);
        Iterator<Cache> cacheIterator = caches.iterator();
        System.err.println();
        
//        try{
            while(cacheIterator.hasNext()) {
            	Cache cache = cacheIterator.next();
            	BeeFactory.getHoneyFactory().setCache(cache);
            }
//        } catch(Throwable t) {
//            t.printStackTrace();
//        }
            
            
//		ServiceLoader<Cache> caches = ServiceLoader.load(Cache.class);
//		Cache oneCache=null;
//		for (Cache cache :caches) {
//			oneCache=cache;
//		}
//		if(oneCache!=null) {
//			BeeFactory.getHoneyFactory().setCache(oneCache);
//		}
            
		
		
		 try {
				
			Suid suid=BeeFactory.getHoneyFactory().getSuid();
			SuidRich suidRich=BeeFactory.getHoneyFactory().getSuidRich();
			
			Orders orders0=new Orders();
			orders0.setUserid("bee0");
			
			Orders orders1=new Orders();
			orders1.setId(100001L);
			orders1.setName("Bee(ORM Framework)");
			
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
			
			orders1.setRemark("other");
			suid.update(orders1);
			suid.select(orders1);
			
//			suid.delete(orders1);
			
			suid.select(orders2);
			suid.select(orders3);
			suid.select(orders4);
			suid.select(orders5);
			suid.select(orders6);
			
			suid.select(orders7);
			suid.select(orders8);
			
			try {
				Thread.sleep(12000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			suid.select(orders3);  //delete 0,3
			
			suid.select(orders7);
			suid.select(orders8);
			suid.select(orders9);
			suid.select(orders10);
			
			System.err.println("==================================");
			
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			suid.select(orders3);
			suid.select(orders8);
			suid.select(orders11);
			
			System.err.println("==================================");
			
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
//			suid.select(orders8);  //delete one
			suid.select(orders11);//delte some
			suid.select(orders8);  
			
			
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			System.err.println("======================finish============");
			
			} catch (BeeException e) {
				Logger.error("In CacheTestDel (BeeException):"+e.getMessage());
				e.printStackTrace();
			}catch (Exception e) {
				Logger.error("In CacheTestDel (Exception):"+e.getMessage());
				e.printStackTrace();
			}
	}
}
