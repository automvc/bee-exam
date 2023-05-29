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
import org.teasoft.honey.osql.core.BeeFactoryHelper;
import org.teasoft.honey.osql.core.Logger;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Test Json field (eg: mysql 5.7)
 * @author Kingstar
 * @since  1.9.8
 */
public class JsonAnnoTest2 {
	private static Suid suid=BeeFactoryHelper.getSuid();
	
	public static void main(String[] args) throws Exception{
		test();
	}
	
	public static void test() throws Exception{	
		
//      Ddl.createTable(new JsonValue());
		
//		JsonDefaultHandler.init();
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
		d.setId(11148);
		suid.insert(d);
		
		
		jsonValue.setDeptName("test Json-update");
		d.setId(11116);
		d.setDeptName("update-test");
		suid.update(d);
		
		
//		JsonValue jsonValue=new JsonValue();
//		jsonValue.setDeptName("test Json");
//		jsonValue.setDeptLeaderId("test Json");
		
		Dept2 d2=new Dept2();
		
		JsonValue jsonValue20=new JsonValue();
		jsonValue20.setDeptName("test Json");
		jsonValue20.setDeptLeaderId("test Json");
		
		JsonValue jsonValue21=new JsonValue();
		jsonValue21.setDeptName("test Json(\"包含引号\")");
		jsonValue21.setDeptLeaderId("test Json");
		
		List<JsonValue> jsonValueList=new ArrayList<>();
		jsonValueList.add(jsonValue20);
		jsonValueList.add(jsonValue21);
		
		String json=JsonUtil.toJson(jsonValueList);
//		System.err.println(JsonUtil.toJson(jsonValue));
		System.err.println(json);
		
		ObjectMapper mapper = new ObjectMapper();
		JavaType javaType2 = mapper.getTypeFactory().constructParametricType(List.class, JsonValue.class);
		List<JsonValue> list3=mapper.readValue(json, javaType2);
		System.err.println("list3:");
		System.err.println(list3.get(0).getDeptLeaderId());
		
		d2.setList(jsonValueList);
		d2.setId(11120);
		suid.insert(d2);
		
		Dept2 dept2=new Dept2();
		dept2.setId(11120);
		List<Dept2> list2=suid.select(dept2);
		Printer.printList(list2);
		
		Printer.printList(list2.get(0).getList());
		
		List<JsonValue> list22=list2.get(0).getList();
		System.err.println(list22.get(0).getDeptLeaderId());
		
		
//		List<Dept2> list2=suid.select(new Dept2());
//		Printer.printList(list2);
	}

}
