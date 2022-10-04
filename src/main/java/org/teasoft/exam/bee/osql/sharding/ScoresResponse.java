/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.sharding;

import java.io.Serializable;

import org.teasoft.bee.osql.annotation.Sharding;
import org.teasoft.bee.osql.annotation.Table;

/**
 * @author Kingstar
 * @since  2.0
 */
@Table("Scores")
public class ScoresResponse  implements Serializable {

	private static final long serialVersionUID = 1593489256055L;
	
	//the field name same as Scores
	@Sharding(appointDS="ds0",tabRule = "classno %2")
    private String classno;
    private String term;
    private String examno;
    private String subject;
    private Double score;
    
    //the field name define in Condition
    private Double maxScore;
    private Double avgScore;
    private Double minScore;
    
    
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public Double getMaxScore() {
		return maxScore;
	}
	public void setMaxScore(Double maxScore) {
		this.maxScore = maxScore;
	}
	public Double getAvgScore() {
		return avgScore;
	}
	public void setAvgScore(Double avgScore) {
		this.avgScore = avgScore;
	}
	public Double getMinScore() {
		return minScore;
	}
	public void setMinScore(Double minScore) {
		this.minScore = minScore;
	}
	
	
	public String toString(){	
		 StringBuffer str=new StringBuffer();	
		 str.append("ScoresResponse[");
		 str.append("classno=").append(classno);
		 str.append(",term=").append(term);
		 str.append(",examno=").append(examno);
		 str.append(",subject=").append(subject);
		 str.append(",score=").append(score);
		 str.append(",maxScore=").append(maxScore);
		 str.append(",avgScore=").append(avgScore);
		 str.append(",minScore=").append(minScore);
		 str.append("]");			 
		 return str.toString();	
	 }

}
