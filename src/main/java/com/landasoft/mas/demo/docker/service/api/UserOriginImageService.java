package com.landasoft.mas.demo.docker.service.api;

import java.util.List;

import com.landasoft.mas.demo.docker.model.vo.UserOriginImage;
/**
 * 用户原始图片查询服务接口
 * @author wulinyun
 * 2018年8月15日下午5:32:01
 */
public interface UserOriginImageService {
	/**
	 * 通过用户id查询用户原始图片数据
	 * @param userId 用户id
	 * @return List<UserOriginImage>
	 */
	public List<UserOriginImage> findUserOriginImageByUserId(String userId);

}
