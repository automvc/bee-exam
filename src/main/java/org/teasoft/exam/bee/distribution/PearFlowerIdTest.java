/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.distribution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.teasoft.honey.distribution.GenIdFactory;

/**
 * @author Kingstar
 * @since  1.7.3
 */
public class PearFlowerIdTest {
	
	public static void main(String[] args) {
		Set<Long> set=new HashSet<>();
		List list=new ArrayList();
		for (int i = 0; i < 1000000; i++) {
			if(i%10==0){
				long ids[] =GenIdFactory.getRangeId("userTable",100);
				for (long j = ids[0]; j <= ids[1]; j++) {
//					System.out.println(j);
					if(!set.add(j)) list.add(j);
				}
			}else{
			long id =GenIdFactory.get("userTable");
			System.out.println(id);
			if(!set.add(id)) list.add(id);
			}
		}
		System.out.println("共生成的ID总数: "+set.size());
		System.out.println("重复集合: "+list);
		
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
