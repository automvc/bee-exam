package entity;

import java.io.Serializable;

/**
 * @author Honey
 * Create on 2026-07-25 17:19:20
 */
public class City implements Serializable {

	private static final long serialVersionUID = 1594752893400L;

	private Long id;
	private String name;
	private Integer level;
	private String remark;
	private Integer provinceId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("City {");
		str.append("id=").append(id);
		str.append(",name=").append(name);
		str.append(",level=").append(level);
		str.append(",remark=").append(remark);
		str.append(",provinceId=").append(provinceId);
		str.append("}");
		return str.toString();
	}
}