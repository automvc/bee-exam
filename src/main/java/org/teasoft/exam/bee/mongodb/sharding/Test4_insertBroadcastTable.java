/*
getMongodbBeeSql() * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.sharding;

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
		try {
			InitDsAndMongoDsUtil.initDS();
			ShardingDoConfig.init();
			test();
		} finally {
			ClearDsAndMongoDsUtil.clearConfig();
		}
	}

	public static void test() {
		
		SuidRich suidRich =BF.getSuidRich();
		
		Noid0 noid0=new Noid0();
		
		List<Noid0> insertList=new ArrayList<>();
		
		for (int i = 0; i < 2; i++) {
			noid0=new Noid0();
			noid0.setName(i+"-aa");
			noid0.setNum(i);
			noid0.setRemark(null);
			insertList.add(noid0);
		}
		
		try {
			
		
		int insertNum=suidRich.insert(insertList);  //fixed bug about multiDS_sharding java style config
//			int insertNum=suidRich.insert(noid0); //bug
		
		for (int i = 0; i < insertList.size(); i++) {
		  System.out.println("---------getUuid: "+insertList.get(i).getUuid());
		}
		System.out.println("insertNum="+insertNum);
		} catch (Exception e) {
			System.err.println("-----------have exception");
			e.printStackTrace();
		}
		
//		for (int i = 0; i < 300; i++) { 
//		for (int i = 0; i < 2; i++) {
			int insertNum=suidRich.insert(insertList);
//		}
		
		System.out.println("finished!");
	}

}
