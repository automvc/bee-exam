/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.sharding;

import java.util.List;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.FunctionType;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.osql.sharding.entity.Scores;
import org.teasoft.exam.bee.osql.sharding.entity.ScoresResponse;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.ConditionImpl;
import org.teasoft.honey.osql.core.Logger;

/**
 * 同时查多个最值,若涉及分片,Bee框架不负责合并结果.
 * 使用了sharding注解.
 * @author Kingstar
 * @since  2.0
 */
public class MoreSQLFunction {
	
	private static SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
	
	public static void main(String[] args) {
		InitSameDsUtil.initDS();
		ShardingInitData.init();
		
		test();
	}

	public static void test() {
		System.out.println("------Sharding test--------MoreSQLFunction-----");
		testSQLFun();
	}
	
	private static void testSQLFun() {
		Condition condition=new ConditionImpl();
		
		condition
//		.selectField("term,examno,subject")
		.selectFun(FunctionType.MAX, "score","maxScore")
		.selectFun(FunctionType.AVG, "score","avgScore")
		.selectFun(FunctionType.MIN, "score","minScore");
		
//		condition.op("classno", Op.eq, 1);
		
//		condition.op("status", Op.nq, "FIN"); //状态为还没关闭的,才能修改     
		
//		condition
//		.groupBy("term,examno,subjectno,subject")
//		.orderBy("term,examno,subjectno")
//		;
		
		Scores scores=new Scores();
//		String result=suidRich.selectJson(scores, condition);
//		Logger.info(result);
		
////		List<Scores> list=suidRich.select(scores, condition);
		List<ScoresResponse> list=suidRich.select(new ScoresResponse(), condition);
		for (int i = 0; i < list.size(); i++) {
			Logger.info(list.get(i).toString());
		}
		
//		List<String[]> listString=suidRich.selectString(scores, condition);
//		String str[];
//		for (int i = 0; i < listString.size(); i++) {
//			str=listString.get(i);
//			String rowStr="";
//			for (int j = 0; j < str.length; j++) {
//				rowStr+=str[j]+"     ";
//			}
//			Logger.info(rowStr);
//		}
		
	}

}
