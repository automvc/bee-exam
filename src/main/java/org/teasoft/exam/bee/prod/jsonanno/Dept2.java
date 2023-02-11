package org.teasoft.exam.bee.prod.jsonanno;

import java.io.Serializable;
import java.util.List;

import org.teasoft.bee.osql.annotation.Table;
import org.teasoft.bee.osql.annotation.customizable.Json;

/**
 * @author Honey Create on 2021-10-25 21:35:58
 */
@Table("Dept")
public class Dept2 implements Serializable {

	private static final long serialVersionUID = 1599384498761L;

	private Integer id;
	private String deptName;
	
	@Json
	private JsonValue jsonValue;
	
	@Json
	private List<JsonValue> list;

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

	public List<JsonValue> getList() {
		return list;
	}

	public void setList(List<JsonValue> list) {
		this.list = list;
	}

	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("Dept[");
		str.append("id=").append(id);
		str.append(",dept=").append(deptName);
		 str.append(",jsonValue=").append(jsonValue);	
		 str.append(",list=").append(list.toString());		 
		str.append("]");
		return str.toString();
	}
}