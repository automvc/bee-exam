/*
 * Copyright 2020-2025 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.honey.osql.name;

import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  2.5.2
 */
public class KeyWordTest {
	
	public static void main(String[] args) {
//		new GenBean().genSomeBeanFile("key_word");
		
		KeyWordEntity kw=new KeyWordEntity();
		kw.setId(1L);
		kw.setName("test-kw");
		kw.setKey("test");
		kw.setComment("test comment");
		
//		Suid suid=BF.getSuid();
//		suid.insert(kw);
		
		SuidRich suidRich=BF.getSuidRich();
		suidRich.createTable(KeyWordEntity.class, true);
	}

}
