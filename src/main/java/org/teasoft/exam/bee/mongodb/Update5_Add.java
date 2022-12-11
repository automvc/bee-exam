/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.shortcut.BF;


/**
 * @author Kingstar
 * @since  2.0
 */
public class Update5_Add {

	public static void main(String[] args) {
		
		SuidRich suidRich = BF.getSuidRich();
		Condition condition = BF.getCondition();
		
		
		condition.setAdd(Orders_F.num, 2);
		condition.setAdd(Orders_F.total, 2); //condition声明要更新超过一个字段
		
		//在实体声明要更新两个字段
		Orders orders=new Orders();
		orders.setName("mongodb72"); //for filter
		orders.setAbc("test bee "); //for filter
		orders.setRemark("changed 1211"); // for update
		orders.setSequence("126"); // for update
		//能找到记录,但与要设置的值一样时,就不会更新,所以此时影响的行是0
		
//		int updateNum=suidRich.update(orders, Orders_F.num,condition); //指定只更新num字段
		int updateNum=suidRich.updateBy(orders, Orders_F.name,condition); //指定用name作为过滤条件
//		int updateNum=suidRich.updateBy(orders, Orders_F.name); //指定用name作为过滤条件
		Logger.info("-(没有用Condition)--updateNum: "+ updateNum);
	}

}
