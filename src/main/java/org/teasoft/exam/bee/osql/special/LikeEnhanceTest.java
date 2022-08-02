/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.special;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.PreparedSql;
import org.teasoft.bee.osql.Suid;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.osql.core.CustomSql;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * V1.11及之前版本， 使用Op.like， 需要判断值是否为空字段，是否只含有匹配符(%和_)
 * <br>Op.like可以创建比左右匹配更复杂的模糊查询,但需要防止,最终的值只包含有匹配符(%和_)
 * <br>在V1.17( 1.17.0.9) 中,能明确%使用在左还是右,还是同时使用在左右, 则应该选用:likeLeft,likeRight,likeLeftRight;
 * <br>Bee框架会对这三种用法的值进行转义(匹配符%,由框架添加), 转义后值中的%(如果有),只代表符号%.
 * <br>where 条件中,不建议只使用not like一个过滤条件(结合其它条件使用则可以)
 * @author Kingstar
 * @since  1.17
 */
public class LikeEnhanceTest {

	private static PreparedSql preparedSql = BF.getPreparedSql();
	private static Suid suid = BF.getSuid();

	public static void main(String[] args) {
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("name", "");
			selectNoPage(CustomSql.getCustomSql("example.autosql.like.isNotNull"), map);
//		example.autosql.like.isNotNull=select * from orders where <if isNotNull>name like #{%name}</if>
			// name的值非null,会保留<if isNotNull></if>之前的内容,但name的值为空字符,会有注入风险,所以报错.
		} catch (Exception e) {
			e.printStackTrace();
		}

		Condition condition = null;
		List<Orders> list2 = null;
		Orders orders = new Orders();

		try {
			condition = BF.getCondition();
			condition
					// .op("1=1 -- userid", Op.like, "bee%") // test invalid field
					// .op("userid", Op.like, "bee%") //模糊查询
					.op("userid", Op.like, "%") // 模糊查询 只有%或_, 从1.17开始,Bee会抛出异常.
			// .op("userid", Op.like, "_")
			// .op("userid", Op.like, "")
			// 使用Op.like,调用方需要对传入的字符进行过滤,特别是1.17之前的版本.
			;

			list2 = suid.select(orders, condition);
			for (int i = 0; i < list2.size(); i++) {
				Logger.info(list2.get(i).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			condition = BF.getCondition();
			condition.op("userid", Op.like, "\u0025"); // like \u0025 is %
			list2 = suid.select(orders, condition);
			for (int i = 0; i < list2.size(); i++) {
				Logger.info(list2.get(i).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			condition = BF.getCondition();
			condition.op("userid", Op.like, "\u005f"); // like \u005f is _
			list2 = suid.select(orders, condition);
			for (int i = 0; i < list2.size(); i++) {
				Logger.info(list2.get(i).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			condition = BF.getCondition();
			condition.op("userid", Op.like, "\u0025\u0025"); // like \u0025 is %
			list2 = suid.select(orders, condition);
			for (int i = 0; i < list2.size(); i++) {
				Logger.info(list2.get(i).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try {
			condition = BF.getCondition();
			condition.op("userid", Op.likeLeft, ""); // likeLeft
			list2 = suid.select(orders, condition);
			for (int i = 0; i < list2.size(); i++) {
				Logger.info(list2.get(i).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			condition = BF.getCondition();
			condition.op("userid", Op.likeLeft, null); // likeLeft
			list2 = suid.select(orders, condition);
			for (int i = 0; i < list2.size(); i++) {
				Logger.info(list2.get(i).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		

//		PreparedSqlExam.java	
		PreparedSql preparedSql = BF.getPreparedSql();
		String sql3_2 = CustomSql
				.getCustomSql("osql.example.entity.selectOrdersLikeNameViaMap2"); // %name
		Map<String, Object> map2 = new HashMap<>();
//		map2.put("name", "Bee");
//		map2.put("name", ""); //1.17之前的版本,需要判断传入的值不能为空字符,%,_.
		
		
		

		// case "%"
		try {
			map2.put("name", "%");
//				map2.put("name", "_");
//				map2.put("name", null);
			preparedSql.select(sql3_2, new Orders(), map2);// map
		} catch (Exception e) {
			e.printStackTrace();
		}

		// case ""
		try {
			map2 = new HashMap<>();
			map2.put("name", ""); // 1.17之前的版本,需要判断传入的值不能为空字符,%,_.
			preparedSql.select(sql3_2, new Orders(), map2);// map
		} catch (Exception e) {
			e.printStackTrace();
		}

		// case "_"
		try {
			map2 = new HashMap<>();
			map2.put("name", "_"); // 1.17之前的版本,需要判断传入的值不能为空字符,%,_.
			preparedSql.select(sql3_2, new Orders(), map2);// map
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// case null
		//[WARN] the parameter value in like is null !
		try {
			map2 = new HashMap<>();
			map2.put("name", null); // 1.17之前的版本,需要判断传入的值不能为空字符,%,_.
			preparedSql.select(sql3_2, new Orders(), map2);// map
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("finished!");

	}

	private static void selectNoPage(String sql, Map<String, Object> map) {
		List<Orders> list3 = preparedSql.select(sql, new Orders(), map);// map
	}

}
