/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.moretable3.moretable3select5._1n1n1_column_condition2;

import java.io.Serializable;
import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.annotation.Column;
import org.teasoft.bee.osql.annotation.JoinTable;
import org.teasoft.bee.osql.annotation.JoinType;
import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.MoreTable;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * 多表查询，test use @Column
 * 主表condition有设条件，从表也有设。
 * 
 * @author Kingstar
 * @since 3.0.0
 */
public class MoreTableSelect_list_filter5_1n1n1_column_condition2 {

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		try {
			MoreTable moreTable = BeeFactory.getHoneyFactory().getMoreTable();

			Province province = new Province();
//			province.setId(1002); //主表条件

//			province.setName2("广东省");

			Condition condition = BF.getCondition();
			condition.op("name2", Op.eq, "广东省"); //主表可以不写表名
			condition.op("province.level", Op.eq, 1); //主表也可以写表名
			condition.op("city.name3", Op.eq, "深圳市");//从表一定要写表名

			List<Province> list1 = moreTable.select(province, condition);

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

class Province implements Serializable {

	private static final long serialVersionUID = 1597409278693L;

	private Integer id;
	@Column("name")
	private String name2;
	private Integer level;
	private String remark;

//	@JoinTable3(mainField = { "id" }, subField = { "provinceId" }, joinType = JoinType.JOIN)
	@JoinTable(mainField = { "id" }, subField = { "provinceId" }, joinType = JoinType.JOIN)
//	private City city;
	private List<City> listCity;
//	private List<?> listCity;
//	private List listCity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}

	public Integer getLevel() {
		return level;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
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

	public List<City> getListCity() {
		return listCity;
	}

	public void setListCity(List<City> listCity) {
		this.listCity = listCity;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Province[");
		str.append("id=").append(id);
		str.append(",name2=").append(name2); // name2
		str.append(",level=").append(level);
		str.append(",remark=").append(remark);
		if (listCity != null) {
			str.append(", listCity=[");
			int i = 0;
			for (City city : listCity) {
				if (i != 0) str.append(", ");
				i++;
				str.append(" city={").append(city.toString() + "}");
			}
			str.append("]");
		} else {
			str.append(",listCity=null");
		}
		str.append("}");
		return str.toString();
	}
}

class City implements Serializable {

	private static final long serialVersionUID = 1592879680416L;

	private Integer id;
	@Column("name")
	private String name3;
	private Integer level;
	private String remark;
	private Integer provinceId;

//	@JoinTable3(mainField = { "id" }, subField = { "cityId" }, joinType = JoinType.JOIN, subClass=Town.class)
//	private List<Town> listTown;
	@JoinTable(mainField = { "id" }, subField = { "cityId" }, joinType = JoinType.JOIN, subClass = Town.class)
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

//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
	
	public String getName3() {
		return name3;
	}

	public void setName3(String name3) {
		this.name3 = name3;
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
		str.append(",name=").append(name3);
		str.append(",level=").append(level);
		str.append(",remark=").append(remark);
		str.append(",provinceId=").append(provinceId);

		if (town != null) {
			str.append(", town={").append(town.toString() + "}");
		} else {
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

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Town[");
		str.append("id=").append(id);
		str.append(",name=").append(name);
		str.append(",level=").append(level);
		str.append(",remark=").append(remark);
		str.append(",cityId=").append(cityId);

//		if(village!=null) {
//			str.append(", village={").append(village.toString()+"}");
//		}else {
//			str.append(",village=null");
//		}

		if (listVillage != null) {
			str.append(", listVillage=[");
			int i = 0;
			for (Village village : listVillage) {
				if (i != 0) str.append(", ");
				i++;
				str.append(" village={").append(village.toString() + "}");
			}
			str.append("]");
		} else {
			str.append(",listVillage=null");
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

		if (road != null) {
			str.append(", road={").append(road.toString() + "}");
		} else {
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