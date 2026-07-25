/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.moretable3.moretable3select5._1_n11_11_n_1_subvalueList_insert_test2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.annotation.JoinTable;
import org.teasoft.bee.osql.annotation.JoinType;
import org.teasoft.bee.osql.api.MoreTable;
//import org.teasoft.beex.json.JacksonJsonUtil;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.BeeFactory;

import entity.News;
import entity.ProvinceHistory;

/**
 * 多表查询，1_n11_1_n_1
 * @author Kingstar
 * @since  3.0.0
 */
public class MoreTableSelect_list_filter5_1_n11_1_n_1_subvalueList {

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		try {
			MoreTable moreTable = BeeFactory.getHoneyFactory().getMoreTable();
			
			
			Province province = new Province();
//			province.setId(1002); //主表条件
//			
//			City city=new City();
//			city.setName("广州市");
//			
//			List<City> listCity=new ArrayList<>();
//			listCity.add(city);
//			province.setListCity(listCity);
//			
//			
//			List<Province> list1 = moreTable.select(province, 0, 10); //select 查询前10条记录
//			
//			if (list1!=null) {
//			for (int i = 0; i < list1.size(); i++) {
////				Logger.info(list1.get(i).toString());
//				Logger.info(JacksonJsonUtil.toJson(list1.get(i)));
//			}
//			}
			
			
			
			
			Road road=new Road();
			road.setName("深南路");
			
			Village village = new Village();
//			village.setId(4010);
			village.setName("阿房村");
//			village.setTownId(3010);
			
			village.setRoad(road);

			Town town = new Town();
//			town.setId(3010);
			town.setName("长安区");
//			town.setVillage(village);
			List<Village> listVillage=new ArrayList<>();
			listVillage.add(village);
			town.setListVillage(listVillage);
			
			News cityNews=new News();
			cityNews.setName("city news");
			cityNews.setDescStr("城市新闻");

			City city = new City();
//			city.setId(2010);
			city.setName("西安");
			city.setTown(town);
			city.setCityNews(cityNews);
			
			News provinceNews=new News();
			provinceNews.setName("province news");
			provinceNews.setDescStr("省新闻");

			province = new Province();
			province.setId(1026);
			province.setName("陕西省");
//			province.setCity(city);
			List<City> listCity=new ArrayList<>();
			listCity.add(city);
			province.setListCity(listCity);
			province.setNews(provinceNews);
			
			ProvinceHistory history=new ProvinceHistory();
//			history.setId(5010);
			history.setName("陕西历史");
			province.setProvinceHistory(history);

			moreTable.insert(province);
			
			province.setRemark("update");
//			moreTable.update(province);
			
			// 不复制的话, 子表的外键值会被自动填充.
			System.out.println("provinceNews.getfId():"+provinceNews.getfId());

		} catch (BeeException e) {
			e.printStackTrace();
			Logger.error("In MoreTableExam (BeeException):"+e.getMessage());
		}catch (Exception e) {
			Logger.error("In MoreTableExam (Exception):"+e.getMessage());
			e.printStackTrace();
		}
	}
}


class Province implements Serializable {

	private static final long serialVersionUID = 1597409278693L;

	private Integer id;
	private String name;
	private Integer level;
	private String remark;
	
	@JoinTable(mainField = { "id" }, subField = { "provinceId" }, joinType = JoinType.JOIN)
	private List<City> listCity;
	
	@JoinTable(mainField = { "id" }, subField = { "provinceId" }, joinType = JoinType.LEFT_JOIN)
	//要用LEFT_JOIN,不然会影响到下一个关联子表listCity
	ProvinceHistory provinceHistory;
	
	@JoinTable(mainField = { "id" }, subField = { "fId" }, joinType = JoinType.LEFT_JOIN)
	private News news;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public ProvinceHistory getProvinceHistory() {
		return provinceHistory;
	}

	public void setProvinceHistory(ProvinceHistory provinceHistory) {
		this.provinceHistory = provinceHistory;
	}
	
	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public List<City> getListCity() {
		return listCity;
	}

	public void setListCity(List<City> listCity) {
		this.listCity = listCity;
	}

}

class City implements Serializable {

	private static final long serialVersionUID = 1592879680416L;

	private Integer id;
	private String name;
	private Integer level;
	private String remark;
	private Integer provinceId;
	
//	@JoinTable3(mainField = { "id" }, subField = { "cityId" }, joinType = JoinType.JOIN, subClass=Town.class)
//	private List<Town> listTown;
	@JoinTable(mainField = { "id" }, subField = { "cityId" }, joinType = JoinType.JOIN, subClass=Town.class)
	private Town town;
	
	@JoinTable(mainField = { "id" }, subField = { "fId" }, joinType = JoinType.LEFT_JOIN)
	private News cityNews;
	
	public Town getTown() {
		return town;
	}

	public void setTown(Town town) {
		this.town = town;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public News getCityNews() {
		return cityNews;
	}

	public void setCityNews(News cityNews) {
		this.cityNews = cityNews;
	}
	
}


class Town implements Serializable {

	private static final long serialVersionUID = 1591964299715L;

	private Integer id;
	private String name;
	private Integer level;
	private String remark;
	private Integer cityId;
	
	@JoinTable(mainField = { "id" }, subField = { "townId" }, joinType = JoinType.JOIN)
	private List<Village> listVillage;
	
	public List<Village> getListVillage() {
		return listVillage;
	}

	public void setListVillage(List<Village> listVillage) {
		this.listVillage = listVillage;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

}


class Village implements Serializable {

	private static final long serialVersionUID = 1598571605825L;

	private Integer id;
	private String name;
	private Integer level;
	private String remark;
	private Integer townId;
	
	@JoinTable(mainField = { "id" }, subField = { "villageId" }, joinType = JoinType.JOIN)
	private Road road;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getTownId() {
		return townId;
	}

	public void setTownId(Integer townId) {
		this.townId = townId;
	}

	public Road getRoad() {
		return road;
	}

	public void setRoad(Road road) {
		this.road = road;
	}
	
}

class Road implements Serializable {

	private static final long serialVersionUID = 1590491224214L;

	private Integer id;
	private String name;
	private Integer level;
	private String remark;
	private Integer villageId;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getVillageId() {
		return villageId;
	}

	public void setVillageId(Integer villageId) {
		this.villageId = villageId;
	}

}