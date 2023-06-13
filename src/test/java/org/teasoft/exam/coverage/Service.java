/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.coverage;

import org.junit.Test;
import org.teasoft.bee.mvc.service.ObjSQLRichService;
import org.teasoft.bee.osql.api.Condition;
import org.teasoft.exam.bee.osql.commomid.Noid;
import org.teasoft.honey.osql.core.ObjSQL;
import org.teasoft.honey.osql.core.ObjSQLRich;
import org.teasoft.honey.osql.name.UpperCaseUnderScoreAndCamelName;
import org.teasoft.honey.osql.serviceimpl.ObjSQLRichServiceImpl;
import org.teasoft.honey.osql.serviceimpl.ObjSQLServiceImpl;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  1.17
 */
public class Service {
	
	@Test
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
		
		
		service2.indexNormal(Noid.class, "uuid", "indexNormal_uuid");
		service2.dropIndex(Noid.class, "indexNormal_uuid");
		
		service2.unique(Noid.class, "uuid", "indexNormal_uuid");
		service2.dropIndex(Noid.class, "indexNormal_uuid");
		
		service2.primaryKey(Noid.class, "uuid", "indexNormal_uuid");
		service2.dropIndex(Noid.class, "indexNormal_uuid");
		
		Noid noid = new Noid();
		noid.setUuid("aaaaaa-no-id");
		noid.setName("new name--new");

		service2.update(noid, "name");
		service2.updateBy(noid, "uuid");

		Condition c = BF.getCondition();
		service2.update(noid, c, "name");
		service2.updateBy(noid, c, "uuid");
		
	}
}
