/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.sharding;

import java.util.ArrayList;
import java.util.List;

import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.mongodb.entity.Noid0;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author AiTeaSoft
 * @since  2.0
 */
public class Test4_insertBroadcastTable {
	
	public static void main(String[] args) {
		ShardingInitData.init();
		InitSameDsUtil.initDS();
		test();
	}

	public static void test() {
		System.out.println("------Sharding test--------Test4_insertBroadcastTable-----");
		
		SuidRich suidRich =BF.getSuidRich();
		
		Noid0 noid0=new Noid0();
		
		List<Noid0> insertList=new ArrayList<>();
		
		for (int i = 1; i < 100; i++) {
			noid0=new Noid0();
			if(i==18) noid0.setUuid("839668237074436");
			noid0.setName(i+"-aa");
			noid0.setNum(i);
			noid0.setRemark(null);
			insertList.add(noid0);
		}
		
		int insertNum=suidRich.insert(insertList);
		
		System.out.println("insertNum="+insertNum);
		
		System.out.println("finished!");
	}

}
