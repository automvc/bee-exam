package entity;

import java.io.Serializable;

/**
 * @author Honey
 * Create on 2026-03-08 07:41:51
 */
public class ProvinceHistory implements Serializable {

	private static final long serialVersionUID = 1594378276962L;

	private Integer id;
	private String name;
	private Integer provinceId;
	private String descStr;

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

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public String getDescStr() {
		return descStr;
	}

	public void setDescStr(String descStr) {
		this.descStr = descStr;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("ProvinceHistory[");
		str.append("id=").append(id);
		str.append(",name=").append(name);
		str.append(",provinceId=").append(provinceId);
		str.append(",descStr=").append(descStr);
		str.append("}");
		return str.toString();
	}
}