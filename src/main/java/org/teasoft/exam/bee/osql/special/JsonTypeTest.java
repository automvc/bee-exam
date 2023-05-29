/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.special;

import java.util.List;

import org.teasoft.bee.osql.api.Suid;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.core.BeeFactoryHelper;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Test Json field (eg: mysql 5.7)
 * @author Kingstar
 * @since  1.9.8
 */
public class JsonTypeTest {
	private static Suid suid=BeeFactoryHelper.getSuid();
	public static void main(String[] args) throws Exception{
		List<Dept> list=suid.select(new Dept());
		Printer.printList(list);
		
		ObjectMapper mapper = new ObjectMapper(); 
		DeptJson deptJson = mapper.readValue(list.get(0).getJsonValue(), DeptJson.class);
		System.err.println(deptJson.getDeptName());
	}

}
