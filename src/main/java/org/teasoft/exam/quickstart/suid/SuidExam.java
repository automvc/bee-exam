/*
 * Copyright 2022-2026 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.quickstart.suid;

import java.math.BigDecimal;
import java.util.List;

import org.entity.Orders;
import org.teasoft.bee.osql.api.Suid;
import org.teasoft.honey.osql.shortcut.BF;

/**
* 查,改,增,删 Suid (select,update,insert,delete)实例
* 
* 关键代码
List<Orders> list1 =suid.select(orders1);  //select
int updateNum=suid.update(orders1);   //update
int insertNum=suid.insert(orders2); //insert 
int deleteNum=suid.delete(orders2);   //delete

* @author Kingstar
* @since  3.0.0
*/
public class SuidExam {

	public static void main(String[] args) {

		Suid suid = BF.getSuid();

		// 需要先生成相应的Javabean
		Orders orders1 = new Orders();
		orders1.setId(100001L);
		orders1.setName("Bee(ORM Framework)");

		// 1:select查询实例
		// 默认不处理null和空字符串.不用再写一堆的判断;其它有值的字段全部自动作为过滤条件
		List<Orders> list1 = suid.select(orders1); // select
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i).toString());
		}

		// 在实体里,默认的运行符是等号,除了等号,Bee是用比较符合书写习惯的方法, 可以任意写不同的条件.
		// Condition condition=BF.getCondition(); //SuidRich接口有很多带Condition参数的方法
		// condition.op(Orders_F.userid, Op.ge, 0); //userid>=0
		// Op支持除了"="外的,>,<,>=,<=,!=, like, in, not in 等

		// 2:update更新实例
		orders1.setName("Bee--ORM Framework");
		// 默认只更新需要更新的字段. 过滤条件默认只用id字段,其它需求可用SuidRich中的方法.
		int updateNum = suid.update(orders1); // update
		System.out.println("update record:" + updateNum);

		Orders orders2 = new Orders();
		orders2.setUserid("bee");
		orders2.setName("Bee(ORM Framework)");
		orders2.setTotal(new BigDecimal(91.99));
		orders2.setRemark(""); // empty String test

		// 3:insert 插入实例
		int insertNum = suid.insert(orders2); // insert
		// 默认不处理null和空字符串.不用再写一堆的判断;其它有值的字段全部自动插入数据库中.
		// 方便结合DB插值,如id自动增长,由DB插入;createtime由DB默认插入
		System.out.println("insert record:" + insertNum);

		// 4:delete 删除实例
		// 默认不处理null和空字符串.不用再写一堆的判断;其它有值的字段全部自动作为过滤条件
		// int deleteNum=suid.delete(orders2); //delete
		// System.out.println("delete record:"+deleteNum);

	}
}
//注意: 事务,分页,排序,范围查询,查询结果直接返回json等都支持,这里只是一个入门例子.
//更加应用参考,请查看: 更多例子   和    综合应用 .
