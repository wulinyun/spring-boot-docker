package com.landasoft.mas.demo.docker.model.vo;
/**
 * 用户实体bean
 * @author wulinyun
 * 2018年8月15日上午11:55:42
 */
public class User {
	/**
	 * 用户Id
	 */
	private String userId;
	/**
	 * 用户名称
	 */
	private String userName;
	/**
	 * 用户性别
	 */
	private String sex;
	/**
	 * 用户名称
	 */
	private Integer age;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", sex=" + sex + ", age=" + age + "]";
	}
	

}
