/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.honey.util;

import org.junit.Test;
import org.teasoft.exam.bee.osql.annotation.moretable.Clazz1;
import org.teasoft.honey.logging.Logger;

import static org.teasoft.honey.util.EntityUtil.*;

import java.lang.reflect.Field;

/**
 * @author Kingstar
 * @since  1.17
 */
public class EntityUtilTest {
	
	@Test
	public void test() {
		
		Logger.info(isCustomBean("com.aiteasoft")+"");
		Logger.info(isCustomBean("com.aiteasoft")+"");
		
		try {
			Field field = new Clazz1().getClass().getDeclaredField("remark");
			Logger.info(isCustomBean(field)+"");
			
			Logger.info(isList(field)+"");
			Logger.info(isSet(field)+"");
			Logger.info(isMap(field)+"");
		} catch (Exception e) {
			Logger.debug(e.getMessage());
		}
	}

}
