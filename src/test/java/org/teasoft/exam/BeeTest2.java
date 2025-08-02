/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam;

import org.junit.Assert;
import org.junit.Test;
import org.teasoft.exam.bee.osql.autogen.IndexAndPkExam;
import org.teasoft.honey.logging.Logger;

/**
 * @author Kingstar
 * @since  1.9
 */
public class BeeTest2 {
	
	@Test
	public void test(){
		
		System.out.println("---BeeTest2 with junit start:------");
		MySqlOneConfig.reset(); //预防测试无序,跳到其它类
		boolean result=false;
		try {
			
			IndexAndPkExam.test();
			GenBeanTest.test();
			
			LessTest.test();
			
			result=true;
		} catch (Exception e) {
			e.printStackTrace();
			Logger.error(e.getMessage(), e);
			result=false;
		}finally {
			MySqlOneConfig.reset(); //预防测试无序,跳到其它类
			Assert.assertEquals(result,true);
		}
		
		System.out.println("---BeeTest2 with junit end.------");
	}

}
