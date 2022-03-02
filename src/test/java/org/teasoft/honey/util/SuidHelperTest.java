/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.honey.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.11
 */
public class SuidHelperTest {
	
	@Test
	public void test() {
		String[] str= {"111","112"};
		List<String[]> list=new ArrayList<>();
		list.add(str);
		System.out.println(SuidHelper.parseFirstColumn(list));
		
		
		//这部分代码,不知为何会影响到CharTest
//		org.teasoft.exam.bee.osql.entity.Noid from=new org.teasoft.exam.bee.osql.entity.Noid();
//		org.teasoft.exam.bee.test.Noid to=new org.teasoft.exam.bee.test.Noid();
//		
//		from.setNum(1);
//		from.setRemark("one");
//		
//		Logger.info(to.getNum());
//		Logger.info(to.getRemark());
//		SuidHelper.copyEntity(from, to);
//		Logger.info(to.getNum());
//		Logger.info(to.getRemark());
	}

}
