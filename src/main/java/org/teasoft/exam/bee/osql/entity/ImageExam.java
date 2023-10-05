package org.teasoft.exam.bee.osql.entity;

import java.io.InputStream;
import java.io.Serializable;

/**
 * @author Honey
 * Create on 2023-10-05 10:03:27
 */
public class ImageExam implements Serializable {

	private static final long serialVersionUID = 1596686274309L;

	private Integer id;
	private String name;
//	private Blob image;
	private InputStream image; //将InputStream存入blob
	private byte[] binary1; //存byte[]
	private byte[] binary2blob; //将byte[]存入blob

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

	public InputStream getImage() {
		return image;
	}

	public void setImage(InputStream image) {
		this.image = image;
	}

	public byte[] getBinary1() {
		return binary1;
	}

	public void setBinary1(byte[] binary1) {
		this.binary1 = binary1;
	}

	public byte[] getBinary2blob() {
		return binary2blob;
	}

	public void setBinary2blob(byte[] binary2blob) {
		this.binary2blob = binary2blob;
	}
	
}