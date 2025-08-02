/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.distribution;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.teasoft.honey.distribution.GenIdFactory;
import org.teasoft.honey.logging.Logger;

/**
 * @author Kingstar
 * @since  1.8
 */
public class PearFlowerIdTest {
	
	public static void main(String[] args) {
		Set<Long> set=new LinkedHashSet<>();
		List list=new ArrayList();
		for (int i = 0; i < 1000000; i++) {
			if(i%10==0){
				long ids[] =GenIdFactory.getRangeId("userTable",85);
				for (long j = ids[0]; j <= ids[1]; j++) {
//					Logger.info(j);
					if(!set.add(j)) list.add(j);
				}
//				System.out.println(set);
			}else{
			long id =GenIdFactory.get("userTable");
			Logger.info(id);
			if(!set.add(id)) list.add(id);
			}
		}
		Logger.info("共生成的ID总数: "+set.size());
		Logger.info("重复集合: "+list);
		
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			Logger.info(e.getMessage());
		}

	}
}
