/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */
package org.teasoft.exam.bee.mongodb.tran;

import java.util.List;

import org.teasoft.bee.osql.SuidRich;
import org.teasoft.bee.osql.transaction.Transaction;
import org.teasoft.beex.mongodb.MongodbTransaction;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.util.Printer;

/**
 * @author Kingstar
 * @since  2.1
 */
//两个插入， 中间有异常，两个都提交不正确
public class TransactionTest5_2 {

	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
//		InitDsAndMongoDsUtil.initDS();
		
		Transaction tran=new MongodbTransaction();
		try {
			
			tran.begin();
			SuidRich suidRich=BF.getSuidRichForMongodb();
//			suidRich.setDataSourceName("ds0");
			
//			InsertOneResult a=collection.insertOne(new Document("firstName", "601"));
			Customer customer=new Customer();
			customer.setFirstName("Test36");
			int aa=suidRich.insert(customer); //要将clientSession传入，才能回滚
			System.out.println(aa);
			int ii=1/0;

			List<Customer> list=suidRich.select(new Customer());
			tran.commit();
			Printer.printList(list);
			
		} catch (RuntimeException e) {
			tran.rollback();
			e.printStackTrace();
		} finally {
//			clientSession.close();
		}

		System.err.println("finished!");
	}

}
