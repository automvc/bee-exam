/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.honey.osql.util;

import java.lang.reflect.Field;

import org.junit.Test;
import org.teasoft.exam.bee.osql.annotation.Orders;

/**
 * @author Kingstar
 * @since  1.11
 */
public class AnnoUtilTest {

	@Test
	public void test() throws NoSuchFieldException {

		Field field = Orders.class.getDeclaredField("id");
		AnnoUtil.isAutoSetString(field);
		AnnoUtil.isDesensitize(field);
		AnnoUtil.isMultiTenancyAnno(field);
		AnnoUtil.isDict(field);
		AnnoUtil.isDictI18n(field);
		AnnoUtil.isColumn(field);
	}

}
