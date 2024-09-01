package org.teasoft.exam.bee.osql.moretable.modify;

import org.teasoft.bee.osql.annotation.Entity;
import org.teasoft.bee.osql.annotation.FK;

@Entity("Book")
public class Book3 {
	
	private Long id;
	private String name;
	private String isbn;
	private String remark;
	
	@FK("bookId")
	BookDetail bookDetail;
	
//	@FK("bookDetailId")
	@FK(value= {"bookDetailId","remark"},refBy= {"id","name"})
	private BookReal bookReal;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
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
	public BookDetail getBookDetail() {
		return bookDetail;
	}
	public void setBookDetail(BookDetail bookDetail) {
		this.bookDetail = bookDetail;
	}
	public BookReal getBookReal() {
		return bookReal;
	}
	public void setBookReal(BookReal bookReal) {
		this.bookReal = bookReal;
	}
	
}
