/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import org.teasoft.bee.mvc.service.ObjSQLRichService;
import org.teasoft.bee.mvc.service.ObjSQLService;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.osql.serviceimpl.ObjSQLRichServiceImpl;
import org.teasoft.honey.osql.serviceimpl.ObjSQLServiceImpl;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  1.9
 */
public class ObjSQLServiceExam {
	
	private static int a=1;
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		ObjSQLService objSQLService=new ObjSQLServiceImpl();
		Orders orders1 = new Orders();
		objSQLService.select(orders1); //select all
		
		ObjSQLRichService objSQLRichService=new ObjSQLRichServiceImpl();
		objSQLRichService.select(orders1,0,10);
		
		objSQLRichService.selectJson(orders1,"id,name");
		objSQLRichService.selectJson(orders1,0,10,"id,name");
		
		Orders orders2 = new Orders();
		orders2.setId(1001L+a);
		a++;
		orders2.setRemark("test for save");
		objSQLRichService.save(orders2);
		
		objSQLRichService.select(orders1,BF.getCondition());
		objSQLRichService.selectFirst(orders1,BF.getCondition());
		objSQLRichService.update(orders1,"id");
		
		objSQLRichService.createTable(Orders.class,false);
		
	}

}
