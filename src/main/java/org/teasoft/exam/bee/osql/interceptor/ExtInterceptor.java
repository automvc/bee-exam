/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.interceptor;

import java.util.List;

import org.teasoft.bee.osql.SuidType;
import org.teasoft.bee.osql.interccept.Interceptor;

/**
 * @author Kingstar
 * @since  1.11
 */
public class ExtInterceptor implements Interceptor{
	
	private String ds;

	@Override
	public Object beforePasreEntity(Object entity,SuidType suidType) {
		System.out.println("---(1)--beforePasreEntity------Ext---------------------");
		setDataSourceOneTime(null); //内容触发
		return entity;
	}
	
	@Override
	public void setDataSourceOneTime(String ds) {
		ds="ds2";  //根据规则设置数据源
		this.ds=ds;
	}
	
	@Override
	public String getOneTimeDataSource() {
		return ds;
	}

	@Override
	public String afterCompleteSql(String sql) {
		System.out.println("---(2)--afterCompleteSql--------Ext-------------------");
		return sql;
	}

	@Override
	public void beforeReturn(List list) {
		System.out.println("---(3)--beforeReturn(List list)---------Ext------------------");
		
	}
	
	@Override
	public void beforeReturn() {
		System.out.println("---(3)--beforeReturn()-------Ext--------------------");
	}

}
