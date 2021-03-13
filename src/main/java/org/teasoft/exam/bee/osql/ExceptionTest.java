/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.math.BigDecimal;
import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.PreparedSql;
import org.teasoft.bee.osql.Suid;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.bee.osql.transaction.Transaction;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.exam.bee.osql.entity.TestUser;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.CustomSql;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.core.SessionFactory;

/**
 * @author Kingstar
 * @since  1.9
 */
public class ExceptionTest {
	private static PreparedSql preparedSql = BeeFactory.getHoneyFactory().getPreparedSql();
	private static Suid suid = BeeFactory.getHoneyFactory().getSuid();
	private static SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		test1();  //SqlNullException
		test2(); //ObjSQLException
		test3(); //BeeSQLException
		test4(); //BeeErrorFieldException
		test5(); //BeeIllegalEntityException
		test6();//BeeIllegalParameterException
	}

	public static void test1() {

		try {
			String nosql = CustomSql.getCustomSql("osql.donot.exist");
			List<String[]> list9 = preparedSql.select(nosql);
			Logger.info(list9.size());
		} catch (BeeException e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
		}

	}

	public static void test2() {
		try {
			Orders orders = new Orders();
			orders.setName("client");
			suidRich.update(orders, "");
		} catch (BeeException e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void test3() {
		try {
			Transaction transaction = SessionFactory.getTransaction();
//			transaction.begin();
			TestUser user = new TestUser();
			user.setUsername("testuser");
			suid.insert(user);//insert 1

			Orders orders = new Orders();
			orders.setUserid("bee");
			orders.setTotal(new BigDecimal("91.99"));
			suid.insert(orders); //insert 2

			transaction.commit();

			List<Orders> list = suid.select(orders); //可任意组合条件查询
			for (int i = 0; i < list.size(); i++) {
				Logger.info(list.get(i).toString());
			}
		} catch (BeeException e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void test4() {

		try {
			Orders orders = new Orders();
			orders.setName("client");
			suidRich.select(orders, "testWrongField");
		} catch (BeeException e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
		}

	}
	
	public static void test5() {

		try {
			suidRich.select(new String());  //java.lang.String is Illegal Entity.
		} catch (BeeException e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
		}

	}
	
	public static void test6() {

		try {
			Orders orders = new Orders();
			orders.setName("client");
			suidRich.select(orders,-1,-2); //wrong page num
		} catch (BeeException e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
		}
	}

}