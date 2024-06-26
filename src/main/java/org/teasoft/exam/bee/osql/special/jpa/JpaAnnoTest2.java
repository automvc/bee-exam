/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.special.jpa;

import org.teasoft.bee.osql.api.Suid;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  1.17
 */
public class JpaAnnoTest2 {

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		Suid suid = BF.getSuid();
		suid.select(new Orders2());
	}

}
