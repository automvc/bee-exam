/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.tran;

import org.teasoft.honey.osql.autogen.Ddl;

/**
 * @author Kingstar
 * @since  2.2
 */
public class Gen {
	
	public static void main(String[] args) {
		Ddl.createTable(Org.class,true);
		Ddl.unique(Org.class, "orgName");
	}

}
