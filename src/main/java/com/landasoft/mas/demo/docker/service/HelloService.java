package com.landasoft.mas.demo.docker.service;

import com.landasoft.mas.demo.docker.vo.User;

/**
 * demo接口定义
 * @author wulinyun
 * 2018年8月15日上午11:53:59
 */
public interface HelloService {
	/**
	 * 通过用户id获取用户信息
	 * @param userId 用户id
	 * @return User
	 */
	public User getUserByUserId(String userId);

}
