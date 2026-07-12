/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.moretable26.moretable3.selectlist.layer3;

import java.util.ArrayList;
import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.api.MoreTable;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.BeeFactory;

/**
 * 多表查询，带条件
 * @author Kingstar
 * @since  3.0.0
 */
public class MoreTableSelect_list_filter3_layer3 {

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		try {
			MoreTable moreTable = BeeFactory.getHoneyFactory().getMoreTable();
			
			
			Province province = new Province();
//			province.setId(1002);
			
			//只从表有值
			City city=new City();
//			city.setId(2002);
			city.setLevel(2);
			List<City> cityList=new ArrayList<>();
			cityList.add(city);	
			
			province.setListCity(cityList);
			
			
			List<Province> list1 = moreTable.select(province, 0, 10); //select 查询前10条记录
			
			if (list1!=null) {
			for (int i = 0; i < list1.size(); i++) {
				Logger.info(list1.get(i).toString());
			}
			}
			

		} catch (BeeException e) {
			e.printStackTrace();
			Logger.error("In MoreTableExam (BeeException):"+e.getMessage());
		}catch (Exception e) {
			Logger.error("In MoreTableExam (Exception):"+e.getMessage());
			e.printStackTrace();
		}
	}
}
