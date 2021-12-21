/*
package org.teasoft.exam.bee.osql.special.groovy

import org.teasoft.bee.osql.Suid
import org.teasoft.honey.osql.core.BeeFactoryHelper
import org.teasoft.honey.osql.core.Logger
import org.teasoft.exam.bee.osql.entity.Orders


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

*/
