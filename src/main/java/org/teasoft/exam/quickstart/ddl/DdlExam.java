/*
 * Copyright 2022-2026 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.quickstart.ddl;

import org.teasoft.exam.moretable3.sharding.entity.Book;
import org.teasoft.honey.osql.autogen.Ddl;

/**
 * Entity -> Table
 * Create DB table via Entity.
 * 
 * @author Kingstar
 * @since  3.0.0
 */
public class DdlExam {
	
	public static void main(String[] args) {
		Ddl.createTable(Book.class);
	}

}
