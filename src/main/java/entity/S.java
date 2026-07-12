package entity;

import java.io.Serializable;

/**
 * @author Honey
 * Create on 2026-03-08 22:54:56
 */
public class S implements Serializable {

	private static final long serialVersionUID = 1596836248839L;

	private Integer id;
	private String sname;
	private Integer sno;
	private Integer age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Integer getSno() {
		return sno;
	}

	public void setSno(Integer sno) {
		this.sno = sno;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("S[");
		str.append("id=").append(id);
		str.append(",sname=").append(sname);
		str.append(",sno=").append(sno);
		str.append(",age=").append(age);
		str.append("]");
		return str.toString();
	}
}