package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author Honey
 * Create on 2023-05-07 20:18:42
 */
public class Orderhistory implements Serializable {

	private static final long serialVersionUID = 1599000980160L;

	private Integer id;
	private String name;
	private String orderNo;
	private String seqNo;
	private BigDecimal num;
	private String numFlag;
	private String type;
	private String detail;
	private Timestamp datetime;
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

	public Timestamp getDatetime() {
		return datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}