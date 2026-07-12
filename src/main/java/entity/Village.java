package entity;

import java.io.Serializable;

/**
 * @author Honey
 * Create on 2026-03-04 23:20:28
 */
public class Village implements Serializable {

	private static final long serialVersionUID = 1598571605825L;

	private Integer id;
	private String name;
	private Integer level;
	private String remark;
	private Integer townId;

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

	public Integer getTownId() {
		return townId;
	}

	public void setTownId(Integer townId) {
		this.townId = townId;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Village[");
		str.append("id=").append(id);
		str.append(",name=").append(name);
		str.append(",level=").append(level);
		str.append(",remark=").append(remark);
		str.append(",townId=").append(townId);
		str.append("}");
		return str.toString();
	}
}