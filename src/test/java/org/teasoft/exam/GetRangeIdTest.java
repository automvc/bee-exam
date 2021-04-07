/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam;

import org.junit.Test;
import org.teasoft.bee.distribution.GenId;
import org.teasoft.honey.distribution.OneTimeSnowflakeId;
import org.teasoft.honey.distribution.PearFlowerId;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.9
 */
public class GetRangeIdTest {
	
	@Test
	public void test(){
		
		GenId genid=new PearFlowerId();
		test0(genid);
		test0(genid);
		Logger.info("");
		
		genid=new OneTimeSnowflakeId();
		test0(genid);
		test0(genid);
		
//		Logger.info(1<<10);
//		Logger.info(1<<13);
	}
	
	private void test0(GenId genid) {
		
		int size=5000;
		long r[]=genid.getRangeId(size);
		
		
		Logger.info(r[0]);
		Logger.info(r[1]);
		Logger.info(Long.toBinaryString(r[0]));
		Logger.info(Long.toBinaryString(r[1]));
		
		if((r[0]+size-1) ==r[1]) {
			Logger.info("The generated id are continuous!");
		}
		
	}

}
