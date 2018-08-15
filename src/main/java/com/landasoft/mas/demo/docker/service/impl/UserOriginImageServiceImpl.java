package com.landasoft.mas.demo.docker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.landasoft.mas.demo.docker.mapper.UserAnnotationMapper;
import com.landasoft.mas.demo.docker.mapper.UserOriginImageMapper;
import com.landasoft.mas.demo.docker.model.vo.UserOriginImage;
import com.landasoft.mas.demo.docker.service.api.UserOriginImageService;
/**
 * 用户原始图片查询服务接口实现
 * @author wulinyun
 * 2018年8月15日下午5:31:53
 */
public class UserOriginImageServiceImpl implements UserOriginImageService {
	//建议阈值为0.7-0.8
		@Value("${imageData.verification_score:0.7}")
		private static final Double VERIFICATION_SCORE = 0.7;
		
		@Autowired
		private UserOriginImageMapper userOriginImageMapper;
		@Autowired
		private UserAnnotationMapper userAnnotationMapper;
		@Override
		public List<UserOriginImage> findUserOriginImageByUserId(String userId) {
			
			//return userOriginImageMapper.findUserOriginImageInfo(userId);
			return userAnnotationMapper.findUserOriginImageByUserId(userId);
		}
}
