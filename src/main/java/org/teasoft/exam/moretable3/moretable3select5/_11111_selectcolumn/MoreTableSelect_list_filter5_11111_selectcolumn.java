/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.moretable3.moretable3select5._11111_selectcolumn;

import java.io.Serializable;
import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.annotation.JoinTable;
import org.teasoft.bee.osql.annotation.JoinType;
import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.MoreTable;
import org.teasoft.beex.json.JacksonJsonUtil;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * 多表查询，带条件
 * @author Kingstar
 * @since  3.0.0
 */
public class MoreTableSelect_list_filter5_11111_selectcolumn {

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		try {
			MoreTable moreTable = BeeFactory.getHoneyFactory().getMoreTable();
			
			
			Province province = new Province();
			province.setId(1002); //主表条件
			
			
//			List<Province> list1 = moreTable.select(province, 0, 10); //select 查询前10条记录
			
			Condition condition = BF.getCondition();
			condition.selectField("city.id", "city.name"); //column from layer 2
			moreTable.select(province,condition);
			condition.selectField("city.id", "town.id", "town.name"); //column from layer 2, 3
			moreTable.select(province,condition);
			condition.selectField("town.id", "town.name"); //column from layer 3   //设置layer3时，layer不能为null; 所以，上一层至少要查出一个字段;  
			moreTable.select(province,condition);
//			只有主表层，main_obj==null,在有子表时，会自动创建。
			condition.selectField("city.id", "town.id", "village.name");//ok
			moreTable.select(province,condition);
			condition.selectField("village.name"); // column from layer 4
			moreTable.select(province,condition);
			condition.selectField("city.id", "village.name");// missing layer 3   中间断层，则前面的可以显示。
			
			List<Province> list1 = moreTable.select(province,condition);
			
			if (list1 != null) {
				for (int i = 0; i < list1.size(); i++) {
//				    Logger.info(list1.get(i).toString());
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
			str.append(",city=null");
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