package org.teasoft.exam.bee.mongodb.json.entity;

import java.io.Serializable;

/**
 * @author Honey
 * Create on 2023-02-11 14:37:05
 */
public class Dept implements Serializable {

	private static final long serialVersionUID = 1596645748464L;

	private Integer id;
	private String deptName;
	private String jsonValue;
	private String list;
	private String one;

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

	public String getJsonValue() {
		return jsonValue;
	}

	public void setJsonValue(String jsonValue) {
		this.jsonValue = jsonValue;
	}

	public String getList() {
		return list;
	}

	public void setList(String list) {
		this.list = list;
	}

	public String getOne() {
		return one;
	}

	public void setOne(String one) {
		this.one = one;
	}

	@Override
	public String toString() {
		return "Dept [id=" + id + ", deptName=" + deptName + ", jsonValue=" + jsonValue
				+ ", list=" + list + ", one=" + one + "]";
	}

}