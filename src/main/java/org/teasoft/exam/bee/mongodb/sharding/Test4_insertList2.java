/*
getMongodbBeeSql() * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.sharding;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.teasoft.bee.osql.IncludeType;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author AiTeaSoft
 * @since  2.0
 */
public class Test4_insertList2 {
	
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
		
		Orders orders=new Orders();
		
		List<Orders> insertList=new ArrayList<>();
		
		for (int i = 50; i < 60; i++) {
			orders=new Orders();
			orders.setAbc("test bee ");
			orders.setName("mongodb" + i);
//			orders.setId(3000L + i);
			orders.setUserid(3000L + i);
//			orders.setNum(i);
//			orders.setRemark(null); //test null   mongodb,批量插入,不处理null
			orders.setTotal(new BigDecimal((i+i*0.01)+""));
			
			insertList.add(orders);
		}
		
		int insertNum=suidRich.insert(insertList);
		
		System.out.println("insertNum="+insertNum);
		
		
		
		System.out.println("finished!");
	}

}
