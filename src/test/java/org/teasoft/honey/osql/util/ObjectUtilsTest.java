/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.honey.osql.util;

import org.junit.Test;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.util.ObjectUtils;

/**
 * @author Kingstar
 * @since  1.9.8
 */
public class ObjectUtilsTest {
	
	@Test
	public void test() {
		boolean f0=false;
		Logger.info(ObjectUtils.isTrue(f0)+""); 
		boolean f=true;
		Logger.info(ObjectUtils.isTrue(f)+"");
		Boolean f2=null;
		Logger.info(ObjectUtils.isTrue(f2)+"");
		Boolean f3=false;
		Logger.info(ObjectUtils.isTrue(f3)+"");
		Boolean f4=true;
		Logger.info(ObjectUtils.isTrue(f4)+"");
	}

}
