/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam;

import org.junit.Test;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.dialect.HSqlDbFrontLimitPaging;
import org.teasoft.honey.osql.dialect.OffsetFetchPaging;

/**
 * @author Kingstar
 * @since  2.1
 */
public class Paging {
	
	@Test
	public void test() {
		
		HSqlDbFrontLimitPaging hp=new HSqlDbFrontLimitPaging();
		String p11=hp.toPageSql("select * from orders", 5);
		String p12=hp.toPageSql("select * from orders", 1, 5);
		
		OffsetFetchPaging of=new OffsetFetchPaging();
		String p21=of.toPageSql("select * from orders", 5);
		String p22=of.toPageSql("select * from orders", 1, 5);
		
		Logger.info(p11);
		Logger.info(p12);
		Logger.info(p21);
		Logger.info(p22);
	}

}
