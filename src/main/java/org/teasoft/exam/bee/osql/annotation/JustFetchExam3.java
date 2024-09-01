/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.annotation;

import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.api.Suid;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.11
 */
public class JustFetchExam3 {
	
	public static void main(String[] args) {
		test();
	}
	public static void test() {
		
	  try{
		Suid suid=BeeFactory.getHoneyFactory().getSuid();
		
		TestUser3 testUser=new TestUser3();
//		testUser.setName2("Bee");
		testUser.setFullName("aaa");
		
		List<TestUser3> list1 =suid.select(testUser);  //select
		for (int i = 0; i < list1.size(); i++) {
			Logger.info(list1.get(i).toString());
		}
		
		suid.select(testUser); 
		
		
		} catch (BeeException e) {
			Logger.error("In JustFetchExam (BeeException):"+e.getMessage());
			e.printStackTrace();
		}catch (Exception e) {
			Logger.error("In JustFetchExam (Exception):"+e.getMessage());
			e.printStackTrace();
		}
	}

}
