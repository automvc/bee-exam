/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.chain;

import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  2.1
 */
public class Chain {
	
	public static void main(String[] args) {
		BF.getSuid().select(new User().setUsername("张三").setPassword("abc"));
	}

}
