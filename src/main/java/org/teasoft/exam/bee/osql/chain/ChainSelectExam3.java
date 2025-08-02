/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.chain;

import java.util.List;

import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.OrderType;
import org.teasoft.bee.osql.api.PreparedSql;
import org.teasoft.bee.osql.chain.Select;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.chain.Aggregate;
import org.teasoft.honey.osql.chain.SelectImpl;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.HoneyUtil;
import org.teasoft.honey.osql.shortcut.CSF;

/**
 * @author Kingstar
 * @since  1.9
 */
public class ChainSelectExam3 {
	private static PreparedSql preparedSql = BeeFactory.getHoneyFactory().getPreparedSql();
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		
	 try {
		 
		 Select inSelect = CSF.getSelect();
		 
		 inSelect.select("id")
		 .from("orders")
		 .where()
		 .op("name", "bee");
		 
//		 inSelect.op("id", Op.gt,122); //没有使用 .in("id", inSelect)前,更改就有效.
		 
		 Select t = CSF.getSelect();
		 t.select()
		 .from("orders")
		 .where()
		 .in("id", inSelect)
		 .and()
		 .op("id", Op.ge,122);
			
		 inSelect.op("id", Op.gt,122); //前面,已使用了 .in("id", inSelect),  这里设置,对前面已没有影响
        
        List<String[]> list1= preparedSql.select(t.toSQL());
        Printer.print(list1);
        
        List<String[]> list2= preparedSql.select(t.toSQL());
        Printer.print(list2);
        
	   } catch (Exception e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
	   }
        
        Logger.info("ChainSelectExam finished....");
        
	}

}
