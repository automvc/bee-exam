/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.math.BigDecimal;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.IncludeType;
import org.teasoft.bee.osql.Suid;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.core.HoneyUtil;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.9
 */
public class InsertAndReturnIdTest {
	private static Suid suid = BeeFactory.getHoneyFactory().getSuid();
	private static SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();

	public static Suid getSuid() {
		return suid;
	}

	public static void setSuid(Suid suid) {
		InsertAndReturnIdTest.suid = suid;
	}
	
	public static void setSuidRich(SuidRich suidRich) {
		InsertAndReturnIdTest.suidRich = suidRich;
	}

	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		boolean oldFlag=HoneyConfig.getHoneyConfig().genid_forAllTableLongId;
		
		HoneyConfig.getHoneyConfig().genid_forAllTableLongId=true;
		test0();
		
		HoneyConfig.getHoneyConfig().genid_forAllTableLongId=false;
		test0();
		test0();

		HoneyConfig.getHoneyConfig().genid_forAllTableLongId=oldFlag;
		
		if(HoneyUtil.isOracle()) testOracle();
		if(HoneyUtil.isMysql() || HoneyUtil.isSQLite()) testMySQL();
	}

	public static void test0() {
		try {
			Orders orders1 = new Orders();
			orders1.setName("Bee(ORM Framework)");
			orders1.setRemark("InsertAndReturnId");
			orders1.setUserid("Bee");
			orders1.setTotal(new BigDecimal("80.80"));
//			orders1.setId(-1L);
			Logger.info("------------------------getId : " + orders1.getId());
			long id = suid.insertAndReturnId(orders1);
			Logger.info("InsertAndReturnId  : " + id);
			Logger.info("------------------------getId : " + orders1.getId());
			Orders insertOrders = suidRich.selectById(Orders.class, id);
			if (insertOrders != null) Logger.info(insertOrders.toString());
			
			long id2 = suid.insertAndReturnId(orders1);
			Logger.info("InsertAndReturnId  : " + id2);
			Logger.info("------------------11------getId : " + orders1.getId());
			
//			suidRich.setDynamicParameter("test", "11");
			suidRich.insertAndReturnId(orders1,IncludeType.INCLUDE_EMPTY);
			
			Logger.info("-------------------11-----getId : " + orders1.getId());

		} catch (BeeException e) {
			Logger.error("In InsertAndReturnIdTest (BeeException):" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			Logger.error("In InsertAndReturnIdTest (Exception):" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void testOracle() {
//		Need create Sequence and Trigger for auto increment id. 
//		By the way,maybe use distribute id is better!
		boolean oldFlag=HoneyConfig.getHoneyConfig().genid_forAllTableLongId;
		try {
			Logger.info("-----------------------------");
			Logger.info("auto increment id,with Oracle Sequence and Trigger, start....");
			HoneyConfig.getHoneyConfig().genid_forAllTableLongId=false;
			Orders orders1 = new Orders();
			orders1.setName("Bee(ORM Framework)");
			orders1.setRemark("InsertAndReturnId");
			orders1.setUserid("Bee");
			orders1.setTotal(new BigDecimal("80.80"));
			orders1.setId(-1L); //Trigger will replace it
			long id = suid.insertAndReturnId(orders1);
			Logger.info("InsertAndReturnId  : " + id);
			
			Orders insertOrders = suidRich.selectById(Orders.class, id);
			if (insertOrders != null) Logger.info(insertOrders.toString());
			
			orders1.setId(-1L);  //Trigger will replace it
			long id2 = suid.insertAndReturnId(orders1);
			Logger.info("InsertAndReturnId  : " + id2);
			Logger.info("auto increment id,with Oracle Sequence and Trigger, end....");
			
		} catch (BeeException e) {
			Logger.error("In InsertAndReturnIdTest (BeeException):" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			Logger.error("In InsertAndReturnIdTest (Exception):" + e.getMessage());
			e.printStackTrace();
		}finally {
			HoneyConfig.getHoneyConfig().genid_forAllTableLongId=oldFlag;
		}
	}
	
	
	public static void testMySQL() {
		boolean oldFlag=HoneyConfig.getHoneyConfig().genid_forAllTableLongId;
		try {
			Logger.info("-----------------------------");
			Logger.info("auto increment id in MySQL, start....");
			
			HoneyConfig.getHoneyConfig().genid_forAllTableLongId=false;
			Orders orders1 = new Orders();
			orders1.setName("Bee(ORM Framework)");
			orders1.setRemark("InsertAndReturnId");
			orders1.setUserid("Bee");
			orders1.setTotal(new BigDecimal("80.80"));
//			orders1.setId(-1L); // in mysql, id can do not pass
			long id = suid.insertAndReturnId(orders1);
			Logger.info("InsertAndReturnId  : " + id);
			
			Orders insertOrders = suidRich.selectById(Orders.class, id);
			if (insertOrders != null) Logger.info(insertOrders.toString());
			
//			orders1.setId(-1L);  // in mysql, id can do not pass
			long id2 = suid.insertAndReturnId(orders1);
			Logger.info("InsertAndReturnId  : " + id2);
			
			Logger.info("auto increment id in MySQL, end....");

		} catch (BeeException e) {
			Logger.error("In InsertAndReturnIdTest (BeeException):" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			Logger.error("In InsertAndReturnIdTest (Exception):" + e.getMessage());
			e.printStackTrace();
		}finally {
			HoneyConfig.getHoneyConfig().genid_forAllTableLongId=oldFlag;
		}
	}
}
