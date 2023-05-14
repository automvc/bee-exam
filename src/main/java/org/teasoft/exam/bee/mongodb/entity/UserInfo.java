/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.entity;

import org.teasoft.bee.osql.annotation.Table;

/**
 * @author Kingstar
 * @since  2.0
 */
@Table("UserInfo")
public class UserInfo {
	private String id;
	private String userid;
	private String username;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", userid=" + userid + ", username=" + username + "]";
	}
	
//	@Override
//	public String toString() {
//		return "UserInfo [userid=" + userid + ", username=" + username + "]";
//	}

}
