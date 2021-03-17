/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.math.BigDecimal;
import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.BeeSQLException;
import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.FunctionType;
import org.teasoft.bee.osql.ObjSQLException;
import org.teasoft.bee.osql.ObjSQLIllegalSQLStringException;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.PreparedSql;
import org.teasoft.bee.osql.Suid;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.bee.osql.exception.JoinTableException;
import org.teasoft.bee.osql.exception.JoinTableParameterException;
import org.teasoft.bee.osql.exception.NoConfigException;
import org.teasoft.bee.osql.transaction.Transaction;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.exam.bee.osql.entity.TestUser;
import org.teasoft.honey.distribution.GenIdFactory;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.ConditionImpl;
import org.teasoft.honey.osql.core.CustomSql;
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.core.SessionFactory;
import org.teasoft.honey.osql.dialect.NoPagingSupported;

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
		test7();//BeeErrorGrammarException
//		test8(); //BeeSQLException
		test9(); //BeeIllegalBusinessException
		test10(); //ConfigWrongException
		test11(); //NotSupportedException
		
		test12();
		test13();
		test14();
		test15();
		test16();
		test17();
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
	
	public static void test7() {

		try {
			 Condition conditionHaving2=new ConditionImpl();
			 conditionHaving2
//			 .groupBy("userid")
//			 .having(FunctionType.COUNT, "distinct(userid)", Op.ge, 1)
			 .having(FunctionType.COUNT, "userid", Op.ge, 1)
			 ;
			 List<Orders> list15 = suid.select(new Orders(), conditionHaving2);
			 System.out.println(list15.size());

		} catch (BeeException e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
//	public static void test8() {
//
//		try {
//			 Condition conditionHaving2=new ConditionImpl();
//			 conditionHaving2
//			 .groupBy("userid")
////			 .having(FunctionType.COUNT, "*", Op.ge, 2)
//			 .having(FunctionType.COUNT, "distinct(userid)", Op.ge, 1)
////			 .having("-- counta(*)>5")
////			 .having("counta(*)>5")
////			 .having("count(distinct(userid))>5")
//			 ;
//			 List<Orders> list15 = suid.select(new Orders(), conditionHaving2);
//			 System.out.println(list15.size());
//
//		} catch (BeeException e) {
//			Logger.error(e.getMessage());
//			e.printStackTrace();
//		} catch (Exception e) {
//			Logger.error(e.getMessage());
//			e.printStackTrace();
//		}
//	}
	
	public static void test9() {
		try {
			suidRich.delete(new Orders());  //delete all records
		} catch (BeeException e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	public static void test10() {
		try {
//			Logger.info("distribute id is: "+GenIdFactory.get());
			HoneyConfig.getHoneyConfig().workerid=1024;
			Logger.info("distribute id is: "+GenIdFactory.get());
		} catch (BeeException e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void test11() {
		try {
			BeeFactory.getHoneyFactory().setDbFeature(new NoPagingSupported());
			suidRich.select(new Orders(),1,10);
		} catch (BeeException e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	public static void test12() {
		try {
			throw new NoConfigException(" test NoConfigException!");
		} catch (BeeException e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void test13() {
		try {
			throw new JoinTableException(" test JoinTableException!");
		} catch (BeeException e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void test14() {
		try {
			throw new JoinTableParameterException(" test JoinTableParameterException!");
		} catch (BeeException e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void test15() {
		try {
			throw new ObjSQLIllegalSQLStringException(" test ObjSQLIllegalSQLStringException!");
		} catch (BeeException e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void test16() {
		try {
			throw new BeeException();
		} catch (BeeException e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void test17() {
		try {
			throw new BeeSQLException();
		} catch (BeeException e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void test18() {
		try {
			throw new ObjSQLException();
		} catch (BeeException e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
}
