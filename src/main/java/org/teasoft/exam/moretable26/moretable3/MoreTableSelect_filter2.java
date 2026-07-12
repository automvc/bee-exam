/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.moretable26.moretable3;

import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.api.MoreTable;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.HoneyContext;
import org.teasoft.honey.osql.core.HoneyContext1;
import org.teasoft.honey.osql.core.StringConst;

import entity.City;
import entity.Province;

/**
 * 多表查询，带条件
 * @author Kingstar
 * @since  3.0.0
 */
public class MoreTableSelect_filter2 {

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		try {
			MoreTable moreTable = BeeFactory.getHoneyFactory().getMoreTable();
			
			
			Province province = new Province();
//			province.setId(1002); //主表条件
			
			City city=new City();
			city.setLevel(2);
			
			province.setCity(city);
			
			List<Province> list1 = moreTable.select(province, 0, 10); //select 查询前10条记录
			
			if (list1!=null) {
			for (int i = 0; i < list1.size(); i++) {
				Logger.info(list1.get(i).toString());
			}
			}
			
//			String ss2=HoneyContext.getSysCommStrInheritableLocal(StringConst.FunType);
			String ss2=HoneyContext1.getExtForShardingStr(StringConst.FunType);
			Logger.info(StringConst.FunType+ " value is:" +ss2);

		} catch (BeeException e) {
			e.printStackTrace();
			Logger.error("In MoreTableExam (BeeException):"+e.getMessage());
		}catch (Exception e) {
			Logger.error("In MoreTableExam (Exception):"+e.getMessage());
			e.printStackTrace();
		}
	}
}
