/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.util.List;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.FunctionType;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.osql.entity.Scores;
import org.teasoft.exam.bee.osql.entity.ScoresResponse;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.ConditionImpl;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.9
 */
public class MoreSQLFunction {
	
	private static SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		testSQLFun();
	}
	
	private static void testSQLFun() {
		Condition condition=new ConditionImpl();
		
		condition
		.selectField("classno,term,examno,subject")
		.selectFun(FunctionType.MAX, "score","maxScore")
		.selectFun(FunctionType.AVG, "score","avgScore")
		.selectFun(FunctionType.MIN, "score","minScore");
		
		condition.op("status", Op.nq, "FIN"); //状态为还没关闭的,才能修改     
		
		condition
		.groupBy("term,examno,subjectno,subject")
		.orderBy("classno,term,examno,subjectno")
		;
		
		Scores scores=new Scores();
//		String r=suidRich.selectJson(scores, IncludeType.EXCLUDE, condition);
		String result=suidRich.selectJson(scores, condition);
		Logger.info(result);
		
////		List<Scores> list=suidRich.select(scores, condition);
		List<ScoresResponse> list=suidRich.select(new ScoresResponse(), condition);
		for (int i = 0; i < list.size(); i++) {
			Logger.info(list.get(i).toString());
		}
		
		List<String[]> listString=suidRich.selectString(scores, condition);
		String str[];
		for (int i = 0; i < listString.size(); i++) {
			str=listString.get(i);
			String rowStr="";
			for (int j = 0; j < str.length; j++) {
				rowStr+=str[j]+"     ";
			}
			Logger.info(rowStr);
		}
		
	}

}
