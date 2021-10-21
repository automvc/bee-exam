/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import org.teasoft.bee.osql.service.ObjSQLRichService;
import org.teasoft.bee.osql.service.ObjSQLService;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.osql.serviceimpl.ObjSQLRichServiceImpl;
import org.teasoft.honey.osql.serviceimpl.ObjSQLServiceImpl;

/**
 * @author Kingstar
 * @since  1.9
 */
public class ObjSQLServiceExam {
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
		objSQLRichService.selectJson(orders1,"id,name",0,10);
		
		Orders orders2 = new Orders();
		orders2.setId(1001L);
		orders2.setRemark("test for save");
		objSQLRichService.save(orders2);
		
	}

}
