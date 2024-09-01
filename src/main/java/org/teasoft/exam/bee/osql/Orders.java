/*
 * Copyright 2019-2024 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.util.List;

import org.teasoft.bee.osql.annotation.JoinTable;

/**
 * @author Kingstar
 * @since  2.4.0
 */
public class Orders {
	private Integer id;
	private String name;
	
	@JoinTable(mainField = "id" ,subField ="id" )
	private List<Orders> list;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Orders> getList() {
		return list;
	}

	public void setList(List<Orders> list) {
		this.list = list;
	}
	
}
