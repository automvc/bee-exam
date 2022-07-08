package org.teasoft.exam.app.bee.entity;

import org.teasoft.bee.osql.annotation.PrimaryKey;

/**
 *  * 命名不规范的实例.  忽学,只用于测试
 */
public class Tb_outaccount// 支出信息实体类
{
	@PrimaryKey
	private Integer _id;// 存储支出编号
	private Double money;// 存储支出金额
	private String time;// 存储支出时间
	private String type;// 存储支出类别
	private String address;// 存储支出地点
	private String mark;// 存储支出备注

	public Integer getid()// 设置支出编号的可读属性
	{
		return _id;
	}

	public void setid(int id)// 设置支出编号的可写属性
	{
		this._id = id;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getTime()// 设置支出时间的可读属性
	{
		return time;
	}

	public void setTime(String time)// 设置支出时间的可写属性
	{
		this.time = time;
	}

	public String getType()// 设置支出类别的可读属性
	{
		return type;
	}

	public void setType(String type)// 设置支出类别的可写属性
	{
		this.type = type;
	}

	public String getAddress()// 设置支出地点的可读属性
	{
		return address;
	}

	public void setAddress(String address)// 设置支出地点的可写属性
	{
		this.address = address;
	}

	public String getMark()// 设置支出备注的可读属性
	{
		return mark;
	}

	public void setMark(String mark)// 设置支出备注的可写属性
	{
		this.mark = mark;
	}
}
