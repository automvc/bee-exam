package org.teasoft.exam.cassandra;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.teasoft.bee.osql.annotation.PrimaryKey;
import org.teasoft.bee.osql.annotation.Table;

/**
*@author Honey
*Create on 2022-03-14 01:30:30
*/
@Table("store.cassandra_table")
public class CassandraTable implements Serializable {

	private static final long serialVersionUID = 1595962860925L;

//	@PrimaryKey
	private Long id;
	private Float f10Float;
	private String f11Inet;
	private Integer f12Int;
	private Short f13Smallint;
	private String f14Text;
	private Time f15Time;
	private Timestamp f16Timestamp;
	private java.util.UUID f17Timeuuid;
	private Byte f18Tinyint;
	private java.util.UUID f19Uuid;
	private String f1Ascii;
	private String f20Varchar;
	private Integer f21Varint;
//	private List f22List;
	private List<Integer> f22List;
//	private List<Phone> f22List;
	private Set f23Set;
//	private Map<String,Integer> f24Map;
	private Map<String,Long> f24Map;
//	private Map<Integer,String> f24Map;
//	private Map<String,Map<Integer,String>> f24Map;
//	private Map<Integer,Phone> f24Map;
	private Long f2Bigint;
	private Blob f3Blob;
	private Boolean f4Boolean;
	private Date f6Date;
	private BigDecimal f7Decimal;
	private Double f8Double;
	private String f9Duration;

//	public Long getF0Id() {
//		return f0Id;
//	}
//
//	public void setF0Id(Long f0Id) {
//		this.f0Id = f0Id;
//	}
	
	public Float getF10Float() {
		return f10Float;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setF10Float(Float f10Float) {
		this.f10Float = f10Float;
	}

	public String getF11Inet() {
		return f11Inet;
	}

	public void setF11Inet(String f11Inet) {
		this.f11Inet = f11Inet;
	}

	public Integer getF12Int() {
		return f12Int;
	}

	public void setF12Int(Integer f12Int) {
		this.f12Int = f12Int;
	}

	public Short getF13Smallint() {
		return f13Smallint;
	}

	public void setF13Smallint(Short f13Smallint) {
		this.f13Smallint = f13Smallint;
	}

	public String getF14Text() {
		return f14Text;
	}

	public void setF14Text(String f14Text) {
		this.f14Text = f14Text;
	}

	public Time getF15Time() {
		return f15Time;
	}

	public void setF15Time(Time f15Time) {
		this.f15Time = f15Time;
	}

	public Timestamp getF16Timestamp() {
		return f16Timestamp;
	}

	public void setF16Timestamp(Timestamp f16Timestamp) {
		this.f16Timestamp = f16Timestamp;
	}

	public java.util.UUID getF17Timeuuid() {
		return f17Timeuuid;
	}

	public void setF17Timeuuid(java.util.UUID f17Timeuuid) {
		this.f17Timeuuid = f17Timeuuid;
	}

	public Byte getF18Tinyint() {
		return f18Tinyint;
	}

	public void setF18Tinyint(Byte f18Tinyint) {
		this.f18Tinyint = f18Tinyint;
	}

	public java.util.UUID getF19Uuid() {
		return f19Uuid;
	}

	public void setF19Uuid(java.util.UUID f19Uuid) {
		this.f19Uuid = f19Uuid;
	}

	public String getF1Ascii() {
		return f1Ascii;
	}

	public void setF1Ascii(String f1Ascii) {
		this.f1Ascii = f1Ascii;
	}

	public String getF20Varchar() {
		return f20Varchar;
	}

	public void setF20Varchar(String f20Varchar) {
		this.f20Varchar = f20Varchar;
	}

	public Integer getF21Varint() {
		return f21Varint;
	}

	public void setF21Varint(Integer f21Varint) {
		this.f21Varint = f21Varint;
	}

	public List getF22List() {
		return f22List;
	}

	public void setF22List(List f22List) {
		this.f22List = f22List;
	}

	public Set getF23Set() {
		return f23Set;
	}

	public void setF23Set(Set f23Set) {
		this.f23Set = f23Set;
	}

	public Map getF24Map() {
		return f24Map;
	}

	public void setF24Map(Map f24Map) {
		this.f24Map = f24Map;
	}

	public Long getF2Bigint() {
		return f2Bigint;
	}

	public void setF2Bigint(Long f2Bigint) {
		this.f2Bigint = f2Bigint;
	}

	public Blob getF3Blob() {
		return f3Blob;
	}

	public void setF3Blob(Blob f3Blob) {
		this.f3Blob = f3Blob;
	}

	public Boolean getF4Boolean() {
		return f4Boolean;
	}

	public void setF4Boolean(Boolean f4Boolean) {
		this.f4Boolean = f4Boolean;
	}

	public Date getF6Date() {
		return f6Date;
	}

	public void setF6Date(Date f6Date) {
		this.f6Date = f6Date;
	}

	public BigDecimal getF7Decimal() {
		return f7Decimal;
	}

	public void setF7Decimal(BigDecimal f7Decimal) {
		this.f7Decimal = f7Decimal;
	}

	public Double getF8Double() {
		return f8Double;
	}

	public void setF8Double(Double f8Double) {
		this.f8Double = f8Double;
	}

	public String getF9Duration() {
		return f9Duration;
	}

	public void setF9Duration(String f9Duration) {
		this.f9Duration = f9Duration;
	}

	 public String toString(){	
		 StringBuffer str=new StringBuffer();	
		 str.append("CassandraTable[");			
		 str.append("id=").append(id);		 
		 str.append(",f10Float=").append(f10Float);		 
		 str.append(",f11Inet=").append(f11Inet);		 
		 str.append(",f12Int=").append(f12Int);		 
		 str.append(",f13Smallint=").append(f13Smallint);		 
		 str.append(",f14Text=").append(f14Text);		 
		 str.append(",f15Time=").append(f15Time);		 
		 str.append(",f16Timestamp=").append(f16Timestamp);		 
		 str.append(",f17Timeuuid=").append(f17Timeuuid);		 
		 str.append(",f18Tinyint=").append(f18Tinyint);		 
		 str.append(",f19Uuid=").append(f19Uuid);		 
		 str.append(",f1Ascii=").append(f1Ascii);		 
		 str.append(",f20Varchar=").append(f20Varchar);		 
		 str.append(",f21Varint=").append(f21Varint);		 
		 str.append(",f22List=").append(f22List);		 
		 str.append(",f23Set=").append(f23Set);		 
		 str.append(",f24Map=").append(f24Map);		 
		 str.append(",f2Bigint=").append(f2Bigint);		 
		 str.append(",f3Blob=").append(f3Blob);		 
		 str.append(",f4Boolean=").append(f4Boolean);		 
		 str.append(",f6Date=").append(f6Date);		 
		 str.append(",f7Decimal=").append(f7Decimal);		 
		 str.append(",f8Double=").append(f8Double);		 
		 str.append(",f9Duration=").append(f9Duration);		 
		 str.append("]");			 
		 return str.toString();			 
	 }		 
}