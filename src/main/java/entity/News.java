package entity;

import java.io.Serializable;

public class News implements Serializable {

	private static final long serialVersionUID = 1594378276963L;

	private Integer id;
	private String name;
	private Integer fId;
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

	public Integer getfId() {
		return fId;
	}

	public void setfId(Integer fId) {
		this.fId = fId;
	}

	public String getDescStr() {
		return descStr;
	}

	public void setDescStr(String descStr) {
		this.descStr = descStr;
	}

}
