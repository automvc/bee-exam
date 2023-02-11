/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.prod.jsonanno.moretable;

import java.util.List;

import org.teasoft.bee.osql.Suid;
import org.teasoft.beex.type.JsonDefaultHandler;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.core.BeeFactoryHelper;
import org.teasoft.honey.osql.core.Logger;

/**
 * Test Json field (eg: mysql 5.7)
 * @author Kingstar
 * @since  1.9.8
 */
public class JsonAnnoTest3 {
	private static Suid suid=BeeFactoryHelper.getSuid();
	
	public static void main(String[] args) throws Exception{
		test();
	}
	
	public static void test() {	
		
//      Ddl.createTable(new JsonValue());
		
		JsonDefaultHandler.init();
//		直接查询Json数据,由Bee负责转化.
		List<Dept> list=suid.select(new Dept());
		Logger.info(list.get(0).getJsonValue().getDeptId());
		Logger.info(list.get(0).getJsonValue().getDeptName());
		Printer.printList(list);
		
		
		
		JsonValue jsonValue=new JsonValue();
		jsonValue.setDeptName("test Json");
		jsonValue.setDeptLeaderId("test Json");
		
		Dept d=new Dept();
		d.setJsonValue(jsonValue);
		d.setId(11117);
//		suid.insert(d);
		
		
		jsonValue.setDeptName("test Json-update400");
		d.setId(11115);
		d.setDeptName("update-test400");
		suid.update(d);

	}

}
