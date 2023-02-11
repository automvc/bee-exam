package org.teasoft.exam.bee.prod.jsonanno.moretable;

import java.io.Serializable;

import org.teasoft.bee.osql.annotation.customizable.Json;


/**
*@author Honey
*Create on 2021-10-25 21:35:58
*/
public class Dept implements Serializable {

	private static final long serialVersionUID = 1599384498761L;

	private Integer id;
	private String deptName;
	@Json
	private JsonValue jsonValue;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public JsonValue getJsonValue() {
		return jsonValue;
	}

	public void setJsonValue(JsonValue jsonValue) {
		this.jsonValue = jsonValue;
	}	

//	public String getJsonValue() {
//		return jsonValue;
//	}
//
//	public void setJsonValue(String jsonValue) {
//		this.jsonValue = jsonValue;
//	}
	
	 public String toString(){	
		 StringBuffer str=new StringBuffer();	
		 str.append("Dept[");			
		 str.append("id=").append(id);		 
		 str.append(",dept=").append(deptName);		 
		 if(jsonValue!=null) str.append(",jsonValue=").append(jsonValue.toString());		 
		 str.append("]");			 
		 return str.toString();			 
	 }
}