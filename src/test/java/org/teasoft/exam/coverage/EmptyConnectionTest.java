/*
 * Copyright 2019-2024 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.coverage;

import java.sql.SQLException;

import org.junit.Test;
import org.teasoft.honey.jdbc.EmptyConnection;
import org.teasoft.honey.jdbc.EmptyDataSource;
import org.teasoft.honey.jdbc.SimpleDataSource;

/**
 * @author Kingstar
 * @since  2.4.0
 */
public class EmptyConnectionTest {

	@Test
	public void test() throws SQLException {
		EmptyConnection a = new EmptyConnection();
		a.unwrap(String.class);
		a.isWrapperFor(String.class);
		a.createStatement();
		try{ a.prepareStatement("");} catch (Exception e) {}
		a.prepareCall("");
		a.nativeSQL("");
		a.setAutoCommit(false);
		a.getAutoCommit();
		a.commit();
		a.rollback();
		a.close();
		a.isClosed();
		a.setReadOnly(false);
		a.isReadOnly();
		a.setCatalog("");
		a.setTransactionIsolation(1);
		a.clearWarnings();
		a.prepareStatement("", 1, 1);
		a.prepareCall("", 1, 1);
		a.setTypeMap(null);
		a.setHoldability(1);
		a.setSavepoint();
		a.setSavepoint("test");
		a.createStatement(1, 1, 1);
		a.prepareStatement("", 1, 1);
		a.prepareCall("", 1, 1);
		a.prepareStatement("", 1);
		a.prepareStatement("", new String[] { "Integer", "String" });
		a.prepareStatement("", new int[] { 1, 2 });
		a.createClob();
		a.createBlob();
		a.createNClob();
		a.createSQLXML();
		a.isValid(1);
		a.setClientInfo("", "");
		a.setClientInfo(null);
		a.getClientInfo("");
		a.createArrayOf("", null);
		a.createStruct("", null);
		a.abort(null);
		a.setNetworkTimeout(null, 1);
		a.setSchema("");
		
		
		EmptyDataSource e=new EmptyDataSource();
		e.unwrap(null);
		e.isWrapperFor(null);
		e.getConnection("", "");
		e.setLogWriter(null);
		e.setLoginTimeout(1);
		
		SimpleDataSource s1=new SimpleDataSource("url");
		SimpleDataSource s2=new SimpleDataSource("url", "username", "pwd0");
	}
}
