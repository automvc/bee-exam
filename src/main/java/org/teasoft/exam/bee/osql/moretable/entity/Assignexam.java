/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(aiteasoft@163.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.moretable.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import org.teasoft.bee.osql.annotation.JoinTable;
import org.teasoft.bee.osql.annotation.JoinType;

/**
 * @author AiTeaSoft.com
 * @since  1.1
 * Create on 2021-01-19 09:24:22
 */
public class Assignexam implements Serializable {

	private static final long serialVersionUID = 1593279039448L;
	
    private Long id;
    private String classno;
    private String term;
    private String examno;
    private String subjectno;
    private String subject;
    private String creater;
    private Timestamp createtime;
    private String updater;
    private Timestamp updatetime;
    private String remark;
    private String ext1;
    private String status;
    private String schoolno;
    
    @JoinTable(mainField="classno,term,subjectno", subField="classno,term,subjectno", joinType=JoinType.JOIN)
    private Assigncourse assigncourse;

    public Long getId() {
	    return id;
    }

    public void setId(Long id) {
	    this.id = id;
    }
    
    public String getClassno() {
	    return classno;
    }

    public void setClassno(String classno) {
	    this.classno = classno;
    }
    
    public String getTerm() {
	    return term;
    }

    public void setTerm(String term) {
	    this.term = term;
    }
    
    public String getExamno() {
	    return examno;
    }

    public void setExamno(String examno) {
	    this.examno = examno;
    }
    
    public String getSubjectno() {
	    return subjectno;
    }

    public void setSubjectno(String subjectno) {
	    this.subjectno = subjectno;
    }
    
    public String getSubject() {
	    return subject;
    }

    public void setSubject(String subject) {
	    this.subject = subject;
    }
    
    public String getCreater() {
	    return creater;
    }

    public void setCreater(String creater) {
	    this.creater = creater;
    }
    
    public Timestamp getCreatetime() {
	    return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
	    this.createtime = createtime;
    }
    
    public String getUpdater() {
	    return updater;
    }

    public void setUpdater(String updater) {
	    this.updater = updater;
    }
    
    public Timestamp getUpdatetime() {
	    return updatetime;
    }

    public void setUpdatetime(Timestamp updatetime) {
	    this.updatetime = updatetime;
    }
    
    public String getRemark() {
	    return remark;
    }

    public void setRemark(String remark) {
	    this.remark = remark;
    }
    
    public String getExt1() {
	    return ext1;
    }

    public void setExt1(String ext1) {
	    this.ext1 = ext1;
    }
    
    public String getStatus() {
	    return status;
    }

    public void setStatus(String status) {
	    this.status = status;
    }
    
    public String getSchoolno() {
	    return schoolno;
    }

    public void setSchoolno(String schoolno) {
	    this.schoolno = schoolno;
    }
    
	 public Assigncourse getAssigncourse() {
		return assigncourse;
	}

	public void setAssigncourse(Assigncourse assigncourse) {
		this.assigncourse = assigncourse;
	}

	public String toString(){	
		 StringBuffer str=new StringBuffer();	
		 str.append("Assignexam[");
		 str.append("id=").append(id);
		 str.append(",classno=").append(classno);
		 str.append(",term=").append(term);
		 str.append(",examno=").append(examno);
		 str.append(",subjectno=").append(subjectno);
		 str.append(",subject=").append(subject);
		 str.append(",creater=").append(creater);
		 str.append(",createtime=").append(createtime);
		 str.append(",updater=").append(updater);
		 str.append(",updatetime=").append(updatetime);
		 str.append(",remark=").append(remark);
		 str.append(",ext1=").append(ext1);
		 str.append(",status=").append(status);
		 str.append(",schoolno=").append(schoolno);
		 
		 if(assigncourse==null)
			 str.append(",assigncourse").append("=null");	
		 else 
		   str.append(",").append(assigncourse.toString());
		 
		 str.append("]");			 
		 return str.toString();	
	 }
}