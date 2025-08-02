package org.teasoft.exam;
/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */



import org.junit.Assert;
import org.junit.Test;
import org.teasoft.exam.bee.prod.AutoSetStringExam;
import org.teasoft.exam.bee.prod.CreateByExam;
import org.teasoft.exam.bee.prod.DesensitizeExam;
import org.teasoft.exam.bee.prod.DictExam;
import org.teasoft.exam.bee.prod.DictI18nExam;
import org.teasoft.exam.bee.prod.MultiTenancyExam;
import org.teasoft.exam.bee.prod.column.ColumnAnnoTest;
import org.teasoft.exam.bee.prod.jsonanno.JsonAnnoTest;
import org.teasoft.exam.bee.prod.jsonanno.JsonAnnoTest2;
import org.teasoft.exam.bee.prod.jsonanno.moretable.JsonAnnoMoreTableTest;
import org.teasoft.exam.bee.prod.jsonanno.moretable.JsonAnnoTest3;
import org.teasoft.exam.bee.test.ClearDsContext;
import org.teasoft.honey.logging.Logger;

/**
 * @author Kingstar
 * @since  1.9
 */
public class EnterpriseTest {
	
	@Test
	public void test(){
		MySqlOneConfig.reset(); //预防测试无序,跳到其它类
		System.out.println("---Bee Test with junit start:------");
		
		boolean result=false;
		try {

			AutoSetStringExam.test();
			CreateByExam.test();
			DesensitizeExam.test();
			
			
			DictExam.test();
			DictI18nExam.test();
			MultiTenancyExam.test();
			
			ColumnAnnoTest.test();
			
//			CurrencyExam.test();
			
			JsonAnnoTest.test();
			JsonAnnoTest2.test();
			
			JsonAnnoMoreTableTest.test();
			JsonAnnoTest3.test();
			
//			org.teasoft.exam.bee.prod.test.CreateByExam.test();
			
//			CheckDsModel.test();
			
			result=true;
		} catch (Exception e) {
			e.printStackTrace();
			Logger.error(e.getMessage(), e);
			result=false;
		}finally {
			ClearDsContext.clear();
			Assert.assertEquals(result,true);
		}
		
		System.out.println("---Bee Test with junit end.------");
	}

}
