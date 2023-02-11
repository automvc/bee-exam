/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.access.ds;

import java.util.List;

import org.teasoft.bee.osql.Suid;
import org.teasoft.exam.bee.access.Stu;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * Access 使用ORM
 */
public class AccessDbTest {
	
	public static void main(String[] args){
		InitSameAccessDsUtil.initDS();
		
		Suid suid=BF.getSuid();
		suid.setDataSourceName("ds0");
		List<Stu> list=suid.select(new Stu());
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("finished");
	}
}
