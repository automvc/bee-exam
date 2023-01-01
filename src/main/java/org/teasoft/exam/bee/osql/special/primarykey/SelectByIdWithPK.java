/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.special.primarykey;

import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.osql.special.primarykey.entity.CustomId;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  1.11
 */
public class SelectByIdWithPK {
	
	private static SuidRich suidRich = BF.getSuidRich();
	
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		
//		String key="aaaadd-no-id";
		String key="aaaacc-no-id";
		
		CustomId customId=suidRich.selectById(CustomId.class, key);
		if(customId!=null)Logger.info(customId.toString());
		
		int delNum=suidRich.deleteById(CustomId.class, key);
		Logger.info(delNum);
	}

}
