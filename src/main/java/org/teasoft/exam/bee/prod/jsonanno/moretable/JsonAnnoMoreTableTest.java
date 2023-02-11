/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.prod.jsonanno.moretable;

import java.util.List;

import org.teasoft.bee.osql.MoreTable;
import org.teasoft.bee.osql.Suid;
import org.teasoft.beex.type.JsonDefaultHandler;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.core.BeeFactoryHelper;

/**
 * Test Json field (eg: mysql 5.7)
 * @author Kingstar
 * @since  1.9.8
 */
public class JsonAnnoMoreTableTest {
	
	private static MoreTable moreTable = BeeFactoryHelper.getMoreTable();
	private static Suid suid=BeeFactoryHelper.getSuid();
	
	
	public static void main(String[] args) throws Exception{
		test();
	}
	
	public static void test() {	
		
		JsonDefaultHandler.init();
		
//		Company company=new Company();
//		company.setId(111);
//		company.setDeptId(11114);
//		company.setComName("Bee");
//		suid.insert(company);
		 
		List list=moreTable.select(new Company());
		Printer.printList(list);
		
		
		Company company=new Company();
		company.setId(111);
		company.setDeptId(11114);
		company.setComName("Bee");
		List list2=moreTable.select(company);
		Printer.printList(list2);
		
		company=new Company();
		company.setId(111);
		company.setDeptId(11114);
		company.setComName("Bee");
		
		//mysql 5.7 Json类型字段，不作为where条件。
//		JsonValue jsonValue=new JsonValue();
//		jsonValue.setDeptName("test Json-update");
//		jsonValue.setDeptLeaderId("test Json");
		Dept dept=new Dept();
//		dept.setJsonValue(jsonValue);
		dept.setId(11114);
		company.setDept(dept);
		
		List list3=moreTable.select(company);
		Printer.printList(list3);
	}

}
