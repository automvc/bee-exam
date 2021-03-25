/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.distribution;

import org.teasoft.bee.distribution.GenId;
import org.teasoft.honey.distribution.PearFlowerId;
import org.teasoft.honey.distribution.SerialUniqueId;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.8
 */
public class IdTest {
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		
		GenId genId=new SerialUniqueId();
		long start=System.currentTimeMillis();
		//直接获取
		for (int i = 0; i < 3; i++) {
//			genId.get();
//			genId.getRangeId(1000);
//			System.out.println(i+": "+genId.get());
			Logger.info(i+": "+Long.toBinaryString(genId.get()));
		}
		
		long end=System.currentTimeMillis();
		Logger.info("使用时间: "+(end-start));
		
		
		
		
		 genId=new PearFlowerId();
		 start=System.currentTimeMillis();
		//直接获取
		for (int i = 0; i < 5; i++) {
//			genId.get();
//			genId.getRangeId(1000);
//			System.out.println(i+": "+genId.get());
			Logger.info(i+": "+Long.toBinaryString(genId.get()));
		}
		
		 end=System.currentTimeMillis();
		 Logger.info("使用时间: "+(end-start));
	}

}
