/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */
package org.teasoft.exam.bee.osql;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.Suid;
import org.teasoft.exam.bee.osql.entity.sqlite.Orders;  //sqlite
import org.teasoft.exam.bee.test.ClearAndInitTestTable;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.0
 */
public class SuidExamEN_SQLite {
	
	public static void main(String[] args) {
		ClearAndInitTestTable.main(null);  //TODO TEST
		test();
	}
	public static void test() {
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  try{
		Suid suid=BeeFactory.getHoneyFactory().getSuid();
		
		Orders orders1=new Orders();
		orders1.setId(100001L);
		orders1.setName("Bee(ORM Framework)");
		
		List<Orders> list1 =suid.select(orders1);  //select
		for (int i = 0; i < list1.size(); i++) {
			Logger.info(list1.get(i).toString());
		}
		
		orders1.setName("Bee(ORM Framework)");
		orders1.setUpdatetime(sf.format(new Date()));
		int updateNum=suid.update(orders1);   //update
		Logger.info("update record:"+updateNum);
		
		Orders orders2=new Orders();
		orders2.setUserid("bee");
		orders2.setName("Bee(ORM Framework)");
		orders2.setTotal(new BigDecimal("91.99"));
		orders2.setRemark("");  //empty String test
		orders2.setCreatetime(sf.format(new Date()));
		
		
		int insertNum=suid.insert(orders2); //insert
		Logger.info("insert record:"+insertNum);
		
//		int deleteNum=suid.delete(orders2);   //delete
//		Logger.info("delete record:"+deleteNum);
		
//		List<Orders> list2 =suid.select(orders1); //select  confirm the data
		List<Orders> list2 =suid.select(new Orders()); 
		for (int i = 0; i < list2.size(); i++) {
			Logger.info(list2.get(i).toString());
		}
		
		} catch (BeeException e) {
			Logger.error("In SuidExamEN (BeeException):"+e.getMessage());
			e.printStackTrace();
		}catch (Exception e) {
			Logger.error("In SuidExamEN (Exception):"+e.getMessage());
			e.printStackTrace();
		}
	}

}
