//package org.teasoft.exam.moretable3.moretable3select5._1_n11_1_n_1;
//
//import java.util.List;
//
//import org.teasoft.bee.osql.annotation.JoinTable3;
//import org.teasoft.bee.osql.annotation.JoinType;
//import org.teasoft.bee.osql.api.MoreTable;
//import org.teasoft.beex.json.JacksonJsonUtil;
//import org.teasoft.honey.logging.Logger;
//import org.teasoft.honey.osql.shortcut.BF;
//
//import entity.News;
//import entity.ProvinceHistory;
//
///**
// * 多表查询，1_n11_1_n_1
// */
//public class MoreTableSelect_list_filter5_1_n11_1_n_1_ZL {
//	public static void main(String[] args) {
//		MoreTable moreTable = BF.getMoreTable();
//		Province province = new Province();
//		List<Province> list1 = moreTable.select(province, 0, 10); //查询前10条记录
//		if (list1 != null) {
//			for (int i = 0; i < list1.size(); i++)
//				Logger.info(JacksonJsonUtil.toJson(list1.get(i)));
//		}
//	}
//}
//class Province {
//	private Integer id;
//	private String name;
//	private Integer level;
//	private String remark;
//	@JoinTable3(mainField = { "id" }, subField = { "provinceId" }, joinType = JoinType.JOIN)
//	private List<City> listCity;
//	@JoinTable3(mainField = { "id" }, subField = { "provinceId" }, joinType = JoinType.LEFT_JOIN)
//	// 要用LEFT_JOIN,不然会影响到下一个关联子表listCity
//	ProvinceHistory provinceHistory; //省历史表
//	@JoinTable3(mainField = { "id" }, subField = { "fId" }, joinType = JoinType.LEFT_JOIN)
//	private News news;//新闻表
//	//省略get,set
//}
//class City{
//	private Integer id;
//	private String name;
//	private Integer level;
//	private String remark;
//	private Integer provinceId;
//	@JoinTable3(mainField = { "id" }, subField = { "cityId" }, joinType = JoinType.JOIN, subClass = Town.class)
//	private Town town;
//	//省略get,set
//}
//class Town {
//	private Integer id;
//	private String name;
//	private Integer level;
//	private String remark;
//	private Integer cityId;
//	@JoinTable3(mainField = { "id" }, subField = { "townId" }, joinType = JoinType.JOIN)
//	private List<Village> listVillage;
//	//省略get,set
//}
//class Village {
//	private Integer id;
//	private String name;
//	private Integer level;
//	private String remark;
//	private Integer townId;
//	@JoinTable3(mainField = { "id" }, subField = { "villageId" }, joinType = JoinType.JOIN)
//	private Road road;
//	//省略get,set
//}
//class Road {
//	private Integer id;
//	private String name;
//	private Integer level;
//	private String remark;
//	private Integer villageId;
//	//省略get,set
//}