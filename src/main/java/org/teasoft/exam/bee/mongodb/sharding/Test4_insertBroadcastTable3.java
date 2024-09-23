/*
getMongodbBeeSql() * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.sharding;

import java.util.ArrayList;
import java.util.List;

import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.mongodb.entity.Noid;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author AiTeaSoft
 * @since  2.0
 */
public class Test4_insertBroadcastTable3 {
	
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
		
		Noid noid=new Noid();
		
		List<Noid> insertList=new ArrayList<>();
		
		for (int i = 20; i < 22; i++) {
			noid=new Noid();
			noid.setName(i+"-aa");
			noid.setNum(i);
			noid.setRemark(null);
			insertList.add(noid);
		}
		
		try {
			
		
//		int insertNum=suidRich.insert(insertList);
//			int insertNum=suidRich.insert(noid); //bug
//			int insertNum=suidRich.insert(noid,null); //bug
			
			int insertNum=(int)suidRich.insertAndReturnId(noid);  //不支持分片.
		
		for (int i = 0; i < insertList.size(); i++) {
		  System.out.println("---------getUuid: "+insertList.get(i).getUuid());
		}
		System.out.println("insertNum="+insertNum);
		} catch (Exception e) {
			System.err.println("-----------have exception");
			e.printStackTrace();
		}
		
////		for (int i = 0; i < 300; i++) { //bug?
//		for (int i = 0; i < 2; i++) {
//			int insertNum=suidRich.insert(insertList);
//		}
		
		System.out.println("finished!");
	}

}
