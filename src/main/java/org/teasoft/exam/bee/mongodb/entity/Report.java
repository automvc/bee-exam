package org.teasoft.exam.bee.mongodb.entity;

import java.io.Serializable;

import org.teasoft.bee.osql.annotation.GenId;
import org.teasoft.bee.osql.annotation.Table;

@Table("Report")
public class Report implements Serializable {

	private static final long serialVersionUID = 1592194205331L;

	@GenId
	private String id;
	
	private java.util.Date reportDate;
	private String reportId;
	private String reportWriterName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public java.util.Date getReportDate() {
		return reportDate;
	}
	public void setReportDate(java.util.Date reportDate) {
		this.reportDate = reportDate;
	}
	public String getReportId() {
		return reportId;
	}
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}
	public String getReportWriterName() {
		return reportWriterName;
	}
	public void setReportWriterName(String reportWriterName) {
		this.reportWriterName = reportWriterName;
	}
	

}