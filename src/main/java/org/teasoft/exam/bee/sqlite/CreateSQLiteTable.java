package org.teasoft.exam.bee.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.teasoft.honey.osql.core.HoneyConfig;

public class CreateSQLiteTable
{
  public static void main(String[] args)
  {
    Connection connection = null;
    try
    {
      // create a database connection
      String url=HoneyConfig.getHoneyConfig().getUrl();
      connection = DriverManager.getConnection(url);
      Statement statement = connection.createStatement();
      statement.setQueryTimeout(30);

      statement.executeUpdate("drop table if exists orders");
      
      String sql="CREATE TABLE orders ("+
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
      
      String sql2=" DROP TABLE IF EXISTS user;"+
      " CREATE TABLE user ("+
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
      
      System.out.println("SQLite create table finished.");
      
    }
    catch(SQLException e)
    {
      System.err.println(e.getMessage());
    }
    finally
    {
      try
      {
        if(connection != null)
          connection.close();
      }
      catch(SQLException e)
      {
        System.err.println(e.getMessage());
      }
    }
  }
}