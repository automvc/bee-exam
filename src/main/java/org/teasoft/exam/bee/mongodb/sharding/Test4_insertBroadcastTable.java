/*
getMongodbBeeSql() * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.sharding;

import java.util.ArrayList;
import java.util.List;

import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.mongodb.Noid0;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author AiTeaSoft
 * @since  2.0
 */
public class Test4_insertBroadcastTable {
	
	public static void main(String[] args) {
		try {
			test();
		} finally {
			ClearDsAndMongoDsUtil.clearConfig();
		}
	}

	public static void test() {
		
		ShardingDoConfig.init();
		InitDsAndMongoDsUtil.initDS();
		
		SuidRich suidRich =BF.getSuidRich();
		
		Noid0 noid0=new Noid0();
		
		List<Noid0> insertList=new ArrayList<>();
		
		for (int i = 16; i < 20; i++) {
			noid0=new Noid0();
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
