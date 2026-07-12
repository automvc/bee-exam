/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.moretable3.moretable3select5._1n;

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
 * 多表查询，带条件
 * 
 * @author Kingstar
 * @since 3.0.0
 */
public class MoreTableSelect_list_filter5_1n {

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		try {
			MoreTable moreTable = BeeFactory.getHoneyFactory().getMoreTable();

			Province province = new Province();
			province.setId(1002); //主表条件

			List<Province> list1 = moreTable.select(province, 0, 10); // select 查询前10条记录

			if (list1 != null) {
				for (int i = 0; i < list1.size(); i++) {
//					Logger.info(list1.get(i).toString());
					Logger.info(JacksonJsonUtil.toJson(list1.get(i)));
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
	private String name;
	private Integer level;
	private String remark;

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

//	public City getCity() {
//		return city;
//	}
//
//	public void setCity(City city) {
//		this.city = city;
//	}
	
	public List<City> getListCity() {
		return listCity;
	}

	public void setListCity(List<City> listCity) {
		this.listCity = listCity;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Province{");
		str.append("id=").append(id);
		str.append(",name=").append(name);
		str.append(",level=").append(level);
		str.append(",remark=").append(remark);
		if(listCity!=null) {
			str.append(", listCity=[");
			int i=0;
			for (City city : listCity) {
				if(i!=0) str.append(", ");
				i++;
				str.append(" city={").append(city.toString()+"}");
			}
			str.append("]");
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
		str.append("City{");
		str.append("id=").append(id);
		str.append(",name=").append(name);
		str.append(",level=").append(level);
		str.append(",remark=").append(remark);
		str.append(",provinceId=").append(provinceId);

		str.append("}");
		return str.toString();
	}
}
