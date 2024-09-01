package org.teasoft.exam.bee.osql.localdatetime;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author Honey
 * Create on 2024-07-06 16:12:12
 */
public class LocaldatetimeTable implements Serializable {

	private static final long serialVersionUID = 1597762704886L;

	private Integer id;
	private String name;
	private Timestamp datetime;
	private Timestamp timestamp;
	private LocalDateTime localdatetime;
	private String ext;
	private String json;

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

	public Timestamp getDatetime() {
		return datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public LocalDateTime getLocaldatetime() {
		return localdatetime;
	}

	public void setLocaldatetime(LocalDateTime localdatetime) {
		this.localdatetime = localdatetime;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	 public String toString(){	
		 StringBuilder str=new StringBuilder();	
		 str.append("LocaldatetimeTable[");			
		 str.append("id=").append(id);		 
		 str.append(",name=").append(name);		 
		 str.append(",datetime=").append(datetime);		 
		 str.append(",timestamp=").append(timestamp);		 
		 str.append(",localdatetime=").append(localdatetime);		 
		 str.append(",ext=").append(ext);		 
		 str.append(",json=").append(json);		 
		 str.append("]");			 
		 return str.toString();			 
	 }		 
}