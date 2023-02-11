/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.access;

import java.util.List;

import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  2.0
 */
public class AccessDbTest {
	public static void main(String[] args) {
		List<Stu> list = BF.getSuid().select(new Stu());

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).getName() + "   ,  ");
			System.out.print(list.get(i).getAge() + "   ,  ");
			System.out.println(list.get(i).getRemark());
		}

		System.out.println("finished");
	}

}
