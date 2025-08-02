/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.math.BigDecimal;
import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.api.Suid;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.BeeFactoryHelper;
import org.teasoft.honey.osql.core.HoneyConfig;

/**
 * @author Kingstar
 * @since  1.0
 */
public class SuidExam {
	
	private static Suid suid = BeeFactoryHelper.getSuid();
	
	public static Suid getSuid() {
		return suid;
	}
	
	public static void setSuid(Suid suid) {
		SuidExam.suid=suid;
	}
	
	public static void main(String[] args) {
//		TestPrepare.init();
		test();
	}
	
	public static void test() {

		try {
			
//			Suid suid = BeeFactory.getHoneyFactory().getSuid();
			
			suid.beginSameConnection();

			Orders orders1 = new Orders();
			
			suid.select(orders1); //select all
			
			orders1.setId(100001L);
			orders1.setName("Bee(ORM Framework)");

			//默认不处理null和空字符串.不用再写一堆的判断;其它有值的字段全部自动作为过滤条件
			List<Orders> list1 = suid.select(orders1); //select
			 suid.select(orders1); //select   test cache
			for (int i = 0; i < list1.size(); i++) {
				Logger.info(list1.get(i).toString());
			}

			orders1.setId(100001L);
			orders1.setName("Bee(ORM Framework)");
			//默认只更新需要更新的字段. 过滤条件默认只用id字段,其它需求可用SuidRich中的方法.
			int updateNum = suid.update(orders1); //update
			Logger.info("update record:" + updateNum);

			Orders orders2 = new Orders();
			orders2.setUserid("bee");
			orders2.setName("Bee-ORM Framework");
			orders2.setTotal(new BigDecimal("91.99"));
			orders2.setRemark(""); //empty String test

			//默认不处理null和空字符串.不用再写一堆的判断;其它有值的字段全部自动插入数据库中. 
			//方便结合DB插值,如id自动增长,由DB插入;createtime由DB默认插入
			int insertNum = suid.insert(orders2); //insert
			Logger.info("insert record:" + insertNum);
			
			 suid.insert(orders2); //insert
			 suid.insert(orders2); //insert
			
			//演示了插入的数据后,查出,然后再将其删除. 这样可以重复利用测试用例

			suid.select(orders2);  //下次再查,可测试缓存
			//suid.update(orders2);
			
			List<Orders> list2 = suid.select(orders2); //select  confirm the data
			for (int i = 0; i < list2.size(); i++) {
				Logger.info(list2.get(i).toString());
			}

			//默认不处理null和空字符串.不用再写一堆的判断;其它有值的字段全部自动作为过滤条件
			int deleteNum=suid.delete(orders2);   //delete
			Logger.info("delete record:"+deleteNum);
			
			List<Orders> listAll = suid.select(new Orders()); //select add and confirm the data
			for (int i = 0; i < listAll.size(); i++) {
				Logger.info(listAll.get(i).toString());
			}
			suid.select(orders2);
			suid.select(orders2);
			suid.endSameConnection();
			
			suid.select(orders2);
			
			suid.beginSameConnection();  //test miss
			Orders orders11 = new Orders();
			orders1.setId(100001L);
			suid.select(orders11); 
			suid.select(orders11); 
			suid.endSameConnection();
			
			System.out.println(HoneyConfig.getHoneyConfig().getSchemaName());
			
		} catch (BeeException e) {
			Logger.error("In SuidExam (BeeException):"+e.getMessage());
			e.printStackTrace();
		}catch (Exception e) {
			Logger.error("In SuidExam (Exception):"+e.getMessage());
			e.printStackTrace();
		}
	}
}
