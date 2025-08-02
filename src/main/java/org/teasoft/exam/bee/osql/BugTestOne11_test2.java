/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.util.Arrays;
import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.api.Suid;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.BeeFactory;

/**
 * @author Kingstar
 * @since  1.8
 */
public class BugTestOne11_test2 {
	public static void main(String[] args) {
		//		TestPrepare.init();
		test();
	}

	public static void test() {

		try {

			Suid suid = BeeFactory.getHoneyFactory().getSuid();
			SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();

//			-------------------v.1.11-------start----------  
			Orders orders = new Orders();
			orders.setId(100002L);
			Orders orders1=suidRich.selectOne(orders); //select
			
			orders1.setRemark("00000000");
			
//			List<Orders> list1 = new ArrayList<>();
//			list1.add(orders1);
//			System.out.println(list1.get(0).getRemark());
//			list1.get(0).setRemark("new remark");  //更改外面的值,却会影响到缓存的.
			
			String remark=suidRich.selectOne(orders).getRemark();
			System.out.println(remark);
			
			System.out.println("---------------------------");
			
			Orders two = new Orders();
			two.setId(1008L);
			
			List<Orders> list1=suidRich.select(two);
			Printer.printList(list1);
			
			list1.get(0).setName("fasfsadfd"); //修改会影响到缓存.
			
			List<Orders> list2=suidRich.select(two);
			Printer.printList(list2);
			
			
			
			Object obj[]=new Object[10];
			
			Orders a0 = new Orders();
			a0.setName("a0");
			
			Orders a1 = new Orders();
			a1.setName("a1");
			
			obj[0]=a0;
			obj[1]=a1;
			
//			a0.setName("a0-----");
			
			
//			Orders a000=(Orders)obj[0];
			Object newArray[]=Arrays.copyOfRange(obj, 0, 1);
			Orders a000=(Orders)newArray[0];
			
			a000.setName("a0-----");  //从缓存数组取出后,修改
			System.err.println(a000.getName());
			
			
			Orders a00000=(Orders)obj[0];
			System.err.println(a00000.getName());
			
			
			if(a00000==a000) System.out.println("还是同一个对象!!!");
			
			
			Object newArray2[]=Arrays.copyOfRange(obj, 0, 1);
			Orders a0002=(Orders)newArray2[0];
			if(a0002==a000) System.out.println("还是同一个对象2222222222!!!");
			
		} catch (BeeException e) {
			e.printStackTrace();
			Logger.error("In BugTest (BeeException):"+e.getMessage());
		}catch (Exception e) {
			Logger.error("In BugTest (Exception):"+e.getMessage());
			e.printStackTrace();
		}

	}
}
