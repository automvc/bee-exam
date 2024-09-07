package org.teasoft.exam.bee.osql.moretable.modify;

import java.util.List;

import org.teasoft.bee.osql.annotation.Column;
import org.teasoft.bee.osql.annotation.FK;
import org.teasoft.bee.osql.annotation.GenId;
import org.teasoft.bee.osql.annotation.PrimaryKey;

public class Book {
	
//	private Long id;
	@GenId
	@Column("id")
	@PrimaryKey
	private Long id2;
	private String name;
	private String isbn;
	private String remark;
	
//	@JoinTable
	@FK(value="bookId",refBy="id2")
//	@FK(value="bookId",refBy="id")
	List<BookDetail> bookDetailList;
	
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
	
	public String getName() {
		return name;
	}
	public Long getId2() {
		return id2;
	}
	public void setId2(Long id2) {
		this.id2 = id2;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public List<BookDetail> getBookDetailList() {
		return bookDetailList;
	}
	public void setBookDetailList(List<BookDetail> bookDetailList) {
		this.bookDetailList = bookDetailList;
	}

	 public String toString(){	
		 StringBuilder str=new StringBuilder();	
		 str.append("Book[");			
		 str.append("id=").append(id2);		 
		 str.append(",name=").append(name);		 
		 str.append(",remark=").append(remark);		 
		 str.append(",isbn=").append(isbn);		 
		 str.append("]");			 
		 return str.toString();			 
	 }	
}
