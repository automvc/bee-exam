/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.moretable3.moretable3select5.whereJoin;

import java.io.Serializable;
import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.annotation.JoinTable;
import org.teasoft.bee.osql.annotation.JoinType;
import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.MoreTable;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * 多表查询，无join条件,自定义在where部分写
 * 
 * @author Kingstar
 * @since 3.0.0
 */
public class MoreTableSelect_list_filter5_wherejoin {

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		try {
			MoreTable moreTable = BeeFactory.getHoneyFactory().getMoreTable();

			S s = new S();
			
			Condition condition=BF.getCondition();
			 condition.selectField("x.sname");
    	    condition.op("y.sname",Op.eq,"WANG");
    	    condition.opWithField("x.sno", Op.gt, "y.sno");
    	    condition.opWithField("x.age", Op.lt, "y.age");

			List<S> list1 = moreTable.select(s,condition); 

			if (list1 != null) {
				for (int i = 0; i < list1.size(); i++) {
					Logger.info(list1.get(i).toString());
				}
			}

		} catch (BeeException e) {
			e.printStackTrace();
			Logger.error("In MoreTableExam (BeeException):" + e.getMessage());
		} catch (Exception e) {
			Logger.error("In MoreTableExam (Exception):" + e.getMessage());
			e.printStackTrace();
		}
	}
}

class S implements Serializable {

	private static final long serialVersionUID = 1596836248839L;

	private Integer id;
	private String sname;
	private Integer sno;
	private Integer age;
	
//    sub_alias='y',
//    main_alias='x'
	
	@JoinTable(mainField = {}, subField = {}, joinType = JoinType.WHERE, subAlias = "y", mainAlias = "x")
	private S x;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Integer getSno() {
		return sno;
	}

	public void setSno(Integer sno) {
		this.sno = sno;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("S[");
		str.append("id=").append(id);
		str.append(",sname=").append(sname);
		str.append(",sno=").append(sno);
		str.append(",age=").append(age);
		str.append("]");
		return str.toString();
	}
}
