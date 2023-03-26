package org.teasoft.exam.bee.mongodb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.teasoft.honey.osql.util.DateUtil;

public class DateTypeTest implements Serializable {

	private static final long serialVersionUID = 1596763375102L;

	private Integer id;
	private String name;
	private String orderNo;
	private String seqNo;
	private BigDecimal num;
	private String numFlag;
	private String type;
	private String detail;
	private Date date;
	private String remark;

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

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	public BigDecimal getNum() {
		return num;
	}

	public void setNum(BigDecimal num) {
		this.num = num;
	}

	public String getNumFlag() {
		return numFlag;
	}

	public void setNumFlag(String numFlag) {
		this.numFlag = numFlag;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	 public String toString(){	
		 StringBuilder str=new StringBuilder();	
		 str.append("Orderhistory[");			
		 str.append("id=").append(id);		 
		 str.append(",name=").append(name);		 
		 str.append(",orderNo=").append(orderNo);		 
		 str.append(",seqNo=").append(seqNo);		 
		 str.append(",num=").append(num);		 
		 str.append(",numFlag=").append(numFlag);		 
		 str.append(",type=").append(type);		 
		 str.append(",detail=").append(detail);		 
//		 str.append(",date=").append(date);		 
		 str.append(",date=").append(DateUtil.toDateStr(date));		 
		 str.append(",remark=").append(remark);		 
		 str.append("]");			 
		 return str.toString();			 
	 }		 
}