package org.teasoft.exam.bee.osql.special.pgsql;

import java.io.Serializable;

import org.teasoft.bee.osql.annotation.Jsonb;
import org.teasoft.bee.osql.annotation.customizable.Json;

/**
 * @author Honey
 * Create on 2024-09-02 21:50:16
 */
public class PgType1 implements Serializable {

	private static final long serialVersionUID = 1594479219187L;

	private Integer id;
	private String name;
	@Json
	private String json1; //对应pgsql数据库的json类型
	@Jsonb
	private String jsonb2;//对应pgsql数据库的jsonb类型
	private byte[] bytea3;//对应pgsql数据库的bytea类型

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

	public String getJson1() {
		return json1;
	}

	public void setJson1(String json1) {
		this.json1 = json1;
	}

	public String getJsonb2() {
		return jsonb2;
	}

	public void setJsonb2(String jsonb2) {
		this.jsonb2 = jsonb2;
	}

	public byte[] getBytea3() {
		return bytea3;
	}

	public void setBytea3(byte[] bytea3) {
		this.bytea3 = bytea3;
	}

	 public String toString(){	
		 StringBuilder str=new StringBuilder();	
		 str.append("PgType1[");			
		 str.append("id=").append(id);		 
		 str.append(",name=").append(name);		 
		 str.append(",json1=").append(json1);		 
		 str.append(",jsonb2=").append(jsonb2);		 
		 str.append(",bytea3=").append(bytea3);		 
		 str.append("]");			 
		 return str.toString();			 
	 }		 
}