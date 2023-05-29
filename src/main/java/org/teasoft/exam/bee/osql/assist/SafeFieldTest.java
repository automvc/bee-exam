/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.assist;

import java.util.List;

import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.osql.assist.entity.TestUser;
import org.teasoft.exam.bee.osql.assist.entity.field.TestUser_F;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.core.BeeFactoryHelper;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  1.11
 */
public class SafeFieldTest {

	public static void main(String[] args) {
		SuidRich suidRich = BeeFactoryHelper.getSuidRich(); //1

		List<String[]> list=suidRich.selectString(new TestUser(), TestUser_F.lastName);
		// select last_name from test_user
		
	    Printer.print(list);
	    
	    
	    Condition condition= BF.getCondition();
	    condition.set(TestUser_F.name, "bee");
	    list=suidRich.selectString(new TestUser(), TestUser_F.name+","+TestUser_F.lastName+","+TestUser_F.email);
	    Printer.print(list);
	    
	    //V1.11.0.4.22 变长参数,  列出你要查询的字段
	    list=suidRich.selectString(new TestUser(), TestUser_F.name,TestUser_F.lastName,TestUser_F.email);
	    Printer.print(list);
	}

}
