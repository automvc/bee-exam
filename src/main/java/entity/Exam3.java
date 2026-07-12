package entity;

import java.io.Serializable;

/**
 * @author Honey
 * Create on 2024-12-13 23:17:42
 */
public class Exam3 implements Serializable {

	private static final long serialVersionUID = 1592272121933L;

	private Long id;
	private Long userid;
	private String lastName;
	private String firstName;
	private String birthDate;
	private String sex;
	private Long groupId;
	private String groupName;
	private String checkDate;
	private String checkTime;
	private String operator;
	private String updatetime;
	private String checkData;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}

	public String getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getCheckData() {
		return checkData;
	}

	public void setCheckData(String checkData) {
		this.checkData = checkData;
	}

	public String toString() {
		StringBuilder str=new StringBuilder();
		str.append("Exam[");
		str.append("id=").append(id);
		str.append(",userid=").append(userid);
		str.append(",lastName=").append(lastName);
		str.append(",firstName=").append(firstName);
		str.append(",birthDate=").append(birthDate);
		str.append(",sex=").append(sex);
		str.append(",groupId=").append(groupId);
		str.append(",groupName=").append(groupName);
		str.append(",checkDate=").append(checkDate);
		str.append(",checkTime=").append(checkTime);
		str.append(",operator=").append(operator);
		str.append(",updatetime=").append(updatetime);
		str.append(",checkData=").append(checkData);
		str.append("]");
		return str.toString();
	}
}