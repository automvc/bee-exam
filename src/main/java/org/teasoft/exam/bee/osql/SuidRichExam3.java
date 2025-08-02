/*
 * Copyright 2016-2019 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.math.BigDecimal;
import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.BeeFactory;

/**
 * @author Kingstar
 * @since  1.0
 */
public class SuidRichExam3 {

	private static SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();

	public static SuidRich getSuidRich() {
		return suidRich;
	}

	public static void setSuidRich(SuidRich suidRich) {
		SuidRichExam3.suidRich = suidRich;
	}

	public static void main(String[] args) {
		test();
	}

	public static void test() {

		try {
			
			
			SuidRichExam5.test(); //重新添加几条记录
			

//			Ddl.createTable(Orders.class,true);
			
//			suidRich.delete(new Orders());
			
			Orders orders0 = new Orders();
			Orders orders1 = new Orders();
			Orders orders2 = new Orders();

			
//			orders0.setId(1003L);
//			orders1.setId(1004L);
//			orders2.setId(1005L);
//			Orders[] ordersArray0 = new Orders[3];
//			ordersArray0[0] = orders0;
//			ordersArray0[1] = orders1;
//			ordersArray0[2] = orders2;
//			suidRich.insert(ordersArray0); //先插入几个数据
			

			//test batch insert
//			Orders orders0 = new Orders();
			orders0.setId(10021L);
			orders0.setUserid("client01");
			//		orders0.setName("MVC book");
			orders0.setTotal(new BigDecimal(91));
			orders0.setRemark("testOneTime");

//			Orders orders1 = new Orders();
			orders1.setId(1005L);
			orders1.setUserid("client02");
			orders1.setRemark("testOneTime");
			orders1.setTotal(new BigDecimal(20));

//			Orders orders2 = new Orders();
			orders2.setId(10016L);
			orders2.setUserid("client03");
			orders2.setRemark("testOneTime");
			orders2.setTotal(new BigDecimal(23));
			
			
			Orders orders3 = new Orders();
			Orders orders4 = new Orders();
			Orders orders5 = new Orders();
			Orders orders6 = new Orders();
			orders3.setId(10013L);
			orders4.setId(10014L);
			orders5.setId(10015L);
			orders6.setId(1003L);

			Orders[] ordersArray = new Orders[7];
			ordersArray[0] = orders0;
			ordersArray[1] = orders1;
			ordersArray[2] = orders2;
			ordersArray[3] = orders3;
			ordersArray[4] = orders4;
			ordersArray[5] = orders5;
			ordersArray[6] = orders6;
			
			
			

//			int insertArray = suidRich.insert(ordersArray, 2, "datetime");//batch insert  批行多批,尾数成批
//			int insertArray = suidRich.insert(ordersArray, 10);//batch insert  执行一批
			int insertArray = suidRich.insert(ordersArray, 5);//batch insert   批行多批,尾数不成批
//			int insertArray = suidRich.insert(ordersArray, 3);//batch insert   批行多批,尾数不成批
			Logger.info("插入成功的记录: "+insertArray);
			
			

		

		} catch (BeeException e) {
		Logger.error("In SuidRichExam3----1-- (BeeException):" + e.getMessage());
		e.printStackTrace();
	} catch (Exception e) {
		Logger.error("In SuidRichExam3----2-- (Exception):" + e.getMessage());
		e.printStackTrace();
	}
		
		List<Orders> list=suidRich.select(new Orders());
		Printer.printList(list);
	
	}
}
