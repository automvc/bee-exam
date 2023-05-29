/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.json;

import java.util.List;

import org.teasoft.bee.osql.api.Suid;
import org.teasoft.exam.bee.mongodb.json.entity.Dept;
import org.teasoft.exam.bee.osql.special.DeptJson;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.core.BeeFactoryHelper;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Kingstar
 * @since 2.0
 */
public class ListJsonTest {

	private static Suid suid = BeeFactoryHelper.getSuid();

	public static void main(String[] args) throws Exception{
		test();
	}

	public static void test() throws Exception{
		List<Dept> list = suid.select(new Dept());
		Printer.printList(list);

		if (list.size() > 0) {
			ObjectMapper mapper = new ObjectMapper();
			DeptJson deptJson = mapper.readValue(list.get(0).getOne(), DeptJson.class);
			System.err.println(deptJson.getDeptName());
		}
	}

}
