/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.special.primarykey;

import java.util.List;

import org.teasoft.bee.osql.IncludeType;
import org.teasoft.bee.osql.api.Suid;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.osql.special.primarykey.entity.CustomId;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * 测试javabean没有id字段的用法
 * 另外Bee有提供分布式id的方法，即使主键名不是id也可以使用分布式id。
 * 但强烈建议新项目,设置一个名为id的字段
 * @author Kingstar
 * @since  1.11
 */
public class PrimaryKeyTest {
	
	private static Suid suid = BF.getSuid();
	private static SuidRich suidRich = BF.getSuidRich();
	
	public static Suid getSuid() {
		return suid;
	}
	
	public static void setSuidRich(Suid suid) {
		PrimaryKeyTest.suid=suid;
	}
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		CustomId noid=new CustomId();
		String key="aaaadd-no-id";
		noid.setUuid(key);
		noid.setName("test no id");
		suid.insert(noid);
		
		List<CustomId> list=suid.select(noid);
		Printer.printList(list);
		
		noid.setUuid(key);
		noid.setName("new name--new");
		suid.update(noid);   //默认id作为where条件里的表达式,用于确定需要更新的记录
//		suidRich.updateBy(noid, "uuid"); //没有id字段;则指定作为where的字段即可.
		
		suidRich.update(noid,IncludeType.INCLUDE_BOTH); 
		
		List<CustomId> list2=suid.select(noid);
		Printer.printList(list2);
		
//		联合主键
		Assignexam assignexam=new Assignexam();
		
		assignexam.setClassno("2001");
		assignexam.setTerm("200101");
		assignexam.setRemark("联合主键更新");
		
		suidRich.select(assignexam);
		
		suidRich.update(assignexam); //默认情况,主键用于where条件
//		update assignexam set remark='联合主键更新' where classno='2001' and term='200101'
		
		suidRich.updateBy(assignexam,"classno,term");
		
//		suidRich.updateById(assignexam, null);
		
	}

}
