package org.teasoft.exam.bee.mongodb.json.entity;

import java.io.Serializable;

import org.teasoft.bee.osql.annotation.GenId;
import org.teasoft.bee.osql.annotation.customizable.Json;

/**
 * @author Honey
 * Create on 2023-02-06 16:11:47
 */
public class Inventory implements Serializable {

	private static final long serialVersionUID = 1591751904042L;

	@GenId
	private String id;
	private String item;
	private Integer qty;
	@Json
	private Size size;
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

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		 
				String a="Inventory [id=" + id + ", item=" + item + ", qty=" + qty ;
				if(size!=null) a += ", size=" + size.toString() ;
				else  a += ", size=null";
				a += ", status=" + status;
						a += "]";
				
				return a;
	}
	
	

}