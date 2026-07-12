package entity;

import java.io.Serializable;

/**
 * @author Honey
 * Create on 2024-12-13 22:21:44
 */
public class TyteTable implements Serializable {

	private static final long serialVersionUID = 1590181053881L;

	private Boolean yesorno;
	private Integer id;
	private String name;
	private Boolean bit2;
	private Byte tiny;

	public Boolean getYesorno() {
		return yesorno;
	}

	public void setYesorno(Boolean yesorno) {
		this.yesorno = yesorno;
	}

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

	public Boolean getBit2() {
		return bit2;
	}

	public void setBit2(Boolean bit2) {
		this.bit2 = bit2;
	}

	public Byte getTiny() {
		return tiny;
	}

	public void setTiny(Byte tiny) {
		this.tiny = tiny;
	}

}