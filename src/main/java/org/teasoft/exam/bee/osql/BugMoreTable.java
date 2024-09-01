/*
 * Copyright 2019-2024 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import org.teasoft.bee.osql.annotation.JoinTable;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  2.4.0
 */
public class BugMoreTable {
   public static void main(String[] args) {
	  BF.getMoreTable().select(new Orders());
}
}

//
//class Orders{
//	private Integer id;
//	private String name;
//	
//	@JoinTable(mainField = "id" ,subField ="id2" )
//	private Integer id2;
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public Integer getId2() {
//		return id2;
//	}
//
//	public void setId2(Integer id2) {
//		this.id2 = id2;
//	}
	
	
	
//}
