package org.teasoft.exam.bee.osql.moretable.insert;

import org.teasoft.bee.osql.annotation.Entity;
import org.teasoft.bee.osql.annotation.FK;
import org.teasoft.bee.osql.annotation.JoinTable;

@Entity("Book")
public class Book2 {
	
	private Long id;
	private String name;
	private String isbn;
	private String remark;
	
//	@JoinTable  //暂时放这。  要改旧逻辑，碰到FK不解析。
	@FK("bookId")
//	@FK(value="codeId",refBy="name")   //测试关系字段,不是主键;  实体设置没有设置主键值,只设置关联字段时的情形
	BookDetail bookDetail;
	
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
	
}
