/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.util.List;

import org.teasoft.bee.osql.BeeSQLException;
import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.bee.osql.search.Operator;
import org.teasoft.bee.osql.search.Search;
import org.teasoft.exam.bee.osql.entity.TestUser;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.core.SearchProcessor;

/**
 * @author Kingstar
 * @since  1.9.8
 */
public class SearchExam {
	
	private static SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();

	public static SuidRich getSuidRich() {
		return suidRich;
	}

	public static void setSuidRich(SuidRich suidRich) {
		SearchExam.suidRich = suidRich;
	}

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		
		Search search[]=new Search[8];
		search[0]=new Search("id",Operator.between,"100023","100025");
		search[1]=new Search("id",Operator.between,"100030","100035","or");
		
		search[2]=new Search();
		search[2].setField("name");
		search[2].setOp(Operator.eq);
		search[2].setValue1("Bee");
		search[2].setOp2("or");
		
		search[3]=new Search();
		search[3].setOp2("(");
		
		search[4]=new Search();
		search[4].setField("id");
		search[4].setOp(Operator.between);
		search[4].setValue1("100040");
		search[4].setValue2("100049");
		
		
		
		search[5]=new Search();
		search[5].setOp2(")");
		
		search[6]=createObj2();
		search[6].setOp(Operator.notBetween);
		
		search[7]=createObj1();
		search[7].setOp(Operator.like);
		search[7].setValue1("Bee");
		
		try {
			
			Condition condition=SearchProcessor.parseSearch(search);
			List<TestUser> list17 = suidRich.select(new TestUser(), condition);
			for (int i = 0; i < list17.size(); i++) {
				Logger.info(list17.get(i).toString());
			}
			
			for (int i = 0; i < search.length; i++) {
			System.err.println(search[i].getField()+"  "+search[i].getOp()
					+"  "+search[i].getValue1()+"  "+search[i].getValue2());
			}
			
		} catch (BeeSQLException e) {
			Logger.error(e.getMessage(),e);
		}
	}
	
	private static Search createObj1() {
		Search search=new Search();
		search.setField("name");
//		search.setOp(Operator.between);
//		search.setValue1("100040");
//		search.setValue2("100049");
		
		return search;
	}
	
	private static Search createObj2() {
		Search search=new Search();
		search.setField("id");
//		search.setOp(Operator.between);
		search.setValue1("100040");
		search.setValue2("100049");
		
		return search;
	}

}
