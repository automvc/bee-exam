/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.sharding.anno;

import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.SuidRich;
//import org.teasoft.exam.bee.osql.entity.User;
import org.teasoft.exam.bee.osql.entity.TestUser;
import org.teasoft.exam.bee.osql.sharding.InitSameDsUtil;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.sharding.HintManager;
import org.teasoft.honey.util.Printer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 没有分片.
 * 可以使用bee.dosql.multiDS.defalutDS=ds0， 不分片的，就使用默认库。
 * @author Kingstar
 * @since  2.0
 */
public class UseJson {
	public static void main(String[] args) {
		InitSameDsUtil.initDS();
		test();
	}
	public static void test() {
		try{
			SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
			
/*			String json = suidRich.selectJson(new TestUser());
			Logger.info("selectJson(new TestUser()):");
			Logger.info(json);
			
			List<TestUser> list=toEntity(json, List.class, TestUser.class);
			Printer.printList(list);
			
			String json2=toJson(list);
			Logger.info(json2);*/
			
			HintManager.setTableName("orders2");
			Orders orders=new Orders();
			String json = suidRich.selectJson(orders);
			Logger.info("selectJson(new Orders()):");
			Logger.info(json);
			
			List<TestUser> list=toEntity(json, List.class, orders.getClass());
			Printer.printList(list);
			
			String json2=toJson(list);
			Logger.info(json2);
			
			
			
//			List<TestUser> list=new ArrayList<>();
//			String json2=toJson(list);
//			Logger.info(json2);
//
//			ObjectMapper mapper = new ObjectMapper();
//
//			TestUser user[] = mapper.readValue(json, TestUser[].class);
//			Logger.info("将直接查询的json转成对象:");
//			for (int i = 0; i < user.length; i++) {
//				Logger.info(user[i].toString());
//			}
//			List<TestUser> list1 = suidRich.select(new TestUser()); //select
//			//User user2=new User();user2.setId(800001);
//			//List<User> list1 = suidRich.select(user2); //select
//			for (int i = 0; i < list1.size(); i++) {
//				Logger.info(list1.get(i).toString());
//			}
//
//			//User user3=new User();user3.setId(800002);
//			//List<User> list3 = suidRich.select(user3); //select
//			
//			
//			String json2 = suidRich.selectJson(new Orders());
//			Logger.info("selectJson(new Orders()):");
//			Logger.info(json2);
//
//			ObjectMapper mapper2 = new ObjectMapper();
//
//			Orders orders[] = mapper2.readValue(json2, Orders[].class);
//			Logger.info("将直接查询的json转成对象:");
//			for (int i = 0; i < orders.length; i++) {
//				Logger.info(orders[i].toString());
//			}
//			List<Orders> list2 = suidRich.select(new Orders()); //select
//			for (int i = 0; i < list2.size(); i++) {
//				Logger.info(list2.get(i).toString());
//			}
			

		} catch (BeeException e) {
			Logger.error("In UseJson (BeeException):" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			Logger.error("In UseJson (Exception):" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static <T> T toEntity(String json, Class<T> clazz, Class elementClass) {
		try {
			if(json==null) return null;
			ObjectMapper mapper = new ObjectMapper();
			JavaType javaType = mapper.getTypeFactory().constructParametricType(clazz, elementClass);
			return (T)mapper.readValue(json, javaType);
			
		} catch (Exception e) {
			Logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	public static String toJson(Object obj) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			Logger.error(e.getMessage(), e);
		}
		return null;
	}
}
