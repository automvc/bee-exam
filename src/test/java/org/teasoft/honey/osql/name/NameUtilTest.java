/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.honey.osql.name;

import org.teasoft.bee.osql.NameTranslate;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.11
 */
public class NameUtilTest {
	public static void main(String[] args) {
		Logger.info(NameUtil.getClassFullName(Class.class));
		
		Logger.info(NameUtil.getClassFullName(TestUser.class));
		Logger.info(NameUtil.getClassFullName(new TestUser()));
		
//		beeName->bee_name,beeTName->bee_t_name
		Logger.info(NameUtil.toUnderscoreNaming("beeName"));
		Logger.info(NameUtil.toUnderscoreNaming("beeTName"));
		Logger.info(NameUtil.toUnderscoreNaming("beeX"));
		Logger.info(NameUtil.toUnderscoreNaming("beeXa"));
		
//		bee_name->beeName,bee_t_name->beeTName
		Logger.info(NameUtil.toCamelNaming("bee_name"));
		Logger.info(NameUtil.toCamelNaming("bee_t_name"));
		
		Logger.info(NameUtil.toCamelNaming("bee_x"));
		Logger.info(NameUtil.toCamelNaming("bee_"));
		Logger.info(NameUtil.toCamelNaming("_bee"));
		
		Logger.info(NameUtil.toCamelNaming("BEE_NAME"));
		Logger.info(NameUtil.toCamelNaming("BEE_T_NAME"));
		
		NameTranslate nameTranslate=new UnderScoreAndCamelName(); 
		Logger.info(nameTranslate.toFieldName("BEE_NAME"));
		Logger.info(nameTranslate.toFieldName("BEE_T_NAME"));
		Logger.info(nameTranslate.toFieldName("bee_x"));
		
		Logger.info(nameTranslate.toColumnName("beeX"));
		
		long t1=System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			nameTranslate.toColumnName("beeX");
//			Logger.info(nameTranslate.toColumnName("beeX"));
		}
		long t2=System.currentTimeMillis();
		
		System.out.println(t2-t1);
	}

}
