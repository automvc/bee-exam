package org.teasoft.exam.moretable26.moretable3.select.layer3;

import java.io.Serializable;
import java.util.List;

import org.teasoft.bee.osql.annotation.JoinTable;
import org.teasoft.bee.osql.annotation.JoinType;

/**
 * @author Honey
 * Create on 2026-02-25 22:25:22
 */
public class City implements Serializable {

	private static final long serialVersionUID = 1592879680416L;

	private Integer id;
	private String name;
	private Integer level;
	private String remark;
	private Integer provinceId;
	
	@JoinTable(mainField = { "id" }, subField = { "cityId" }, joinType = JoinType.JOIN, subClass=Town.class)
//	private List<Town> listTown;
	private Town town;

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

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	
	public Town getTown() {
		return town;
	}

	public void setTown(Town town) {
		this.town = town;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("City[");
		str.append("id=").append(id);
		str.append(",name=").append(name);
		str.append(",level=").append(level);
		str.append(",remark=").append(remark);
		str.append(",provinceId=").append(provinceId);
		
		if (getTown() != null)
			str.append(", town=").append(town.toString());
		
		str.append("}");
		return str.toString();
	}
}