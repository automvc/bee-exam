/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.tran;

import java.util.List;

import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.bee.osql.transaction.Tran;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.util.Printer;

/**
 * @author Kingstar
 * @since  1.17
 */
public class TranTest {
	
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		TranTest test=new TranTest();
		test.testTran();
	}
	
	
	
	@Tran
	public void testTran() {
		
	try {
			
			SuidRich suidRich=BF.getSuidRichForMongodb();
			
			Customer customer=new Customer();
			customer.setFirstName("Test33");
			int aa=suidRich.insert(customer); //要将clientSession传入，才能回滚
			System.out.println(aa);
			int ii=1/0;

			List<Customer> list=suidRich.select(new Customer());
			Printer.printList(list);
			
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
//			clientSession.close();
		}
		
	}

}
