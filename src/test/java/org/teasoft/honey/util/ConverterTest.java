/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.honey.util;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.teasoft.honey.logging.Logger;

/**
 * @author Kingstar
 * @since  2.1.8
 */
public class ConverterTest {
	
	@Test
	public void test() {

		Logger.info(Converter.transfer("driver-class-name")); // driverClassName

		Map<String, String> map = new HashMap<>();
		map.put("bee.db.driverName", "com.mysql.jdbc.Driver");
		map.put("driver-class-name", "com.mysql.jdbc.Driver");
		
		Converter.transferKey(map); 
		Converter.map2Prop(map); 
	}

}
