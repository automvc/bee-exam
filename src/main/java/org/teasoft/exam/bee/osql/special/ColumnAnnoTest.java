/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.special;

import java.util.List;

import org.teasoft.bee.osql.Suid;
import org.teasoft.honey.osql.core.BeeFactoryHelper;

/**
 * #默认@Column转换功能是关闭，若要使用，需要设置
 * bee.osql.openDefineColumn=true
 * @author Kingstar
 * @since  1.17
 */
public class ColumnAnnoTest {

//	#默认@Column转换功能是关闭，若要使用，需要设置
//	bee.osql.openDefineColumn=true

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		Suid suid = BeeFactoryHelper.getSuid();
//	    Suid suid=BF.getSuid();//从1.9.8开始,BF可以加快输入  
		Orders orders1 = new Orders();
		List<Orders> list1 = suid.select(orders1);

		// 2:update更新实例
		orders1.setName2("Bee--ORM Framework");
		orders1.setId(1000L);
		// 默认只更新需要更新的字段. 过滤条件默认只用id字段,其它需求可用SuidRich中的方法.
		int updateNum = suid.update(orders1); // update

		Orders orders2 = new Orders();
		orders2.setUserid("bee");
		orders2.setRemark(""); // 默认过滤空字符和null
		int insertNum = suid.insert(orders2); // 3. 插入 insert

		// 4:delete 删除实例
		// 默认不处理null和空字符串.其它有值的字段全部自动作为过滤条件
		// int deleteNum=suid.delete(orders2); //delete

	}

}
