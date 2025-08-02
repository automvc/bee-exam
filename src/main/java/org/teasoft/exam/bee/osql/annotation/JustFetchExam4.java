/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.annotation;

import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.FunctionType;
import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.Suid;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  1.11
 */
public class JustFetchExam4 {
	
	public static void main(String[] args) {
		test();
	}
	public static void test() {
		
	  try{
		Suid suid=BeeFactory.getHoneyFactory().getSuid();
		
		TestUser4 testUser=new TestUser4();
//		testUser.setName2("Bee");
//		testUser.setFullName("aaa");
		
		Condition condition=BF.getCondition();
		condition.selectFun(FunctionType.COUNT, "*", "count1");
		condition.selectField("lastName");
		condition.groupBy("lastName");
		
		
//		List<TestUser4> list1 =suid.select(testUser,condition);  //select
//		for (int i = 0; i < list1.size(); i++) {
//			Logger.info(list1.get(i).toString());
//		}
		
//		suid.select(testUser); 
		
		
		List<TestUser4> list2 =BF.getMoreTable().select(testUser,condition); //more table
		
		for (int i = 0; i < list2.size(); i++) {
		Logger.info(list2.get(i).toString());
	}
		
		
		} catch (BeeException e) {
			Logger.error("In JustFetchExam (BeeException):"+e.getMessage());
			e.printStackTrace();
		}catch (Exception e) {
			Logger.error("In JustFetchExam (Exception):"+e.getMessage());
			e.printStackTrace();
		}
	}

}
