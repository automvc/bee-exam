/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.util.List;

import org.teasoft.bee.osql.FunctionType;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.osql.entity.Scores;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.ConditionImpl;

/**
 * @author Kingstar
 * @since  1.9
 */
public class SelectFun {
	
	static SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		
		Scores scores=new Scores();
		scores.setTeacherno("60001");
		scores.setTeachername("");  //v1.8 bug. default can not filter empty string.
		
		Condition condition=getCondition();
		
//		String total_1 = suidRich.selectWithFun(scores, FunctionType.COUNT, "*", condition);
		String total_1 = suidRich.selectWithFun(scores, FunctionType.COUNT, "*");
		Logger.info(total_1);
		
//		int total_2 = suidRich.count(scores, condition);
//		Logger.info(total_2);
//		
//		int total_3 = suidRich.count(scores);
//		Logger.info(total_3);
		
		
		condition.start(0).size(10);
		 List<Scores> list=suidRich.select(scores, condition);
			for (int i = 0; i < list.size(); i++) {
				Logger.info(list.get(i).toString());
			}
	}
	
//	private static String count(Scores scores, final Condition condition) {
//		String total = suidRich.selectWithFun(scores, FunctionType.COUNT, "*", condition);
//		return total;
//	}
	
	private static Condition getCondition() {
		Condition condition=new ConditionImpl();
		
//		.selectFun(FunctionType.MAX, "score","maxScore"); //exception : The method just support use one Function!
		condition.op("status", Op.nq, "FIN"); //状态为还没关闭的,才能修改
		
		condition
		.lParentheses()
		.op("classno", Op.eq, "201")
		.or()
		.op("classno", Op.eq, "191(高中)")
		.rParentheses()
		;
		
        return condition;
	}

}
