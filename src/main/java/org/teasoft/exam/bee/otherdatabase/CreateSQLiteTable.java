package org.teasoft.exam.bee.otherdatabase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.teasoft.honey.osql.core.SessionFactory;

public class CreateSQLiteTable
{
  public static void main(String[] args)
  {
    Connection connection = null;
    try
    {
      // create a database connection
//      String url=HoneyConfig.getHoneyConfig().getUrl();
//      connection = DriverManager.getConnection(url);
    	
      connection=SessionFactory.getConnection();
      Statement statement = connection.createStatement();
      statement.setQueryTimeout(30);

      String sql="drop table if exists orders; "
      		+ " CREATE TABLE orders ("+
//    	      " id bigint(20) PRIMARY KEY NOT NULL,"+
    	      " id INTEGER PRIMARY KEY NOT NULL,"+    //INTEGER  KEY will auto increment
    	      "  userid varchar(20)  NOT NULL,"+
    	      "  name varchar(100)  DEFAULT NULL,"+
    	      "  total decimal(10,2) NOT NULL,"+
    	      "  createtime timestamp NULL DEFAULT CURRENT_TIMESTAMP,"+
    	      "  remark varchar(255)  DEFAULT NULL,"+
    	      "  sequence varchar(30)  DEFAULT NULL,"+
    	      "  abc varchar(20) DEFAULT NULL,"+
    	      "  updatetime datetime NULL DEFAULT CURRENT_TIMESTAMP"+
    	      ") ";
      
      statement.executeUpdate(sql);
      
      statement.executeUpdate(sql.replace(" orders", " orders_202007"));
      
      String sql2=" DROP TABLE IF EXISTS test_user;"+
      " CREATE TABLE test_user ("+
      "   id INTEGER PRIMARY KEY NOT NULL,"+
      "   email varchar(100)  DEFAULT NULL,"+
      "   last_name varchar(60)  DEFAULT NULL,"+
      "   name varchar(60)  DEFAULT NULL,"+
      "   password varchar(60)  DEFAULT NULL,"+
      "   username varchar(60)  NOT NULL,"+
      "   createtime timestamp NULL DEFAULT CURRENT_TIMESTAMP"+
      " );";
      
      statement.executeUpdate(sql2);
      String sql3=  " DROP TABLE IF EXISTS leaf_alloc;"+
      " CREATE TABLE leaf_alloc ("+
      "   id INTEGER PRIMARY KEY NOT NULL,"+
      "   biz_tag varchar(128)  NOT NULL DEFAULT '' UNIQUE,"+
      "   max_id bigint(20) NOT NULL DEFAULT '1',"+
      "   step int(11) NOT NULL,"+
      "   description varchar(256)  DEFAULT NULL,"+
      "   update_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,"+
      "   version int(11) DEFAULT NULL"+
      " ) ;";
      
      statement.executeUpdate(sql3);
      
      statement.executeUpdate(sql3.replace(" leaf_alloc", " leaf_alloc2"));
      
      System.out.println("Create SQLite tables finished.");
      
    }catch (SQLException e) {
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