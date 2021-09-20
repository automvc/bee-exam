package org.teasoft.exam.bee.osql.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.sql.Date;

/**
*@author Honey
*Create on 2021-07-08 22:16:25
*/
public class Testnum implements Serializable {

	private static final long serialVersionUID = 1593131133708L;

	private String id;
	private String name;
	private String ext;
	private Timestamp datetime;
	private Date date;
	private Timestamp tstamp;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public Timestamp getDatetime() {
		return datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Timestamp getTstamp() {
		return tstamp;
	}

	public void setTstamp(Timestamp tstamp) {
		this.tstamp = tstamp;
	}

	 public String toString(){	
		 StringBuffer str=new StringBuffer();	
		 str.append("Testnum[");			
		 str.append("id=").append(id);		 
		 str.append(",name=").append(name);		 
		 str.append(",ext=").append(ext);		 
		 str.append(",datetime=").append(datetime);		 
		 str.append(",date=").append(date);		 
		 str.append(",tstamp=").append(tstamp);		 
		 str.append("]");			 
		 return str.toString();			 
	 }		 
}