/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import org.junit.Test;
import org.teasoft.bee.osql.SqlKeyWord;
import org.teasoft.bee.osql.UpperKey;
import org.teasoft.honey.osql.core.Logger;

/**
	* @author Kingstar
	* @since  1.9
	*/
public class UpperKeyTest {

	@Test
	public void test() {
		SqlKeyWord k = new UpperKey();
		Logger.info(k.select()+k.distinct()+k.from());
		Logger.info(k.where()+k.and()+k.between()+k.groupBy()+k.orderBy()+k.forUpdate());
		Logger.info(k.isNotNull()+k.isNull()+k.in()+k.exists()+k.notExists());
		Logger.info(k.innerJoin()+k.join()+k.leftJoin()+k.rightJoin());
		Logger.info(k.limit()+k.top());
		Logger.info(k.insert()+k.into()+k.values());
		Logger.info(k.delete()+k.from());
		Logger.info(k.update()+k.set());
	}

}