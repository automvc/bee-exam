package entity;

import java.io.Serializable;

import org.teasoft.bee.osql.annotation.JoinTable;
import org.teasoft.bee.osql.annotation.JoinType;

/**
 * @author Honey
 * Create on 2026-02-24 19:20:21
 */
public class Province2 implements Serializable {

	private static final long serialVersionUID = 1597453602638L;

	private Integer id;
	private String name;
	private Integer level;
	private String remark;
	
//	@JoinTable3(mainField = { "id" }, subField = { "provinceId" }, joinType = JoinType.JOIN)
	@JoinTable(mainField = { "id" }, subField = { "provinceId" }, joinType = JoinType.JOIN, subClass=City.class)
	City city;

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

}