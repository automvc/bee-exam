/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam;

import org.junit.Assert;
import org.junit.Test;
import org.teasoft.exam.bee.superclass.supertest.UseSuperEntityTest;
import org.teasoft.exam.bee.superclass.supertestanno.UseSuperEntityTest2;
import org.teasoft.exam.bee.superclass.supertestmore.MoreTest;
import org.teasoft.exam.bee.superclass.supertestmore.MoreTest2;
import org.teasoft.exam.bee.superclass.supertestmore.UseSuperEntityTest3;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  2.1.10
 */
public class UseSupperEntityTest {
	@Test
	public void test() {

		System.out.println("---UseSupperEntityTest with junit start:------");
		MySqlOneConfig.reset(); // 预防测试无序,跳到其它类
		boolean result = false;
		try {
			UseSuperEntityTest.test();
			
			UseSuperEntityTest2.test();
			
			UseSuperEntityTest3.test();
			MoreTest.test();
			MoreTest2.test();

		} catch (Exception e) {
			e.printStackTrace();
			Logger.error(e.getMessage(), e);
			result = false;
		} finally {
			MySqlOneConfig.reset(); // 预防测试无序,跳到其它类
			Assert.assertEquals(result, true);
		}

		System.out.println("---UseSupperEntityTest with junit end.------");
	}
}
