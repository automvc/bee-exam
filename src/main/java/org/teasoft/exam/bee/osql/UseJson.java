/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.osql.entity.User;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.Logger;

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
			String json = suidRich.selectJson(new User());
			Logger.info("selectJson(new User()):");
			Logger.info(json);

			ObjectMapper mapper = new ObjectMapper();

			User user[] = mapper.readValue(json, User[].class);
			Logger.info("将直接查询的json转成对象:");
			for (int i = 0; i < user.length; i++) {
				Logger.info(user[i].toString());
			}
			List<User> list1 = suidRich.select(new User()); //select
			//User user2=new User();user2.setId(800001);
			//List<User> list1 = suidRich.select(user2); //select
			for (int i = 0; i < list1.size(); i++) {
				Logger.info(list1.get(i).toString());
			}

			//User user3=new User();user3.setId(800002);
			//List<User> list3 = suidRich.select(user3); //select

		} catch (BeeException e) {
			Logger.error("In UseJson (BeeException):" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			Logger.error("In UseJson (Exception):" + e.getMessage());
			e.printStackTrace();
		}
	}
}
