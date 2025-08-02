/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.prod.jsonanno;

import java.util.ArrayList;
import java.util.List;

import org.teasoft.bee.osql.api.Suid;
import org.teasoft.beex.json.JsonUtil;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.BeeFactoryHelper;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * Test Json field (eg: mysql 5.7)
 * @author Kingstar
 * @since  1.9.8
 */
public class JsonAnnoTest {
	private static Suid suid=BeeFactoryHelper.getSuid();
	
		public static void main(String[] args) throws Exception{
			test();
		}
		
		public static void test() {	
		
//      Ddl.createTable(new JsonValue());
		
//		JsonDefaultHandler.init();
//		直接查询Json数据,由Bee负责转化.
		List<Dept> list=suid.select(new Dept());
		if(list.size()>0) {
			if(list.get(0).getJsonValue()!=null) {
		Logger.info(list.get(0).getJsonValue().getDeptId());
		Logger.info(list.get(0).getJsonValue().getDeptName());
			}
		Printer.printList(list);
		}
		
		
		
		JsonValue jsonValue=new JsonValue();
		jsonValue.setDeptName("test Json");
		jsonValue.setDeptLeaderId("test Json");
		
		Dept d=new Dept();
		d.setJsonValue(jsonValue);
		d.setId(11138);
		int a=BF.getSuidRich().deleteById(Dept.class,11138);
		System.out.println(a);
		suid.insert(d);
		
		
		jsonValue.setDeptName("test Json-update");
		d.setId(11116);
		d.setDeptName("update-test");
		suid.update(d);
		
		Dept2 d2=new Dept2();
		
		JsonValue jsonValue20=new JsonValue();
		jsonValue20.setDeptName("test Json");
		jsonValue20.setDeptLeaderId("test Json");
		
		JsonValue jsonValue21=new JsonValue();
		jsonValue21.setDeptName("test Json");
		jsonValue21.setDeptLeaderId("test Json");
		
		List<JsonValue> jsonValueList=new ArrayList<>();
		jsonValueList.add(jsonValue20);
		jsonValueList.add(jsonValue21);
		
		String json=JsonUtil.toJson(jsonValueList);
//		System.err.println(JsonUtil.toJson(jsonValue));
		System.err.println(json);
		

	}

}
