/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.coverage;

import org.junit.Test;
import org.teasoft.bee.mvc.service.ObjSQLRichService;
import org.teasoft.bee.osql.NameTranslate;
import org.teasoft.honey.osql.core.NameTranslateHandle;
import org.teasoft.honey.osql.core.ObjSQL;
import org.teasoft.honey.osql.core.ObjSQLRich;
import org.teasoft.honey.osql.name.UpperCaseUnderScoreAndCamelName;
import org.teasoft.honey.osql.serviceimpl.ObjSQLRichServiceImpl;
import org.teasoft.honey.osql.serviceimpl.ObjSQLServiceImpl;

/**
 * @author Kingstar
 * @since  1.17
 */
public class Service {
	
//	@Test
	public void test() {
		
//		NameTranslate oldNameTranslate=NameTranslateHandle.getNameTranslate();
		
		ObjSQLRichService service=new ObjSQLRichServiceImpl();
		service.setNameTranslateOneTime(new UpperCaseUnderScoreAndCamelName());
		
		ObjSQLServiceImpl service1=new ObjSQLServiceImpl();
		service1.setNameTranslateOneTime(new UpperCaseUnderScoreAndCamelName());
		service1.setSuid(new ObjSQL());
		service1.getSuid();
		
		ObjSQLRichServiceImpl service2=new ObjSQLRichServiceImpl();
//		service2.setNameTranslate(new UpperCaseUnderScoreAndCamelName());
		service2.setNameTranslateOneTime(new UpperCaseUnderScoreAndCamelName());
//		service2.setSuid(new ObjSQL());
		service2.getSuid();
		
//		NameTranslateHandle.setNameTranslate(oldNameTranslate); 
		service2.setSuidRich(new ObjSQLRich());
		service2.getSuidRich();
		
	}
}
