/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.sharding.anno;

import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.SuidRich;
//import org.teasoft.exam.bee.osql.entity.User;
import org.teasoft.exam.bee.osql.entity.TestUser;
import org.teasoft.exam.bee.osql.sharding.InitSameDsUtil;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.util.Printer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 分片, 分页+  一库一表
 * 
 * @author Kingstar
 * @since  2.0
 */
public class UseJson5 {
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
			
//			HintManager.setTableName("orders2");
			
			Condition condition=BF.getCondition();
			condition.start(0).size(2);
			
			condition
			.op(Orders_F.userid, Op.eq, 0)
//			.or()
//			.op(Orders_F.userid, Op.eq, 1)
			;
			
			
			Orders3 orders=new Orders3();
			String json = suidRich.selectJson(orders,condition); //分页
			Logger.info("selectJson(new Orders()):");
			Logger.info(json);
			
			List<TestUser> list=toEntity(json, List.class, orders.getClass());
			Printer.printList(list);
			
			String json2=toJson(list);
			Logger.info(json2);
			

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
