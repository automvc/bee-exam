/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.coverage;

import java.lang.reflect.Field;

import org.junit.Test;
import org.teasoft.bee.spi.AnnoAdapter;
import org.teasoft.bee.spi.defaultimpl.AnnoAdapterBeeDefault;
import org.teasoft.exam.bee.osql.annotation.moretable.Clazz1;
import org.teasoft.exam.bee.osql.annotation.moretable.Student1;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.17
 */
public class AnnoAdapterTest {

	@Test
	public void test() {
		
		AnnoAdapter annoAdapter = new AnnoAdapterBeeDefault();
		
		//测试不是@Table只返回"";
		annoAdapter.getValue(Student1.class);
		
		
		//测试不是@Column,则返回"";
//		@Datetime(suidType=SuidType.SELECT)
//		private String remark;
		try {
//			Field field=Clazz1.class.getField("remark");
			
			Field field = new Clazz1().getClass().getDeclaredField("remark");
			annoAdapter.getValue(field);
		} catch (Exception e) {
			Logger.debug(e.getMessage());
		}
		
		

	}

}
