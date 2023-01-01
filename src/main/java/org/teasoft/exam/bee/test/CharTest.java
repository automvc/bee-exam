/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.test;

import java.util.List;

import org.teasoft.bee.osql.MoreTable;
import org.teasoft.bee.osql.PreparedSql;
import org.teasoft.bee.osql.Suid;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.core.BeeFactoryHelper;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.type.CharTypeHandler;
import org.teasoft.honey.osql.type.TypeHandlerRegistry;

/**
 * @author Kingstar
 * @since  1.11
 */
public class CharTest {
	
	private static Suid suid=BeeFactoryHelper.getSuid();
	
	public static Suid getSuid() {
		return suid;
	}

	public static void setSuidRich(Suid suid) {
		CharTest.suid = suid;
	}
	
	public static void main(String[] args) {
		test();
	}
	public static void test() {
		
		TypeHandlerRegistry.register(char.class, new CharTypeHandler<Character>(),true);
		test2();
		
		TypeHandlerRegistry.register(char.class, new CharTypeHandler<Character>());
//		TypeHandlerRegistry.register(Character.class, new CharTypeHandler<Character>());
		test2();
	}
	
	private static void test2() {
		
		List list=suid.select(new Noid());
		Printer.printList(list);
		
		String sql="select uuid,name,num,remark,ch from noid";
		PreparedSql p=BeeFactoryHelper.getPreparedSql();  //自定义sql应用不了类型处理器
		list=p.select(sql, Noid.class);
		Printer.printList(list);
		
		String json=p.selectJson(sql);
		Logger.info(json);
		
		SuidRich suidRich=BeeFactoryHelper.getSuidRich();
		String json2=suidRich.selectJson(new Noid());//会将原生类型的默认值转到where条件.
		Logger.info(json2);
		
		String sql2="select uuid,name,num,remark,ch from noid";
//		SqlLib SqlLib=new SqlLib();
//		List list2=SqlLib.moreTableSelect(sql2, new Noid());
		PreparedSql pm=BeeFactoryHelper.getPreparedSql(); 
		List list2=pm.moreTableSelect(sql2, new Noid());
		Printer.printList(list2);
		
		MoreTable moreTable=BeeFactoryHelper.getMoreTable();
		List list3=moreTable.select(new Noid());
		Printer.printList(list3);
		
	}

}
