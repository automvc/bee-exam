/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.osql.entity.TestUser;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.9
 */
public class SelectById {

	public static void main(String[] args) {
		test();
	}

	public static void test() {

	  try{
		  
		SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
		

		List<TestUser> listSelectByIds=suidRich.selectByIds(new TestUser(), "800001,800002");  //PostgreSQL 是强类型,不能这种用
		for (int i = 0; i < listSelectByIds.size(); i++) {
			Logger.info(listSelectByIds.get(i).toString());
			Logger.info("=============================================");
		}
		
		TestUser testUser1=suidRich.selectById(new TestUser(), 1004);
		if(testUser1!=null)Logger.info(testUser1.toString());
		
		TestUser testUser2=suidRich.selectById(new TestUser(), 800001L);
		
		TestUser testUser3=suidRich.selectById(new TestUser(), "1004");
		if(testUser3!=null)Logger.info(testUser3.toString());
//		test Exception
//		TestUser testUser3=suidRich.selectById(new TestUser(), "800001,800001");
//		Logger.info(testUser3.toString());

//		int deleteNum3=suidRich.deleteById(TestUser.class, 1004);
//		Logger.info("deleteNum3: "+deleteNum3);
		
//		suidRich.insert(testUser2);
		
		String json=suidRich.selectJson(new TestUser());
		Logger.info("selectJson(new User()):");
		Logger.info(json);
		
	  } catch (BeeException e) {
		  Logger.error("In SuidRichExam (Exception):"+e.getMessage());
		  e.printStackTrace();
	  }catch (Exception e) {
		  Logger.error("In SuidRichExam (Exception):"+e.getMessage());
		  e.printStackTrace();
	  }
		
	}
	
}
