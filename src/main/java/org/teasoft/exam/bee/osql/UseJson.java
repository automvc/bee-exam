/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.osql.entity.Orders;
//import org.teasoft.exam.bee.osql.entity.User;
import org.teasoft.exam.bee.osql.entity.TestUser;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.BeeFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Kingstar
 * @since  1.7.2
 */
public class UseJson {
	public static void main(String[] args) {
		test();
	}
	public static void test() {
		try{
			SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
			
			
//			TestUser one=suidRich.selectFirst(new TestUser(),null);
//			
//			TestUser one=new TestUser();
//			one.setId(800001L);
//			one.setName("Bee");
//			one.setEmail("beeUser@163.com");
//			one.setLastName("bee");
//			int insertNum=suidRich.insert(one);
//			System.out.println(insertNum);
			
			String json = suidRich.selectJson(new TestUser());
			Logger.info("selectJson(new TestUser()):");
			Logger.info(json);

			ObjectMapper mapper = new ObjectMapper();

			TestUser user[] = mapper.readValue(json, TestUser[].class);
			Logger.info("将直接查询的json转成对象:");
			for (int i = 0; i < user.length; i++) {
				Logger.info(user[i].toString());
			}
			List<TestUser> list1 = suidRich.select(new TestUser()); //select
			//User user2=new User();user2.setId(800001);
			//List<User> list1 = suidRich.select(user2); //select
			for (int i = 0; i < list1.size(); i++) {
				Logger.info(list1.get(i).toString());
			}

			//User user3=new User();user3.setId(800002);
			//List<User> list3 = suidRich.select(user3); //select
			
			
			String json2 = suidRich.selectJson(new Orders());
			Logger.info("selectJson(new Orders()):");
			Logger.info(json2);

			ObjectMapper mapper2 = new ObjectMapper();

			Orders orders[] = mapper2.readValue(json2, Orders[].class);
			Logger.info("将直接查询的json转成对象:");
			for (int i = 0; i < orders.length; i++) {
				Logger.info(orders[i].toString());
			}
			List<Orders> list2 = suidRich.select(new Orders()); //select
			for (int i = 0; i < list2.size(); i++) {
				Logger.info(list2.get(i).toString());
			}
			
//			ObjectMapper mapper = new ObjectMapper(); 
//			String json =  mapper.writeValueAsString(list); 
			

		} catch (BeeException e) {
			Logger.error("In UseJson (BeeException):" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			Logger.error("In UseJson (Exception):" + e.getMessage());
			e.printStackTrace();
		}
	}
}
