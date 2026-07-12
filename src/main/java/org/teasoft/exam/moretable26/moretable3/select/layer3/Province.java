package org.teasoft.exam.moretable26.moretable3.select.layer3;

import java.io.Serializable;

import org.teasoft.bee.osql.annotation.JoinTable;
import org.teasoft.bee.osql.annotation.JoinType;

/**
 * @author Honey
 * Create on 2026-02-25 22:25:22
 */
public class Province implements Serializable {

	private static final long serialVersionUID = 1597409278693L;

	private Integer id;
	private String name;
	private Integer level;
	private String remark;
	
//	@JoinTable3(mainField = { "id" }, subField = { "provinceId" }, joinType = JoinType.JOIN)
	@JoinTable(mainField = { "id" }, subField = { "provinceId" }, joinType = JoinType.JOIN, subClass=City.class)
	private City city;

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

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Province[");
		str.append("id=").append(id);
		str.append(",name=").append(name);
		str.append(",level=").append(level);
		str.append(",remark=").append(remark);
		if(city!=null)
		 str.append(",city={").append(city.toString()+"}");
		str.append("}");
		return str.toString();
	}
}