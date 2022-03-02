package org.teasoft.exam.bee.test;

import java.io.Serializable;

import org.teasoft.bee.osql.annotation.JoinTable;
import org.teasoft.bee.osql.annotation.JoinType;

/**
*@author Honey
*Create on 2021-07-08 22:25:17
*/
public class Noid implements Serializable {

	private static final long serialVersionUID = 1590272445571L;

	private String uuid;
	private String name;
	private int num = 2;
	private String remark;

	private char ch='a';

	@JoinTable(mainField = "uuid", subField = "uuid", joinType=JoinType.LEFT_JOIN, subAlias = "aanoid2")
	private Noid aanoid2;
	
//	@JoinTable(mainField = "uuid", subField = "uuid", joinType=JoinType.JOIN, subAlias = "Noid3")
//	private Noid noid3;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//	public Integer getNum() {
	//		return num;
	//	}
	//
	//	public void setNum(Integer num) {
	//		this.num = num;
	//	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public char getCh() {
		return ch;
	}

	public void setCh(char ch) {
		this.ch = ch;
	}

	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("Noid[");
		str.append("uuid=").append(uuid);
		str.append(",name=").append(name);
		str.append(",num=").append(num);
		str.append(",remark=").append(remark);
		str.append(",ch=").append(ch);
		str.append("]");
		return str.toString();
	}
}