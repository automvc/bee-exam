/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.dialect;

import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.dialect.sqlserver.SqlServerFeature;

/**
 * @author Kingstar
 * @since  1.11
 */
public class CustomerSqlServerFeature extends SqlServerFeature {
	
	public String toPageSql(String sql, int start, int size) {
		
		Logger.warn("在此处添加你的分页实现");
		//添加你的分页实现.
		
		
		return "";
	}
	

}
