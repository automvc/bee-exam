/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.sharding.moretable;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.api.MoreTable;
import org.teasoft.bee.osql.api.Suid;
import org.teasoft.exam.bee.osql.moretable.entity.Assigncourse;
import org.teasoft.exam.bee.osql.moretable.entity.Assignexam;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.7
 */
public class MoreTableExam11 {

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		try {
			MoreTable moreTable = BeeFactory.getHoneyFactory().getMoreTable();
			
			
			//V1.9
			Assigncourse assigncourse=new Assigncourse();
			assigncourse.setStatus("1");
			
			Assignexam assignexam=new Assignexam(); //主表
			assignexam.setStatus("1");
			assignexam.setAssigncourse(assigncourse);
			
			moreTable.select(assignexam);
			
			assignexam.setClassno("aaa");
			moreTable.select(assignexam);

			Assigncourse assigncourse2=new Assigncourse();
			assigncourse2.setId(344343344343L);
			Suid suid = BeeFactory.getHoneyFactory().getSuid();
			suid.delete(assigncourse2);

		} catch (BeeException e) {
			e.printStackTrace();
			Logger.error("In MoreTableExam (BeeException):"+e.getMessage());
		}catch (Exception e) {
			Logger.error("In MoreTableExam (Exception):"+e.getMessage());
			e.printStackTrace();
		}
	}
}
