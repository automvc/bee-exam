package org.teasoft.exam.bee.osql.moretable.update;

import org.teasoft.bee.osql.annotation.FK;

public class BookDetail {
	
	private Long id;
	private Long bookId; //测试oneHasOne
	private String codeId;
	private String remark;
	
//	@JoinTable
	@FK("bookDetailId")
	private BookReal bookReal;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public String getCodeId() {
		return codeId;
	}
	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public BookReal getBookReal() {
		return bookReal;
	}
	public void setBookReal(BookReal bookReal) {
		this.bookReal = bookReal;
	}
	
}
