/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.math.BigDecimal;
import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.Suid;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.0
 */
public class SuidExam {
	
	
	public static void main(String[] args) {
//		TestPrepare.init();
		test();
	}
	
	public static void test() {

		try {
			
			Suid suid = BeeFactory.getHoneyFactory().getSuid();

			Orders orders1 = new Orders();

			//默认不处理null和空字符串.不用再写一堆的判断;其它有值的字段全部自动作为过滤条件
			List<Orders> list1 = suid.select(orders1); //select
			for (int i = 0; i < list1.size(); i++) {
//				Logger.info(list1.get(i).toString());
				Logger.info(list1.get(i).toString());
			}

			orders1.setId(100001L);
			orders1.setName("Bee(ORM Framework)");
			//默认只更新需要更新的字段. 过滤条件默认只用id字段,其它需求可用SuidRich中的方法.
			int updateNum = suid.update(orders1); //update
			Logger.info("update record:" + updateNum);

			Orders orders2 = new Orders();
			orders2.setUserid("bee");
			orders2.setName("Bee-ORM framework");
			orders2.setTotal(new BigDecimal("91.99"));
			orders2.setRemark(""); //empty String test

			//默认不处理null和空字符串.不用再写一堆的判断;其它有值的字段全部自动插入数据库中. 
			//方便结合DB插值,如id自动增长,由DB插入;createtime由DB默认插入
			int insertNum = suid.insert(orders2); //insert
			Logger.info("insert record:" + insertNum);
			
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

		} catch (BeeException e) {
			e.printStackTrace();
		}
	}
}
