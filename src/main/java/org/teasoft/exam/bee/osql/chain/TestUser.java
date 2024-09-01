/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.chain;

/**
 * @author Kingstar
 * @since  2.1
 */
public class TestUser {

	private Long id;
	private String username;
	private String password;

	public Long getId() {
		return id;
	}

	public TestUser setId(Long id) {
		this.id = id;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public TestUser setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public TestUser setPassword(String password) {
		this.password = password;
		return this;
	}

}
