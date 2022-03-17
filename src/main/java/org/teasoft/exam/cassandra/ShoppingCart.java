package org.teasoft.exam.cassandra;

import java.io.Serializable;
import java.sql.Timestamp;

import org.teasoft.bee.osql.annotation.Table;


/**
*@author Honey
*Create on 2022-03-13 22:31:33
*/
//@Table("store.shopping_cart")
public class ShoppingCart implements Serializable {

	private static final long serialVersionUID = 1597318311458L;

	private String userid;
	private Integer itemCount;
	private Timestamp lastUpdateTimestamp;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Integer getItemCount() {
		return itemCount;
	}

	public void setItemCount(Integer itemCount) {
		this.itemCount = itemCount;
	}

	public Timestamp getLastUpdateTimestamp() {
		return lastUpdateTimestamp;
	}

	public void setLastUpdateTimestamp(Timestamp lastUpdateTimestamp) {
		this.lastUpdateTimestamp = lastUpdateTimestamp;
	}

	 public String toString(){	
		 StringBuffer str=new StringBuffer();	
		 str.append("ShoppingCart[");			
		 str.append("userid=").append(userid);		 
		 str.append(",itemCount=").append(itemCount);		 
		 str.append(",lastUpdateTimestamp=").append(lastUpdateTimestamp);		 
		 str.append("]");			 
		 return str.toString();			 
	 }		 
}