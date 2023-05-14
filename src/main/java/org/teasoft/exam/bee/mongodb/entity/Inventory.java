package org.teasoft.exam.bee.mongodb.entity;

import java.io.Serializable;

/**
 * @author Honey
 * Create on 2023-04-26 17:19:44
 */
public class Inventory implements Serializable {

	private static final long serialVersionUID = 1592721204250L;

	private String id;
	private String item;
	private Integer qty;
	private String size;
	private String status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}