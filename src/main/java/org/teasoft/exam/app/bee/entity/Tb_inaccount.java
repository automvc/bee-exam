package org.teasoft.exam.app.bee.entity;

import org.teasoft.bee.osql.annotation.JoinTable;
import org.teasoft.bee.osql.annotation.PrimaryKey;

import java.util.List;

/**
 * 命名不规范的实例.  忽学,只用于测试
 */
public class Tb_inaccount// 收入信息实体类
{
	@PrimaryKey
	private Integer _id;// 存储收入编号
	private Double money;// 存储收入金额
	private String time;// 存储收入时间
	private String type;// 存储收入类别
	private String handler;// 存储收入付款方
	private String mark;// 存储收入备注

	@JoinTable(mainField = "_id",subField = "_id",subClazz =Tb_outaccount.class )
	private List<Tb_outaccount> list;
	
	public List<Tb_outaccount> getList() {
		return list;
	}

	public void setList(List<Tb_outaccount> list) {
		this.list = list;
	}


	public Integer getid()// 设置收入编号的可读属性
	{
		return _id;
	}

	public void setid(int id)// 设置收入编号的可写属性
	{
		this._id = id;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getTime()// 设置收入时间的可读属性
	{
		return time;
	}

	public void setTime(String time)// 设置收入时间的可写属性
	{
		this.time = time;
	}

	public String getType()// 设置收入类别的可读属性
	{
		return type;
	}

	public void setType(String type)// 设置收入类别的可写属性
	{
		this.type = type;
	}

	public String getHandler()// 设置收入付款方的可读属性
	{
		return handler;
	}

	public void setHandler(String handler)// 设置收入付款方的可写属性
	{
		this.handler = handler;
	}

	public String getMark()// 设置收入备注的可读属性
	{
		return mark;
	}

	public void setMark(String mark)// 设置收入备注的可写属性
	{
		this.mark = mark;
	}
}
