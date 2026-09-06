/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.annotation.listmoretable2;

import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;

public class MoreTableExam11_5 {

	public static void main(String[] args) {
		try {
			SuidRich suidRich = BF.getSuidRich();
			List<Clazz> list = suidRich.select(new Clazz(), 0, 2);
			Printer.printList(list);
		} catch (BeeException e) {
			//...
		}
	}
}
