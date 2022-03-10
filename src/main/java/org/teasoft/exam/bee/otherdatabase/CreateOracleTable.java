package org.teasoft.exam.bee.otherdatabase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.teasoft.exam.bee.osql.entity.Scores;
import org.teasoft.exam.bee.osql.entity.dynamic.LeafAlloc3;
import org.teasoft.exam.bee.osql.moretable.entity.Assigncourse;
import org.teasoft.exam.bee.osql.moretable.entity.Assignexam;
import org.teasoft.honey.osql.autogen.Ddl;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.core.SessionFactory;

public class CreateOracleTable {
	public static void main(String[] args) {
		Connection connection = null;
		try {
    	
          connection=SessionFactory.getConnection();
          Statement statement = connection.createStatement();
      
          String sql=""
      		+ " CREATE TABLE orders ("+
    	      " id number(18) primary key,"+  
    	      "  userid varchar2(20)  NOT NULL,"+
    	      "  name varchar2(60) ,"+
    	      "  total number(12,2) NOT NULL,"+
    	      "  sequence varchar2(60)  ,"+
    	      "  abc varchar2(20) ,"+
    	      "  remark varchar2(255) ,"+
    	      "  createtime varchar2(24) ,"+
    	      "  updatetime varchar2(24)"+
    	      ") ";   
      
      
			String sql0 = "drop table orders";
			try {
				statement.executeUpdate(sql0);
			} catch (Exception e) {
				Logger.info(e.getMessage());
			}
			try {
				statement.executeUpdate(sql0.replace(" orders", " orders_202007"));
			} catch (Exception e) {
				Logger.info(e.getMessage());
			}

			statement.executeUpdate(sql);
			statement.executeUpdate(sql.replace(" orders", " orders_202007"));
      
			String sql2=""+
            " CREATE TABLE test_user ("+
            "   id number(18) primary key,"+
            "   email varchar(100)  DEFAULT NULL,"+
            "   last_name varchar(60)  DEFAULT NULL,"+
            "   name varchar(60)  DEFAULT NULL,"+
            "   password varchar(60)  DEFAULT NULL,"+
            "   username varchar(60)  NOT NULL,"+
            "   createtime varchar2(24) "+
            " )";
      
			try {
				String sql20 = "drop table test_user";
				statement.executeUpdate(sql20);
			} catch (Exception e) {
				Logger.info(e.getMessage());
			}
			
			statement.executeUpdate(sql2);

      
//         String sql3=  ""+
//           " CREATE TABLE leaf_alloc ("+
//           "   id number(18) primary key,"+
//           "   biz_tag varchar(128) ,"+
//           "   max_id number(20) ,"+
//           "   step number(11),"+
//           "   description varchar(256) ,"+
//           "   updatetime varchar2(24),"+
//           "   version number(11) "+
//           " ) ";
//      
//            
//            String sql30 = "drop table leaf_alloc";
//			try {
//				statement.executeUpdate(sql30);
//			} catch (Exception e) {
//				Logger.info(e.getMessage());
//			}
//			try {
//				statement.executeUpdate(sql30.replace(" leaf_alloc", " leaf_alloc2"));
//			} catch (Exception e) {
//				Logger.info(e.getMessage());
//			}
//
//			statement.executeUpdate(sql3);
//			statement.executeUpdate(sql3.replace(" leaf_alloc", " leaf_alloc2"));
			
			
			boolean f=Ddl.createTable(new Scores(),true);
			
//			Ddl.setDynamicParameter("version", ""); //default
			boolean f2=Ddl.createTable(new LeafAlloc3(),true);
			
			Ddl.setDynamicParameter("version", "2");
			boolean f3=Ddl.createTable(new LeafAlloc3(),true);
			
			Ddl.createTable(new Assignexam(),true);
			Ddl.createTable(new Assigncourse(),true);
			

			System.out.println("Create Oracle tables finished.");

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (connection != null) connection.close();
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
	}
}