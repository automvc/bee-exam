/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.special;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.teasoft.honey.osql.core.ExceptionHelper;
import org.teasoft.honey.osql.core.HoneyUtil;
import org.teasoft.honey.osql.core.SessionFactory;

/**
 * @author Kingstar
 * @since  1.11
 */
public class ReturnGenId {
	
	public static void main(String[] args) {
		
		
		
		int num = 0;
		long returnId = -1L;
		Connection conn = null;
		PreparedStatement pst = null;
		boolean hasException = false;
		ResultSet rsKey=null;
		try {
			conn = SessionFactory.getConnection();
			String sql="insert into test_primary_key2 (name,remark,remark2,myid,myid2) values ('test_pk',null,'',66273430365791,123)";
			String exe_sql = HoneyUtil.deleteLastSemicolon(sql);
			pst = conn.prepareStatement(exe_sql, new String[] { "myid"});
			//mysql返回的是自增主键的值，new String[]{"id"}里，字段名随便用都可以，如用idaaa也能接收。
//			所以，想获取其它的字段就不行了。
			//oracle 就不行，主键是id，就只能用id.
			
			//Caused by: java.sql.SQLException: Column Index out of range, 2 > 1. 
//			pst = conn.prepareStatement(exe_sql, new String[] { "myid","myid2" });  //放两个字段不行
			num = pst.executeUpdate();
			
			System.out.println("num: "+num);

			rsKey = pst.getGeneratedKeys();
			rsKey.next();
			returnId = rsKey.getLong(1);
			long returnId2 = rsKey.getLong(2);
			
			System.err.println(returnId);
			System.err.println(returnId2);
		} catch (SQLException e) {
			hasException = true;
			throw ExceptionHelper.convert(e);
		} 
		
	}

}
