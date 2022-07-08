/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.special;

import org.teasoft.bee.osql.Suid;
import org.teasoft.bee.osql.transaction.Tran;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.osql.core.BeeFactoryHelper;

/**
 * @author Kingstar
 * @since  1.17
 */
public class TranTest {
	
	public static void main(String[] args) {
		TranTest test=new TranTest();
		test.testTran();
	}
	
	
	
	@Tran
	public void testTran() {
		
		Suid suid=BeeFactoryHelper.getSuid(); //1
		Orders orders1=new Orders();
		orders1.setId(100001L);
		orders1.setName("Bee(ORM Framework)");
		
		 suid.insert(orders1); //2.1 插入
		suid.select(orders1); //2.2 查询
		
	}

}
