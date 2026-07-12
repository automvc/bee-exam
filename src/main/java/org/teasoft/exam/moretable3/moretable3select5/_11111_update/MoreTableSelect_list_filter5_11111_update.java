/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.moretable3.moretable3select5._11111_update;

import java.io.Serializable;
import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.annotation.JoinTable;
import org.teasoft.bee.osql.annotation.JoinType;
import org.teasoft.bee.osql.api.MoreTable;
import org.teasoft.beex.json.JacksonJsonUtil;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.BeeFactory;

/**
 * 多表select/insert/delete，带条件
 * @author Kingstar
 * @since  3.0.0
 */
public class MoreTableSelect_list_filter5_11111_update {

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		try {
			MoreTable moreTable = BeeFactory.getHoneyFactory().getMoreTable();
			
			
			Province province = new Province();
//			province.setId(1002); //主表条件
			
			
			List<Province> list1 = moreTable.select(province, 0, 20);
			if (list1 != null) {
				for (int i = 0; i < list1.size(); i++) {
					Logger.info(JacksonJsonUtil.toJson(list1.get(i)));
				}
			}

			Village village = new Village();
			village.setId(4010);
			village.setName("阿房村");
//			village.setTownId(3010);

			Town town = new Town();
			town.setId(3010);
			town.setName("长安区");
			town.setVillage(village);

			City city = new City();
			city.setId(2010);
			city.setName("西安");
			city.setTown(town);

			province = new Province();
			province.setId(1010);
			province.setName("陕西省");
			province.setCity(city);

			moreTable.insert(province);
//			moreTable.delete(province);
			
			village.setName("阿房村-update");
			city.setName("西安-update");
			city.setRemark("test update");
			
			moreTable.update(province);
			
			
			list1 = moreTable.select(province, 0, 20);
			if (list1 != null) {
				for (int i = 0; i < list1.size(); i++) {
					Logger.info(JacksonJsonUtil.toJson(list1.get(i)));
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


class Province implements Serializable {

	private static final long serialVersionUID = 1597409278693L;

	private Integer id;
	private String name;
	private Integer level;
	private String remark;
	
	@JoinTable(mainField = { "id" }, subField = { "provinceId" }, joinType = JoinType.JOIN)
//	@FK(refBy="id", value="provinceId")
	private City city;
//	private List<City> listCity;
//	private List<?> listCity;
//	private List listCity;

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
	


	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Province[");
		str.append("id=").append(id);
		str.append(",name=").append(name);
		str.append(",level=").append(level);
		str.append(",remark=").append(remark);
		if(city!=null) {
			str.append(" city={").append(city.toString()+"}");
		}else {
			str.append(",listCity=null");
		}
		str.append("}");
		return str.toString();
	}
}

class City implements Serializable {

	private static final long serialVersionUID = 1592879680416L;

	private Integer id;
	private String name;
	private Integer level;
	private String remark;
	private Integer provinceId;
	
	@JoinTable(mainField = { "id" }, subField = { "cityId" }, joinType = JoinType.JOIN, subClass=Town.class)
//	private List<Town> listTown;
//	@FK(refBy="id", value="cityId")
	private Town town;
	
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

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("City[");
		str.append("id=").append(id);
		str.append(",name=").append(name);
		str.append(",level=").append(level);
		str.append(",remark=").append(remark);
		str.append(",provinceId=").append(provinceId);
		
		if(town!=null) {
			str.append(", town={").append(town.toString()+"}");
		}else {
			str.append(",town=null");
		}
		
		
		str.append("}");
		return str.toString();
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
//	@FK(refBy="id", value="townId")
	private Village village;
	
	public Village getVillage() {
		return village;
	}

	public void setVillage(Village village) {
		this.village = village;
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

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Town[");
		str.append("id=").append(id);
		str.append(",name=").append(name);
		str.append(",level=").append(level);
		str.append(",remark=").append(remark);
		str.append(",cityId=").append(cityId);
		
		if(village!=null) {
			str.append(", village={").append(village.toString()+"}");
		}else {
			str.append(",village=null");
		}
		
		str.append("}");
		return str.toString();
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
//	@FK(refBy="id", value="villageId")
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

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Village[");
		str.append("id=").append(id);
		str.append(",name=").append(name);
		str.append(",level=").append(level);
		str.append(",remark=").append(remark);
		str.append(",townId=").append(townId);
		
		if(road!=null) {
			str.append(", road={").append(road.toString()+"}");
		}else {
			str.append(",road=null");
		}
		
		str.append("}");
		return str.toString();
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

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Road[");
		str.append("id=").append(id);
		str.append(",name=").append(name);
		str.append(",level=").append(level);
		str.append(",remark=").append(remark);
		str.append(",villageId=").append(villageId);
		str.append("}");
		return str.toString();
	}
}