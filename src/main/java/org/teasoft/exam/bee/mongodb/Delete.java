/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb;

import org.teasoft.bee.osql.SuidRich;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  2.0
 */
public class Delete {

	public static void main(String[] args) {
		SuidRich suidRich = BF.getSuidRich();
		int delNum = suidRich.delete(new Orders3());
		Logger.info("delNum:" + delNum);
	}

}
