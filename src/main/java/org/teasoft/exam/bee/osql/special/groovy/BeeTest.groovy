/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.special.groovy

import org.teasoft.bee.osql.Suid
import org.teasoft.honey.osql.core.BeeFactoryHelper
import org.teasoft.honey.osql.core.Logger
import org.teasoft.exam.bee.osql.entity.Orders

/**
 * @author Kingstar
 * @since  1.9.8
 */
class BeeTest {

	static void main(args){
		Suid suid = BeeFactoryHelper.getSuid();
		def orders1 = new Orders()
		suid.select(orders1)
		List<Orders> list1 = suid.select(orders1) //select
		for (i in 0..list1.size()-1) {
			Logger.info(list1.get(i).toString())
		}
	}

}
