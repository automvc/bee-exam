package entity;

import java.io.Serializable;

/**
 * @author Honey
 * Create on 2025-06-29 23:29:45
 */
public class KeyWord implements Serializable {

	private static final long serialVersionUID = 1598034981721L;

	private Long id;
	private String name;
	private String key;
	private String comment;

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

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}