///*
// * Copyright 2020-2025 the original author.All rights reserved.
// * Kingstar(honeysoft@126.com)
// * The license,see the LICENSE file.
// */
//
//package entity;
//
//import java.util.List;
//
//import org.teasoft.bee.osql.annotation.JoinType;
//import org.teasoft.bee.osql.api.MoreTable;
//import org.teasoft.beex.json.JacksonJsonUtil;
//import org.teasoft.honey.logging.Logger;
//import org.teasoft.honey.osql.shortcut.BF;
//
//
//public class MoreTableExample {
//	public static void main(String[] args) {
//		MoreTable moreTable = BF.getMoreTable();
//		Province province = new Province();
//		List<Province> list1 = moreTable.select(province, 0, 10); // 查询前10条记录
//		if (list1 != null) {
//			for (int i = 0; i < list1.size(); i++)
//				Logger.info(JacksonJsonUtil.toJson(list1.get(i)));
//		}
//	}
//}
//
//class Province {
//	private Integer id;
//	private String name;
//	private Integer level;
//	private String remark;
//	@JoinTable(mainField = { "id" }, subField = { "provinceId" }, joinType = JoinType.JOIN)
//	private List<City> listCity;
//	@JoinTable(mainField = { "id" }, subField = { "provinceId" }, joinType = JoinType.LEFT_JOIN)
//	// 要用LEFT_JOIN,不然会影响到下一个关联子表listCity
//	ProvinceHistory provinceHistory; // 省历史表
//	@JoinTable(mainField = { "id" }, subField = { "fId" }, joinType = JoinType.LEFT_JOIN)
//	private News news;// 新闻表
//	// 省略get,set
//}
//
//class City {
//	private Integer id;
//	private String name;
//	private Integer level;
//	private String remark;
//	private Integer provinceId;
//	@JoinTable(mainField = { "id" }, subField = { "cityId" }, joinType = JoinType.JOIN, subClass = Town.class)
//	private Town town;
//	// 省略get,set
//}
//
//class Town {
//	private Integer id;
//	private String name;
//	private Integer level;
//	private String remark;
//	private Integer cityId;
//	@JoinTable(mainField = { "id" }, subField = { "townId" }, joinType = JoinType.JOIN)
//	private List<Village> listVillage;
//	// 省略get,set
//}
//
//class Village {
//	private Integer id;
//	private String name;
//	private Integer level;
//	private String remark;
//	private Integer townId;
//	@JoinTable(mainField = { "id" }, subField = { "villageId" }, joinType = JoinType.JOIN)
//	private Road road;
//	// 省略get,set
//}
