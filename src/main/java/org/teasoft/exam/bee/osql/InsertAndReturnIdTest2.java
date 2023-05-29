/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.math.BigDecimal;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.IncludeType;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.core.Logger;

/**
 * 测试postgresql返回自增长的id.
 * @author Kingstar
 * @since  1.9
 */
public class InsertAndReturnIdTest2 {
	private static SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();

	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		boolean oldFlag=HoneyConfig.getHoneyConfig().genid_forAllTableLongId;
		
		HoneyConfig.getHoneyConfig().genid_forAllTableLongId=false; //测试由DB生成ID
		test0();
		HoneyConfig.getHoneyConfig().genid_forAllTableLongId=oldFlag;
	}

	public static void test0() {
		try {
			Orders orders1 = new Orders();
			orders1.setName("Bee(ORM Framework)");
			orders1.setRemark("InsertAndReturnId");
			orders1.setUserid("Bee");
			orders1.setTotal(new BigDecimal("80.80"));
			Logger.info("------------------------getId : " + orders1.getId());
			
//		    Long r_id=suidRich.insertAndReturnId(orders1,IncludeType.EXCLUDE_BOTH); //不包含null和空字符.可以
//		    Long r_id=suidRich.insertAndReturnId(orders1); //id是null,postgresql不支持
		    Long r_id=suidRich.insertAndReturnId(orders1,IncludeType.INCLUDE_EMPTY);//不包含null的字段
			
			Logger.info("-------------------返回的id----- : " + r_id);
			
			//要使用新的依赖
//		<dependency>
//		    <groupId>org.postgresql</groupId>
//		    <artifactId>postgresql</artifactId>
//		    <version>42.2.24.jre7</version>
//		</dependency>

		} catch (BeeException e) {
			Logger.error("In InsertAndReturnIdTest (BeeException):" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			Logger.error("In InsertAndReturnIdTest (Exception):" + e.getMessage());
			e.printStackTrace();
		}
	}
	
}
