/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.util.List;

import org.teasoft.bee.osql.Suid;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.osql.entity.Noid;
import org.teasoft.exam.bee.osql.entity.Testnum;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.core.BeeFactoryHelper;

/**
 * @author Kingstar
 * @since  1.9.8
 */
public class SpecialTest {
	
	private static Suid suid = BeeFactoryHelper.getSuid();
	private static SuidRich suidRich = BeeFactoryHelper.getSuidRich();
	
	public static Suid getSuid() {
		return suid;
	}
	
	public static void setSuidRich(Suid suid) {
		SpecialTest.suid=suid;
	}
	
	public static void main(String[] args) {
//		test();
		testNoId();
	}
	
	public static void test() {
		Testnum testnum=new Testnum();
		testnum.setId("sd15");
		List<Testnum> list=suid.select(testnum);
		Printer.printList(list);
		
		
		testnum.setId("sd15");
		testnum.setName("new name3");
		suid.update(testnum);
		
		List<Testnum> list2=suid.select(testnum);
		Printer.printList(list2);
	}
	
	public static void testNoId() {
		Noid noid=new Noid();
		noid.setUuid("aaaaaa-no-id");
		noid.setName("test no id");
		suid.insert(noid);
		
		List<Noid> list=suid.select(noid);
		Printer.printList(list);
		
		noid.setUuid("aaaaaa-no-id");
		noid.setName("new name3");
//		suid.update(noid);   //默认id作为where条件里的表达式,用于确定需要更新的记录
		suidRich.updateBy(noid, "uuid"); //没有id字段;则指定作为where的字段即可.
		
		List<Noid> list2=suid.select(noid);
		Printer.printList(list2);
	}

}
